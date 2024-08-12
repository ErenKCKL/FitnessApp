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
    private CustomerRepository customerRepository;

    @Autowired
    private TrainingProgramsRepository trainingProgramsRepository;

    public List<CaloriesBurned> getAllCaloriesBurned() {
        return caloriesBurnedRepository.findAll();
    }

    public CaloriesBurned getCaloriesBurnedById(int id) {
        return caloriesBurnedRepository.findById(id).orElse(null);
    }

    public CaloriesBurned createCaloriesBurned(CaloriesBurned caloriesBurned) {
        // Fetch the related entities from the database
        Customer customer = customerRepository.findById(caloriesBurned.getCustomer().getId()).orElse(null);
        TrainingPrograms trainingProgram = trainingProgramsRepository.findById(caloriesBurned.getTrainingProgram().getId()).orElse(null);

        // Null check and logging
        if (customer == null || trainingProgram == null) {
            throw new RuntimeException("One of the related entities is not found");
        }

        System.out.println("Retrieved from DB - Customer ID: " + customer.getId());
        System.out.println("Retrieved from DB - Training Program ID: " + trainingProgram.getId());

        caloriesBurned.setCustomer(customer);
        caloriesBurned.setTrainingProgram(trainingProgram);

        int calculatedCalories = calculateCaloriesBurned(caloriesBurned);
        caloriesBurned.setCaloriesBurned(calculatedCalories);
        return caloriesBurnedRepository.save(caloriesBurned);
    }

    public CaloriesBurned updateCaloriesBurned(int id, CaloriesBurned caloriesBurnedDetails) {
        CaloriesBurned caloriesBurned = caloriesBurnedRepository.findById(id).orElse(null);
        if (caloriesBurned != null) {
            Customer customer = customerRepository.findById(caloriesBurnedDetails.getCustomer().getId()).orElse(null);
            TrainingPrograms trainingProgram = trainingProgramsRepository.findById(caloriesBurnedDetails.getTrainingProgram().getId()).orElse(null);

            // Null check and logging
            if (customer == null || trainingProgram == null) {
                throw new RuntimeException("One of the related entities is not found");
            }

            System.out.println("Retrieved from DB - Customer ID: " + customer.getId());
            System.out.println("Retrieved from DB - Training Program ID: " + trainingProgram.getId());

            caloriesBurned.setCustomer(customer);
            caloriesBurned.setTrainingProgram(trainingProgram);
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
        int totalCalories = 0;

        // Loop through each workout in the training program
        for (Workouts workout : caloriesBurned.getTrainingProgram().getWorkouts()) {
            int sets = workout.getSets();
            int repeats = workout.getRepeats();
            Exercises exercise = workout.getExercise(); // Get the associated exercise

            // Calculate calories burned for this workout and add to the total
            int calories = (int) ((sets * repeats * 0.1) + (caloriesBurned.getCustomer().getWeight() * 0.35));
            totalCalories += calories;

            // Debugging output
            System.out.println("Workout: " + exercise.getName() + ", Sets: " + sets + ", Repeats: " + repeats);
            System.out.println("Calories for this workout: " + calories);
        }

        System.out.println("Total Calculated Calories: " + totalCalories);
        return totalCalories;
    }

}
