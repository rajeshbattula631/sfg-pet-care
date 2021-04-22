package com.example.sfgpetcare.services.map;

import com.example.sfgpetcare.model.Speciality;
import com.example.sfgpetcare.model.Vet;
import com.example.sfgpetcare.services.SpecialitySevice;
import com.example.sfgpetcare.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialitySevice specialitySevice;

    public VetServiceMap(SpecialitySevice specialitySevice) {
        this.specialitySevice = specialitySevice;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialitySevice.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });

        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
