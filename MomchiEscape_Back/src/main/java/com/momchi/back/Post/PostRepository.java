package com.momchi.back.Post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    // Create
    void save(Post post);

    // Read
    List<Post> getAllPosts();
    Post findById(Long postId);
    List<Post> orderByLikeCount();
    List<Post> findByLevel(String level);
    List<Post> findByCategory(String contentType);

    // Update
    void update(Post post);

    // Delete
    void deleteById(Long postId);

}
