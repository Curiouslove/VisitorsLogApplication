package com.termii.visitorslogapplication.data.repository;

import com.termii.visitorslogapplication.data.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Boolean existsByEmailAddress(String email);
    Staff findByEmailAddress(String emailAddress);
}
