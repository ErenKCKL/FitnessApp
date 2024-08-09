package demo.fitnessapp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "weight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "weight")
    private double weight;
}
