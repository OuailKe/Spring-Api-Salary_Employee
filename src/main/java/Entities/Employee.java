package Entities;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "employee") @Data
@RequiredArgsConstructor @Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Users {

    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    public Employee(String username, String password, Role role, String firstName, String lastName, String adress, String email) {
        super(username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
