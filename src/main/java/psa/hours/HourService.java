package psa.hours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class HourService {

    @Autowired
    private HourRepository hourRepository;

    public Hours createHours(Hours hour){
        return hourRepository.save(hour);
    }

    public Collection<Hours> getHours(){
        Collection<Hours> hours = new ArrayList<>();

        hourRepository.findAll().forEach(hours::add);
        return hours;
    }

    public Optional<Hours> findHoursById(Long id){
        return hourRepository.findById(id);
    }

    public void deleteById(Long id){
        hourRepository.deleteById(id);
    }


}
