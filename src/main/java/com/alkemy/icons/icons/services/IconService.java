package com.alkemy.icons.icons.services;

import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;


import java.util.List;

public interface IconService {

    public List<IconResponseDTO> getAllIcons();

    public void delete(Long id);

}
