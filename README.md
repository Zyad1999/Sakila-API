
# Sakila API

This project provides an API for the Sakila database, which is a sample database used for testing and education purposes. The API is available in two styles: Representational State Transfer (REST) and Simple Object Access Protocol (SOAP). It uses JAX-RS and JAX-WS to create the web services, JPA to interact with MySQL database, and Maven to manage the project. It also utilizes Lombok and MapStruct for improved code generation and Tomcat for deployment.


## Technologies Used

- JAX-RS
- JAX-WS
- JPA
- Maven
- Lombok
- MapStruct
- Tomcat
## Getting Started


### Requirements

- Java 11 or higher
- Maven
- Tomcat
- MySQL Server
- Sakila DB


### Installation

To get started with this project, you will need to clone this repository onto your local machine:

```bash
  git clone https://github.com/Zyad1999/Sakila-API
```
- Configure the Sakila-API/src/main/resources/META-INF/persistence.xml file with your DB credentials.
- Configure the tomcat plguin in the Sakila-API/pom.xml file with your tomcat credentials.


### Deployment

To deploy this project run

```bash
  cd Sakila-API
  mvn install tomcat7:deploy
```


## Documentation

- [REST Documentation](https://documenter.getpostman.com/view/12328895/2s93Y3uLQr)
- [SOAP WSDL](https://github.com/Zyad1999/Sakila-API/blob/main/SakilaAPI-SOAP.xml)


## Usage
- The REST endpoints can be accessed at http://localhost:9090/sakilaAPI/rest
- The SOAP endpoints can be accessed at http://localhost:9090/sakilaAPI/soap
## REST API Reference

- The REST API provides endpoints for CRUD operation at all the resources in addintion to enpoints for the bussines logic.

- CRUD operations on the resources follow this pattern.

#### Get all entites of table paginated

```http
  GET /sakilaAPI/rest/entity?limit=1&offset=0
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `limit` | `int` | **Required**. Number of entites returned |
| `offset` | `int` | **Required**. Number of entites skipped |

#### Get signle entity with id

```http
  GET /sakilaAPI/rest/entity/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of entity to fetch |

#### Add an entity to table

```http
  POST /sakilaAPI/rest/entity
```

| Body | Location     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `EntityRequest`      | `Sakila-API\src\main\java\com\sakilaAPI\service\dtos\requests` | **Required**. Body of the entity that will be added|

#### Update an entity

```http
  POST /sakilaAPI/rest/entity/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of the entity that will be updated  |

| Body | Location     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `EntityRequest`      | `Sakila-API\src\main\java\com\sakilaAPI\service\dtos\requests` | **Optional**. Body of attributes to be updated|

#### Delete an entity

```http
  DELETE /sakilaAPI/rest/entity/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of entity to delete |

## SOAP API Reference

- The SOAP API provides a Web Service for all the entites which containg CRUD operations on the entity and the bussiness logic of the entity if any.
- The services follow this pattern.

#### Endpoint

| Service Name  | Port Name     | Description                |
| :-------- | :------- | :------------------------- |
| `EntityService` | `EntityPort` | The endpoint of the entity|

#### Information

| Address  | WSDL     | Implementation class |
| :-------- | :------- | :------------------------- |
| `/sakilaAPI/soap/entity` | `/sakilaAPI/soap/entity?wsdl` | `	com.sakilaAPI.api.soap.services.Entity` |


## Contributing

Contributions are always welcome! Please feel free to open a pull request or an issue if you would like to contribute to this project.