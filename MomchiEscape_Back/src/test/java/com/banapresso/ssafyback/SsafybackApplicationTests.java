package com.banapresso.ssafyback;

import com.banapresso.ssafyback.Post.Post;
import com.banapresso.ssafyback.Post.PostRepository;
import com.banapresso.ssafyback.Post.PostService;
import com.banapresso.ssafyback.Post.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SsafybackApplicationTests {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Autowired
    PostServiceImpl postServiceIm;

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest(){
        System.out.println(postServiceIm.selectPost(1L).toString());

//        postService.getAllPosts();
    }

    @Test
    void insertTest(){
        Post post = new Post();
        post.setId(100L);
        post.setTitle("asdf");
        post.setContent("고해림 하품 그만해");
        post.setUrl("진짜 엄청 졸려하네 아침점심저녁 다졸려함");
        post.setPart("늦잠");
        post.setViewCount(1L);

        postRepository.save(post);
    }

    @Test
    void deleteTest() {
        Post post = new Post();
        post.setId(100L);

        postRepository.delete(post);

    }
}
