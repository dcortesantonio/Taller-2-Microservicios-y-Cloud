# Taller-2-Microservicios-y-Cloud

- [Parte 1](#heading)
- [Parte 2](#heading-1)
  * [Servidor Eureka](#sub-heading-1)
    + [Operaciones](#sub-sub-heading-1)
  * [Postman](#sub-heading-2)

  <a name="heading-1"></a>
  ## Parte 2 - Spring Cloud

  <a name="sub-heading-1"></a>
  ### Servidor Eureka
  - [ ]  Clonar el repositorio
      ```bash
      git clone https://github.com/dcortesantonio/Taller-2-Microservicios-y-Cloud.git
      ```
  - [ ]  Moverse a la carpeta ***eurekaserver*** en la carpeta  ***Punto2***
      ```bash
      cd /Punto2/eurekaserver
      ```
  - [ ]  Correr el servidor
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```
      <a name="sub-sub-heading-1"></a>
      #### Calculadora y Operaciones  
      Se deben correr cada una de las proyectos de las operaciones, y el proyecto calculadora.

      - [ ]  Correr dos instancias del proyecto sumador, en el puerto 9001 y 9002:
          ```bash
          cd /Punto2/sumador
          mvn clean install
          SERVER_PORT=9001 mvn spring-boot:run &
          SERVER_PORT=9002 mvn spring-boot:run &
          ```

      - [ ]  Correr dos instancias del proyecto sumador, en el puerto 9003 y 9004:
          ```bash
          cd /Punto2/restador
          mvn clean install
          SERVER_PORT=9003 mvn spring-boot:run &
          SERVER_PORT=9004 mvn spring-boot:run &
          ```
      - [ ]  Correr dos instancias del proyecto restador, en el puerto 9003 y 9004:
          ```bash
          cd /Punto2/restador
          mvn clean install
          SERVER_PORT=9003 mvn spring-boot:run &
          SERVER_PORT=9004 mvn spring-boot:run &
          ```
      - [ ]  Correr dos instancias del proyecto multiplicador, en el puerto 9005 y 9006:
          ```bash
          cd /Punto2/multiplicador
          mvn clean install
          SERVER_PORT=9005 mvn spring-boot:run &
          SERVER_PORT=9006 mvn spring-boot:run &
          ```          
      - [ ]  Correr dos instancias del proyecto divisor, en el puerto 9007 y 9008:
          ```bash
          cd /Punto2/divisor
          mvn clean install
          SERVER_PORT=9007 mvn spring-boot:run &
          SERVER_PORT=9008 mvn spring-boot:run &
          ```        
      - [ ]  Correr el proyecto calculator:
          ```bash
          cd /Punto2/calculator
          mvn clean install
          mvn spring-boot:run &
          ```                   

<a name="sub-heading-2"></a>
  #### Postman  
  Probar el servidor con el navegador o postman:

  - Ruta realizar una suma:  - http://localhost:8888/calculadora/suma?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una resta:  - http://localhost:8888/calculadora/resta?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una multiplicación:  - http://localhost:8888/calculadora/multip?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una división:  - http://localhost:8888/calculadora/div?a=(varA)&b=(varB)&user=(varUser)/
    - (varA) : Se refiere al primer número al cual se le realizará la operación.
    - (varB) : Se refiere al segundo número al cual se le realizará la operación.
    - (varUser) : Se refiere a una cadena de texto la cual representa un usuario.
