package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.TrainingPrograms;
import demo.fitnessapp.service.concretes.TrainingProgramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingPrograms")
public class TrainingProgramsController {

    @Autowired
    private TrainingProgramsService trainingProgramsService;

    @GetMapping
    public List<TrainingPrograms> getAllTrainingPrograms() {
        return trainingProgramsService.getAllTrainingPrograms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingPrograms> getTrainingProgramById(@PathVariable int id) {
        TrainingPrograms trainingProgram = trainingProgramsService.getTrainingProgramById(id);
        if (trainingProgram != null) {
            return ResponseEntity.ok(trainingProgram);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TrainingPrograms> createTrainingProgram(@RequestBody TrainingPrograms trainingPrograms) {
        TrainingPrograms createdTrainingProgram = trainingProgramsService.createTrainingProgram(trainingPrograms);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrainingProgram);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingPrograms> updateTrainingProgram(@PathVariable int id, @RequestBody TrainingPrograms trainingProgramsDetail) {
        TrainingPrograms updatedTrainingProgram = trainingProgramsService.updateTrainingProgram(id, trainingProgramsDetail);
        if (updatedTrainingProgram != null) {
            return ResponseEntity.ok(updatedTrainingProgram);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingProgram(@PathVariable int id) {
        trainingProgramsService.deleteTrainingProgram(id);
        return ResponseEntity.noContent().build();
    }




}
