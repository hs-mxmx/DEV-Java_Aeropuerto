# Java_Aeropuerto

Simulación del funcionamiento de un Aeropuerto mediante un proyecto codificado en Java dividido en dos partes:

- Parte 1: Programación Concurrente

El programa ha sido creado con el fin de poder tratar diferentes procesos durante el proceso de ejecución, conocidos estos procesos como hilos los cuales se tiene que garantizar un acceso de exclusión mutua a las variables compartidas del programa en aquellas clases y métodos que puedan suponer condiciones de carrera o violaciones de integridad y seguridad.

Para ello se ha implementado 'import java.util.concurrent.locks.ReentrantLock;' con el fin de poder crear un código seguro y eficiente mediante el uso de locks.


- Parte 2: Programación Distribuida

En esta segunda parte se ha implementado una comunicación Cliente / Servidor, el Servidor estará enviando constantemente el estado de la cinta y de las maletas contenidas en el avión, para ello tienen que realizar una apertura de flujos para poder iniciar y establecer la conexión.

El servidor puede funcionar de forma Local o Remota, dando la posibilidad de ejecutarse con LocalHost: '127.0.0.1' con el fin de poder ejecutar la comunicación Cliente / Servidor en la misma máquina, o Remota, donde el Servidor estará a la espera de una conexión con un Cliente.

Para esta segunda parte ha sido necesario implementar 'import java.net.*;'  y 'import java.io.*;' con el fin de poder crear conexiones en puertos especificos y transmitir datos a través de esto mediante una comunicación TCP, el programa tiene por defecto el puerto '5000' pero se le ofrece la oportunidad de cambiarlo tanto al Servidor como al Cliente.

Como futuras mejoras quedaría modificar la transmisión del tipo de dato, en vez de enviar datos de tipo String a través de la red me gustaría implementar una comunicaciónb basada en 'ObjectInputStream' y 'ObjectOutputStream' con el fin de poder tratar los datos como son realmente y no como conversiones modificadas.

- Cumplimientos:

  - [x] Programación Concurrente
  - [x] Programación Distribuida
  - [x] Programación Orientada a Objetos
  - [x] Lenguaje de Programación Java
  - [x] Estructura bien diferenciada Cliente / Servidor
  - [ ] Comunicación Bidireccional (Implementada pero no se le da uso)
  - [ ] Multilenguaje en el código
