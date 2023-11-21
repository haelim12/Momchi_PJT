package com.momchi.back.Controller;

import com.momchi.back.Video.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {
    private final VideoServiceImpl videoService;
    @GetMapping
    public ResponseEntity getAllVideos(){
        return new ResponseEntity(videoService.getAllVideos(),HttpStatus.OK);
    }
    @GetMapping("/level/{level}")
    public ResponseEntity getVideosByLevel(@PathVariable int level){
        return new ResponseEntity(videoService.getByLevel(level), HttpStatus.OK);
    }
    @GetMapping("/{videoId}")
    public ResponseEntity getVideoById(@PathVariable Long videoId){
        return new ResponseEntity(videoService.getVideoById(videoId),HttpStatus.OK);
    }
    @GetMapping("/popular")
    public ResponseEntity getPopularVideo(){
        return new ResponseEntity(videoService.getPopularVideo(),HttpStatus.OK);
    }
    @PutMapping("/{videoId}")
    public ResponseEntity updateViewCount(@PathVariable Long videoId){
        videoService.updateViewCount(videoId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
