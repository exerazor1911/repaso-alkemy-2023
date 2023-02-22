package com.alkemy.icons.icons.services;

import com.alkemy.icons.icons.dtos.requests.ContinentRequestDTO;
import com.alkemy.icons.icons.dtos.responses.ContinentResponseDTO;

import java.util.List;

public interface ContinentService {

    public ContinentResponseDTO save(ContinentRequestDTO dto);

    public List<ContinentResponseDTO> getAllContinents();

    void delete(Long id);
}
