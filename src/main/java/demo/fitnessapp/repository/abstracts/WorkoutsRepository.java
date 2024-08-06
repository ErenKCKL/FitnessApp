package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutsRepository extends JpaRepository<Workouts, Integer> {
}
