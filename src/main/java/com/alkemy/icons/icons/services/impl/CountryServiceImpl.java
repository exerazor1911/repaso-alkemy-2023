package com.alkemy.icons.icons.services.impl;

import com.alkemy.icons.icons.dtos.filters.CountryFiltersDTO;
import com.alkemy.icons.icons.dtos.requests.CountryRequestDTO;
import com.alkemy.icons.icons.dtos.responses.CountryBasicResponseDTO;
import com.alkemy.icons.icons.dtos.responses.CountryResponseDTO;
import com.alkemy.icons.icons.entities.CountryEntity;
import com.alkemy.icons.icons.exceptions.ParamNotFound;
import com.alkemy.icons.icons.mappers.CountryMapper;
import com.alkemy.icons.icons.repositories.CountryRepository;
import com.alkemy.icons.icons.repositories.specification.CountrySpecification;
import com.alkemy.icons.icons.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountrySpecification countrySpecification;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<CountryBasicResponseDTO> getAllCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
        return countryMapper.countryEntityListToBasicResponseDTOList(entities);
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

    @Override
    public CountryResponseDTO getById(Long id) {
        Optional<CountryEntity> entity = countryRepository.findById(id);

        if (entity.isEmpty()) {
            throw new RuntimeException("country with the provided id not found");
        }

        CountryResponseDTO dto = countryMapper.countryEntityToResponseDTO(entity.get());

        return dto;
    }

    @Override
    public List<CountryResponseDTO> getByFilters(String name, Long continent, String order) {
        CountryFiltersDTO dto = new CountryFiltersDTO(name, continent, order);
        Optional<List<CountryEntity>> entities = Optional.ofNullable(countryRepository.findAll(countrySpecification.getByFilters(dto)));

        if (entities.isEmpty()) {
            throw new ParamNotFound("no countries present over the DB with the provided filters");
        }

        List<CountryResponseDTO> response = countryMapper.countryEntityListToResponseDTOList(entities.get());
        return response;
    }
}
