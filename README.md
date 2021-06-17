# ing_software_skysoft_skydoku
Repositorio para trabajo practico final de la materia Ingenieria de Software de la FCEFyN - UNC

#### Skydoku
Este juego está compuesto por una cuadrícula de 4x4 casillas
en dificultad fácil, 9x9 casillas en dificultad normal y 16x16 casillas
en dificultad dificil dividida en regiones de 2x2, 3x3 o 4x4 casillas
respectivamente.
Partiendo de algunos números ya dispuestos en algunas de las casillas,
hay que completar las casillas vacías con dígitos del 1 al 4, del 1 al 9
y del 1 al 16 según la dificultad elegida sin que se repitan por fila, columna
o región.

- ##### Reglas:

    - Regla 1: hay que completar las casillas vacías con un solo número.
    - Regla 2: en una misma fila no puede haber números repetidos.
    - Regla 3: en una misma columna no puede haber números repetidos.
    - Regla 4: en una misma región no puede haber números repetidos.
    - Regla 5: la solución de un sudoku es única.

- Ingreso de numero:
  Debe hacer clic en la casilla, luego seleccionar el cuadro de texto debajo
  a la izquierda, ingresar un numero del 1 al 16 y apretar enter.

- Borrado de numero:
  Debe hacer clic derecho sobre la casilla, se le restaran 10 puntos.

## Ejecucion de Skydoku
Debe tener instalado java 8 o superior.

- Descargue el archivo .jar desde el release de este proyecto.
- Ejecute el archivo jar.
- Si usa linux y no funciona pruebe ejecutar `java -jar skysoft-skydoku.jar`

## Build:
Debe tener instalado maven y sobre el directorio raiz del proyecto ejecutar el siguiente comando:

- ```mvn package```

## CI:
Se utiliza la herramienta circleci.
- Build y Test: [![CircleCI](https://circleci.com/gh/JCLosano/ing_software_skysoft_skydoku/tree/main.svg?style=svg)](https://circleci.com/gh/JCLosano/ing_software_skysoft_skydoku/tree/main)
