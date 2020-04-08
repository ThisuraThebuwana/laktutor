package com.arumosam.laktutor.controllers;

import com.arumosam.laktutor.models.Admin;
import com.arumosam.laktutor.servicers.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/admins")
    public List<Admin> list(){
        return service.listAll();
    }

    @GetMapping("/admins/{username}")
    public ResponseEntity<Admin> get(@PathVariable String username){
        try {
            Admin admin = service.get(username);
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }
}
