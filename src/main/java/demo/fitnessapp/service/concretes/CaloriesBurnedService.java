package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.*;
import demo.fitnessapp.repository.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaloriesBurnedService {

    @Autowired
    private CaloriesBurnedRepository caloriesBurnedRepository;

    @Autowired
    private HeightRepository heightRepository;

    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private SleepHoursRepository sleepHoursRepository;

    @Autowired
    private WorkoutsRepository workoutRepository;

    public List<CaloriesBurned> getAllCaloriesBurned() {
        return caloriesBurnedRepository.findAll();
    }

    public CaloriesBurned getCaloriesBurnedById(int id) {
        return caloriesBurnedRepository.findById(id).orElse(null);
    }

    public CaloriesBurned createCaloriesBurned(CaloriesBurned caloriesBurned) {
        // Veritabanından nesneleri al
        Height height = heightRepository.findById(caloriesBurned.getHeight().getId()).orElse(null);
        Weight weight = weightRepository.findById(caloriesBurned.getWeight().getId()).orElse(null);
        SleepHours sleepHours = sleepHoursRepository.findById(caloriesBurned.getSleepHours().getId()).orElse(null);
        Workouts workout = workoutRepository.findById(caloriesBurned.getWorkout().getId()).orElse(null);

        // Null kontrolü ve loglama
        if (height == null || weight == null || sleepHours == null || workout == null) {
            throw new RuntimeException("One of the related entities is not found");
        }

        System.out.println("Retrieved from DB - Height: " + height.getHeight());
        System.out.println("Retrieved from DB - Weight: " + weight.getWeight());
        System.out.println("Retrieved from DB - Sleep Hours: " + sleepHours.getSleepHours());
        System.out.println("Retrieved from DB - Workout Sets: " + workout.getSets());
        System.out.println("Retrieved from DB - Workout Repeats: " + workout.getRepeats());

        caloriesBurned.setHeight(height);
        caloriesBurned.setWeight(weight);
        caloriesBurned.setSleepHours(sleepHours);
        caloriesBurned.setWorkout(workout);

        int calculatedCalories = calculateCaloriesBurned(caloriesBurned);
        caloriesBurned.setCaloriesBurned(calculatedCalories);
        return caloriesBurnedRepository.save(caloriesBurned);
    }

    public CaloriesBurned updateCaloriesBurned(int id, CaloriesBurned caloriesBurnedDetails) {
        CaloriesBurned caloriesBurned = caloriesBurnedRepository.findById(id).orElse(null);
        if (caloriesBurned != null) {
            Height height = heightRepository.findById(caloriesBurnedDetails.getHeight().getId()).orElse(null);
            Weight weight = weightRepository.findById(caloriesBurnedDetails.getWeight().getId()).orElse(null);
            SleepHours sleepHours = sleepHoursRepository.findById(caloriesBurnedDetails.getSleepHours().getId()).orElse(null);
            Workouts workout = workoutRepository.findById(caloriesBurnedDetails.getWorkout().getId()).orElse(null);

            // Null kontrolü ve loglama
            if (height == null || weight == null || sleepHours == null || workout == null) {
                throw new RuntimeException("One of the related entities is not found");
            }

            System.out.println("Retrieved from DB - Height: " + height.getHeight());
            System.out.println("Retrieved from DB - Weight: " + weight.getWeight());
            System.out.println("Retrieved from DB - Sleep Hours: " + sleepHours.getSleepHours());
            System.out.println("Retrieved from DB - Workout Sets: " + workout.getSets());
            System.out.println("Retrieved from DB - Workout Repeats: " + workout.getRepeats());

            caloriesBurned.setHeight(height);
            caloriesBurned.setWeight(weight);
            caloriesBurned.setSleepHours(sleepHours);
            caloriesBurned.setWorkout(workout);
            caloriesBurned.setDate(caloriesBurnedDetails.getDate());

            int calculatedCalories = calculateCaloriesBurned(caloriesBurned);
            caloriesBurned.setCaloriesBurned(calculatedCalories);
            return caloriesBurnedRepository.save(caloriesBurned);
        }
        return null;
    }

    public void deleteCaloriesBurned(int id) {
        caloriesBurnedRepository.deleteById(id);
    }

    private int calculateCaloriesBurned(CaloriesBurned caloriesBurned) {
        double weight = caloriesBurned.getWeight().getWeight();
        double height = caloriesBurned.getHeight().getHeight();
        int sleepHours = caloriesBurned.getSleepHours().getSleepHours();
        Workouts workout = caloriesBurned.getWorkout();

        // Debug çıktısı
        System.out.println("Weight: " + weight);
        System.out.println("Height: " + height);
        System.out.println("Sleep Hours: " + sleepHours);
        System.out.println("Workout Sets: " + workout.getSets());
        System.out.println("Workout Repeats: " + workout.getRepeats());

        // Basit bir kalori hesaplama formülü
        // Bu formül kişisel verilere göre özelleştirilebilir
        int calories = (int) ((workout.getSets() * workout.getRepeats() * 0.1) + (weight * 0.35) + (height * 0.1) - (sleepHours * 0.5));
        System.out.println("Calculated Calories: " + calories);
        return calories;
    }

}
