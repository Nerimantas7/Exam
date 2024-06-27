package lt.techin.exam.mapper;

import lt.techin.exam.dto.AdvertDto;
import lt.techin.exam.entity.Advert;

public class AdvertMapper {

    public static AdvertDto mapToAdvertDto(Advert advert){
        if (advert == null) {
            return null;
        }
        return new AdvertDto(advert.getId(),
                    advert.getAdvertTitle(),
                    advert.getAdvertText(),
                    advert.getPrice(),
                    advert.getAdvertPlace(),
                    advert.getAdvertCategory().getId()
        );
    }

    public static Advert mapToAdvert(AdvertDto advertDto){
        if (advertDto == null) {
            return null;
        }
        Advert advert = new Advert();
                    advert.setId(advertDto.getId());
                    advert.setAdvertTitle(advertDto.getAdvertTitle());
                    advert.setAdvertText(advertDto.getAdvertText());
                    advert.setPrice(advertDto.getPrice());
                    advert.setAdvertPlace(advertDto.getAdvertPlace());
        return advert;
    }
}
