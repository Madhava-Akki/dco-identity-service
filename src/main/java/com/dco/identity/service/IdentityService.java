package com.dco.identity.service;

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

@Service
@RequiredArgsConstructor
class IdentityService {
    private final IdentityRepository repository;
    private final IdentityMapper mapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public IdentityDTO createIdentity(IdentityDTO identityDTO) {
        Identity identity = mapper.toEntity(identityDTO);
        repository.save(identity);
]        kafkaTemplate.send("identity-topic", "identity verified: " + identity.getSocialSecurityNumber());
        return mapper.toDTO(identity);
    }

}
