package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Exercises;
import demo.fitnessapp.repository.abstracts.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExercisesRepository exercisesRepository;

    public List<Exercises> getAllExercises() {
        return exercisesRepository.findAll();
    }

    public Exercises getExerciseById(int id) {
        return exercisesRepository.findById(id).orElse(null);
    }

    public Exercises createExercise(Exercises exercise) {
        return exercisesRepository.save(exercise);
    }

    public Exercises updateExercise(int id, Exercises exerciseDetails) {
        Exercises exercise = exercisesRepository.findById(id).orElse(null);
        if (exercise != null) {
            exercise.setName(exerciseDetails.getName());
            return exercisesRepository.save(exercise);
        }
        return null;
    }

    public void deleteExercise(int id) {
        exercisesRepository.deleteById(id);
    }
}