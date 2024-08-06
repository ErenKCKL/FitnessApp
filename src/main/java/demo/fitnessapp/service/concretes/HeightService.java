package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Height;
import demo.fitnessapp.repository.abstracts.HeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeightService {

    @Autowired
    private HeightRepository heightRepository;

    public List<Height> getAllHeights() {
        return heightRepository.findAll();
    }

    public Height getHeightById(int id) {
        return heightRepository.findById(id).orElse(null);
    }

    public Height createHeight(Height height) {
        return heightRepository.save(height);
    }

    public Height updateHeight(int id, Height heightDetails) {
        Height height = heightRepository.findById(id).orElse(null);
        if (height != null) {
            height.setHeight(heightDetails.getHeight());
            return heightRepository.save(height);
        }
        return null;
    }

    public void deleteHeight(int id) {
        heightRepository.deleteById(id);
    }

}
