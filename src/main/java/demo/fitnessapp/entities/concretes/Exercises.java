package demo.fitnessapp.entities.concretes;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Entity
@Table(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exercises {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id;

    @Column(name = "name")
    String name;

}
