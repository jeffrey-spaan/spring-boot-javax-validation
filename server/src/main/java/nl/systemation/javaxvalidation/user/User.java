package nl.systemation.javaxvalidation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @Author Jeffrey Spaan
 * @Company Systemation
 * @Created on Thursday, August 27th, 2020
 * @Updated on Sunday, August 30th, 2020
 */

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
