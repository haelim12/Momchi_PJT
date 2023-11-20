package com.momchi.back.Controller;

import com.momchi.back.Video.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VideoController {
    private final VideoServiceImpl videoService;
    @GetMapping("/videos/{videoId}")
    public ResponseEntity updateViewCount(@PathVariable Long videoId){
        videoService.updateViewCount(videoId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/videos")
    public ResponseEntity getAllVideos(){
        return new ResponseEntity(videoService.getAllVideos(),HttpStatus.OK);
    }
}
