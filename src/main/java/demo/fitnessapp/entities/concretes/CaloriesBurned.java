package demo.fitnessapp.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "caloriesburned")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CaloriesBurned {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "trainingprograms_id", nullable = false)
    private TrainingPrograms trainingProgram;

    @Column(name = "caloriesburned")
    private int caloriesBurned;
}
