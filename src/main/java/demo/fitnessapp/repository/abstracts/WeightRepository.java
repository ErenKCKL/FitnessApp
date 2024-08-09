package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Integer> {
}
