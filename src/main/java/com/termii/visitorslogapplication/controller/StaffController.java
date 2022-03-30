package com.termii.visitorslogapplication.controller;

import com.termii.visitorslogapplication.dto.request.LoginDto;
import com.termii.visitorslogapplication.dto.request.NewVisitRequest;
import com.termii.visitorslogapplication.dto.request.StaffDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StaffController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        return  new ResponseEntity<>("successfull", HttpStatus.OK);
    }

    @PostMapping("/visit")
    public ResponseEntity<?> logNewVisit(@RequestBody NewVisitRequest newVisitRequest){

    }

    @PostMapping("/staff")
    public ResponseEntity<?> addNewStaff(@RequestBody StaffDto staffDto){

    }

    @GetMapping("/staff")
    public ResponseEntity<?> getAllStaff(){

    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<?> getSpecificStaff(@PathVariable Long id){

    }

}
