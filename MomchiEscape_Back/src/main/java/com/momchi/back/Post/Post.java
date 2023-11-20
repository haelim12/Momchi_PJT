package com.momchi.back.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private String contentType;
    private String url;
    private String level;  // 아 영 아 그 만 하 고 좀 자
    private Long likeCnt;
}
