package lt.techin.exam.service;

import lt.techin.exam.dto.AdvertCategoryDto;

import java.util.List;

public interface AdvertCategoryService {

    AdvertCategoryDto addCategory(AdvertCategoryDto advertCategoryDto);

    AdvertCategoryDto getCategoryById(Long categoryId);

    List<AdvertCategoryDto> getAllCategories();

    AdvertCategoryDto updateAdvertCategory(Long categoryId, AdvertCategoryDto updatedAdvertCategory);

    void deleteAdvertCategory(Long categoryId);
}
