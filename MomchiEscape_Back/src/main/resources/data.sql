
insert into User (name, email, password, nickname, birthday, level)
VALUES ("김씨","asdf@asdf.com","asdf","파이리","1998-12-02","초보"),
       ("이씨","qwer@asdf.com","asdf","꼬부기","1993-05-22","중수"),
       ("박씨","zxcv@asdf.com","asdf","이상해씨","1988-01-01","고수");

insert into Video (url, level)
VALUES ("https://www.youtube.com/watch?v=Ueb365f-bY0","초보"),
       ("https://www.youtube.com/watch?v=zruKSHfD7b4","중수"),
       ("https://www.youtube.com/watch?v=ytYwVE82O3M","초보"),
       ("https://www.youtube.com/watch?v=dabI9cnwtMQ","고수"),
       ("https://www.youtube.com/watch?v=jrP8JEBMRD","고수");


INSERT INTO Record (user_id, video_id, date, time)
SELECT
    1 as user_id,
    FLOOR(1 + RAND() * 4) as video_id,
    DATE_ADD('2023-01-01', INTERVAL FLOOR(RAND() * (DATEDIFF(NOW(), '2023-01-01') + 1)) DAY) as date,
    CONCAT(
            LPAD(FLOOR(RAND() * 24), 2, '0'), ':',
            LPAD(FLOOR(RAND() * 60), 2, '0'), ':',
            LPAD(FLOOR(RAND() * 60), 2, '0')
        ) as time
FROM
    (SELECT 1 as n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6
     UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10
     UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15
     UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20
     UNION SELECT 21 UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25
     UNION SELECT 26 UNION SELECT 27 UNION SELECT 28 UNION SELECT 29 UNION SELECT 30
     UNION SELECT 31 UNION SELECT 32 UNION SELECT 33 UNION SELECT 34 UNION SELECT 35
     UNION SELECT 36 UNION SELECT 37 UNION SELECT 38 UNION SELECT 39 UNION SELECT 40
     UNION SELECT 41 UNION SELECT 42 UNION SELECT 43 UNION SELECT 44 UNION SELECT 45
     UNION SELECT 46 UNION SELECT 47 UNION SELECT 48 UNION SELECT 49 UNION SELECT 50
     UNION SELECT 51 UNION SELECT 52 UNION SELECT 53 UNION SELECT 54 UNION SELECT 55
     UNION SELECT 56 UNION SELECT 57 UNION SELECT 58 UNION SELECT 59 UNION SELECT 60
     UNION SELECT 61 UNION SELECT 62 UNION SELECT 63 UNION SELECT 64 UNION SELECT 65
     UNION SELECT 66 UNION SELECT 67 UNION SELECT 68 UNION SELECT 69 UNION SELECT 70
     UNION SELECT 71 UNION SELECT 72 UNION SELECT 73 UNION SELECT 74 UNION SELECT 75
     UNION SELECT 76 UNION SELECT 77 UNION SELECT 78 UNION SELECT 79 UNION SELECT 80
     UNION SELECT 81 UNION SELECT 82 UNION SELECT 83 UNION SELECT 84 UNION SELECT 85
     UNION SELECT 86 UNION SELECT 87 UNION SELECT 88 UNION SELECT 89 UNION SELECT 90
     UNION SELECT 91 UNION SELECT 92 UNION SELECT 93 UNION SELECT 94 UNION SELECT 95
     UNION SELECT 96 UNION SELECT 97 UNION SELECT 98 UNION SELECT 99 UNION SELECT 100
     UNION SELECT 101 UNION SELECT 102 UNION SELECT 103 UNION SELECT 104 UNION SELECT 105
     UNION SELECT 106 UNION SELECT 107 UNION SELECT 108 UNION SELECT 109 UNION SELECT 110
     UNION SELECT 111 UNION SELECT 112 UNION SELECT 113 UNION SELECT 114 UNION SELECT 115
     UNION SELECT 116 UNION SELECT 117 UNION SELECT 118 UNION SELECT 119 UNION SELECT 120
     UNION SELECT 121 UNION SELECT 122 UNION SELECT 123 UNION SELECT 124 UNION SELECT 125
     UNION SELECT 126 UNION SELECT 127 UNION SELECT 128 UNION SELECT 129 UNION SELECT 130
     UNION SELECT 131 UNION SELECT 132 UNION SELECT 133 UNION SELECT 134 UNION SELECT 135
     UNION SELECT 136 UNION SELECT 137 UNION SELECT 138 UNION SELECT 139 UNION SELECT 140
     UNION SELECT 141 UNION SELECT 142 UNION SELECT 143 UNION SELECT 144 UNION SELECT 145
     UNION SELECT 146 UNION SELECT 147 UNION SELECT 148 UNION SELECT 149 UNION SELECT 150
     UNION SELECT 151 UNION SELECT 152 UNION SELECT 153 UNION SELECT 154 UNION SELECT 155
     UNION SELECT 156 UNION SELECT 157 UNION SELECT 158 UNION SELECT 159 UNION SELECT 160
     UNION SELECT 161 UNION SELECT 162 UNION SELECT 163 UNION SELECT 164 UNION SELECT 165
     UNION SELECT 166 UNION SELECT 167 UNION SELECT 168 UNION SELECT 169 UNION SELECT 170
     UNION SELECT 171 UNION SELECT 172 UNION SELECT 173 UNION SELECT 174 UNION SELECT 175
     UNION SELECT 176 UNION SELECT 177 UNION SELECT 178 UNION SELECT 179 UNION SELECT 180
     UNION SELECT 181 UNION SELECT 182 UNION SELECT 183 UNION SELECT 184 UNION SELECT 185
     UNION SELECT 186 UNION SELECT 187 UNION SELECT 188 UNION SELECT 189 UNION SELECT 190) AS numbers;