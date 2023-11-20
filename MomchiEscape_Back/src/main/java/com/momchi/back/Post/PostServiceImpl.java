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
        System.out.println(post);
        postRepository.save(post);
        Video video = new Video(post.getUrl(), post.getLevel());
        videoService.saveVideo(video);
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

    // 부위별 게시글 조회
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
