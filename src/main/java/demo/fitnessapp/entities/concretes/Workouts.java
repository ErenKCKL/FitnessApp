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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercises_id")
    private Exercises exercises;

    @Column(name = "sets")
    private int sets;

    @Column(name = "repeats")
    private int repeats;
    

}
