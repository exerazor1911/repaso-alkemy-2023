package com.alkemy.icons.icons.services.impl;

import com.alkemy.icons.icons.dtos.requests.ContinentRequestDTO;
import com.alkemy.icons.icons.dtos.responses.ContinentResponseDTO;
import com.alkemy.icons.icons.entities.ContinentEntity;
import com.alkemy.icons.icons.mappers.ContinentMapper;
import com.alkemy.icons.icons.repositories.ContinentRepository;
import com.alkemy.icons.icons.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;

    @Autowired
    private ContinentRepository continentRepository;

    public ContinentResponseDTO save(ContinentRequestDTO dto) {
        ContinentEntity entity = continentMapper.continentRequestDTOtoEntity(dto);
        return continentMapper.continentEntityToResponseDTO(continentRepository.save(entity));
    }

    @Override
    public List<ContinentResponseDTO> getAllContinents() {
        List<ContinentEntity> entities = continentRepository.findAll();
        return continentMapper.continentEntityListToResponseDTOList(entities);
    }

    @Override
    public void delete(Long id) {
        continentRepository.deleteById(id);
    }

}
