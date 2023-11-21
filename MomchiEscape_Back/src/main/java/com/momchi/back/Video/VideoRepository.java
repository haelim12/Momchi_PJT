package com.momchi.back.Video;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface VideoRepository {
    void saveVideo(Video video);
    List<Video> getAllVideos();
    List<Video> getByLevel(String level);
    Video getPopularVideo();
    void updateViewCount(Long videoId);
}
