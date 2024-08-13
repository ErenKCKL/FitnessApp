package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Workouts;
import demo.fitnessapp.repository.abstracts.WorkoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsService {

    @Autowired
    private WorkoutsRepository workoutsRepository;

    public List<Workouts> getAllWorkouts() {
        return  workoutsRepository.findAll();
    }

    public Workouts getWorkoutById(int id) {
        return workoutsRepository.findById(id).orElse(null);
    }

    public Workouts createWorkout(Workouts workouts){
        return workoutsRepository.save(workouts);
    }

    public Workouts updateWorkout(int id, Workouts workoutsDetail){
        Workouts workouts = workoutsRepository.findById(id).orElse(null);
        if (workouts != null) {
            workouts.setTrainingProgram(workoutsDetail.getTrainingProgram());
            workouts.setSets(workoutsDetail.getSets());
            workouts.setRepeats(workoutsDetail.getRepeats());
            return workoutsRepository.save(workouts);
        }
        return null;
    }

    public void deleteWorkout(int id) {
        workoutsRepository.deleteById(id);
    }
}
