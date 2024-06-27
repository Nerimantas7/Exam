package lt.techin.exam.controller;

import lombok.AllArgsConstructor;
import lt.techin.exam.dto.AdvertCommentDto;
import lt.techin.exam.service.AdvertCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts/comments")
public class AdvertCommentController {

    private AdvertCommentService advertCommentService;

    // Build Add Advert Comment REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @PostMapping
    public ResponseEntity<AdvertCommentDto> addComment(@RequestBody AdvertCommentDto advertCommentDto){
        AdvertCommentDto addedComent = advertCommentService.addComment(advertCommentDto);
        System.out.println("Comment added: " + addedComent);
        return new ResponseEntity<>(addedComent, HttpStatus.CREATED);
    }

    // Build Get Advert Comment REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping("{id}")
    public ResponseEntity<AdvertCommentDto> getCommentById(@PathVariable("id") Long commentId){
        AdvertCommentDto advertCommentDto = advertCommentService.getCommentById(commentId);
        System.out.println("Comment find with given ID: " + advertCommentDto);
        return ResponseEntity.ok(advertCommentDto);
    }

    // Build Get All Comments REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping
    public ResponseEntity<List<AdvertCommentDto>> getAllComments(){
        List<AdvertCommentDto> comments = advertCommentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    //Build Update Book Comment REST API
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @PutMapping("{id}")
    public ResponseEntity<AdvertCommentDto> updateComment(@PathVariable("id") Long commentId,
                                                        @RequestBody AdvertCommentDto updatedComment){
        AdvertCommentDto advertCommentDto = advertCommentService.updateAdvertComment(commentId, updatedComment);
        System.out.println(("Advert comment updated with given Id: " + commentId));
        return ResponseEntity.ok(advertCommentDto);
    }

    // Build Delete Book Comment REST API
//    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId){
        advertCommentService.deleteAdvertComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully!");
    }


}
