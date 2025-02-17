package com.dco.identity.controller;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@RestController
@RequestMapping("/identity")
@RequiredArgsConstructor
class IdentityController {
    private final IdentityService service;

    @PostMapping
    public ResponseEntity<IdentityDTO> createIdentity(@RequestBody @Valid IdentityDTO identityDTO) {
        return new ResponseEntity<>(service.createIdentity(identityDTO), HttpStatus.CREATED);
    }
}