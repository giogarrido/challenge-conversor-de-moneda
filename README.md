
# Conversor de Moneda

Este es un programa sencillo en Java que permite convertir diferentes tipos de monedas entre sí, como USD, MXN, BRL, COP, entre otras. La aplicación ofrece un menú de opciones donde el usuario puede seleccionar las monedas de origen y destino para realizar la conversión.

## Características

- Conversión entre diversas monedas:
  - Dólar estadounidense (USD)
  - Peso mexicano (MXN)
  - Real brasileño (BRL)
  - Peso colombiano (COP)
- Interfaz de usuario sencilla mediante un menú en consola.
- Implementación utilizando el nuevo `switch` mejorado en Java (Java 12+).

## Requisitos

- Java 12 o superior.
- IDE compatible con Java o consola de comandos para ejecutar el programa.

## Instalación

1. Clona este repositorio en tu máquina local usando el siguiente comando:
    ```bash
    git clone https://github.com/giogarrido/challenge-conversor-de-moneda.git
    ```

2. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, VSCode, etc.) o navega a la carpeta del proyecto desde tu terminal.

3. Asegúrate de tener una versión compatible de Java instalada en tu sistema:
    ```bash
    java -version
    ```

## Uso

Una vez que hayas clonado el repositorio y abierto el proyecto:

1. Ejecuta el programa desde tu IDE o usa el siguiente comando desde la terminal:
    ```bash
    javac ConversorDeMoneda.java
    java ConversorDeMoneda
    ```

2. El programa mostrará un menú con opciones de conversión entre diferentes monedas. Elige la opción correspondiente para convertir de una moneda a otra.

### Ejemplo de ejecución:

```bash
1. Convertir de USD a MXN
2. Convertir de MXN a USD
3. Convertir de USD a BRL
4. Convertir de BRL a USD
5. Convertir de USD a COP
6. Convertir de COP a USD
Elige una opción: 1
Ingrese el monto en USD: 100
100 USD son 2000 MXN (ejemplo con una tasa de cambio ficticia)
```

## Tecnologías usadas

- Java
- Gson (si aplicas manipulación de JSON para las tasas de cambio)

## Contribución

Si quieres contribuir al desarrollo de este proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama con tu feature: `git checkout -b mi-nueva-feature`.
3. Realiza los cambios necesarios y haz commit: `git commit -am 'Agrego mi feature'`.
4. Haz push a la rama: `git push origin mi-nueva-feature`.
5. Crea un pull request en GitHub.

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).
