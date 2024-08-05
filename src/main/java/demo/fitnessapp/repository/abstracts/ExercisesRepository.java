package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExercisesRepository extends JpaRepository<Exercises, Integer> {


}
