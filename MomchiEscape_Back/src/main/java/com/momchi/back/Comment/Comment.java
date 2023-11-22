package com.momchi.back.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long commentId;
    private Long userId;
    private Long videoId;
    private String content;

    private String nickname;
}
