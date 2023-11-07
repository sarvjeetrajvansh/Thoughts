package com.assigment.modeldemo.Controllers;

import com.assigment.modeldemo.Repositories.ThoughtsRepository;
import com.assigment.modeldemo.Services.ThoughtsServices;
import com.assigment.modeldemo.models.Thoughts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ThoughtsController {

    private ThoughtsServices thoughtsServices;


    public ThoughtsController(ThoughtsServices thoughtsServices){
        this.thoughtsServices = thoughtsServices;
    }

    @GetMapping
    public ResponseEntity<Object> getAllThoughts(){

        return thoughtsServices.getAllThoughts();
    }
    @GetMapping("{id}")
    public  ResponseEntity<Object> getThoughtsById(@PathVariable("id") UUID id){

        return  thoughtsServices.getThoughtsById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createThoughts(@RequestBody Thoughts thoughts){
        return  thoughtsServices.createThoughts(thoughts);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Object> updateThoughts(@PathVariable("id") UUID id, @RequestBody Thoughts thoughts){

        return thoughtsServices.updateThoughts(id,thoughts);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteThoughts(@PathVariable("id") UUID id){
        return thoughtsServices.deleteThoughts(id);
    }


}
