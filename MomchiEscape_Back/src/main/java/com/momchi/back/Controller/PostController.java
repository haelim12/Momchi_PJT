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
    public ResponseEntity<Post> save(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllPosts() {
        return new ResponseEntity(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity getAllPostsByCategory(@PathVariable int category) {
        return new ResponseEntity(postService.getPostByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> selectPost(@PathVariable Long id) {
        Post post = postService.selectPost(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @GetMapping("/viewcount")
    public ResponseEntity<List<Post>> getPostByLikeCount() {
        return new ResponseEntity<List<Post>>(postService.getPostByLikeCount(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Post post) {
        postService.update(post);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
