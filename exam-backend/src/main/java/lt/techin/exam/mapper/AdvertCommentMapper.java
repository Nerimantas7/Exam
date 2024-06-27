package lt.techin.exam.mapper;

import lt.techin.exam.dto.AdvertCommentDto;
import lt.techin.exam.entity.AdvertComment;

public class AdvertCommentMapper {

    // convert advert comment jpa entity into book comment dto
    public static AdvertCommentDto mapToAdvertCommentDto(AdvertComment advertComment){
        if (advertComment == null) {
            return null;
        }
        return new AdvertCommentDto(
                advertComment.getId(),
                advertComment.getAdvertComment()
        );
    }

    // convert advert comment dpo into book comment jpa entity
    public static AdvertComment mapToAdvertComment(AdvertCommentDto advertCommentDto){
        if (advertCommentDto == null) {
            return null;
        }
        return new AdvertComment(
                advertCommentDto.getId(),
                advertCommentDto.getAdvertComment()
        );
    }
}
