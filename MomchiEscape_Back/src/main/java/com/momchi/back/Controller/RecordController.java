package com.momchi.back.Controller;

import com.momchi.back.Record.Record;
import com.momchi.back.Record.RecordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {
    private final RecordServiceImpl recordService;

    @PostMapping
    public ResponseEntity saveRecord(@RequestBody Record record){
        recordService.saveRecord(record);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/streak/{userId}")
    public ResponseEntity getStreak(@PathVariable Long userId){
        return new ResponseEntity(recordService.getStreakContinue(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getAllRecord(@PathVariable Long userId){
        return new ResponseEntity(recordService.getAllRecord(userId), HttpStatus.OK);
    }
    @GetMapping("/month")
    public ResponseEntity getMonthlyRecord(@RequestParam String date, @RequestParam Long userId){
        return new ResponseEntity(recordService.getRecordByDate(date,userId),HttpStatus.OK);
    }
    @GetMapping("/streak/month")
    public ResponseEntity getMonthlyStreak(@RequestParam String date, @RequestParam Long userId){
        return new ResponseEntity(recordService.mapToStreak(date,userId),HttpStatus.OK);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity deleteRecord(@PathVariable Long recordId){
        recordService.deleteRecord(recordId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
