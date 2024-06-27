package lt.techin.exam.mapper;

import lt.techin.exam.dto.AdvertCategoryDto;
import lt.techin.exam.entity.AdvertCategory;

public class AdvertCategoryMapper {

    public static AdvertCategoryDto mapToAdvertCategoryDto(AdvertCategory advertCategory){
        if (advertCategory == null) {
            return null;
        }
        return new AdvertCategoryDto(
                advertCategory.getId(),
                advertCategory.getAdvertCategory(),
                advertCategory.getCategoryDescription()
        );
    }

    public static AdvertCategory mapToAdvertCategory(AdvertCategoryDto advertCategoryDto){
        if (advertCategoryDto == null) {
            return null;
        }
        return new AdvertCategory(
                advertCategoryDto.getId(),
                advertCategoryDto.getAdvertCategory(),
                advertCategoryDto.getCategoryDescription()
        );
    }

}
