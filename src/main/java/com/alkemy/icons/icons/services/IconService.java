package com.alkemy.icons.icons.services;

import com.alkemy.icons.icons.dtos.requests.IconRequestDTO;
import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;


import java.util.List;

public interface IconService {

    public List<IconResponseDTO> getAllIcons();

    public void delete(Long id);

    public IconResponseDTO save(IconRequestDTO dto);

    IconResponseDTO update(Long id, IconRequestDTO dto);
}
