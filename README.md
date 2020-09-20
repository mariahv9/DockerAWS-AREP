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
* [Link AWS](http://ec2-35-175-129-150.compute-1.amazonaws.com:51004/index)

### Control versionamiento

[![CircleCI](https://circleci.com/gh/mariahv9/DockerAWS-AREP.svg?style=svg&circle-token=fa8c51f3bedd926b133267148a5e3c22e1617f4a)](https://app.circleci.com/pipelines/github/mariahv9/DockerAWS-AREP)

## Construido con 

* [Java 8](https://www.java.com/es/about/whatis_java.jsp)
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Docker](https://www.docker.com/) - Contenedores
* [Docker Hub](https://hub.docker.com/) - Repositorio de contenedores
* [AWS](https://console.aws.amazon.com/ec2/v2/home?region=us-east-1#Home:) - Creacion de servicio EC2
* [CircleCI](https://circleci.com/) - Control de versionamiento


## Autor

* **Maria Fernanda Hernandez Vargas** - [mariahv9](https://github.com/mariahv9)


## Licencia

Este proyecto está bajo la Licencia GNU General Public License - mira el archivo [LICENSE.txt](LICENSE.txt) para detalles

