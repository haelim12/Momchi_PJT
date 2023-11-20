package com.momchi.back.Like;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeRepository {
    boolean checkLike(Like like);
    Long findByUserAndPost(Like like);
    void saveLike(Like like);
    void unLike(Long likeId);
}
