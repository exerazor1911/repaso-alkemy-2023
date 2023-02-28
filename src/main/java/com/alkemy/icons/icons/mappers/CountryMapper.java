package com.alkemy.icons.icons.mappers;

import com.alkemy.icons.icons.dtos.requests.ContinentRequestDTO;
import com.alkemy.icons.icons.dtos.requests.CountryRequestDTO;
import com.alkemy.icons.icons.dtos.requests.IconRequestDTO;
import com.alkemy.icons.icons.dtos.responses.CountryBasicResponseDTO;
import com.alkemy.icons.icons.dtos.responses.CountryResponseDTO;
import com.alkemy.icons.icons.entities.ContinentEntity;
import com.alkemy.icons.icons.entities.CountryEntity;
import com.alkemy.icons.icons.entities.IconEntity;
import com.alkemy.icons.icons.repositories.ContinentRepository;
import com.alkemy.icons.icons.repositories.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class CountryMapper {
    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private IconRepository iconRepository;

    @Autowired
    private ContinentMapper continentMapper;

    @Autowired
    @Lazy
    private IconMapper iconMapper;

    public List<CountryBasicResponseDTO> countryEntityListToBasicResponseDTOList(List<CountryEntity> entities) {

        List<CountryBasicResponseDTO> dtos = new ArrayList<>();

        for (CountryEntity entity : entities) {
            dtos.add(countryEntityToBasicResponseDTO(entity));
        }

        return dtos;

    }

    public CountryBasicResponseDTO countryEntityToBasicResponseDTO(CountryEntity entity) {
        CountryBasicResponseDTO dto = new CountryBasicResponseDTO();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setDenomination(entity.getDenomination());
        dto.setInhabitantsQuantity(entity.getInhabitantsQuantity());

        return dto;
    }

    public CountryEntity countryRequestDTOtoEntity(CountryRequestDTO dto) {
        CountryEntity entity = new CountryEntity();

        entity.setDenomination(dto.getDenomination());
        entity.setImage(dto.getImage());
        entity.setInhabitantsQuantity(dto.getInhabitantsQuantity());
        entity.setTotalSurfaceInSquaredMeters(dto.getTotalSurfaceInSquaredMeters());

        Optional<ContinentRequestDTO> continentRequestDTO = Optional.ofNullable(dto.getContinent());

        if (continentRequestDTO.isPresent()) {
            ContinentEntity continentEntity = continentMapper.continentRequestDTOtoEntity(continentRequestDTO.get());
            ContinentEntity continentEntitySaved = continentRepository.save(continentEntity);

            entity.setContinent(continentEntitySaved);
            entity.setContinentId(continentEntitySaved.getId());
        }

        Optional<Set<IconRequestDTO>> iconRequestDTOS = Optional.ofNullable(dto.getIcons());

        if (iconRequestDTOS.isPresent()) {

            Set<IconEntity> iconEntities = iconMapper.iconRequestDTOSetToEntitySet(iconRequestDTOS.get());

            for (IconEntity icon : iconEntities) {
                icon.addCountry(entity);
                iconRepository.save(icon);
            }

            entity.setIcons(iconEntities);
        }

        return entity;
    }

    public CountryResponseDTO countryEntityToResponseDTO(CountryEntity entity) {

        CountryResponseDTO dto = new CountryResponseDTO();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setDenomination(entity.getDenomination());
        dto.setInhabitantsQuantity(entity.getInhabitantsQuantity());
        dto.setTotalSurfaceInSquaredMeters(entity.getTotalSurfaceInSquaredMeters());
        dto.setContinent(continentMapper.continentEntityToResponseDTO(entity.getContinent()));
        dto.setIcons(iconMapper.iconEntityListToResponseDTOList(entity.getIcons().stream().toList()));

        return dto;
    }

    public List<CountryResponseDTO> countryEntityListToResponseDTOList(List<CountryEntity> countryEntities) {
        List<CountryResponseDTO> dtos = new ArrayList<>();

        for (CountryEntity entity : countryEntities) {
            dtos.add(countryEntityToResponseDTO(entity));
        }

        return dtos;
    }
}
