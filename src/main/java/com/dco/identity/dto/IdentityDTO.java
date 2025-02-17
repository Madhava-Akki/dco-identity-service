package com.dco.identity.dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
class IdentityDTO {
    private String socialSecurityNumber;
    private byte[] passportCopy;
    private byte[] photo;
}