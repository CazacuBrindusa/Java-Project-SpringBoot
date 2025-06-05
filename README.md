# Java-Project-SpringBoot

Create a backend by using a custom made TCP Server or a Spring Boot application. The application should allow CRUD (Create, Read, Update, Delete) operations on an entity related to your bachelor’s degree application.


The backend should allow the following operations:

POST http://locahost:port/entity => where port is a dedicated port and entity the name of the chosen entity related to your thesis; this call will save the entity (sent as a JSON) in memory in a dedicated data structure (collection)
GET http://locahost:port/entities => where port is a dedicated port and entities the plural for the name of the chosen entity related to your thesis; this call will return all the entities that are saved in memory as a JSON
GET http://locahost:port/entity/1 => where port is a dedicated port, entity the name of the chosen entity related to your thesis and 1 the id of the entity that you want to get the details of; this call will return the entity that is saved in memory with id 1 as a JSON or an HTTP 404 error code if the id does not exist
PUT http://locahost:port/entity/1 => where port is a dedicated port, entity the name of the chosen entity related to your thesis and 1 the id of the entity that you want to update; this call will update the entity that is saved in memory with id 1 based on the details sent as JSON or an HTTP 400 error code if the id does not exist or the data is not valid
DELETE http://locahost:port/entity/1 => where port is a dedicated port, entity the name of the chosen entity related to your thesis and 1 the id of the entity that you want to delete; this call will delete the entity that is saved in memory with id 1 or return an HTTP 400 error code if the id does not exist
