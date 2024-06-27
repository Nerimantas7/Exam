package lt.techin.exam.mapper;

import lt.techin.exam.dto.AdvertDto;
import lt.techin.exam.entity.Advert;

public class AdvertMapper {

    public static AdvertDto mapToAdvertDto(Advert advert){
        return new AdvertDto(advert.getId();

        );
    }
}
