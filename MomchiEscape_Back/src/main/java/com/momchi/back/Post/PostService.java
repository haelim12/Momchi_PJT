package com.momchi.back.Post;

import java.util.List;

public interface PostService {
    // 게시글 저장
    public void save(Post post);

    // 전체 게시글 가져오기
    public List<Post> getAllPosts();

    // 카테고리 별 게시글 조회
    public List<Post> getPostByCategory(int category);

    // 아이디로 게시글 찾기
    public Post selectPost(Long id);

    // 조회수 순 게시글 조회
    public List<Post> getPostByLikeCount();

    // 난이도 별 게시글 조회
    public List<Post> getPostByLevel(String level);

    // 게시글 수정
    public void update(Post post);

    // 게시글 삭제
    // 아이디로 게시글 삭제
    public void deleteById(Long id);
}
