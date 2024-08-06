package demo.fitnessapp.api.controller;

import demo.fitnessapp.entities.concretes.SleepHours;
import demo.fitnessapp.entities.concretes.Workouts;
import demo.fitnessapp.service.concretes.SleepHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleepHours")
public class SleepHoursController {

    @Autowired
    private SleepHoursService sleepHoursService;

    @GetMapping
    public List<SleepHours> getAllSleepHours() {
        return sleepHoursService.getAllSleepHours();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SleepHours> getSleepHoursById(@PathVariable int id) {
        SleepHours sleepHours = sleepHoursService.getSleepHourById(id);
        if (sleepHours == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sleepHours);
    }

    @PostMapping
    public SleepHours createSleepHours(@RequestBody SleepHours sleepHours) {
        return sleepHoursService.createSleepHours(sleepHours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SleepHours> updateSleepHours(@PathVariable int id, @RequestBody SleepHours sleepHoursDetail) {
        SleepHours updatedSleepHours = sleepHoursService.updateSleepHours(id, sleepHoursDetail);
        if (updatedSleepHours == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSleepHours);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSleepHours(@PathVariable int id) {
        sleepHoursService.deleteSleepHour(id);
        return ResponseEntity.noContent().build();
    }


}
