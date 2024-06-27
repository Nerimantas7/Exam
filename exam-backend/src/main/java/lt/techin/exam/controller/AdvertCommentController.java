package lt.techin.exam.controller;

import lt.techin.exam.service.AdvertCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdvertCommentController {

    private AdvertCommentService advertCommentService;

    // Build Add Book Comment REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @PostMapping
    public ResponseEntity<BookCommentDto> addComment(@RequestBody BookCommentDto bookCommentDto){
        BookCommentDto addedComent = bookCommentService.addComment(bookCommentDto);
        System.out.println("Comment added: " + addedComent);
        return new ResponseEntity<>(addedComent, HttpStatus.CREATED);
    }

    // Build Get Book Comment REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping("{id}")
    public ResponseEntity<BookCommentDto> getCommentById(@PathVariable("id") Long commentId){
        BookCommentDto bookCommentDto = bookCommentService.getCommentById(commentId);
        System.out.println("Comment find with given ID: " + bookCommentDto);
        return ResponseEntity.ok(bookCommentDto);
    }

    // Build Get All Comments REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @GetMapping
    public ResponseEntity<List<BookCommentDto>> getAllComments(){
        List<BookCommentDto> comments = bookCommentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    //Build Update Book Comment REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") //Method Level Security
    @PutMapping("{id}")
    public ResponseEntity<BookCommentDto> updateComment(@PathVariable("id") Long commentId,
                                                        @RequestBody BookCommentDto updatedComment){
        BookCommentDto bookCommentDto = bookCommentService.updateBookComment(commentId, updatedComment);
        System.out.println(("Book comment updated with given Id: " + commentId));
        return ResponseEntity.ok(bookCommentDto);
    }

    // Build Delete Book Comment REST API
    @PreAuthorize("hasRole('ADMIN')") //Method Level Security
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId){
        bookCommentService.deleteBookComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully!");
    }


}
