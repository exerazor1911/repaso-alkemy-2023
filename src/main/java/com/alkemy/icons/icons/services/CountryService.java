package com.alkemy.icons.icons.services;

import com.alkemy.icons.icons.dtos.requests.CountryRequestDTO;
import com.alkemy.icons.icons.dtos.responses.CountryBasicResponseDTO;
import com.alkemy.icons.icons.dtos.responses.CountryResponseDTO;

import java.util.List;

public interface CountryService {

    public List<CountryBasicResponseDTO> getAllCountries();

    public void delete(Long id);

    public CountryResponseDTO save(CountryRequestDTO dto);

    CountryResponseDTO getById(Long id);

    List<CountryResponseDTO> getByFilters(String name, Long continent, String order);
}
