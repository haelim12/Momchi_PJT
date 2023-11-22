package com.momchi.back.Record;

import com.momchi.back.Video.Video;
import com.momchi.back.Video.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
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

    public List<List<Integer>> mapToStreak(String date, Long userId){
        List<Record> records= getRecordByDate(date,userId);
        String[] yearMonth = date.split("-");
        LocalDate targetDate = LocalDate.of(Integer.parseInt(yearMonth[0]), Integer.parseInt(yearMonth[1]),1);
        int lengthOfMonth = targetDate.lengthOfMonth();
        int dayOfWeek = targetDate.getDayOfWeek().getValue() == 7 ? 0 : targetDate.getDayOfWeek().getValue();

        List<List<Integer>> monthly = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int day = 1;
        int week = 0;
        while (day<=lengthOfMonth){
            if(day == 1 && dayOfWeek>0){
                temp.add(-1);
                dayOfWeek--;
            }
            else {
                if(checkRecord(day,records)){
                    temp.add(1);
                }
                else {
                    temp.add(0);
                }
                day++;
            }
            if(week == 6 || day == lengthOfMonth+1){
                week = -1;
                monthly.add(new ArrayList<>(temp));
                temp.clear();
            }
            week++;
        }
        while (monthly.get(monthly.size()-1).size() <7){
            monthly.get(monthly.size()-1).add(-1);
        }
        return monthly;
    }
    private boolean checkRecord(int day, List<Record> records){
        for (int i = 0; i < records.size(); i++) {
            if(records.get(i).getDate().getDayOfMonth() == day){
                return true;
            }
        }
        return false;
    }

    public List<Record> getRecordByDate(String date, Long userId){
        String[] yearMonth = date.split("-");
        if(Integer.parseInt(yearMonth[1]) <10){
            yearMonth[1] = "0"+yearMonth[1];
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("date",yearMonth[0]+"-"+yearMonth[1]);
        return recordRepository.getRecordByDate(map);
    }

    public void deleteRecord(Long recordId){
        recordRepository.deleteRecord(recordId);
    }
}
