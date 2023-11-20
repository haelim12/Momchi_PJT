package com.momchi.back.Post;


import com.momchi.back.Video.Video;
import com.momchi.back.Video.VideoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final VideoServiceImpl videoService;

    @Override
    public void save(Post post) {
        if(post.getContentType().equals("영상 추천")){
            post.setUrl(refractorUrl(post.getUrl()));
            Video video = new Video(post.getUrl(), post.getLevel());
            videoService.saveVideo(video);
        }
        postRepository.save(post);
    }

    private String refractorUrl(String original){
        String[] splitted = original.split("watch\\?v=");
        return splitted[0]+"embed/"+splitted[1];
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
    public List<Post> getPostByLikeCount() {
        return postRepository.orderByLikeCount();
    }

    // 카테고리별 게시글 조회
    @Override
    public List<Post> getPostByCategory(int category) {
        String contentType = "";
        switch (category){
            case 1: contentType = "영상 추천";
                break;
            case 2: contentType = "후기";
                break;
            case 3: contentType = "honey팁";
                break;
        }
        return postRepository.findByCategory(contentType);
    }

    // 레벨별 게시글 조회
    @Override
    public List<Post> getPostByLevel(String level) {
        return postRepository.findByLevel(level);
    }

    @Override
    public void update(Post post) {
        postRepository.update(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

}
