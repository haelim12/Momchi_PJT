package com.momchi.back.Controller;

import com.momchi.back.Comment.Comment;
import com.momchi.back.Comment.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity saveComment(@RequestBody Comment comment){
        System.out.println(comment);
        commentService.saveComment(comment);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity getCommentByPostId(@PathVariable Long postId){
        return new ResponseEntity(commentService.getCommentByPostId(postId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
