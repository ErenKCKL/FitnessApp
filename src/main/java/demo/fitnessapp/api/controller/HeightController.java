package demo.fitnessapp.api.controller;


import demo.fitnessapp.entities.concretes.Height;
import demo.fitnessapp.service.concretes.HeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heights")
public class HeightController {

    @Autowired
    private HeightService heightService;

    @GetMapping
    public List<Height> getAllHeights() {
        return heightService.getAllHeights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Height> getHeightById(@PathVariable int id) {
        Height height = heightService.getHeightById(id);
        if (height == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(height);
    }

    @PostMapping
    public Height createHeight(@RequestBody Height height) {
        return heightService.createHeight(height);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Height> updateHeight(@PathVariable int id, @RequestBody Height heightDetails) {
        Height updatedHeight = heightService.updateHeight(id, heightDetails);
        if (updatedHeight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedHeight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeight(@PathVariable int id) {
        heightService.deleteHeight(id);
        return ResponseEntity.noContent().build();
    }
}
