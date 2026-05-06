package com.latinclub.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.latinclub.backend.model.ContentRequest;
import com.latinclub.backend.repository.ContentRequestRepository;

@Service
public class ContentRequestService {

    private final ContentRequestRepository repository;

    public ContentRequestService(ContentRequestRepository repository) {
        this.repository = repository;
    }

    public ContentRequest save(ContentRequest request) {
        return repository.save(request);
    }

    public List<ContentRequest> getAll() {
        return repository.findAll();
    }
}