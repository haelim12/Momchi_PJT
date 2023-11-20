package com.momchi.back.Video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    public Video(String videoUrl, String level){
        this.videoUrl = videoUrl;
        this.level = level;
    }

    private Long videoId;
    private String videoUrl;
    private String level;
    private Long viewCnt;
}
