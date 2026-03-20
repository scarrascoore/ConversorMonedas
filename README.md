# Conversor de Monedas en Java

Pequeño proyecto de consola desarrollado en **Java** para convertir montos entre distintas monedas usando una **API de tipo de cambio en tiempo real**.

## Objetivo del proyecto

Este proyecto permite practicar:

- Programación orientada a objetos en Java
- Consumo de APIs REST
- Manejo de JSON con Gson
- Uso de `HttpClient`
- Validación básica de entradas en consola
- Organización del código en paquetes (`modelo` y `vista`)

## Funcionalidades

El programa permite convertir entre estas monedas:

1. USD → ARS  
2. ARS → USD  
3. USD → PEN  
4. PEN → USD  
5. USD → COP  
6. COP → USD  
7. USD → MXN  
8. MXN → USD  

Además:

- Muestra un menú interactivo en consola
- Solicita el monto a convertir
- Consulta la tasa de cambio actual desde la API
- Muestra el resultado formateado
- Maneja errores de entrada y de conexión

## Estructura del proyecto

```text
src/
├── modelo/
│   └── Metodos.java
└── vista/
    └── Main.java
```

### `modelo/Metodos.java`
Contiene la lógica de conversión:

- recibe moneda origen, moneda destino y monto
- realiza la petición HTTP a la API
- procesa la respuesta JSON
- obtiene la tasa de conversión
- calcula el resultado final

### `vista/Main.java`
Contiene la interacción con el usuario:

- muestra el menú
- recibe la opción elegida
- solicita el monto
- llama a la clase `Metodos`
- imprime el resultado en consola

## Tecnologías usadas

- **Java 21**  
- **Gson** para procesar JSON  
- **Java HttpClient** para consumir la API  
- **ExchangeRate API** para obtener tipos de cambio

## Requisitos

Antes de ejecutar el proyecto necesitas:

- Tener instalado **Java 21** o una versión compatible
- Tener agregada la librería **Gson**
- Tener una API Key válida de ExchangeRate API

## Seguridad de la API Key

Para evitar exponer datos sensibles, la clave de la API no debe subirse a GitHub con un valor real.

En el archivo `Metodos.java` debes ver algo así:

```java
private static final String API_KEY = "AQUI DEBES INGRESAR EL CODIGO DEL API";
```

Antes de ejecutar localmente, reemplaza ese texto por tu clave real. La cual 
debes obtenerla de: https://app.exchangerate-api.com/

## Ejecución

1. Clona o descarga el proyecto
2. Abre el proyecto en tu IDE
3. Coloca tu API Key real en `Metodos.java`
4. Ejecuta la clase `Main`

## Ejemplo de uso

```text
******************************************
    CHALLENGE: Conversor de Monedas
******************************************
Esta aplicación da soporte a monedas mundiales que circulan habitualmente
------------------------------------------------------------

MENU DE OPCIONES:
1. Dólar estadounidense (USD) => Peso argentino (ARS)
2. Peso argentino (ARS) => Dólar estadounidense (USD)
3. Dólar estadounidense (USD) => Sol peruano (PEN)
4. Sol peruano (PEN) => Dólar estadounidense (USD)
5. Dólar estadounidense (USD) => Peso colombiano (COP)
6. Peso colombiano (COP) => Dólar estadounidense (USD)
7. Dólar estadounidense (USD) => Peso mexicano (MXN)
8. Peso mexicano (MXN) => Dólar estadounidense (USD)
9. Salir de la aplicación

Por favor, elija una opción del menú: 3
Ingresa la cantidad de USD a convertir: 50
➡ 50.00 USD = 186.25 PEN
```

> El valor exacto dependerá de la tasa de cambio del momento.

## Buenas prácticas aplicadas

- Separación de responsabilidades entre vista y lógica
- Validación de errores de API
- Manejo de excepciones
- Protección básica de credenciales antes de publicar el código

## Mejoras futuras

- Agregar más monedas
- Permitir convertir entre cualquier par de monedas
- Mover la API Key a variables de entorno
- Crear historial de conversiones
- Agregar pruebas unitarias
- Mejorar formato visual en consola

## Autor

**Shelvy Carrasco Oré**
- GitHub: `https://github.com/scarrascoore`
- LinkedIn: `https://linkedin.com/in/shelvycarrascoore`
---

## Licencia

Proyecto personal de práctica para fortalecer habilidades en Java, consumo de APIs y desarrollo backend.
