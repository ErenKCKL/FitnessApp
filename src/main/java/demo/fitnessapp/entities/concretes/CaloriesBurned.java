package demo.fitnessapp.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calories_burned")
@Setter
public class CaloriesBurned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "training_programs_id")
    private TrainingPrograms trainingProgram;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private int caloriesBurned;

}
