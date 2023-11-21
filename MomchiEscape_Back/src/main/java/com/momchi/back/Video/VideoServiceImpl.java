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
    public List<Video> getByLevel(int level){
        switch (level){
            case 1:
                return videoRepository.getByLevel("초보");
            case 2:
                return videoRepository.getByLevel("중수");
            case 3:
                return videoRepository.getByLevel("고수");
        }
        return null;
    }
    public Video getVideoById(Long videoId){
        return videoRepository.getVideoById(videoId);
    }
    public Video getPopularVideo(){
        return videoRepository.getPopularVideo();
    }
    public void updateViewCount(Long videoId){
        videoRepository.updateViewCount(videoId);
    }
}
