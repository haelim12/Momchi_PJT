package com.momchi.back.Record;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Long recordId;
    private Long userId;
    private LocalDate date;
    private String time;
    private Long videoId;
}
