package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.Exercises;
import demo.fitnessapp.service.concretes.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercises> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercises> getExerciseById(@PathVariable int id) {
        Exercises exercise = exerciseService.getExerciseById(id);
        if (exercise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercise);
    }

    @PostMapping
    public Exercises createExercise(@RequestBody Exercises exercise) {
        return exerciseService.createExercise(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercises> updateExercise(@PathVariable int id, @RequestBody Exercises exerciseDetails) {
        Exercises updatedExercise = exerciseService.updateExercise(id, exerciseDetails);
        if (updatedExercise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedExercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable int id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
