package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.Workouts;
import demo.fitnessapp.service.concretes.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutsController {
    @Autowired
    private WorkoutsService workoutsService;

    @GetMapping
    public List<Workouts> getAllWorkouts(){
        return workoutsService.getAllWorkouts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Workouts> getWorkoutById(@PathVariable int id) {
        Workouts workout = workoutsService.getWorkoutById(id);
        if (workout == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workout);
    }

    @PostMapping
    public Workouts createWorkout(@RequestBody Workouts workout) {
        return workoutsService.createWorkout(workout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workouts> updateWorkout(@PathVariable int id, @RequestBody Workouts workoutDetails) {
        Workouts updatedWorkout = workoutsService.updateWorkout(id, workoutDetails);
        if (updatedWorkout == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable int id) {
        workoutsService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }

}
