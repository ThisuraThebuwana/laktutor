package com.arumosam.laktutor.controllers;

import com.arumosam.laktutor.models.Resource;
import com.arumosam.laktutor.servicers.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping("/resources")
    public List<Resource> list() {
        return service.listAll();
    }

    @GetMapping("/resources/{id}")
    public ResponseEntity<Resource> get(@PathVariable Integer id) {
        try {
            Resource resource = service.get(id);
            return new ResponseEntity<Resource>(resource, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/resources")
    public void add(@RequestBody Resource resource){
        service.save(resource);
    }

    @PutMapping("/resources/{id}")
    public ResponseEntity<?> update(@RequestBody Resource resource, @PathVariable Integer id){
        try {
            Resource existResource = service.get(id);
            service.save(resource);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/resources/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Resource existResource = service.get(id);
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
