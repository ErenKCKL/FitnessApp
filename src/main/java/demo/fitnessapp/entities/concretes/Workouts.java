package demo.fitnessapp.entities.concretes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Entity
@Table(name = "workouts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Workouts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sets;
    private int repeats;

    @ManyToOne
    @JoinColumn(name = "exercises_id")
    private Exercises exercise;

    @ManyToOne
    @JoinColumn(name = "training_programs_id")
    private TrainingPrograms trainingProgram;
    

}
