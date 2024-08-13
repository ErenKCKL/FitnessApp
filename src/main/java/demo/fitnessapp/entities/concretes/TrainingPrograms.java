package demo.fitnessapp.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "training_programs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrainingPrograms {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate date;

    @OneToMany(mappedBy = "trainingProgram")
    private List<Workouts> workouts;
}
