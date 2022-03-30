package com.termii.visitorslogapplication.service;

import com.termii.visitorslogapplication.data.model.Visitor;
import com.termii.visitorslogapplication.dto.request.NewVisitRequest;
import com.termii.visitorslogapplication.dto.request.VisitorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VisitorService {
        Visitor addNewVisitor(VisitorDto visitorDto);
        List<Visitor> getAllVisitor();
        Optional<Visitor> findAVisitor(Long visitorId);
        void logNewVisit(NewVisitRequest newVisitRequest);
        Boolean existsByEmail(String email);
}
