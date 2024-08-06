package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.SleepHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepHoursRepository extends JpaRepository<SleepHours, Integer> {
}
