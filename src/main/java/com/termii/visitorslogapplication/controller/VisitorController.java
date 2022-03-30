package com.termii.visitorslogapplication.controller;

import com.termii.visitorslogapplication.dto.request.LoginDto;
import com.termii.visitorslogapplication.dto.request.VisitorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VisitorController {


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        return  new ResponseEntity<>("successfull", HttpStatus.OK);
    }

    @PostMapping("/visitor")
    public ResponseEntity<?> addNewVisitor(@RequestBody VisitorDto visitorDto){

    }

    @GetMapping("/visitors")
    public ResponseEntity<?> getVisitors(){

    }

    @GetMapping("/visitor/{id}")
    public ResponseEntity<?> getSpecificVisitor(@PathVariable Long id){

    }

}
