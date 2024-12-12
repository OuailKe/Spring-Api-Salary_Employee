package Entities;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "employee") @Data
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Users {

    private String firstName;
    private String lastName;
    private String adress;
    private String email;
}
