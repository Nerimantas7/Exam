package lt.techin.exam.service;

import lt.techin.exam.dto.AdvertDto;


import java.util.List;

public interface AdvertService {

    AdvertDto addAdvert(AdvertDto advertDto);

    AdvertDto getAdvertById(Long advertId);

    List<AdvertDto> getAllAdverts();

    AdvertDto updateAdvert(Long advertId, AdvertDto updatedAdvert);

    void deleteAdvert(long advertId);
}
