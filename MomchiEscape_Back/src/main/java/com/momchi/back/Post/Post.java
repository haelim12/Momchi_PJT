package com.momchi.back.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
//    private Long userId;
    private String url;
    private String part;
    private Long viewCount;
}
