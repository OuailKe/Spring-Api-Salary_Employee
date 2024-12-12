package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data @RequiredArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fId;
    private int hours;
    private double amount;
    private final double tax = 0.2;
    private double netAmount;
    private double grossAmount;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Employee employee;
}
