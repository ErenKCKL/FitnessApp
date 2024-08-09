package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.CaloriesBurned;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaloriesBurnedRepository extends JpaRepository<CaloriesBurned, Integer> {
}
