package com.momchi.back.Record;

import com.momchi.back.Video.Video;
import com.momchi.back.Video.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl {
    private final RecordRepository recordRepository;
    private final VideoServiceImpl videoService;

    public void saveRecord(Record record){
        videoService.updateViewCount(record.getVideoId());
        recordRepository.saveRecord(record);
    }

    public List<Record> getAllRecord(Long userId){
        return recordRepository.getAllRecord(userId);
    }

    public Long getStreakContinue(Long userId){
        Long streak = 0L;
        List<Record> allRecords = recordRepository.getAllRecord(userId);
        for (int i = 0; i < allRecords.size(); i++) {
            if(i == 0){
                LocalDate currentDate = LocalDate.now();
                long dif = ChronoUnit.DAYS.between(allRecords.get(i).getDate(), currentDate);
                if(dif<=1){
                    streak++;
                }
                continue;
            }
            long dif = ChronoUnit.DAYS.between(allRecords.get(i).getDate(), allRecords.get(i-1).getDate());
            if(dif == 0){
                continue;
            }
            if(dif<=1){
                streak++;
                continue;
            }
            break;
        }
        return streak;
    }

    public void deleteRecord(Long recordId){
        recordRepository.deleteRecord(recordId);
    }
}
