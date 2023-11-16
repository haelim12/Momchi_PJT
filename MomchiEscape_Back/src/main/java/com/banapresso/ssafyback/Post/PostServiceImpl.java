package com.banapresso.ssafyback.Post;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    // 전체 게시글 가져오기
    @Override
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    // 아이디로 게시글 찾기
    @Override
    public Post selectPost(Long id) {
        return postRepository.findById(id);
    }

    // 조회수 순 게시글 조회
    @Override
    public List<Post> getPostByViewCount() {
        return postRepository.orderByViewCount();
    }

    // 부위별 게시글 조회
    @Override
    public List<Post> getPostByPart(String part) {
        return postRepository.findByPart(part);
    }

    @Override
    public void update(Post post) {
        postRepository.update(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

}
