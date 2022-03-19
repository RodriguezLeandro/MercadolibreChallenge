# Mercadolibre Challenge

 Desafío técnico para el puesto de software developer en Mercadolibre.
 
 # Table of Contents

* [Consigna](#consigna)
* [Desafíos](#desafios)
* [Solución desafío 1](#solucionDesafio1)
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

La solución planteada 


## Swagger url

http://localhost:5000/swagger-ui/index.html#/dna-controller/processDnaUsingPOST
