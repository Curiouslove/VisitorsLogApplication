package com.termii.visitorslogapplication.controller;

import com.termii.visitorslogapplication.data.model.Visitor;
import com.termii.visitorslogapplication.dto.request.LoginDto;
import com.termii.visitorslogapplication.dto.request.VisitorDto;
import com.termii.visitorslogapplication.service.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class VisitorController {
    private VisitorService visitorService;

    @PostMapping("/visitor")
    public ResponseEntity<?> addNewVisitor(@RequestBody VisitorDto visitorDto){
        Visitor visitor = visitorService.addNewVisitor(visitorDto);
        return new ResponseEntity<>(visitor, HttpStatus.CREATED);
    }

    @GetMapping("/visitors")
    public ResponseEntity<?> getVisitors(){
        List<Visitor> visitorList = visitorService.getAllVisitor();
        return new ResponseEntity<>(visitorList, HttpStatus.OK);

    }

    @GetMapping("/visitor/{id}")
    public ResponseEntity<?> getSpecificVisitor(@PathVariable Long id){
            Optional<Visitor> visitor = visitorService.findAVisitor(id);
            return new ResponseEntity<>(visitor.get(), HttpStatus.OK);
    }

}
