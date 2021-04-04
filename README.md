# TAREA DE AMAZON GATEWAY Y LAMBDA
# Sebastián Villamarín Rodríguez
# AREP-LAB7

## Descripción

	1. Cree un servicio Web en Spark que convierta de grados farenheit en grados celcius. El servicio debe responder un JSON.
	2. Despliegue el servicio en una máquina de AWS EC2 y publíquelo.
	3. Cree una ruta en el API getway para acceder al servicio . Ojo ya la integración no es con función lambda.
	4. Cree un aplicación JS para usar el servicio. Depliegue la aplicación en S3. Asegúrese que esté disponible sobre internet.
	5. Pruebe la aplicación Web
	6. Entregue el código desarrollado en Github, un reporte de las pruebas, y u video con el experimento funcionando.
	7. Intente que el servicio en EC2 no esté accesible sobre internet, solo debe estar accesible por medio del API gateway
	
## Prerrequisitos

Para la realización y ejecución tanto del programa como de las pruebas de este, se requieren ser instalados los siguientes programas:

  - Maven. Herramienta que se encarga de estandarizar la estructura física de los proyectos de software, maneja dependencias (librerías) automáticamente desde repositorios y           administra el flujo de vida de construcción de un software.
  - GIT. Sistema de control de versiones que almacena cambios sobre un archivo o un conjunto de archivos, permite recuperar versiones previas de esos archivos y permite otras         cosas como el manejo de ramas (branches).
  - Docker. Programa encargado de crear contenedores ligeros y portables para las aplicaciones software que puedan ejecutarse en cualquier máquina con Docker instalado,               independientemente del sistema operativo que la máquina tenga por debajo, facilitando así también los despliegues.
  
Para asegurar que el usuario cumple con todos los prerrequisitos para poder ejecutar el programa, es necesario disponer de un Shell o Símbolo del Sistema para ejecutar los siguientes comandos para comprobar que todos los programas están instalados correctamente, para así compilar y ejecutar tanto las pruebas como el programa correctamente.

  - mvn -version
  - git --version
  - java -version
  - docker version
  
# Instalación
Para descargar el proyecto de GitHub, primero debemos clonar este repositorio, ejecutando la siguiente línea de comando en GIT.
	
	https://github.com/svillamarin27/AREP-LAB7.git
	
# Ejecución
Para compilar el proyecto utilizando la herramienta Maven, nos dirigimos al directorio donde se encuentra alojado el proyecto, y dentro de este ejecutamos en un Shell o Símbolo del Sistema el siguiente comando:

      mvn package
	  
# Rol en Identity and Access Management (IAM)

Primero se debe crear un rol en Identity and Access Management **(IAM)**. Para crear este rol, primero se accede al Dashboard de AWS educate, y se selecciona la opción IAM.

![image](https://user-images.githubusercontent.com/37603257/113606604-dc517800-960d-11eb-9071-adca53db738d.png)

Para seleccionar roles en AWS, se selecciona la opción Roles de la página de AWS.

![image](https://user-images.githubusercontent.com/37603257/113606852-289cb800-960e-11eb-9130-b1c7d9bec483.png)

Se crea un nuevo rol para poder iniciar con la creación de un rol en AWS.

![image](https://user-images.githubusercontent.com/37603257/113607199-8e893f80-960e-11eb-88c1-f2bf6f8c5a09.png)

Luego ,se realiza clic en el botón **Lambda** para crear un rol para las funciones Lambda, y luego clic en el botón Siguiente:Permisos.

![image](https://user-images.githubusercontent.com/37603257/113607521-e7f16e80-960e-11eb-838e-34ebbeed61e3.png)

Para crear un rol que tenga todas las políticas de permisos para no tener ningún conflicto de permisos , se seleccionan las políticas **AdministratorAccess** para poder evitar dichos conflictos sobre las funciones lambda. Luego se realiza clic en Siguiente: Etiquetas.

![image](https://user-images.githubusercontent.com/37603257/113608042-9c8b9000-960f-11eb-9cc4-f7a10323b8a0.png)

La siguiente pagina se deja como está por defecto, y se realiza clic en el botón Siguiente: Revisar.

![image](https://user-images.githubusercontent.com/37603257/113608313-03a94480-9610-11eb-810b-134f65d67d71.png)

Para crear el rol, se ingresa el nombre del rol que es **VILLAREP**, se deja la descripción del rol que se ingresa automáticamente por el sistema. Luego se procede a realizar clic en el botón Crear un rol.

![image](https://user-images.githubusercontent.com/37603257/113608608-6bf82600-9610-11eb-95db-00da419ec390.png)

Para finalizar con la creación del rol que se utilizará para la función lambda, se realiza la respectiva verificación comprobando que se encuentre el rol en la lista de roles creados en AWS.

![image](https://user-images.githubusercontent.com/37603257/113608921-c5f8eb80-9610-11eb-9088-a9c0fec40b3b.png)

