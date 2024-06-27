package lt.techin.exam.service.impl;

import lt.techin.exam.dto.AdvertCategoryDto;
import lt.techin.exam.dto.AdvertDto;
import lt.techin.exam.entity.AdvertCategory;
import lt.techin.exam.exception.ResourceNotFoundException;
import lt.techin.exam.mapper.AdvertCategoryMapper;
import lt.techin.exam.repository.AdvertCategoryRepository;
import lt.techin.exam.service.AdvertCategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertCategoryServiceImpl implements AdvertCategoryService {

    private AdvertCategoryRepository advertCategoryRepository;

    @Override
    public AdvertCategoryDto addCategory(AdvertCategoryDto advertCategoryDto) {
        AdvertCategory advertCategory = AdvertCategoryMapper.mapToAdvertCategory(advertCategoryDto);
        AdvertCategory addedcategory = advertCategoryRepository.save(advertCategory);

        return AdvertCategoryMapper.mapToAdvertCategoryDto(addedcategory);
    }

    @Override
    public AdvertCategoryDto getCategoryById(Long categoryId) {

        AdvertCategory advertCategory = advertCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Book category is not exist with given Id: " + categoryId));
        return AdvertCategoryMapper.mapToAdvertCategoryDto(advertCategory);
    }

    @Override
    public List<AdvertCategoryDto> getAllCategories() {
        List<AdvertCategory> categories = advertCategoryRepository.findAll();

        return categories.stream().map(advertCategory -> AdvertCategoryMapper.mapToAdvertCategoryDto(advertCategory))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertCategoryDto updateAdvertCategory(Long categoryId, AdvertCategoryDto updatedAdvertCategory) {
        AdvertCategory advertCategory = advertCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category is not exist with given Id:" + categoryId));
        advertCategory.setAdvertCategory(updatedAdvertCategory.getAdvertCategory());
        advertCategory.setCategoryDescription(updatedAdvertCategory.getCategoryDescription());
        AdvertCategory savedAdvertCategory = advertCategoryRepository.save(advertCategory);
        return AdvertCategoryMapper.mapToAdvertCategoryDto(savedAdvertCategory);
    }

    @Override
    public void deleteAdvertCategory(Long categoryId) {
        AdvertCategory advertCategory = advertCategoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category is not exist with given Id:" + categoryId));
        advertCategoryRepository.deleteById(categoryId);

    }
}
