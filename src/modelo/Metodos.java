package modelo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Metodos {

    private static final String API_KEY = "AQUI DEBES INGRESAR EL CODIGO DEL API";

    private final String codigoBase;
    private final String targetCode;
    private final double monto;
    private double resultado;

    public Metodos(String baseCode, String targetCode, double monto) {
        this.codigoBase = baseCode.toUpperCase();
        this.targetCode = targetCode.toUpperCase();
        this.monto = monto;
    }

    public double convert() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + codigoBase + "/" + targetCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al realizar la solicitud al servidor: " + response.statusCode());
        }

        JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);

        if (jsonObject == null || !jsonObject.has("result")) {
            throw new IOException("La respuesta de la API no tiene el formato esperado.");
        }

        String resultadoApi = jsonObject.get("result").getAsString();

        if (!resultadoApi.equals("success")) {
            String tipoError = jsonObject.has("error-type")
                    ? jsonObject.get("error-type").getAsString()
                    : "desconocido";
            throw new IOException("Error en la API: " + tipoError);
        }

        if (!jsonObject.has("conversion_rate")) {
            throw new IOException("No se encontró la tasa de conversión para " + targetCode);
        }

        double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
        resultado = monto * conversionRate;

        return resultado;
    }
}

