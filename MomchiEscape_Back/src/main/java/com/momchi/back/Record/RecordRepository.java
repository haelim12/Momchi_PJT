package com.momchi.back.Record;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RecordRepository {
    void saveRecord(Record record);
    List<Record> getAllRecord(Long userId);
    List<Record> getRecordByDate(HashMap<String, Object> map);
    void deleteRecord(Long recordId);
}
