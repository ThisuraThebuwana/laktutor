package com.arumosam.laktutor.servicers;

import com.arumosam.laktutor.models.Tutor;
import com.arumosam.laktutor.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repo;

    public List<Tutor> listAll(){

        return repo.findAll();
    }
    public void save(Tutor tutor){
        repo.save(tutor);
    }
    public Tutor get(Integer rid){
        return repo.findById(rid).get();
    }
    public void delete(Integer rid){
        repo.deleteById(rid);
    }
}
