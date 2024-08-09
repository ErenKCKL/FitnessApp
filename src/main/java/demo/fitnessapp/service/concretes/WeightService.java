package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Weight;
import demo.fitnessapp.repository.abstracts.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    public Weight getWeightById(int id) {
        return weightRepository.findById(id).orElse(null);
    }

    public Weight createWeight(Weight weight) {
        return weightRepository.save(weight);
    }

    public Weight updateWeight(int id, Weight weightDetails) {
        Weight weight = weightRepository.findById(id).orElse(null);
        if (weight != null) {
            weight.setWeight(weightDetails.getWeight());
            return weightRepository.save(weight);
        }
        return null;
    }

    public void deleteWeight(int id) {
        weightRepository.deleteById(id);
    }
}


