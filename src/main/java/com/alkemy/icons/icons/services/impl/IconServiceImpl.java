package com.alkemy.icons.icons.services.impl;

import com.alkemy.icons.icons.dtos.requests.IconRequestDTO;
import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;
import com.alkemy.icons.icons.entities.IconEntity;
import com.alkemy.icons.icons.mappers.IconMapper;
import com.alkemy.icons.icons.repositories.IconRepository;
import com.alkemy.icons.icons.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepository iconRepository;

    @Override
    public List<IconResponseDTO> getAllIcons() {
        Optional<List<IconEntity>> entities = Optional.of(iconRepository.findAll());

        if (entities.isEmpty()) {
            throw new RuntimeException("database has no icons");
        }

        return iconMapper.iconEntityListToResponseDTOList(entities.get());
    }

    @Override
    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

    @Override
    public IconResponseDTO save(IconRequestDTO dto) {
        IconEntity entity = iconMapper.iconRequestDTOToEntity(dto);
        return iconMapper.iconEntityToResponseDTO(iconRepository.save(entity));
    }

    @Override
    public IconResponseDTO update(Long id, IconRequestDTO dto) {
        Optional<IconEntity> foundEntity = iconRepository.findById(id);

        if (foundEntity.isEmpty()) {
            throw new RuntimeException("The entity with the provided id is not present in the database");
        }

        IconEntity entityToSave = iconMapper.editEntity(foundEntity.get(), dto);

        IconResponseDTO response = iconMapper.iconEntityToResponseDTO(iconRepository.save(entityToSave));

        return response;
    }
}
