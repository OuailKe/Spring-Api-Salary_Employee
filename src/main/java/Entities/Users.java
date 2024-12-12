package Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data @RequiredArgsConstructor @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
