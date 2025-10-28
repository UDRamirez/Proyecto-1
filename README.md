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

El patrón abstract factory se implemento mediante la clase FabricaMestra, una clase que devuelve otro tipo de fábricas dependiendo del tipo que se requiera con ayuda de la clase ContratoFabrica, pues esta ayuda a obtener los componentes o piezas, haciendo que el builder y otro codigo utilizado no tenga que depender de las clases concretas, además cada fábrica ya sabe como realizar istancias de su tipo de pieza, por lo que es más facil manejarlo.
Quisimos usar Abstract Factory para este segmento puesto que son muchas piezas y por tanto muchas fabricas, al implementar este patron nos permite manejar varias familias de piezas similares, además de que hace más fácil el poder agregar nuevas piezas.


### Patrón **Builder**
Se creó la clase ArmadaBuilder que tiene métodos como agregarCPU(), agregarGPU(), agregarRAM(), etc., y mantiene un objeto Compu interno.

La clase DirectorConstructor tiene métodos como construirPcEconomica(), construirPcPremium() o construirPcPersonalizada().

El director llama al builder paso a paso: por ejemplo, primero builder.agregarCPU(), luego builder.agregarGPU(), hasta completar la computadora.

El builder combina los componentes y finalmente retorna un Compu o Compunent.

Nuestro patrón builder se implementa mediante la clase ArmadaBuilder, que contiene todos los metodo para agregar las piezas que armarán a la nueva PC de tipo Compu, mientras que DirectorConstructor con ayuda de este builder permite crear varias combinaciones de Pc's como la economica y la premium que ya se encuentran ahí, esto lo hace paso a paso con directo llamando al builder paso a paso hasta terminar de "ensamblar" la computadora regresando un objeto de tipo Compu o Compunent,pero no solo queda ahí puesto que estas dos clases también son la base fundamental cuando se quiere crear una PC personalizada.
La razón por la que implementamos este patrón es porque justamente como se llama el patrón, una computadora se va construyendo paso a paso con las piezas que se quieren ir agregando, además de que este patrón es flexible a la hora de crear distintas Pc's pues todas cumplen con la misma lógica de construcción, solo sus piezas son las que cambian, además al haber tantas piezas disponibles para elegir, hace al programa más mantenible y menos engorroso a la hora de elegir con que se quiere construir la PC


### Patrón **Decorator**
El patrón Decorator en el proyecto fue implementado mediante nuestra clase PCDecorada, un tipo de PC que recibe un Compunent(un objeto de tipo Compu al principio para empezar a decorar) y luego un Programa, cada decorador agregado se envuelve a la PC base, agregando programas a una lista y actualizando el precio total de la PC cada vez que esto sucede, la estructura permite poder encadenar estos decoradores, agregando uno detrás de otro.
La razón por la que nos pareció factible utilizar este patrón fue para evitar crear subclases para las combinaciones de los programas, además de que de cierta forma consideramos una analogía con la práctica 2, pues en esta se hacía builder con un helado (base) al cual se le decoraba con varios toppings, pero en este caso es una computadora (base) a la que se "decora" con programas, además el uso de este patrón nos permitio agregar funcionalidades sin tener que modificar la clase Compu


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

