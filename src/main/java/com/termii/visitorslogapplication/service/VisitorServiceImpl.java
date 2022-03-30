package com.termii.visitorslogapplication.service;

import com.termii.visitorslogapplication.data.model.Visitor;
import com.termii.visitorslogapplication.data.repository.VisitorRepository;
import com.termii.visitorslogapplication.dto.request.NewVisitRequest;
import com.termii.visitorslogapplication.dto.request.VisitorDto;
import com.termii.visitorslogapplication.exception.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository visitorRepository;

    @Override
    public Visitor addNewVisitor(VisitorDto visitorDto) {

        Boolean localGovernmentExist = existsByEmail(visitorDto.getEmailAddress());
        if (localGovernmentExist){
            throw new ResourceNotFound("Visitor already exist");
        }

        else {
            Visitor visitor = new Visitor();
            visitor.setVisitorName(visitorDto.getVisitorName());
            visitor.setAddress(visitorDto.getAddress());
            visitor.setPhoneNumber(visitorDto.getPhoneNumber());
            visitor.setEmailAddress(visitorDto.getEmailAddress());
            visitorRepository.save(visitor);

            return visitor;
        }
    }

    @Override
    public List<Visitor> getAllVisitor() {
        return visitorRepository.findAll();
    }

    @Override
    public Optional<Visitor> findAVisitor(Long visitorId) {
        Optional<Visitor> visitor = visitorRepository.findById(visitorId);
        if (visitor.isEmpty()){
            throw  new ResourceNotFound("visitor  does not exist");
        }
        else {
            return visitor;
        }
    }

    @Override
    public void logNewVisit(NewVisitRequest newVisitRequest) {

    }

    @Override
    public Boolean existsByEmail(String email) {
        return visitorRepository.existsByEmailAddress(email);
    }
}
