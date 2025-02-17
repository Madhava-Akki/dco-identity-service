package com.dco.identity.entities;

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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "SSN is required")
    private String socialSecurityNumber;

    @Lob
    private byte[] passportCopy;

    @Lob
    private byte[] photo;
}
