package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.Weight;
import demo.fitnessapp.service.concretes.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weights")
public class WeightController {

    @Autowired
    private WeightService weightService;

    @GetMapping
    public List<Weight> getAllWeights() {
        return weightService.getAllWeights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weight> getWeightById(@PathVariable int id) {
        Weight weight = weightService.getWeightById(id);
        if (weight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weight);
    }

    @PostMapping
    public Weight createWeight(@RequestBody Weight weight) {
        return weightService.createWeight(weight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weight> updateWeight(@PathVariable int id, @RequestBody Weight weightDetails) {
        Weight updatedWeight = weightService.updateWeight(id, weightDetails);
        if (updatedWeight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedWeight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeight(@PathVariable int id) {
        weightService.deleteWeight(id);
        return ResponseEntity.noContent().build();
    }
}
