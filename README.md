# SUM-Srv-Log-Dts

Tier server arquitecture in Java, Jersey API conection
  1. Runtime: Wildfly 25.0.1 -> Data Layer
  2. Runtime: Wildfly 25.0.1 -> Bussines Layer
  3. Runtime: Tomcat v9 -> Service Layer
  4. Runtime: Tomcat v9 -> Presentation Layer
![image](https://user-images.githubusercontent.com/60512858/172479485-c8688074-0488-4545-ac1a-31e89a372e08.png)

Contents
Manual de instalación y ejecución del proyecto	2
Contexto del proyecto & Configuración del entorno de Java:	2
Propiedades JVM Equipo	2
Configuración de Equipo físico	2
Configuración Eclipse	3
Configuración del proyecto.	4
Contexto del proyecto	4
Extraer los .Zip y abrir proyectos	4
Configuración de contenedores y RuntimeEnviroments (WildFly-Tomcat)	6
Configuración BD/Contexto:	7
Schema	8
Ejecución y corrida	8
Acceso a la presentación:	9












Manual de instalación y ejecución del proyecto
Contexto del proyecto & Configuración del entorno de Java:
-	Propiedades Equipo:
 
-	Versión de JDK y JRE 
 
-	Instalación de JDK y JRE
Link manual de instalacion
Propiedades JVM Equipo
-	Configuración Variables Entorno del sistema
 
 
-	En el path agregar el bin del jdk
 

Configuración de Equipo físico 
-	Descargar Eclipse EE Full
Link descarga:
 

Configuración Eclipse
 
 
Eclipse por defecto toma como referencia un JRE (Java Runtime Enviroment) que este empaquetado en la descarga inicial de eclipse ee, si este es el caso dejar el que esta así, ya que es una versión estable, de lo contrario agregar la referencia al jre que descargo. 
Configuración del proyecto.
Contexto del proyecto
-	Elementos iniciales
 
-	Dir Archivos-Libs-Dependecias Proyect = dependencias y librerías opcionales, en síntesis el proyecto debería funcionar sin adicionar ninguna de las dependencias porque ya están incluidas en los EAR
-	Dir SUM-Presentacion = proyecto dentro de WorkSpace de eclipse a
-	Dir SUM-Srv-Log-Dts = proyecto dentro de WorkSpace de eclipse b
-	Dir RuntimeEnviroments = Contenedores WildFly/TomCat

Extraer los .Zip y abrir proyectos
1.	Abrir el directorio SUM-Presentación como un proyecto en un Workspace a de Eclipse ee
 
 

2.	Abrir el directorio SUM-Srv-Log-Dts como un proyecto de WorkSpace b de Eclipse ee

 
 
Configuración de contenedores y RuntimeEnviroments (WildFly-Tomcat)
-	Contexto
 
-	Extraer contenedores
 
-	Agregar 3 Runtime Enviroments para cada los contenedores de aplicación que haga referencia a la carpeta respectiva en eclipse ee Window/Preferences

 

 

-	Agregar servidores con respectivos RunTimes
 

Replicar los pasos anteriores para el nivel de presentación, hay que recordar que para la el tier de presentación es solo UN runtime.

Configuración BD/Contexto:

 

-	User = root
-	Password = root

Schema
 


Nota. Cada nivel tiene referencia al nivel inmediatamente anterior, con el objeto de llamar las interfaces, es posible que la referencias se pierdan, importar paquetes en donde se haga referencia a otro proyecto y agregar el proyecto al BuildPath Eg. Referencia Nivel de lógica a interface de Datos:
 
Ejecución y corrida
-	Ejecutar cada servidor, en los dos Works paces
 
 
Acceso a la presentación:
-	Acceder a la pagina inicial 
http://localhost:8085/Presentacion/

