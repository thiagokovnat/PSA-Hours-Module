package psa.hours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HourService {

    @Autowired
    private HourRepository hourRepository;

    public boolean datesAreEqual(Date dateOne, Date dateTwo){
        return (dateOne.getDay() == dateTwo.getDay()) && (dateOne.getMonth() == dateTwo.getMonth()) && (dateOne.getYear() == dateTwo.getYear());
    }

    public Hours createHours(Hours hour) throws ResponseStatusException{
        Collection<Hours> hours = this.getHours();
        for(Hours h: hours){
            if((hour.getResponsibleResourceID() == h.getResponsibleResourceID()) && (hour.getTaskId() == h.getTaskId()) && (datesAreEqual(h.getDate(), hour.getDate()))){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User has already loaded hours for that task/date");
            }
        }
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
