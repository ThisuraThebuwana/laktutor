package com.arumosam.laktutor.controllers;

import com.arumosam.laktutor.models.Student;
import com.arumosam.laktutor.servicers.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> list(){
        return service.listAll();
    }

    @GetMapping("/students/{sid}")
    public ResponseEntity<Student> get(@PathVariable Integer sid){
        try {
           Student student =  service.get(sid);
           return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public void add(@RequestBody Student student){
        service.save(student);
    }

    @PutMapping("/students/{sid}")
    public ResponseEntity<?> update(@PathVariable Integer sid,@RequestBody Student student){
        try {
            Student existStudent = service.get(sid);
            service.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{sid}")
    public ResponseEntity<?> delete(@PathVariable Integer sid){
        try {
            Student existStudent = service.get(sid);
            service.delete(sid);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
