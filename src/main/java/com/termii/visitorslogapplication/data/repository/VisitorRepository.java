package com.termii.visitorslogapplication.data.repository;

import com.termii.visitorslogapplication.data.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Boolean existsByEmailAddress(String email);
}
