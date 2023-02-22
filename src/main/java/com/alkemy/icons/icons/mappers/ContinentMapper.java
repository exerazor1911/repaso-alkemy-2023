package com.alkemy.icons.icons.mappers;

import com.alkemy.icons.icons.dtos.requests.ContinentRequestDTO;
import com.alkemy.icons.icons.dtos.responses.ContinentResponseDTO;
import com.alkemy.icons.icons.entities.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    public ContinentEntity continentRequestDTOtoEntity (ContinentRequestDTO dto) {

        ContinentEntity entity = new ContinentEntity();

        entity.setImage(dto.getImage());
        entity.setDenomination(dto.getDenomination());

        return entity;
    }

    public ContinentResponseDTO continentEntityToResponseDTO(ContinentEntity entity) {

        ContinentResponseDTO dto = new ContinentResponseDTO();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setDenomination(entity.getDenomination());

        return dto;
    }

    public List<ContinentResponseDTO> continentEntityListToResponseDTOList(List<ContinentEntity> list) {
        List<ContinentResponseDTO> dtoList = new ArrayList<>();

        for (ContinentEntity entity : list) {
            dtoList.add(continentEntityToResponseDTO(entity));
        }

        return dtoList;

    }

}
