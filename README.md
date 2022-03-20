# Mercadolibre Challenge

 Desafío técnico para el puesto de software developer en Mercadolibre.
 
 # Table of Contents

* [Consigna](#consigna)
* [Desafíos](#desafios)
* [Solución desafío 1](#solucionDesafio1)
* [Solución desafío 2](#solucionDesafio2)
* [Solución desafío 3](#solucionDesafio3)
 ## Consigna <a name="consigna"></a>
 
 Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
 
 Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante o no basándose  en su secuencia de ADN.
 
 Para eso te ha pedido crear un programa con un método o función con la siguiente firma:
 
&nbsp;&nbsp;&nbsp;&nbsp; **boolean isMutant(String[] dna)**

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia de ADN.
Las letras de los Strings solo pueden ser: (A, T, C, G), las cuales representa cada base nitrogenada de ADN.

Sabrás si un humano es mutante, si encuentras **más de una secuencia de cuatro letras iguales**, de forma oblicua, horizontal o vertical.

### Desafíos <a name="desafios"></a>

**Nivel 1**

Programa que cumpla con el método pedido por Magneto de la manera mas eficiente posible.

**Nivel 2**

Crear una API Rest, hostear esa API en un cloud computing libre, crear el servicio "/Mutant" en donde se pueda detectar si un humano
es humano o mutante enviando la secuencia de ADN mediante un HTTP POST mediante un Json.

En caso de verificar un mutante, debería devolver un HTTP-200-OK, en caso contrario un 403-Forbidden.

**Nivel 3**

Anexar una base de datos, la cual guarde los ADN's verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra "/stats" que devuelva un Json con las estadísticas de las verificaciones de ADN.

Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1 millón de peticiones por segundo).

Tests automáticos, Code coverage > 80%.

### Solución desafío nivel 1 <a name="solucionDesafio1"></a>

La solución planteada se basa en realizar 4 barridos a la matriz de NxN para identificar la presencia de adn mutante:
un barrido horizontal por filas, un barrido vertical por columnas, un barrido por la diagonal ascendente y por último un barrido por la diagonal descendente.

En cada barrido basta con recorrer las lineas en esa dirección, y en caso de encontrarse con 4 repeticiones consecutivas de caractéres, devolver verdadero.

<img width="843" alt="Barridos Solucion 1 Meli ChallengeV2" src="https://user-images.githubusercontent.com/15307332/159141938-4edaca1f-d1b2-4481-9c56-a89f7c32e542.png">

La justificación de ser la solución más eficiente posible se encuentra debido a la complejidad computacional y espacial de la misma.

La complejidad espacial del algoritmo implementado es **O(1)**, ya que no se realiza consumo adicional de memoria. 
La complejidad temporal del algoritmo implementado es **O(4\*N\*N)**, siendo NxN el tamaño de la instancia ingresada como parámetro, es decir, la cantidad de 
celdas de la matriz. De esta manera se logra obtener una complejidad temporal lineal en el tamaño de la instancia.

***Como sabemos que es la solución mas eficiente y que no hay otra mejor?***

También analicé el caso teórico de la complejidad temporal/espacial utilizada en diferentes algoritmos conocidos de búsqueda, las cuales fueron:

- Modelar el problema como un algoritmo de búsqueda sobre grafos, utilizando **DFS** para recorrer el modelo e identificar la presencia de adn mutante.
Esta solución fue descartada porque la búsqueda DFS habría que hacerla al menos desde cada celda, y un recorrido posible desde cada celda para identificar 
adn mutante tiene tamaño 8 en peor caso, resultando en al menos una complejidad teórica de **O(2*8\*N\*N)**.

- Utilizar un algoritmo de backtracking recursivo desde cada celda, descartando los posibles caminos en los cuales ya se identifica de manera temprana 
que el adn contiguo será humano, y de esa manera podando los posibles caminos del árbol de búsqueda asociado. Esta se trataba de una solución elegante, ya que 
con una función recursiva resuelve el problema de una manera muy eficiente, pero la descarté debido a que la complejidad teórica que tiene es: **O(2*8\*N\*N)**. 

- Utilizar un algoritmo de pattern searching de búsqueda de una palabra en un texto, siendo la matriz de adn el texto a buscar y realizar la búsqueda de las palabras
"AAAA", "GGGG", "CCCC" Y "TTTT". De entre todos los algoritmos de pattern searching analizados, la mayoría tenía una complejidad temporal teórica de al menos **O(N)**,
y además de eso al realizar la búsqueda sobre cada palabra la complejidad teórica final daba al menos **O(4\*N\*N)**, con lo cual fueron descartados.

- Uno de los algoritmos de pattern searching resultó tener una complejidad muy interesante para este caso, que es el de Suffix tree pattern searching. 
El cual presenta una complejidad temporal de **O(M)** siendo M el tamaño de la palabra, que en este caso sería 4. 
Es decir, que la solución más eficiente de búsqueda posible sería la utilización de este algoritmo, pero la idea fue descartada debido al contexto de ejecución en
nuestra solución. Esta estructura de suffix tree, es adecuada cuando tenemos un texto que no se modifica muy seguido, y es por eso que resulta muy eficiente para guardar información que no cambia demasiado con el tiempo. En nuestro contexto de uso, no nos sirve recrear esta estructura cada vez que llega una petición de 
análisis de adn. De hecho la creación de la estructura dado un ADN, tiene complejidad **O(N)**. Por eso la estructura fue también descartada.

### Solución desafío nivel 2 <a name="solucionDesafio2"></a>

La construcción de la solución fue presentada utilizando el framework Spring boot, una herramienta versátil que permite levantar un api Rest de manera sencilla, y 
provee varias herramientas que facilitan la administración de la misma.
La aplicación se encuentra hosteada en el cloud computing de **AWS**, el cual brinda de manera gratuita(al menos por un año) un paquete de servicios infraestructurales con el cual podemos hacer uso de servidores web, bases de datos, balanceadores de carga, y muchas otras utilidades varias.

La selección de AWS como infraestructura para levantar la aplicación, es debido al requerimiento de poder soportar 1 millon de requests por segundo durante picos de 
carga de solicitudes. Ellos brindan un servicio en el cual ya está dado un balanceador de carga de requests, y dependiendo de la demanda de las mismas, crean instancias virtuales en su servidor de las denominadas EC2, que son componentes que permiten levantar instancias de la aplicación y poner a disposición las mismas para cumplir con las necesidades de demanda de negocio variables.

En cuanto a las decisiones arquitecturales de diseño de la solución, elegí hacer uso del patrón arquitectural **N-Layered pattern**. En el cual la solución se encuentra dividida en diversas capas, las cuales permiten el desacoplamiento de cada uno de sus módulos, y están claramente asignadas las responsabilidades de cada módulo que conforma la solución. 
Las capas utilizadas son la de presentación, de aplicación, de dominio y de infraestructura. 

El patrón arquitectural fue seleccionado por su simplicidad a la hora de realizar el diseño de la solución de una manera simple, clara y rápida. 
Y además, porque a gran escala, puede ser utilizado en conjunción con **arquitectura de microservicios**. Las cuales van muy de la mano con estas herramientas libres
de AWS de cloud computing, ya que al implementar pequeños modulos independientes, el resultado se vuelve escalable y consistente para poder dar servicios confiables y de calidad.

### Solución desafío nivel 3 <a name="solucionDesafio3"></a>

## Swagger url

http://localhost:5000/swagger-ui/index.html#/dna-controller/processDnaUsingPOST
