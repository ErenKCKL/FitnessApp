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

    @ManyToOne
    @JoinColumn(name = "height_id", nullable = false)
    private Height height;

    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "weight_id", nullable = false)
    private Weight weight;

    @ManyToOne
    @JoinColumn(name = "sleephours_id", nullable = false)
    private SleepHours sleepHours;

    @ManyToOne
    @JoinColumn(name = "workouts_id", nullable = false)
    private Workouts workout;

    @Column(name = "date")
    private LocalDate date;

    private int caloriesBurned;
}
