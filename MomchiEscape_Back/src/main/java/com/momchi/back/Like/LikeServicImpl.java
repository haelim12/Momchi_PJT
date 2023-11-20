package com.momchi.back.Like;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServicImpl {
    private final LikeRepository likeRepository;

    public boolean checkLike(Long userId, Long postId){
        return likeRepository.checkLike(new Like(userId,postId));
    }
    private Long findByUserAndPost (Like like){
        return likeRepository.findByUserAndPost(like);
    }
    public void like(Like like){
        if(!checkLike(like.userId,like.postId)){
            likeRepository.saveLike(like);
        }
        else {
            likeRepository.unLike(findByUserAndPost(like));
        }
    }
}
