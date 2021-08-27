SELECT NOW();



INSERT INTO Users (userPhoneNumber, userName, userSex, userBirth)
VALUES (?, ?, ?, ?);

SELECT userIdx
FROM Users
WHERE userPhoneNumber = ?;

INSERT INTO UserAreas (userLocation, userIdx)
VALUES (?, ?);

SELECT userIdx, userLongitude, userLatitude
FROM Users
where userPhoneNumber = ?;

UPDATE Users
SET userLongitude = ?,
    userLatitude  = ?
WHERE userIdx = ?;



-- 테이블 생성
-- ExamineType Table Create SQL
CREATE TABLE ExamineType
(
    `examineType` TINYINT     NOT NULL AUTO_INCREMENT COMMENT '0:공통, 1:피부과, 2:치과, 3:성형외과, 4:안과, 5:암요양, 6:정형외과 7:한방',
    `examineName` VARCHAR(40) NOT NULL COMMENT '문진 과목 명',
    `createdAt`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineType PRIMARY KEY (examineType)
);

ALTER TABLE ExamineType
    COMMENT '문진표 타입';


-- Examines Table Create SQL
CREATE TABLE Examines
(
    `examineIdx`  INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '문진표 인덱스',
    `userIdx`     INT UNSIGNED NOT NULL COMMENT '유저인덱스',
    `examineType` TINYINT      NOT NULL COMMENT '문진표카테고리',
    `status`      TINYINT      NOT NULL DEFAULT 0 COMMENT '0:미완료 1:완료',
    `createdAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Examines PRIMARY KEY (examineIdx)
);

ALTER TABLE Examines
    COMMENT '문진표';


-- Reviews Table Create SQL
CREATE TABLE Reviews
(
    `reviewIdx`   INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '병원리뷰 인덱스',
    `hospitalIdx` INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `userIdx`     INT UNSIGNED NOT NULL COMMENT '유저인덱스',
    `review`      VARCHAR(500) NOT NULL COMMENT '병원 리뷰 내용',
    `reviewScore` FLOAT        NOT NULL COMMENT '리뷰점수',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT '0:삭제, 1:유지',
    `createdAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Reviews PRIMARY KEY (reviewIdx)
);

ALTER TABLE Reviews
    COMMENT '병원리뷰';


-- Estimates Table Create SQL
CREATE TABLE Estimates
(
    `estimateIdx`  INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '견적서 인덱스',
    `hospitalIdx`  INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `examineIdx`   INT UNSIGNED NOT NULL COMMENT '문진표 인덱스',
    `estimateCost` INT UNSIGNED NOT NULL COMMENT '의견금액',
    `opinion`      VARCHAR(500) NOT NULL COMMENT '의견',
    `createdAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Estimates PRIMARY KEY (estimateIdx)
);

ALTER TABLE Estimates
    COMMENT '견적서';


-- PartnerReservations Table Create SQL
CREATE TABLE PartnerReservations
(
    `partnerReservationIdx` INT UNSIGNED NOT NULL COMMENT '예약가능날짜인덱스',
    `partnerIdx`            INT UNSIGNED NOT NULL COMMENT '파트너 인덱스',
    `reservationTime`       DATETIME     NOT NULL COMMENT '예약가능시간',
    `createdAt`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_PartnerReservations PRIMARY KEY (partnerReservationIdx)
);

ALTER TABLE PartnerReservations
    COMMENT '파트너 예약 관리';


-- ExamineQuestions Table Create SQL
CREATE TABLE ExamineQuestions
(
    `examineQuestionIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '문진표 질문 인덱스',
    `examineType`        TINYINT      NOT NULL COMMENT '문진표 카테고리',
    `questionType`       TINYINT      NOT NULL COMMENT '0:단일, 1:복수, 2:서술',
    `examineContent`     VARCHAR(100) NOT NULL COMMENT '질문내용',
    `createdAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineQuestions PRIMARY KEY (examineQuestionIdx)
);

ALTER TABLE ExamineQuestions
    COMMENT '문진표 질문';


-- HospitalTags Table Create SQL
CREATE TABLE HospitalTags
(
    `hospitalTagIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '병원 태그 인덱스',
    `hospitalIdx`    INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `hospitalTag`    VARCHAR(20)  NOT NULL COMMENT '병원 태그',
    `createdAt`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalTags PRIMARY KEY (hospitalTagIdx)
);

ALTER TABLE HospitalTags
    COMMENT '병원 태그';


-- UserHospitalHearts Table Create SQL
CREATE TABLE UserHospitalHearts
(
    `userIdx`     INT UNSIGNED NOT NULL COMMENT '유저인덱스',
    `hospitalIdx` INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT '0:off,  1:0n',
    `createdAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_UserHospitalHearts PRIMARY KEY (userIdx, hospitalIdx)
);

ALTER TABLE UserHospitalHearts
    COMMENT '유저 관심 병원';


-- ReviewImg Table Create SQL
CREATE TABLE ReviewImg
(
    `reviewImgIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '리뷰 이미지 인덱스',
    `reviewIdx`    INT UNSIGNED NOT NULL COMMENT '병원리뷰 인덱스',
    `reviewImg`    TEXT         NOT NULL,
    `createdAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ReviewImg PRIMARY KEY (reviewImgIdx)
);

ALTER TABLE ReviewImg
    COMMENT '병원리뷰 이미지';


-- Reservations Table Create SQL
CREATE TABLE Reservations
(
    `reservationIdx`        INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '예약 인덱스',
    `estimateIdx`           INT UNSIGNED NOT NULL COMMENT '견적서 인덱스',
    `partnerReservationIdx` INT UNSIGNED NOT NULL COMMENT '예약가능날짜인덱스',
    `status`                TINYINT      NOT NULL DEFAULT 0 COMMENT '0:미완료 1:완료,2:예약취소',
    `createdAt`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`             TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Reservations PRIMARY KEY (reservationIdx)
);

ALTER TABLE Reservations
    COMMENT '병원 예약';


-- Events Table Create SQL
CREATE TABLE Events
(
    `eventIdx`    INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '이벤트 인덱스',
    `hospitalIdx` INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `eventName`   VARCHAR(50)  NOT NULL COMMENT '이벤트 이름',
    `eventUrl`    TEXT         NOT NULL COMMENT '이벤트 url',
    `eventImg`    TEXT         NOT NULL COMMENT '이벤트 대표 이미지',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`   TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Events PRIMARY KEY (eventIdx)
);

ALTER TABLE Events
    COMMENT '이벤트 테이블';


-- Notifications Table Create SQL
CREATE TABLE Notifications
(
    `notificationIdx`  INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '공지사항 인덱스',
    `notificationName` VARCHAR(50)  NOT NULL COMMENT '공지사항 이름',
    `notification`     TEXT         NOT NULL COMMENT '공지사항',
    `notificationUrl`  TEXT         NOT NULL COMMENT '공지사항 url',
    `status`           TINYINT      NOT NULL DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Notifications PRIMARY KEY (notificationIdx)
);

ALTER TABLE Notifications
    COMMENT '공지사항';


-- HospitalStory Table Create SQL
CREATE TABLE HospitalStory
(
    `storyIdx`    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `hospitalIdx` INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `storyName`   VARCHAR(50)  NOT NULL,
    `storyImg`    TEXT         NOT NULL,
    `story`       VARCHAR(100) NOT NULL,
    `storyUrl`    TEXT         NOT NULL,
    `storyFixed`  CHAR(1)      NOT NULL COMMENT 'Y:고정 N: 고정 안함',
    `status`      TINYINT      NOT NULL DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalStory PRIMARY KEY (storyIdx)
);

ALTER TABLE HospitalStory
    COMMENT '병원이야기';


-- PartnerExamines Table Create SQL
CREATE TABLE PartnerExamines
(
    `partnerIdx`    INT UNSIGNED NOT NULL COMMENT '파트너 인덱스',
    `examineIdx`    INT UNSIGNED NOT NULL COMMENT '문진표 인덱스',
    `examineStatus` TINYINT      NOT NULL DEFAULT 0 COMMENT '0:미확인 1: 확인 2: 견적서(전송)',
    `createdAt`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_PartnerExamines PRIMARY KEY (partnerIdx, examineIdx)
);

ALTER TABLE PartnerExamines
    COMMENT '파트너가 받은 문진표';


-- ExamineUserAnswers Table Create SQL
CREATE TABLE ExamineUserAnswers
(
    `examineIdx`         INT UNSIGNED NOT NULL COMMENT '문진표 인덱스',
    `examineQuestionIdx` INT UNSIGNED NOT NULL COMMENT '문진표 질문 인덱스',
    `examineAnswer`      TEXT         NOT NULL COMMENT '문진표 응답 내용',
    `createdAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineUserAnswers PRIMARY KEY (examineIdx, examineQuestionIdx)
);

ALTER TABLE ExamineUserAnswers
    COMMENT '문진표 유저 응답';


-- 배너
SELECT hospitalIdx, AdImg
FROM Ad
ORDER BY createdAt DESC
LIMIT 5;

-- 우리의 의견
SELECT estimateIdx,
       IFNULL(hospitalLogo, -1)                                         AS hospitalLogo,
       hospitalName,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail)              AS hospitalAddress,
       DATE_FORMAT(Estimates.createdAt, '%Y.%m.%d')                     AS createdAt,
       CONCAT(
               CASE WEEKDAY(Estimates.createdAt)
                   WHEN '0' THEN '(월)'
                   WHEN '1' THEN '(화)'
                   WHEN '2' THEN '(수)'
                   WHEN '3' THEN '(목)'
                   WHEN '4' THEN '(금)'
                   WHEN '5' THEN '(토)'
                   WHEN '6' THEN '(일)'
                   END, " ", DATE_FORMAT(Estimates.createdAt, '%H:%i')) AS createdDay,
       Estimates.estimateCost

FROM Estimates
         INNER JOIN Hospitals ON Hospitals.hospitalIdx = Estimates.hospitalIdx
WHERE Estimates.userIdx = ?;


-- 유저 위도, 유저 경도, 위도
-- 37.5548732, 127.0246126
SELECT IFNULL(doctorImg, -1)                                                      AS doctorImg,
       subjectIdx,
       hospitalName,
       IFNULL((SELECT ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1)
               FROM Reviews
               WHERE Reviews.hospitalIdx = Hospitals.hospitalIdx), 0)             AS averageStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail)                        AS hospitalAddress,
       round((6371 * acos(cos(radians(?)) * cos(radians(hospitalLatitude)) * cos(radians(hospitalLongitude)
           - radians(?)) + sin(radians(?)) * sin(radians(hospitalLatitude)))), 1) as distance,
       hospitalIdx
FROM Hospitals
WHERE hospitalName Like concat('%', ?, '%');


SELECT (6371 * acos(cos(radians(userLatitude)) * cos(radians(cafeLatitude)) *
                    cos(radians(cafeHardness) - radians(userHardness)) +
                    sin(radians(userLatitude)) * sin(radians(cafeLatitude)))) AS distance
FROM Cafe,
     User -- HAVING distance <= (이 값을 지정하면 특정거리 이하만 출력하게 할 수 있음) ORDER BY distance;


CREATE TABLE Subjects
(
    `subjectIdx`  INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '진료과목 인덱스',
    `subjectName` VARCHAR(30)  NOT NULL COMMENT '진료 과목명',
    `createdAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PRIMARY KEY (subjectIdx)
);

ALTER TABLE Subjects
    COMMENT '진료 과목 종류';

-- Examines Table Create SQL
CREATE TABLE Examines
(
    `examineIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '문진표 인덱스',
    `userIdx`    INT UNSIGNED NOT NULL COMMENT '유저인덱스',
    `subjectIdx` INT UNSIGNED NOT NULL COMMENT '진료과목 인덱스',
    `status`     TINYINT      NOT NULL DEFAULT 1 COMMENT '0:삭제 1:미삭제',
    `createdAt`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Examines PRIMARY KEY (examineIdx)
);

ALTER TABLE Examines
    COMMENT '문진표';

-- ExamineQuestions Table Create SQL
CREATE TABLE ExamineQuestions
(
    `examineQuestionIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '문진표 질문 인덱스',
    `subjectIdx`         INT UNSIGNED NOT NULL COMMENT '진료과목 인덱스',
    `questionType`       TINYINT      NOT NULL COMMENT '0:단일, 1:복수, 2:서술',
    `examineContent`     VARCHAR(100) NOT NULL COMMENT '질문내용',
    `createdAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineQuestions PRIMARY KEY (examineQuestionIdx)
);

ALTER TABLE ExamineQuestions
    COMMENT '문진표 질문';

CREATE TABLE ExamineUserAnswers
(
    `examineIdx`         INT UNSIGNED NOT NULL COMMENT '문진표 인덱스',
    `examineQuestionIdx` INT UNSIGNED NOT NULL COMMENT '문진표 질문 인덱스',
    `examineAnswer`      TEXT         NOT NULL COMMENT '문진표 응답 내용',
    `createdAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineUserAnswers PRIMARY KEY (examineIdx, examineQuestionIdx)
);

ALTER TABLE ExamineUserAnswers
    COMMENT '문진표 유저 응답';

-- 리뷰 이미지
SELECT hospitalImg
FROM Hospitals
WHERE hospitalIdx = ?;

-- 리뷰 총 평점
SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)         AS averageStar,
       COUNT(reviewIdx)                                                 AS reviewCount,
       COUNT(CASE WHEN reviewScore = 5 THEN 1 END)                      AS 5PointCount,
       COUNT(CASE WHEN reviewScore >= 4 AND reviewScore < 5 THEN 1 END) AS 4PointCount,
       COUNT(CASE WHEN reviewScore >= 3 AND reviewScore < 4 THEN 1 END) AS 3PointCount,
       COUNT(CASE WHEN reviewScore >= 2 AND reviewScore < 3 THEN 1 END) AS 2PointCount,
       COUNT(CASE WHEN reviewScore < 2 THEN 1 END)                      AS 1PointCount

FROM Reviews
WHERE hospitalIdx = ?
  AND status = 1;

-- 리뷰 가져오기
SELECT @rownum := @rownum + 1                                                                 as rNum,

       reviewIdx,
       reviewScore,
       DATE_FORMAT(createdAt, '%Y.%m.%d')                                                     AS createdAt,
       review,
       (SELECT reviewImg
        FROM ReviewImg
        WHERE Reviews.reviewIdx = ReviewImg.reviewIdx
          AND reviewImgIdx IN (SELECT MAX(reviewImgIdx) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)
       )                                                                                      AS reviewImg,
       (SELECT COUNT(reviewImg) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx) AS reviewImgCount

FROM Reviews,
     (SELECT @rownum := 0) t2
WHERE hospitalIdx = ?
LIMIT 1,1;

-- 리뷰 사진 가져오기
SELECT reviewImg
FROM ReviewImg
WHERE reviewIdx = ?;

-- HospitalClosedDay Table Create SQL
CREATE TABLE HospitalClosedDay
(
    `closedDayIdx` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '휴뮤일 인덱스',
    `hospitalIdx`  INT UNSIGNED NOT NULL COMMENT '병원 인덱스',
    `monClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `tueClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `wedClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `thuClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `friClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `satClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `sunClosed`    TINYINT      NOT NULL DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `createdAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalClosedDay PRIMARY KEY (closedDayIdx)
);

ALTER TABLE HospitalClosedDay
    COMMENT '병원 정기 휴무일';

-- 병원 정보
SELECT IFNULL(hospitalImg, -1)                             AS hospitalImg,
       IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
       hospitalName,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       IFNULL(hospitalInfo, -1)                            AS hospitalInfo,
       hospitalPhonenumber,
       DATE_FORMAT(hospitalStratTime, '%H:%i')             AS hospitalStratTime,
       DATE_FORMAT(hospitalEndTime, '%H:%i')               AS hospitalEndTime,
       hospitalHoliday,
       monClosed,
       tueClosed,
       wedClosed,
       tueClosed,
       friClosed,
       satClosed,
       sunClosed

FROM Hospitals
         INNER JOIN HospitalClosedDay ON HospitalClosedDay.hospitalIdx = Hospitals.hospitalIdx
WHERE Hospitals.hospitalIdx = ?;



SELECT hospitalTag
FROM HospitalTags
WHERE hospitalIdx = ?;

SELECT userIdx
FROM UserHospitalHearts
WHERE userIdx = ?
  AND hospitalIdx = ?;

INSERT INTO UserHospitalHearts (userIdx, hospitalIdx)
VALUES (?, ?);


UPDATE UserHospitalHearts
SET status = IF(status = 0, 1, 0)
WHERE userIdx = ?
  AND hospitalIdx = ?;

SELECT COUNT(CASE WHEN status = 1 THEN 1 END) AS heartStatus
FROM UserHospitalHearts
WHERE userIdx = ?
  AND hospitalIdx = ?;

-- 병원이야기 상단
SELECT storyImg, storyTitle, storySubTitle
FROM HospitalStory
WHERE hospitalIdx = ?
  AND status = 1
  AND storyFixed = 'Y'
ORDER BY createdAt desc
limit 1;

-- 병원로고, 병원 이름
SELECT hospitalLogo, hospitalName
FROM Hospitals
WHERE hospitalIdx = ?;

-- 병원 이야기 가져오기
SELECT DATE_FORMAT(createdAt, '%Y.%m.%d') AS createdAt, storyImg, storyTitle, story, storySubTitle
FROM HospitalStory
WHERE hospitalIdx = ?
  AND status = 1
ORDER BY createdAt DESC
LIMIT ?,?;


INSERT INTO Reviews(hospitalIdx, userIdx, review, reviewScore)
VALUES (1, 1, "최고", 3.7);

SELECT LAST_INSERT_ID() AS reviewIdx;

SELECT reviewIdx
FROM Reviews
WHERE hospitalIdx = ?
  AND userIdx = ?
  AND review = ?
  AND reviewScore = ?;

INSERT INTO ReviewImg(reviewIdx, reviewImg)
VALUES (?, ?);


INSERT INTO Hospitals(subjectIdx, hospitalName, hospitalAddress, hospitalAddressDetail, hospitalPhonenumber,
                      hospitalLatitude, hospitalLongitude)
VALUES (?, ?, ?, ?, ?, ?, ?);

INSERT INTO HospitalClosedDay(hospitalIdx)
VALUES (?);

ALTER TABLE Hospitals
    AUTO_INCREMENT 42;
ALTER TABLE HospitalClosedDay
    AUTO_INCREMENT 42;
ALTER TABLE UserAreas
    AUTO_INCREMENT 1;
ALTER TABLE ExamineQuestions
    AUTO_INCREMENT 1;
ALTER TABLE Examines
    AUTO_INCREMENT 1;
ALTER TABLE PartnerExamines
    AUTO_INCREMENT 1;

SELECT userIdx
FROM Reviews
WHERE reviewIdx = ?;
UPDATE Reviews
SET status = 0
WHERE reviewIdx = ?;


SELECT reviewIdx,
       reviewScore,
       DATE_FORMAT(createdAt, '%Y.%m.%d')                                                     AS createdAt,
       review,
       IFNULL((SELECT reviewImg
               FROM ReviewImg
               WHERE Reviews.reviewIdx = ReviewImg.reviewIdx
                 AND reviewImgIdx IN
                     (SELECT MAX(reviewImgIdx) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)
              ), -1)                                                                          AS reviewImg,
       (SELECT COUNT(reviewImg) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx) AS reviewImgCount

FROM Reviews
WHERE hospitalIdx = ?
  AND status = 1
LIMIT ?,?;

DELETE
FROM Reviews
WHERE reviewIdx = ?;

DELETE
FROM ReviewImg
WHERE reviewIdx = ?;

UPDATE Reviews
SET review      = ?,
    reviewScore = ?
WHERE reviewIdx = ?;

-- order number 추출
SELECT (COUNT(CASE WHEN partnerIdx = ? AND examineStatus = 0 OR examineStatus = 1 THEN 1 END) + 1)
           AS orderNumber
FROM PartnerExamines;

SELECT userLocation
FROM UserAreas
WHERE userIdx = ?;
DELETE
FROM UserAreas
WHERE userIdx = ?;

SET @rownum := 0;
SELECT @rownum := @rownum + 1                                                                 as no,
       userIdx                                                                                AS reviewUserIdx,
       reviewIdx,
       reviewScore,
       DATE_FORMAT(createdAt, '%Y.%m.%d')                                                     AS createdAt,
       review,
       IFNULL((SELECT reviewImg
               FROM ReviewImg
               WHERE Reviews.reviewIdx = ReviewImg.reviewIdx
                 AND reviewImgIdx IN
                     (SELECT MAX(reviewImgIdx) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)
              ), -1)                                                                          AS reviewImg,
       (SELECT COUNT(reviewImg) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx) AS reviewImgCount,
       COUNT(*) OVER ()                                                                       as TotalCount

FROM Reviews
WHERE hospitalIdx = ?
  AND status = 1
ORDER BY reviewIdx
limit ?,?;



SELECT examineQuestionIdx, questionType, examineContent
FROM ExamineQuestions
WHERE subjectIdx = 1
ORDER BY examineQuestionIdx;

SELECT examineQuestionIdx, questionType, examineContent
FROM ExamineQuestions
WHERE subjectIdx = 8
ORDER BY examineQuestionIdx;

INSERT INTO Examines (userIdx, subjectIdx)
VALUES (?, ?);
SELECT LAST_INSERT_ID() AS examineIdx;

INSERT INTO ExamineUserAnswers (examineIdx, examineQuestionIdx, examineAnswer)
VALUES ?;

SELECT SUBSTRING_INDEX(SUBSTRING_INDEX(userLocation, " ", 2), " ", -1) AS userLocation
FROM UserAreas
WHERE userIdx = ?;



SELECT hospitalIdx
FROM Hospitals
WHERE hospitalAddressDetail Like concat('%', ?, '%')
  AND subjectIdx = ?;

SELECT partnerIdx
FROM Partners
WHERE hospitalIdx = ?;

INSERT INTO PartnerExamines (partnerIdx, examineIdx, examineOrder)
VALUES ?;

SELECT DISTINCT ExamineQuestions.examineQuestionIdx, examineContent, questionType
FROM ExamineQuestions
         INNER JOIN ExamineUserAnswers ON ExamineUserAnswers.examineQuestionIdx = ExamineQuestions.examineQuestionIdx
WHERE examineIdx = ?;
SELECT examineAnswer
FROM ExamineUserAnswers
WHERE examineQuestionIdx = ?
  AND examineIdx = ?;
SELECT userIdx
FROM Examines
WHERE examineIdx = ?;


-- 지도 가져오기 37.5533535 127.0235435
SELECT hospitalIdx,
       hospitalLatitude,
       hospitalLongitude,
       hospitalName,
       hospitalImg,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = hospitalIdx)                                  AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail)                        AS hospitalAddress,
       round((6371 * acos(cos(radians(?)) * cos(radians(hospitalLatitude)) * cos(radians(hospitalLongitude)
           - radians(?)) + sin(radians(?)) * sin(radians(hospitalLatitude)))), 1) as distance

FROM Hospitals

WHERE hospitalAddress Like concat('%', ?, '%')
  AND hospitalAddressDetail Like concat('%', ?, '%')
  AND subjectIdx = ?;


SELECT hospitalIdx
FROM Hospitals
WHERE hospitalAddressDetail Like concat('%', ?, '%')
  AND subjectIdx = ?
  AND hospitalAddress Like concat('%', ?, '%');

UPDATE Users
SET userDeviceToken=?
WHERE userIdx = ?;

SELECT COUNT(reviewIdx) AS reviewNumber
FROM Reviews
WHERE hospitalIdx = ?
  AND status = 1;


-- 우리 - 나의상태
SELECT examineIdx,
       (CASE subjectIdx
            WHEN 1 then '피부과'
            WHEN 2 then '치과'
            WHEN 3 then '성형외과'
            WHEN 4 then '안과'
            WHEN 5 then '암 요양'
            WHEN 6 then '정형외과'
            WHEN 7 then '한의원'
           END)                                                                                   AS subejct,
       DATE_FORMAT(createdAt, '%Y.%m.%d')                                                         AS createdAt,
       (SELECT COUNT(examineIdx) FROM Estimates WHERE Estimates.examineIdx = Examines.examineIdx) AS estimateCount
FROM Examines
WHERE userIdx = ?
  AND status = 1
ORDER BY examineIdx DESC;
-- 우리의 의견
SELECT estimateIdx,
       hospitalName,
       hospitalLogo,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = hospitalIdx)           AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       estimateCost

FROM Estimates
         INNER JOIN Hospitals On Estimates.hospitalIdx = Hospitals.hospitalIdx
WHERE userIdx = ?
  AND estimateStatus = 0
ORDER BY estimateIdx DESC;


-- 견적서 상세조회
SELECT Hospitals.hospitalIdx,
       (CASE subjectIdx
            WHEN 1 then '피부과'
            WHEN 2 then '치과'
            WHEN 3 then '성형외과'
            WHEN 4 then '안과'
            WHEN 5 then '암 요양'
            WHEN 6 then '정형외과'
            WHEN 7 then '한의원'
           END)                                            AS subejct,
       hospitalName,
       hospitalLogo,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = hospitalIdx)           AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       DATE_FORMAT(hospitalStartTime, '%H:%i')             AS hospitalStratTime,
       DATE_FORMAT(hospitalEndTime, '%H:%i')               AS hospitalEndTime,
       estimateCost,
       opinion,
       DATE_FORMAT(Estimates.createdAt, '%Y.%m.%d')        AS createdAt

FROM Estimates
         INNER JOIN Hospitals On Estimates.hospitalIdx = Hospitals.hospitalIdx
WHERE estimateIdx = ?
  AND estimateStatus = 0
ORDER BY estimateIdx DESC;


SELECT COUNT(1) AS CNT
FROM Estimates
WHERE estimateIdx = ?;

SELECT reservationTime
FROM Reservations
WHERE DATE_FORMAT(reservationTime, '%Y') = ?
  and DATE_FORMAT(reservationTime, '%m') = ?
  and DATE_FORMAT(reservationTime, '%d') = ?;
-- 예약 가능한 시간 확인하기
SELECT DATE_FORMAT(reservationTime, '%H:%i') AS reservedTime
FROM Reservations
         INNER JOIN Estimates ON Estimates.estimateIdx = Reservations.estimateIdx
WHERE hospitalIdx = ?
  AND DATE_FORMAT(reservationTime, '%Y-%m-%d') = ?

ORDER BY reservedTime;

-- 예약 확인하기 2021-07-15 18:00
SELECT COUNT(1) AS CNT
FROM Reservations
         INNER JOIN Estimates ON Estimates.estimateIdx = Reservations.estimateIdx
WHERE hospitalIdx = ?
  AND DATE_FORMAT(reservationTime, '%Y-%m-%d %H:%i') = ?;
-- '2021-07-29 18:00' 예약하기
INSERT INTO Reservations (estimateIdx, reservationTime)
VALUES (?, ?);

SELECT hospitalIdx
FROM Estimates
WHERE estimateIdx = ?;

SELECT userIdx
FROM Estimates
WHERE estimateIdx = ?;

SELECT hospitalStartTime,
       hospitalEndTime,
       hospitalHoliday,
       monClosed,
       tueClosed,
       wedClosed,
       thuClosed,
       friClosed,
       satClosed,
       sunClosed
FROM Hospitals
         INNER JOIN HospitalClosedDay ON HospitalClosedDay.hospitalIdx = Hospitals.hospitalIdx
WHERE Hospitals.hospitalIdx = ?;

CREATE TABLE ExamineAddress
(
    `examineIdx`           INT UNSIGNED NOT NULL COMMENT '문진표 인덱스',
    `examineAddress`       VARCHAR(45)  NOT NULL COMMENT '문진표 지역',
    `examineAddressDetail` VARCHAR(45)  NOT NULL COMMENT '문진표 상세지역',
    `createdAt`            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SELECT CONCAT(examineAddress, " ", examineAddressDetail) AS address
FROM ExamineAddress
WHERE examineIdx = ?;

UPDATE Estimates
SET estimateStatus=1
WHERE estimateIdx = ?;

SELECT userDeviceToken
FROM Users
WHERE userIdx = ?;
SELECT (CASE subjectIdx
            WHEN 1 then '피부과'
            WHEN 2 then '치과'
            WHEN 3 then '성형외과'
            WHEN 4 then '안과'
            WHEN 5 then '암 요양'
            WHEN 6 then '정형외과'
            WHEN 7 then '한의원'
    END) AS subejct,
       hospitalName
FROM Hospitals
         INNER JOIN Estimates ON Estimates.hospitalIdx = Hospitals.hospitalIdx
WHERE estimateIdx = ?;

SELECT DATE_FORMAT(createdAt, '%Y-%m-%d') AS createdAt
FROM Examines
WHERE examineIdx = ?;

UPDATE Estimates
SET isRead='Y'
WHERE estimateIdx = ?;

SELECT COUNT(1) AS unreadCount
FROM Estimates
WHERE isRead = 'N'
  AND userIdx = ?;

-- 진행중인 일정 조회
SELECT reservationIdx,
       Hospitals.hospitalIdx,
       Estimates.estimateIdx,
       DATE_FORMAT(reservationTime, '%Y-%m-%d')            AS reservationDay,
       IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
       hospitalName,
       hospitalPhoneNumber,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       CONCAT(
               DATE_FORMAT(reservationTime, '%Y-%m-%d'), " ",
               CASE WEEKDAY(reservationTime)
                   WHEN '0' THEN '(월)'
                   WHEN '1' THEN '(화)'
                   WHEN '2' THEN '(수)'
                   WHEN '3' THEN '(목)'
                   WHEN '4' THEN '(금)'
                   WHEN '5' THEN '(토)'
                   WHEN '6' THEN '(일)' END)                AS reservationTime,
       DATE_FORMAT(reservationTime, '%H : %i')             AS time,
       estimateCost

FROM Reservations
         INNER JOIN Estimates ON Estimates.estimateIdx = Reservations.estimateIdx
         INNER JOIN Hospitals ON Hospitals.hospitalIdx = Estimates.hospitalIdx
WHERE reservationTime > CURDATE()
  AND Estimates.userIdx = ?
ORDER BY reservationTime DESC;

-- 진행중인 일정 조회
SELECT DATE_FORMAT(reservationTime, '%Y-%m-%d')            AS reservationDay,
       IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
       hospitalName,
       hospitalPhoneNumber,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       CONCAT(
               DATE_FORMAT(reservationTime, '%Y-%m-%d'), " ",
               CASE WEEKDAY(reservationTime)
                   WHEN '0' THEN '(월)'
                   WHEN '1' THEN '(화)'
                   WHEN '2' THEN '(수)'
                   WHEN '3' THEN '(목)'
                   WHEN '4' THEN '(금)'
                   WHEN '5' THEN '(토)'
                   WHEN '6' THEN '(일)' END)                AS reservationTime,
       DATE_FORMAT(reservationTime, '%H : %i')             AS time,
       estimateCost

FROM Reservations
         INNER JOIN Estimates ON Estimates.estimateIdx = Reservations.estimateIdx
         INNER JOIN Hospitals ON Hospitals.hospitalIdx = Estimates.hospitalIdx
WHERE reservationTime < CURDATE();

UPDATE Reservations
SET reservationTime=?
WHERE estimateIdx = ?;

DELETE
FROM Reservations
WHERE estimateIdx = ?;

SELECT userIdx
FROM Estimates
WHERE estimateIdx = ?;

UPDATE Users
SET userPushalarm = IF(userPushalarm = 1, 0, 1)
WHERE userIdx = ?;

SELECT userPushalarm
FROM Users
WHERE userIdx = ?;
alter table Reviews
    add reviewOrder int unsigned not null after reviewScore;

SELECT *
FROM Reviews
WHERE reviewIdx = 1;

SELECT IFNULL(reviewOrder, 0) AS lastReviewOrder
FROM Reviews
WHERE hospitalIdx = ?
  AND status = 1
ORDER BY reviewIdx DESC
LIMIT 1;

SELECT COUNT(1) + 1 AS reviewOrder
FROM Reviews
WHERE hospitalIdx = ?;



SELECT estimateIdx,
       hospitalName,
       IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = hospitalIdx
          AND Reviews.status = 1)                          AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       estimateCost

FROM Estimates
         INNER JOIN Hospitals On Estimates.hospitalIdx = Hospitals.hospitalIdx
WHERE userIdx = ?
  AND estimateStatus = 0
ORDER BY estimateIdx DESC;


SELECT estimateIdx,
       hospitalName,
       IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = hospitalIdx
          AND status = 1)                                  AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       estimateCost

FROM Estimates
         INNER JOIN Hospitals On Estimates.hospitalIdx = Hospitals.hospitalIdx
WHERE userIdx = ?
  AND examineIdx = ?
  AND estimateStatus = 0
ORDER BY estimateIdx DESC;


SELECT userIdx
FROM Examines
WHERE examineIdx = ?;

SELECT (CASE subjectIdx
            WHEN 1 then '피부과'
            WHEN 2 then '치과'
            WHEN 3 then '성형외과'
            WHEN 4 then '안과'
            WHEN 5 then '암 요양'
            WHEN 6 then '정형외과'
            WHEN 7 then '한의원'
    END) AS subject
FROM UserSubjects
WHERE userIdx = ?
ORDER BY subjectIdx;
SELECT userName, userSex, userBirth
FROM Users
WHERE userIdx = ?;

UPDATE Users
SET userName=?,
    userSex=?,
    userBirth=?
WHERE userIdx = ?;

DELETE
FROM UserAreas
WHERE userIdx = ?;

DELETE
FROM UserSubjects
WHERE userIdx = ?;

INSERT INTO UserSubjects (subjectIdx, userIdx)
VALUES (?);

UPDATE Users SET userStatus = 2 WHERE userIdx = ?;

-- 내가 찜한 병원
SELECT hospitalIdx,hospitalName,
       IFNULL(hospitalLogo,-1)AS hospitalLogo,
       (SELECT IFNULL(ROUND(SUM(reviewScore) / COUNT(reviewIdx), 1), 0)
        FROM Reviews
        WHERE Reviews.hospitalIdx = Hospitals.hospitalIdx
          AND Reviews.status = 1)                          AS reviewStar,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
       hospitalStartTime,
       hospitalEndTime
FROM UserHospitalHearts
         INNER JOIN Hospitals ON UserHospitalHearts.hospitalIdx = Hospitals.hospitalIdx
WHERE UserHospitalHearts.userIdx = ?
  AND UserHospitalHearts.status = 1;


SELECT DISTINCT DATE_FORMAT(createdAt, '%Y년 %m월 %d일')AS createdAt FROM Reviews WHERE status=1 AND userIdx=43
ORDER BY createdAt DESC;


 SELECT reviewOrder,
               reviewIdx,
               reviewScore,
               DATE_FORMAT(createdAt, '%Y.%m.%d')                                                     AS createdAt,
               review,
               IFNULL((SELECT reviewImg
                       FROM ReviewImg
                       WHERE Reviews.reviewIdx = ReviewImg.reviewIdx
                         AND reviewImgIdx IN
                             (SELECT MIN(reviewImgIdx) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)
                      ), -1)                                                                          AS reviewImg,
               (SELECT COUNT(reviewImg) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx) AS reviewImgCount

        FROM Reviews
        WHERE status = 1 AND userIdx = ? AND DATE_FORMAT(createdAt, '%Y년 %m월 %d일') = ?
        ORDER BY reviewIdx DESC;


SELECT Events.hospitalIdx,
       eventName,
       eventImg,
       hospitalName,
       CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress
FROM Events
         INNER JOIN Hospitals ON Events.hospitalIdx = Hospitals.hospitalIdx
WHERE eventStatus = 1
ORDER BY eventIdx DESC;
SELECT notificationIdx,notificationName,DATE_FORMAT(createdAt, '%Y.%m.%d') AS createdAt,notification
FROM Notifications WHERE notificationStatus =1
ORDER BY notificationIdx DESC;

SELECT LAST_INSERT_ID() AS reservationIdx;
SELECT COUNT(1) AS CNT FROM Reservations WHERE reservationIdx=?


-- Hoilday Table Create SQL
CREATE TABLE Hoilday
(
    `hoildayIdx`   INT            NOT NULL    AUTO_INCREMENT COMMENT '공휴일 인덱스',
    `hoildayName`  VARCHAR(50)    NOT NULL    COMMENT '공휴일 이름',
    `hoildayDate`  DATETIME       NOT NULL    COMMENT '공휴일날짜',
    `createdAt`    TIMESTAMP      NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP      NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (hoildayIdx)
);

ALTER TABLE Holiday COMMENT '공휴일 저장정보';

INSERT INTO Holiday (holidayName, holidayDate)VALUES ?;

SELECT holidayName, DATE_FORMAT(holidayDate, "%Y-%m-%d") AS holiday
FROM Holiday
WHERE DATE_FORMAT(holidayDate, "%Y-%m") = ?

-- 진행중인 일정
SELECT DISTINCT DATE_FORMAT(reservationTime, '%Y년 %m월 %d일') AS reservationDay

        FROM Reservations
            INNER JOIN Estimates
        ON Estimates.estimateIdx=Reservations.estimateIdx

        WHERE reservationTime > CURDATE() AND Estimates.userIdx = ?
        ORDER BY reservationTime DESC;

-- 완료된 일정
SELECT DISTINCT DATE_FORMAT(reservationTime, '%Y년 %m월 %d일') AS reservationDay

        FROM Reservations
            INNER JOIN Estimates
        ON Estimates.estimateIdx=Reservations.estimateIdx

        WHERE reservationTime < CURDATE() AND Estimates.userIdx = ?
        ORDER BY reservationTime DESC;

        SELECT Hospitals.hospitalIdx,
               Estimates.estimateIdx,
               IFNULL(hospitalLogo, -1)                            AS hospitalLogo,
               hospitalName,
               hospitalPhoneNumber,
               CONCAT(hospitalAddress, " ", hospitalAddressDetail) AS hospitalAddress,
               CONCAT(
                       DATE_FORMAT(reservationTime, '%y.%m.%d'), " ",
                       CASE WEEKDAY(reservationTime)
                           WHEN '0' THEN '(월)'
                           WHEN '1' THEN '(화)'
                           WHEN '2' THEN '(수)'
                           WHEN '3' THEN '(목)'
                           WHEN '4' THEN '(금)'
                           WHEN '5' THEN '(토)'
                           WHEN '6' THEN '(일)' END)                AS reservationTime,
               DATE_FORMAT(reservationTime, '%H : %i') AS time,
       estimateCost

        FROM Reservations
            INNER JOIN Estimates
        ON Estimates.estimateIdx=Reservations.estimateIdx
            INNER JOIN Hospitals ON Hospitals.hospitalIdx=Estimates.hospitalIdx
        WHERE reservationTime > CURDATE() AND Estimates.userIdx = ? AND DATE_FORMAT(reservationTime, '%Y년 %m월 %d일') = ?
        ORDER BY reservationTime DESC;

 SELECT DATE_FORMAT(createdAt, '%y.%m.%d') AS createdAt,
               storyImg, storyTitle, story
        FROM HospitalStory
        WHERE hospitalIdx = ?
          AND status = 1
          AND storyFixed = 'Y'
        ORDER BY createdAt DESC;