package com.assigment.modeldemo.Services;

import com.assigment.modeldemo.Repositories.ThoughtsRepository;
import com.assigment.modeldemo.models.Thoughts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThoughtsServices {

    private ThoughtsRepository thoughtsRepository;

    public ThoughtsServices(ThoughtsRepository thoughtsRepository){
        this.thoughtsRepository = thoughtsRepository;
    }
    public ResponseEntity<Object> getAllThoughts() {
       Optional<List<Thoughts>> thoughtList= Optional.of(thoughtsRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(thoughtList.get());
    }

    public ResponseEntity<Object> getThoughtsById(UUID id) {
        Optional<Thoughts> thoughts = thoughtsRepository.findById(id);
        if(thoughts.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(thoughts.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Thought ID not Found");
        }
    }

    public ResponseEntity<Object> createThoughts(Thoughts thoughts) {
        if(thoughts == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Send some thoughts with Request");
        }
        thoughtsRepository.save(thoughts);
        return ResponseEntity.status(HttpStatus.OK).body("Your Thoughts are with us now");
    }

    public ResponseEntity<Object> updateThoughts(UUID id, Thoughts thoughts) {

        if(thoughts == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }

        Optional <Thoughts> thgts = thoughtsRepository.findById(id);
        if(thgts.isPresent()){
            thoughts.setUuid(thgts.get().getUuid());
            thoughtsRepository.save(thoughts);
            return ResponseEntity.status(HttpStatus.OK).body("Change of Thought is welcomed ");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not able to update thoughts");

    }

    public ResponseEntity<Object> deleteThoughts(UUID id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Thought Id not found !!");
        }
        thoughtsRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("It's always good to get rid of old Thoughts");
    }
}
