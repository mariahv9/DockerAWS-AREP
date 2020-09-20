# Taller de de modularización con virtualización e Introducción a Docker y a AWS

Uso de los servicios EC2 de AWS y Docker para la creación de un servicio Web.

## Clonacion del repositorio 

Para clonar el proyecto usar el siguiente comando:

```
git clone https://github.com/mariahv9/DockerAWS-AREP
```

### Ejecucion App

```
cd DockerAWS-AREP
cd RoundRobin
mvn package
java -cp java -cp target/classes;target/dependency/* edu.escuelaing.arep.SparkWebServer
```

Abrir el siguiente para ver el servicio:

* [Link Local](http://localhost:4567/index)

### Control versionamiento

[![CircleCI]()]()

## Construido con 

* [Java 8](https://www.java.com/es/about/whatis_java.jsp)
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Heroku](https://dashboard.heroku.com/) - Despliegue
* [CircleCI](https://circleci.com/) - Control de versionamiento


## Autor

* **Maria Fernanda Hernandez Vargas** - [mariahv9](https://github.com/mariahv9)


## Licencia

Este proyecto está bajo la Licencia GNU General Public License - mira el archivo [LICENSE.txt](LICENSE.txt) para detalles

