package com.momchi.back.Controller;

import com.momchi.back.Post.Post;
import com.momchi.back.Post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
@CrossOrigin("")
public class PostController {
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> save(Post post) {
        postService.save(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<List<Post>>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> selectPost(@PathVariable Long id) {
        Post post = postService.selectPost(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @GetMapping("/viewcount")
    public ResponseEntity<List<Post>> getPostByViewCount() {
        return new ResponseEntity<List<Post>>(postService.getPostByViewCount(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Post post) {
        postService.update(post);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Post post) {
        postService.delete(post);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
