package com.alkemy.icons.icons.mappers;

import com.alkemy.icons.icons.dtos.requests.IconRequestDTO;
import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;
import com.alkemy.icons.icons.entities.IconEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IconMapper {

    public List<IconResponseDTO> iconEntityListToResponseDTOList (List<IconEntity> entities) {
        List<IconResponseDTO> dtos = new ArrayList<>();

        for (IconEntity entity : entities) {
            dtos.add(iconEntityToResponseDTO(entity));
        }

        return dtos;
    }

    public IconResponseDTO iconEntityToResponseDTO(IconEntity entity) {
        IconResponseDTO dto = new IconResponseDTO();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setDenomination(entity.getDenomination());

        return dto;
    }


    public Set<IconEntity> iconRequestDTOSetToEntitySet(Set<IconRequestDTO> iconRequestDTOS) {

        Set<IconEntity> entities = new HashSet<>();

        for (IconRequestDTO icon : iconRequestDTOS) {
            entities.add(iconRequestDTOToEntity(icon));
        }

        return entities;
    }

    public IconEntity iconRequestDTOToEntity(IconRequestDTO icon) {

        IconEntity entity = new IconEntity();

        entity.setDenomination(icon.getDenomination());
        entity.setHeight(icon.getHeight());
        entity.setHistory(icon.getHistory());
        entity.setImage(icon.getImage());

        LocalDate lt = LocalDate.now();
        entity.setCreationDate(lt);

        return entity;
    }
}
