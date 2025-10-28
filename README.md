# README - Proyecto 01- MonosChinosMX

## Equipo: *"Los Canekitas"*

| Nombre                          | Número de Cuenta |
|---------------------------------|------------------|
| Ramírez Macías Ulises Dante     | 319217535        |
| Ramírez Palacios Miguel         | 322216376        |
| Reyes Grimaldo Angel Ismael     | 119003833        |

---      

## Patrones de Diseño usado para el proyecto

### Patrón **Abstract Factory**
Nuestro proyecto implementa AbstractFactory a traves de la clase FabricaMaestra, la cual a su vez crea fabricas de componentes que a su vez, crean a los componentes que una PC puede usar para armarse, consideramos que Abstract Factory era algo muy factible para este proyecto, pues el builder de la PC necesita Piezas/componentes para poder armar una, entonces como habían muchos tipos de componentes y por ende, muchas fabricas, decidimos hacer una abstracta para que pueda crearlas según el tipo que se requiera 


### Patrón **Builder**
Builder durante nuestro proyecto, fue usado para que cada PC se arme paso a paso agregando cada uno de sus componentes en el constructor, ya sea mediante que el usuario escoga sus componentes o que estos se agreguen por defecto a atraves de la clase DirectorConstructor y los metodos para armar una pc premium o una pc básica,

| Elementos del patrón  | Nuestras clases              |
|-----------------------|------------------------------|
| Builder               | Builder.java                 |
| Concrete Builder      | ConstructorPaquete.java      |
| Director              | EncargadoEntregas.java       |
| Product               | Paquete.java y sus subclases |

### Patrón **Decorator**
El patrón Decorator se decidio usar en el proyecto para el segmento de agregar programas preinstalados a la computadora que se esta construyendo, esto debido a que la computadora armada se "decora" con los programas que el usuario desee o que ya esten preestabelcidos mediante la clase DirectorConstructor.
Cada programa (Windows, WSLTerminal, etc.) se le asigna una versión y un precio, los cuales cuando un programa se asigna a una computadora base, se obtiene el precio de esta misma, y luego se le agrega el programa, además de sumar el precio de la pc base junto con el del programa agregado para que de un precio total, este proceso se repite hasta que el usuario ya no quiera agregar más programas o ya no haya programas que agregar (No se pueden agregar duplicados de programas).
Usar este patrón nos pareció la idea más optima para este segmento, puesto que se podría considerar una analogia a la práctica 2, donde se decoraba un helado con toppings, pero en este proyecto en vez de un helado es una PC y en vez de toppings son programas, para asi lanzar un precio y descripción final de toda la PC ya con sus programas pre-instalados.

### Patrón **Proxy**
---

## Instrucciones de Compilación y Ejecución

  Compilamos con:
  ```
  javac App.java
  ```
  Ejecutamos con:
  ```
  java App.java
  ```

*NOTA: Comando utilizado en Linux y con la versión Java 23 (JDK 23)*

---

## Descripción del Programa
Este programa crea un sistema para la formación de grupos de entrenamiento para aspirantes ninja. Dichos grupos se asignan con líderes voluntarios, paquetes de herramientas y campos de entrenamiento, todo personalizado y adecuado a ciertos criterios utilizando los patrones de diseño Factory y Builder, perfectos para la instanciación de nuestros algoritmos de reparto de herramientas, líderes y campos de entrenamiento.
