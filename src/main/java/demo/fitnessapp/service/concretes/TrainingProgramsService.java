package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.TrainingPrograms;
import demo.fitnessapp.entities.concretes.Workouts;
import demo.fitnessapp.repository.abstracts.TrainingProgramsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingProgramsService {

    @Autowired
    private TrainingProgramsRepository trainingProgramsRepository;

    public List<TrainingPrograms> getAllTrainingPrograms() {
        return trainingProgramsRepository.findAll();
    }

    public TrainingPrograms getTrainingProgramById(int id){
        return trainingProgramsRepository.findById(id).orElse(null);
    }

    public TrainingPrograms createTrainingProgram(TrainingPrograms trainingPrograms){
        for (Workouts workout : trainingPrograms.getWorkouts()) {
            workout.setTrainingProgram(trainingPrograms);  // Set the training program reference in each workout
        }
        return trainingProgramsRepository.save(trainingPrograms);
    }

    public TrainingPrograms updateTrainingProgram(int id, TrainingPrograms trainingProgramsDetail) {
        TrainingPrograms trainingPrograms = trainingProgramsRepository.findById(id).orElse(null);
        if (trainingPrograms != null) {
            trainingPrograms.setName(trainingProgramsDetail.getName());
            trainingPrograms.setDate(trainingProgramsDetail.getDate());

            // Update the list of workouts
            trainingPrograms.getWorkouts().clear();
            trainingPrograms.getWorkouts().addAll(trainingProgramsDetail.getWorkouts());

            for (Workouts workout : trainingPrograms.getWorkouts()) {
                workout.setTrainingProgram(trainingPrograms);
            }

            return trainingProgramsRepository.save(trainingPrograms);
        }
        return null;
    }

    public void deleteTrainingProgram(int id){
        trainingProgramsRepository.deleteById(id);
    }
}
