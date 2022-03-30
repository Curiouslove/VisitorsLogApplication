package com.termii.visitorslogapplication.service;

import com.termii.visitorslogapplication.data.model.Staff;
import com.termii.visitorslogapplication.dto.request.StaffDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> findStaff(Long staffId);
    Boolean existsByEmail(String email);
    Staff addNewStaff(StaffDto staffDto);
}
