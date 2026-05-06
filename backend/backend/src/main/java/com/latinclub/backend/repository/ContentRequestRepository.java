package com.latinclub.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.latinclub.backend.model.ContentRequest;

@Repository
public interface ContentRequestRepository extends JpaRepository<ContentRequest, Long> {

}