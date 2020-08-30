# Spring Boot Javax Validation Example
*Created on: 27-08-2020*<br />
*Last updated on: 27-08-2020*

**Contributor:**<br />
Jeffrey Spaan *(Solution Consultant @ Systemation, the Netherlands)*

Welcome developer. Securing your application against incorrect input, for example SQL injections, is a complex task.<br />
To prevent incorrect input within your Java application, **Javax Validation** enforces constraints on object data. Also known as Bean Validation.<br />
In this tutorial we will cover the basics and setup of a **Spring Boot application** with **Javax Validation**.

### What is Spring Boot?
**Spring Boot** is a Java-Based framework used, and not limited to, creating micro service applications.<br />
Configuring the back-end of your application is easier than ever with the use of Spring Boot dependencies which enables you to simply select the required dependencies to quickly setup the back-end of your application.<br />

### What is Javax Validation?
Validating user input is, of course, an incredible common requirement in the majority of applications, and the **Java Bean Validation framework** has become the de-facto standard for handling this kind of logic.
**Javax Validation** is a standard framework - **JSR 380**, also known as ***Bean Validation 2.0*** enforcing constraints using data annotations such as, and not limited to:<br />
***@NotNull<br />
 @Email<br />
 @Digits<br />
 @Size<br />
 @Pattern***<br />
 [and many more...](https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html)

## Getting Started

Create your project folder on your hard-drive, for this example we will use: ```spring-boot-javax-validation\server```<br /><br />
![Project folder](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/01-folderstructure.JPG)

<br />

In your browser, navigate to: [https://start.spring.io](https://start.spring.io)<br />
* **Project:** ```Maven Project```<br />
* **Language:** ```Java```<br />
* **Spring Boot (version):** We will use the latest stable version: ```2.3.3```<br />
* **Group:** this is your internet domain, backwards. For Systemation we will use: ```nl.systemation```<br />
* **Artifact:** this is the name of your project. For this project we will use: ```javaxvalidation```<br />
* **Description:** this is a short description about your project. For this project we will use: ```Demo Project Spring Boot Javax Validation```<br />
* **Packaging:** ```JAR```<br />
* **Java:** (we will use the latest supported version): ```11```<br />
* **Dependencies:** ```Lombok, Spring Web, Spring Data JPA, H2 Database```

To create the Spring Boot application, click on: ![Spring Boot Dependency Selection](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/03-generate.JPG)

![Spring Boot Dependency Selection](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/02-startspringio.JPG)

The download of the ZIP file will start automatically. Open the ZIP file and extract the project files in your project folder.<br />

![Spring Boot Dependency Selection](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/05-unzip.JPG)

Open the project folder in your favorite IDE.<br />

## Dependencies information
### Lombok
Project Lombok is a Java library that automatically plugs into the editor and build tools, spicing up Java.
Never write another getter or equals method again. Ideal to reduce boilerplate code.<br />
Want to know more about the specific Lombok annotations which we will use in our project? Visit: https://projectlombok.org/ <br />
**Tip:** Do not forget to install the Lombok plugin in your IDE.

### Spring Web
Spring Web provides core HTTP integration, including some handy Servlet filters, Spring HTTP Invoker, infrastructure to integrate with other web frameworks and HTTP technologies.

### Spring Data JPA
The Java Persistence API (JPA) is a Java specification for accessing, persisting, and managing data between Java objects / classes and a relational database.

### H2 Database
H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode. Mainly, H2 database can be configured to run as inmemory database, which means that data will not persist on the disk.

### POM.xml
A Project Object Model or POM is the fundamental unit of work in Maven.<br />
It is an XML file that contains information about the project and configuration details used by Maven to build the project.<br />
<br />
The following listing shows the ```POM.xml``` file that is created once you've chosen a Maven project:<br />
**NOTE:** Add the ```Spring Boot Validation``` dependency in your pre-generated ```POM.xml``` file!
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.3.3.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>nl.systemation</groupId>
	<artifactId>javaxvalidation</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>javaxvalidation</name>
	<description>Demo Project Spring Boot Javax Validation</description>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- Add this dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```
<hr>

## Create back-end files
Now let's add some code to make a fully functioning **Spring Boot MVC servlet.**<br />
To do so, following files have to be created:
* Entity
* Controller
* Service
* Repository

The files have to be added according the best practices **Spring Boot Architecture guidelines**.

```bash
server\src\main\java\nl\systemation\javaxvalidation
└──user
   ├──User.java
   ├──UserController.java       
   ├──UserRepository.java
   └──UserService.java
```
<hr>

### Spring Boot Entity
Let's add an entity to enable Spring Boot to persist data to/from the database.<br />
To do so, add an entity named: ```User.java```<br />
Annotate the entity with the **Spring Boot** ```@Entity``` annotation.<br />
This annotation will instruct Spring Boot that the class is an entity and is mapped to a database table.<br /><br />
We will also use some Lombok annotations to reduce boilerplate code and ensure our code will remain easy to read.

```java
@Data // Lombok to create the Getters and Setters
@AllArgsConstructor // Lombok to create the All Args Constructor
@NoArgsConstructor // Lombok to create the No Args Constructor
@Entity // Spring Boot annotation to enable database persistence
@Table(name = "users") // Persist data into table with name users
public class User {

    @Id // Database table key is the ID
    @GeneratedValue(strategy = GenerationType.AUTO) // Create key value sequence and auto generate the identifier
    private Long id;

    @NotNull // Value is mandatory
    @Size(min = 2, max = 50) // Value must contain at least 2 characters and a maximum of 50 characters
    @Pattern(regexp = "[a-zA-Z]+") // Value must consist of values as per Regular Expression pattern
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @NotNull
    @Digits(integer = 3, fraction = 0) // Value must consist of digits only with a maximum of 3 digits
    private int age;

    @NotNull
    @Email // Value must be an email address
    private String email;

    @JsonIgnore // Ignore the password with JSON requests (security related)
    private String password;
}
```
<hr>

### Spring Boot Controller
In order to access the API via the front-end (HTTP request), an access point is mandatory.<br />
Let's add a controller named: ```UserController.java``` <br/>
```@RestController```: This is a **Spring Boot** annotation which marks the Java class as a Controller;<br />
```@RequestMapping```: This is a **Spring Boot** annotation which maps ```"/api/user"``` as the API access point;

```java
@RequiredArgsConstructor // Lombok to create the Required Args Constructor
@CrossOrigin(origins="http://localhost:3000", maxAge = 3600) // Allow access from port 3000 to this API
@RestController // Mark this Java class as the controller layer
@RequestMapping("/api/users") // Link to the API access point
public class UserController {

    private final UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    // NOTE: @Valid annotation enables the Bean Validation annotations as per the entity
    // The incoming JSON data is checked against the Bean Validation annotations as per the entity
    @PostMapping
    public void addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}") // DELETE request handler by ID
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
```
<hr>

### Spring Boot Service
In order to process the requests, coming in via the Controller, business logic is written in the **Spring Boot Service** layer.<br />
Via the service layer, commands will be given to the repository to transfer data to/from the database.<br />
```@Service```: This is a **Spring Boot** annotation which marks the Java class as the Service layer;<br />

```java
@RequiredArgsConstructor // Lombok to create the Required Args Constructor
@Service // Mark this Java class as the service layer
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
```
<hr>

### Spring Boot Repository
The repository will handle the commands which it receives from the service layer.<br />
The repository can implement a variety of commands from various repositories.<br />
In this example we will implement the JpaRepository, which has some pre-configured methods which we use in our service layer, such as:
* **findAll** *(gets all data from a specific database table)*
* **findById** *(gets data from a specific row, which is found via the provided ID)*
* **save** *(saves data to the database table)*
* **deleteById** *(deletes data from a specific row, which is found via the provided ID)*

```@Repository```: This is a **Spring Boot** annotation which marks the Java interface as the Repository;

```java
@Repository // Mark this Java class as the repository layer
public interface UserRepository extends JpaRepository<User, Long> {
}
```
<hr>

## Database connectivity

### application.properties
Now we will connect the H2 Database with our code.<br />
In the ```server\src\main\resources``` folder, find the ```application.properties``` file.<br />
Here we will add following lines to connect the server with the database, enabling us to persist data to/from the database.

```properties
# H2 Database name:
spring.datasource.url=jdbc:h2:mem:testdb

# H2 Database driver:
spring.datasource.driverClassName=org.h2.Driver

# H2 Database credentials:
spring.datasource.username=sa
spring.datasource.password=password

# H2 Database dialect:
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Enable H2 Database access via http://localhost:8080/h2-console
spring.h2.console.enabled=true
```

**NOTE:** *With application startup the database is automatically generated as per the ```application.properties``` settings.*
<hr>

### Download Postman
In order for us to test the http requests, download Postman via: https://www.postman.com/downloads/ <br />
Once installed, start-up Postman.
<hr>

## Start server

Open the terminal window, and execute following command:<br />
*Note, each command line will be indicated with the **$** symbol.*
```bash
$ cd server
$ mvn spring-boot:run
```

Once the server has started, we will test our application with Postman.<br />
Postman enables us to test the http requests, which are pre-set in the **Spring Boot controller layer**.<br />
<br />
First let's test the **POST user HTTP request** happy path (with correctly provided JSON data):
<br />

![Postman HTTP Post user request with correct data](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/06-postmanpostcorrect.JPG)

As you can see, the response from the server is ```Status 200```, meaning the HTTP Post request is executed without error.

<br />

Now let's test the **POST user HTTP request** unhappy path (with incorrect provided first name):
<br />

![Postman HTTP Post user request with incorrect first name](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/07-postmanpostincorrectname.JPG)

As you can see, the response from the server is ```Status 400```, meaning the HTTP Post request is rejected due to incorrect provided JSON data.
To see more details about the error, ***open your terminal.***

<br />

Now let's test the **POST user HTTP request** unhappy path (with incorrect provided age):
<br />

![Postman HTTP Post user request with incorrect age](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/08-postmanpostincorrectage.JPG)

As you can see, the response from the server is ```Status 400```, meaning the HTTP Post request is rejected due to incorrect provided JSON data.
To see more details about the error, ***open your terminal.***

<br />

Finally let's test the **POST user HTTP request** unhappy path (with incorrect email):
<br />

![Postman HTTP Post user request with incorrect age](https://raw.githubusercontent.com/jeffrey-spaan/spring-boot-javax-validation/master/images/09-postmanpostincorrectemail.JPG)

Again you will see the ```Status 400``` response from the server, meaning the HTTP Post request is again rejected due to incorrect provided JSON data.
To see more details about the error, ***open your terminal.***
<br />

### Congratulations!
You have successfully created a **Spring Boot application** which validates input data **(Bean Validation)** with the use of **Javax Validation annotations.** <br />
With this we have come to the end of this tutorial.<br />
I hope you've enjoyed the process, please give it a **Star** in case you liked it.<br />
Thank you for your support!