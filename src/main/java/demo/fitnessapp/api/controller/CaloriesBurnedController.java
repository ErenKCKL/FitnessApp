package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.CaloriesBurned;
import demo.fitnessapp.service.concretes.CaloriesBurnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caloriesBurned")
public class CaloriesBurnedController {

    @Autowired
    private CaloriesBurnedService caloriesBurnedService;

    @GetMapping
    public List<CaloriesBurned> getAllCaloriesBurned() {
        return caloriesBurnedService.getAllCaloriesBurned();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaloriesBurned> getCaloriesBurnedById(@PathVariable int id) {
        CaloriesBurned caloriesBurned = caloriesBurnedService.getCaloriesBurnedById(id);
        if (caloriesBurned == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(caloriesBurned);
    }

    @PostMapping
    public CaloriesBurned createCaloriesBurned(@RequestBody CaloriesBurned caloriesBurned) {
        return caloriesBurnedService.createCaloriesBurned(caloriesBurned);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaloriesBurned> updateCaloriesBurned(@PathVariable int id, @RequestBody CaloriesBurned caloriesBurnedDetails) {
        CaloriesBurned updatedCaloriesBurned = caloriesBurnedService.updateCaloriesBurned(id, caloriesBurnedDetails);
        if (updatedCaloriesBurned == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCaloriesBurned);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaloriesBurned(@PathVariable int id) {
        caloriesBurnedService.deleteCaloriesBurned(id);
        return ResponseEntity.noContent().build();
    }
}
