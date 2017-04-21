# Spring-Shop
   Java project with crud operations on web.
   
 ## Prerequisites
 * Java 1.8
 * Maven >=3.3.9
 * MongoDB 3.4.3
 * Bower
    - sudo apt-get update
    - sudo apt-get install nodejs
    - sudo apt-get install npm
    - sudo npm install -g bower 
    - sudo npm install -g bowerrc
 
 ## Spring REST, HATEOAS
 spring.data.rest.base-path=/api

        localhost:8080/api
        
 ## Deployment
 To run locally execute
 
      bower install
      
      mvn package
      java -jar target/*.jar 
      
## Configuration 
     
  * [Thymelif with Angular](https://teamtreehouse.com/library/using-thymeleaf-to-serve-html)
    - Add a properties file at src/main/resources/application.properties
    - Add the following text at the top:
       spring.thymeleaf.mode = LEGACYHTML5
    - HTML parser, In the dependencies block of build.gradle, add Neko HTML as a runtime dependency:
      nekohtml:1.9.22'  

## Built With
  * [Spring Data JPA](https://github.com/spring-projects/spring-data-mongodb) - Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. 
## Authors
* **Khimin Nazar** - *Initial work* - [Khimin Nazar](https://github.com/naz1719)

