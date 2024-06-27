package lt.techin.exam.service.impl;

import lt.techin.exam.dto.AdvertDto;
import lt.techin.exam.entity.Advert;
import lt.techin.exam.entity.AdvertCategory;
import lt.techin.exam.exception.ResourceNotFoundException;
import lt.techin.exam.mapper.AdvertMapper;
import lt.techin.exam.repository.AdvertCategoryRepository;
import lt.techin.exam.repository.AdvertRepository;
import lt.techin.exam.service.AdvertService;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertServiceImpl implements AdvertService {

    private AdvertRepository advertRepository;
    private AdvertCategoryRepository advertCategoryRepository;

    @Override
    public AdvertDto addAdvert(AdvertDto advertDto) {
        Advert advert = AdvertMapper.mapToAdvert(advertDto);

        AdvertCategory advertCategory = advertCategoryRepository.findById(advert.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category is not exists with id: " + advertDto.getCategoryId()));
        advert.setAdvertCategory(advertCategory);

        Advert addedAdvert = advertRepository.save(advert);

        return AdvertMapper.mapToAdvertDto(addedAdvert);
    }

    @Override
    public AdvertDto getAdvertById(Long advertId) {
        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(()-> new ResourceNotFoundException("Advert is not exist with given Id: " + advertId));

        return AdvertMapper.mapToAdvertDto(advert);
    }

    @Override
    public List<AdvertDto> getAllAdverts() {
        List<Advert> adverts = advertRepository.findAll();

        return adverts.stream().map(advert -> AdvertMapper.mapToAdvertDto(advert))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertDto updateAdvert(Long advertId, AdvertDto updatedAdvert) {

        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(()-> new ResourceNotFoundException("Advert is not exist with given Id: " + advertId));
            advert.setAdvertTitle(updatedAdvert.getAdvertTitle());
            advert.setAdvertText(updatedAdvert.getAdvertText());
            advert.setPrice(updatedAdvert.getPrice());
            advert.setAdvertPlace(updatedAdvert.getAdvertPlace());

            AdvertCategory advertCategory = advertCategoryRepository.findById(updatedAdvert.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category is not exists with given Id:" + updatedAdvert.getCategoryId()));
        advert.setAdvertCategory(advertCategory);

        Advert updatedAdvertObj = advertRepository.save(advert);

        return AdvertMapper.mapToAdvertDto(updatedAdvertObj);
    }

    @Override
    public void deleteAdvert(long advertId) {

        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(()-> new ResourceNotFoundException("Advert is not exist with given Id:"+ advertId));
        advertRepository.deleteById(advertId);
    }
}
