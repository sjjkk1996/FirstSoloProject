package com.example.firstsoloproject.repository;

import com.example.firstsoloproject.entitly.Join;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface JoinRepository extends JpaRepository<Join, Long> {
    @Override
    ArrayList<Join> findAll();
}
