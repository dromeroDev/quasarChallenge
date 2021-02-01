# Operación ​Fuego de Quasar

Solución al Challenge Operación ​Fuego de Quasar con Backend (Java) y Frontend (Angular)

## Empezando

Estas instrucciones le proporcionarán una copia del proyecto en su máquina local con fines de desarrollo y prueba. Consulte la implementación para obtener informacón sobre cómo implementar el proyecto en producción. 

### Prerequisitos

- IDE : SpringToolSuite o Eclipse
- Terminal
- Navegador web
- Maven
- Java 8
- Angular Cli
- Node
- npm

### Estructura del proyecto

#### Backend (Java)
Patron MVC (Modelo - Vista - Controlador)
Cada capa tiene una responsabilidad particular y cada paquete del proyecto agrupa clases comunes: 
- controllers: reciben y tratan los request http.
- services: lógica de negocio.
- entidades: los modelos que representan el negocio.
- dto: clase de objetos que se devuelven a la vista
- contants: variables estaticas que se utilizan en la aplicación
- forms: clase de objetos que se reciben de la vista
- validators: validaciones personalizadas 
- exceptions: excepciones personalizadas para el manejo de errores.

#### Frontend (Angular)
Arquitectura modular (Cada modulo tiene una responsabilidad particular): 
- Core: Para aquellos componentes, servicios, entre otros que se manejan de forma singleton en la aplicación.
- Share: Para aquellos componentes que serán compartidos en nuestra aplicación. 
- Layout: Estructura estatica y molde de la aplicación
- Modules: Para aquellos modulos con componentes que realizan una funcionalidad especifica en el proyecto.

### Instalación y ejecución

1. Importar el proyecto al IDE como "Existing Maven Projects"

2. Ejecutar desde la terminal en el raiz del proyecto: mvn install

3. Desde el IDE correr la aplicación con "Run - Run As - Spring Boot App"

4. Desde el navegador ingresar http://localhost:8080

5. Disfrute la aplicación

## Test

Los test se encuentran en: src/test/java 

Podra ejecutar uno a uno desde el IDE (Run As - JUnit) o utilizando la terminal bajo el comando 'mvn test'

## Deploy

El deploy en AWS se realiza bajo el uso de Elastic

1. Crea una aplicación de Elastic Beanstalk llamada getting-started-app.

2. Lanza un entorno llamado GettingStartedApp-env con estos recursos de AWS:

- Una instancia de Amazon Elastic Compute Cloud (Amazon EC2) (máquina virtual)
- Un grupo de seguridad de Amazon EC2
- Un bucket de Amazon Simple Storage Service (Amazon S3)
- Alarmas de Amazon CloudWatch
- Una pila de AWS CloudFormation
- Un nombre de dominio

3. Cree una nueva versión de la aplicación llamada Sample Application (Aplicación de muestra). Este es el archivo de aplicación de ejemplo predeterminado de Elastic Beanstalk.

4. Implementa el código para la aplicación de ejemplo en el entorno GettingStartedApp-env.

Cuando se lancen todos los recursos y las instancias EC2 que ejecutan la aplicación superen las comprobaciones de estado, los cambios de estado del entorno tendrán el valor Ok. Ahora puede usar el sitio web de su aplicación web.

Ejemplo: http://quasar-env.eba-wabjzdvt.sa-east-1.elasticbeanstalk.com/

## Autor

* **Diego Romero - dromeroDev** 



