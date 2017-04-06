# CLI-Data-Manager
   Java project with the console interface for 
   library managing. Available such commands:
   
            book add --author 'J.K. Rownling' --title 'Harry Potter' 
            book list    // return a list of all books ordered by name in asceding direction
            book edit --author 'J.K. Rownling' --newAuthor 'N.O. Khimin'             
            book remove --title 'Harry Potter'
 
 ![peek 2017-03-30 11-14](https://cloud.githubusercontent.com/assets/16464652/24494563/5f440f32-153b-11e7-9ad4-3db347320638.gif)
 ## Prerequisites
 * Java 1.8
 * Maven >=3.3.9
 * MongoDB 3.4.3
 * Bower
    1. npm install -g bower // Install bower
    2. npm install -g bowerrc // Install bowerrc for location bower_components    
 
 
 
 ## Deployment
 To run locally execute
 
      bower install
      
      mvn package
      java -jar target/*.jar 
      
## Built With
  * [Spring Shell](https://github.com/spring-projects/spring-shell) - Spring Shell is an shell skeleton that can be easily extended with commands using a Spring based programming model. 
  * [Spring Data Mongo](https://github.com/spring-projects/spring-data-mongodb) - Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. 
## Authors
* **Khimin Nazar** - *Initial work* - [Khimin Nazar](https://github.com/naz1719)

