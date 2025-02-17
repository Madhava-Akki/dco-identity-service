package com.dco.identity.mapper;

@Mapper(componentModel = "spring")
interface IdentityMapper {
    IdentityDTO toDTO(Identity identity);
    Identity toEntity(IdentityDTO identityDTO);
}