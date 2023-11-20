package com.momchi.back.Video;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl {
    private final VideoRepository videoRepository;

    public void saveVideo(Video video){
        videoRepository.saveVideo(video);
    }
    public List<Video> getAllVideos(){
        return videoRepository.getAllVideos();
    }
    public List<Video> getByLevel(String level){
        return videoRepository.getByLevel(level);
    }
    public void updateViewCount(Long videoId){
        videoRepository.updateViewCount(videoId);
    }
}
