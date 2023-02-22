package com.alkemy.icons.icons.services.impl;

import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;
import com.alkemy.icons.icons.entities.IconEntity;
import com.alkemy.icons.icons.mappers.IconMapper;
import com.alkemy.icons.icons.repositories.IconRepository;
import com.alkemy.icons.icons.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepository iconRepository;

    @Override
    public List<IconResponseDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        return iconMapper.iconEntityListToResponseDTOList(entities);
    }

    @Override
    public void delete(Long id) {
        iconRepository.deleteById(id);
    }
}
