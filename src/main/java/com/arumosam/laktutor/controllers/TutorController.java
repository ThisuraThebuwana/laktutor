package com.arumosam.laktutor.controllers;

import com.arumosam.laktutor.models.Tutor;
import com.arumosam.laktutor.servicers.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TutorController {

    @Autowired
    private TutorService service;

    @GetMapping("/tutors")
    public List<Tutor> list() {
        return service.listAll();
    }

    @GetMapping("/tutors/{id}")
    public ResponseEntity<Tutor> get(@PathVariable Integer id) {
        try {
            Tutor tutor = service.get(id);
            return new ResponseEntity<Tutor>(tutor, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Tutor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutors")
    public void add(@RequestBody Tutor tutor){
        service.save(tutor);
    }

    @PutMapping("/tutors/{id}")
    public ResponseEntity<?> update(@RequestBody Tutor tutor, @PathVariable Integer id){
        try {
            Tutor existTutor = service.get(id);
            service.save(tutor);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutors/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Tutor existTutor = service.get(id);
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
