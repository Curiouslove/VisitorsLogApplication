package com.termii.visitorslogapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VisitorController {


    @PostMapping("/login")
    public ResponseEntity<?> login(String Username, String password){
        return  new ResponseEntity<>("successfull", HttpStatus.OK);
    }
}
