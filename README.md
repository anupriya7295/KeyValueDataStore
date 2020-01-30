# Key value Datastore
- KeyValueDatastore application provides (create, delete, read) api to access datastore.
- It import library datastore that can instantiate a class and work with datastore.

# Features!
- Datastore can be initialized using optional file path.If one is not provided then  it will create itslef in reasonable location(all OS).
- New key value pair can be added to datastore using create API.
- Read operation on key is performed by using read API , providing key and receiving value as JSON
- Delete operation can be performed by using delete API with key.
- Every key supports setting Time-To-Live(TTL) when it is created , it is optional.
if provided then it will be considered as seconds.Once the TTL for key is expired then key will no longer available for read or delete.

### Prerequisite
* [JAVA 8]
* [MAVEN 3]
Frame work 
* [Spring Boot]

### To Use Datastore
Import applicaation in eclipse and run as spring boot application.

If windows OS then datastore in following path 
```
C:\Users\[username]\datastore.txt
```
```
datastore - C:\Users\[username]\datastore.txt
dataStoreLineMap - C:\Users\[username]\datastorelinemap.json
dataStoreDeactivatedKey - C:\Users\[username]\datastoredeactivatedkey.json
```
After application started on port 8080. click below link to access swagger.

NOTE: datastorelibrary in datastore repository

http://localhost:8080/swagger-ui.html#/

   [JAVA 8]: <https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html>
   [MAVEN 3]: <https://maven.apache.org/>
   [Spring Boot]: <https://spring.io/projects/spring-boot>
   
   
   