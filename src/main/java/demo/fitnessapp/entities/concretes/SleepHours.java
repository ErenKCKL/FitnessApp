package demo.fitnessapp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "sleephours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SleepHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sleephours")
    private int sleepHours;

}
