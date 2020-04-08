package com.arumosam.laktutor.servicers;

import com.arumosam.laktutor.models.Student;
import com.arumosam.laktutor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAll(){
        return repo.findAll();
    }
    public void save(Student student){
        repo.save(student);
    }
    public Student get(Integer sid){
        return repo.findById(sid).get();
    }
    public void delete(Integer sid){
        repo.deleteById(sid);
    }
}
