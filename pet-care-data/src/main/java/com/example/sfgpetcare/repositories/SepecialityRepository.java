package com.example.sfgpetcare.repositories;

import com.example.sfgpetcare.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SepecialityRepository extends CrudRepository<Speciality, Long> {
}
