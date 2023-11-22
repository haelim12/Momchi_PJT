package com.momchi.back.Controller;

import com.momchi.back.Like.Like;
import com.momchi.back.Like.LikeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeServiceImpl likeService;
    @GetMapping
    public ResponseEntity checkLike(@RequestParam Long userId, @RequestParam Long postId){
        return new ResponseEntity(likeService.checkLike(userId,postId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity like(@RequestBody Like like){
        likeService.like(like);
        return new ResponseEntity(HttpStatus.OK);
    }
}
