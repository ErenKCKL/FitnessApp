package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Exercises;
import demo.fitnessapp.entities.concretes.SleepHours;
import demo.fitnessapp.repository.abstracts.SleepHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepHoursService {

    @Autowired
    private SleepHoursRepository sleepHoursRepository;

    public List<SleepHours> getAllSleepHours() {
        return sleepHoursRepository.findAll();
    }

    public SleepHours getSleepHourById(int id){
        return sleepHoursRepository.findById(id).orElse(null);
    }

    public SleepHours createSleepHours(SleepHours sleepHours){
        return sleepHoursRepository.save(sleepHours);
    }

    public SleepHours updateSleepHours(int id, SleepHours sleepHoursDetail) {
        SleepHours sleepHours = sleepHoursRepository.findById(id).orElse(null);
        if (sleepHours != null) {
            sleepHours.setSleepHours(sleepHoursDetail.getSleepHours());
            return sleepHoursRepository.save(sleepHours);
        }
        return null;
    }

    public void deleteSleepHour(int id){
        sleepHoursRepository.deleteById(id);
    }
}
