package com.momchi.back.Record;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordRepository {
    void saveRecord(Record record);

    List<Record> getAllRecord(Long userId);
    void deleteRecord(Long recordId);

}
