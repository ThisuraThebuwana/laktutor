package com.arumosam.laktutor.servicers;

import com.arumosam.laktutor.models.Admin;
import com.arumosam.laktutor.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    public List<Admin> listAll(){
        return repo.findAll();
    }

    public Admin get(String username){
        return repo.findById(username).get();
    }
}
