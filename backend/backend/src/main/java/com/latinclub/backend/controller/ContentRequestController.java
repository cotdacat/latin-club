package com.latinclub.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latinclub.backend.model.ContentRequest;
import com.latinclub.backend.service.ContentRequestService;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*")
public class ContentRequestController {

    private final ContentRequestService service;

    public ContentRequestController(ContentRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContentRequest> submit(@RequestBody ContentRequest request) {
        ContentRequest saved = service.save(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<ContentRequest>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}