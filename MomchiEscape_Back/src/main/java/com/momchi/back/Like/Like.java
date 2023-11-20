package com.momchi.back.Like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    public Like(Long userId, Long postId){
        this.userId = userId;
        this.postId = postId;
    }
    Long likeId;
    Long userId;
    Long postId;
}
