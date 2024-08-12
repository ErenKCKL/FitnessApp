package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.TrainingPrograms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramsRepository extends JpaRepository<TrainingPrograms, Integer> {
}
