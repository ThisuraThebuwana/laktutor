package com.arumosam.laktutor.servicers;

import com.arumosam.laktutor.models.Resource;
import com.arumosam.laktutor.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repo;

    public List<Resource> listAll(){

        return repo.findAll();
    }
    public void save(Resource resource){
        repo.save(resource);
    }
    public Resource get(Integer rid){
        return repo.findById(rid).get();
    }
    public void delete(Integer rid){
        repo.deleteById(rid);
    }
}
