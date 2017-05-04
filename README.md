# Spring-Shop
   Java project with crud operations on web.
   
   ![peek 2017-05-03 20-40](https://cloud.githubusercontent.com/assets/16464652/25675664/fd7f389e-3047-11e7-8cca-161b55c95d3d.gif)
 ## Prerequisites
 * Java 1.8
 * Maven >=3.3.9
 * MySQL
    -   mysql -u root -p$mySQL_password -e "CREATE DATABASE IF NOT EXISTS shop;"
    - spring.datasource.password=LACOSTE
 * Bower
    - sudo apt-get update
    - sudo apt install nodejs-legacy
    - sudo apt-get install npm
    - sudo npm install -g bower 
    - sudo npm install -g bowerrc
 
 ## Spring REST, HATEOAS
 spring.data.rest.base-path=/api

        localhost:8080/api
        
 ## Deployment
 To run locally execute
 
      bower install
      mysql -u root -p$mySQL_password -e "CREATE DATABASE IF NOT EXISTS shop;"
      
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
Back end
  * [Spring Boot](https://github.com/spring-projects/spring-data-mongodb) - Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. 
  * [Spring Data JPA](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.
  * [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
## Authors
* **Khimin Nazar** - *Initial work* - [Khimin Nazar](https://github.com/naz1719)

