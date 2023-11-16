package com.banapresso.ssafyback.Post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    // Create
    void save(Post post);

    // Read
    List<Post> getAllPosts();
    Post findById(Long id);
    List<Post> orderByViewCount();
    List<Post> findByPart(String part);

    // Update
    void update(Post post);

    // Delete
    void delete(Post post);
    void deleteById(Long id);

}
