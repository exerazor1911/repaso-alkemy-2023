package com.alkemy.icons.icons.services.impl;

import com.alkemy.icons.icons.dtos.requests.CountryRequestDTO;
import com.alkemy.icons.icons.dtos.responses.CountryBasicResponseDTO;
import com.alkemy.icons.icons.dtos.responses.CountryResponseDTO;
import com.alkemy.icons.icons.entities.CountryEntity;
import com.alkemy.icons.icons.mappers.CountryMapper;
import com.alkemy.icons.icons.repositories.CountryRepository;
import com.alkemy.icons.icons.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<CountryBasicResponseDTO> getAllCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
        return countryMapper.countryEntityListToResponseDTOList(entities);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryResponseDTO save(CountryRequestDTO dto) {
        CountryEntity entity = countryMapper.countryRequestDTOtoEntity(dto);
        return countryMapper.countryEntityToResponseDTO(countryRepository.save(entity));
    }
}
