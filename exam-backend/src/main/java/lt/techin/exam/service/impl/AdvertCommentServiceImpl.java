package lt.techin.exam.service.impl;

import lt.techin.exam.dto.AdvertCommentDto;
import lt.techin.exam.entity.AdvertComment;
import lt.techin.exam.exception.ResourceNotFoundException;
import lt.techin.exam.mapper.AdvertCommentMapper;
import lt.techin.exam.repository.AdvertCommentRepository;
import lt.techin.exam.service.AdvertCommentService;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertCommentServiceImpl implements AdvertCommentService {

    private AdvertCommentRepository advertCommentRepository;
    @Override
    public AdvertCommentDto addComment(AdvertCommentDto advertCommentDto) {
        AdvertComment advertComment = AdvertCommentMapper.mapToAdvertComment(advertCommentDto);
        AdvertComment addedComment = advertCommentRepository.save(advertComment);

        return AdvertCommentMapper.mapToAdvertCommentDto(addedComment);
    }

    @Override
    public AdvertCommentDto getCommentById(Long commentId) {
        AdvertComment advertComment = advertCommentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment is not exist with given Id: " + commentId));

        return AdvertCommentMapper.mapToAdvertCommentDto(advertComment);
    }

    @Override
    public List<AdvertCommentDto> getAllComments() {
        List<AdvertComment> comments = advertCommentRepository.findAll();
        return comments.stream().map((advertComment) -> AdvertCommentMapper.mapToAdvertCommentDto(advertComment))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertCommentDto updateAdvertComment(Long commentId, AdvertCommentDto updatedAdvertComment) {
        AdvertComment advertComment = advertCommentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment is not exist with given Id: "+commentId));
        advertComment.setAdvertComment(updatedAdvertComment.getAdvertComment());
        AdvertComment savedComment = advertCommentRepository.save(advertComment);
        return AdvertCommentMapper.mapToAdvertCommentDto(savedComment);
    }

    @Override
    public void deleteAdvertComment(Long commentId) {
        AdvertComment advertComment = advertCommentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment is not exist with given Id: "+commentId));
        advertCommentRepository.deleteById(commentId);

    }
}
