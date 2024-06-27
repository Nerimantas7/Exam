package lt.techin.exam.service;

import lt.techin.exam.dto.AdvertCommentDto;

import java.util.List;

public interface AdvertCommentService {

    AdvertCommentDto addComment(AdvertCommentDto advertCommentDto);

    AdvertCommentDto getCommentById(Long commentId);

    List<AdvertCommentDto> getAllComments();

    AdvertCommentDto updateAdvertComment(Long commentId, AdvertCommentDto updatedAdvertComment);

    void deleteAdvertComment(Long commentId);
}
