package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.Height;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeightRepository extends JpaRepository<Height, Integer> {
}
