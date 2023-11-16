package com.banapresso.ssafyback.Post;

import java.util.List;

public interface PostService {
    // 게시글 저장
    public void save(Post post);

    // 전체 게시글 가져오기
    public List<Post> getAllPosts();

    // 아이디로 게시글 찾기
    public Post selectPost(Long id);

    // 조회수 순 게시글 조회
    public List<Post> getPostByViewCount();

    // 부위별 게시글 조회
    public List<Post> getPostByPart(String part);

    // 게시글 수정
    public void update(Post post);

    // 게시글 삭제
    public void delete(Post post);

    // 아이디로 게시글 삭제
    public void deleteById(Long id);
}
