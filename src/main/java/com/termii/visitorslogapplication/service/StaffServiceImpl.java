package com.termii.visitorslogapplication.service;

import com.termii.visitorslogapplication.data.model.Staff;
import com.termii.visitorslogapplication.data.repository.StaffRepository;
import com.termii.visitorslogapplication.exception.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService{
    private final StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findStaff(Long staffId) {
        Optional<Staff> visitor = staffRepository.findById(staffId);
        if (visitor.isEmpty()){
            throw  new ResourceNotFound("visitor  does not exist");
        }
        else {
            return visitor;
        }
    }

    @Override
    public Boolean existsByEmail(String email) {
        return staffRepository.existsByEmailAddress(email);
    }
}
