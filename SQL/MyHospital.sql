
SELECT NOW();



INSERT INTO Users (userPhoneNumber,userName,userSex,userBirth)
VALUES (?,?,?,?);

SELECT userIdx FROM Users WHERE userPhoneNumber = ?;

INSERT INTO UserAreas (userLocation,userIdx)
VALUES (?,?);

SELECT userIdx,userLongitude,userLatitude FROM Users where userPhoneNumber = ?;

UPDATE Users SET userLongitude = ?, userLatitude = ? WHERE userIdx = ?;



-- 테이블 생성
-- ExamineType Table Create SQL
CREATE TABLE ExamineType
(
    `examineType`  TINYINT        NOT NULL    AUTO_INCREMENT COMMENT '0:공통, 1:피부과, 2:치과, 3:성형외과, 4:안과, 5:암요양, 6:정형외과 7:한방',
    `examineName`  VARCHAR(40)    NOT NULL    COMMENT '문진 과목 명',
    `createdAt`    TIMESTAMP      NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP      NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineType PRIMARY KEY (examineType)
);

ALTER TABLE ExamineType COMMENT '문진표 타입';


-- Examines Table Create SQL
CREATE TABLE Examines
(
    `examineIdx`   INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '문진표 인덱스',
    `userIdx`      INT UNSIGNED    NOT NULL    COMMENT '유저인덱스',
    `examineType`  TINYINT         NOT NULL    COMMENT '문진표카테고리',
    `status`       TINYINT         NOT NULL    DEFAULT 0 COMMENT '0:미완료 1:완료',
    `createdAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Examines PRIMARY KEY (examineIdx)
);

ALTER TABLE Examines COMMENT '문진표';




-- Reviews Table Create SQL
CREATE TABLE Reviews
(
    `reviewIdx`    INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '병원리뷰 인덱스',
    `hospitalIdx`  INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `userIdx`      INT UNSIGNED    NOT NULL    COMMENT '유저인덱스',
    `review`       VARCHAR(500)    NOT NULL    COMMENT '병원 리뷰 내용',
    `reviewScore`  FLOAT           NOT NULL    COMMENT '리뷰점수',
    `status`       TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:삭제, 1:유지',
    `createdAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Reviews PRIMARY KEY (reviewIdx)
);

ALTER TABLE Reviews COMMENT '병원리뷰';


-- Estimates Table Create SQL
CREATE TABLE Estimates
(
    `estimateIdx`   INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '견적서 인덱스',
    `hospitalIdx`   INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `examineIdx`    INT UNSIGNED    NOT NULL    COMMENT '문진표 인덱스',
    `estimateCost`  INT UNSIGNED    NOT NULL    COMMENT '의견금액',
    `opinion`       VARCHAR(500)    NOT NULL    COMMENT '의견',
    `createdAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Estimates PRIMARY KEY (estimateIdx)
);

ALTER TABLE Estimates COMMENT '견적서';


-- PartnerReservations Table Create SQL
CREATE TABLE PartnerReservations
(
    `partnerReservationIdx`  INT UNSIGNED    NOT NULL    COMMENT '예약가능날짜인덱스',
    `partnerIdx`             INT UNSIGNED    NOT NULL    COMMENT '파트너 인덱스',
    `reservationTime`        DATETIME        NOT NULL    COMMENT '예약가능시간',
    `createdAt`              TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`              TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_PartnerReservations PRIMARY KEY (partnerReservationIdx)
);

ALTER TABLE PartnerReservations COMMENT '파트너 예약 관리';


-- ExamineQuestions Table Create SQL
CREATE TABLE ExamineQuestions
(
    `examineQuestionIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '문진표 질문 인덱스',
    `examineType`         TINYINT         NOT NULL    COMMENT '문진표 카테고리',
    `questionType`        TINYINT         NOT NULL    COMMENT '0:단일, 1:복수, 2:서술',
    `examineContent`      VARCHAR(100)    NOT NULL    COMMENT '질문내용',
    `createdAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineQuestions PRIMARY KEY (examineQuestionIdx)
);

ALTER TABLE ExamineQuestions COMMENT '문진표 질문';


-- HospitalTags Table Create SQL
CREATE TABLE HospitalTags
(
    `hospitalTagIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '병원 태그 인덱스',
    `hospitalIdx`     INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `hospitalTag`     VARCHAR(20)     NOT NULL    COMMENT '병원 태그',
    `createdAt`       TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`       TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalTags PRIMARY KEY (hospitalTagIdx)
);

ALTER TABLE HospitalTags COMMENT '병원 태그';


-- UserHospitalHearts Table Create SQL
CREATE TABLE UserHospitalHearts
(
    `userIdx`      INT UNSIGNED    NOT NULL    COMMENT '유저인덱스',
    `hospitalIdx`  INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `status`       TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:off,  1:0n',
    `createdAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_UserHospitalHearts PRIMARY KEY (userIdx, hospitalIdx)
);

ALTER TABLE UserHospitalHearts COMMENT '유저 관심 병원';


-- ReviewImg Table Create SQL
CREATE TABLE ReviewImg
(
    `reviewImgIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '리뷰 이미지 인덱스',
    `reviewIdx`     INT UNSIGNED    NOT NULL    COMMENT '병원리뷰 인덱스',
    `reviewImg`     TEXT            NOT NULL,
    `createdAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ReviewImg PRIMARY KEY (reviewImgIdx)
);

ALTER TABLE ReviewImg COMMENT '병원리뷰 이미지';


-- Reservations Table Create SQL
CREATE TABLE Reservations
(
    `reservationIdx`         INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '예약 인덱스',
    `estimateIdx`            INT UNSIGNED    NOT NULL    COMMENT '견적서 인덱스',
    `partnerReservationIdx`  INT UNSIGNED    NOT NULL    COMMENT '예약가능날짜인덱스',
    `status`                 TINYINT         NOT NULL    DEFAULT 0 COMMENT '0:미완료 1:완료,2:예약취소',
    `createdAt`              TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`              TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Reservations PRIMARY KEY (reservationIdx)
);

ALTER TABLE Reservations COMMENT '병원 예약';


-- Events Table Create SQL
CREATE TABLE Events
(
    `eventIdx`     INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '이벤트 인덱스',
    `hospitalIdx`  INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `eventName`    VARCHAR(50)     NOT NULL    COMMENT '이벤트 이름',
    `eventUrl`     TEXT            NOT NULL    COMMENT '이벤트 url',
    `eventImg`     TEXT            NOT NULL    COMMENT '이벤트 대표 이미지',
    `status`       TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`    TIMESTAMP       NULL        DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NULL        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Events PRIMARY KEY (eventIdx)
);

ALTER TABLE Events COMMENT '이벤트 테이블';


-- Notifications Table Create SQL
CREATE TABLE Notifications
(
    `notificationIdx`   INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '공지사항 인덱스',
    `notificationName`  VARCHAR(50)     NOT NULL    COMMENT '공지사항 이름',
    `notification`      TEXT            NOT NULL    COMMENT '공지사항',
    `notificationUrl`   TEXT            NOT NULL    COMMENT '공지사항 url',
    `status`            TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`         TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`         TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Notifications PRIMARY KEY (notificationIdx)
);

ALTER TABLE Notifications COMMENT '공지사항';


-- HospitalStory Table Create SQL
CREATE TABLE HospitalStory
(
    `storyIdx`     INT UNSIGNED    NOT NULL    AUTO_INCREMENT,
    `hospitalIdx`  INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `storyName`    VARCHAR(50)     NOT NULL,
    `storyImg`     TEXT            NOT NULL,
    `story`        VARCHAR(100)    NOT NULL,
    `storyUrl`     TEXT            NOT NULL,
    `storyFixed`   CHAR(1)         NOT NULL    COMMENT 'Y:고정 N: 고정 안함',
    `status`       TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:종료,1:진행 중',
    `createdAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalStory PRIMARY KEY (storyIdx)
);

ALTER TABLE HospitalStory COMMENT '병원이야기';



-- PartnerExamines Table Create SQL
CREATE TABLE PartnerExamines
(
    `partnerIdx`     INT UNSIGNED    NOT NULL    COMMENT '파트너 인덱스',
    `examineIdx`     INT UNSIGNED    NOT NULL    COMMENT '문진표 인덱스',
    `examineStatus`  TINYINT         NOT NULL    DEFAULT 0 COMMENT '0:미확인 1: 확인 2: 견적서(전송)',
    `createdAt`      TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`      TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_PartnerExamines PRIMARY KEY (partnerIdx, examineIdx)
);

ALTER TABLE PartnerExamines COMMENT '파트너가 받은 문진표';


-- ExamineUserAnswers Table Create SQL
CREATE TABLE ExamineUserAnswers
(
    `examineIdx`          INT UNSIGNED    NOT NULL    COMMENT '문진표 인덱스',
    `examineQuestionIdx`  INT UNSIGNED    NOT NULL    COMMENT '문진표 질문 인덱스',
    `examineAnswer`       TEXT            NOT NULL    COMMENT '문진표 응답 내용',
    `createdAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineUserAnswers PRIMARY KEY (examineIdx, examineQuestionIdx)
);

ALTER TABLE ExamineUserAnswers COMMENT '문진표 유저 응답';





-- 배너
SELECT hospitalIdx, AdImg FROM Ad ORDER BY createdAt DESC LIMIT 5;

-- 우리의 의견
SELECT
       estimateIdx,IFNULL(hospitalLogo,-1)AS hospitalLogo,hospitalName,
       CONCAT(hospitalAddress," ",hospitalAddressDetail)AS hospitalAddress,
       DATE_FORMAT(Estimates.createdAt, '%Y.%m.%d')AS createdAt,
CONCAT(
 CASE WEEKDAY(Estimates.createdAt)
    WHEN '0' THEN '(월)'
    WHEN '1' THEN '(화)'
    WHEN '2' THEN '(수)'
    WHEN '3' THEN '(목)'
    WHEN '4' THEN '(금)'
    WHEN '5' THEN '(토)'
    WHEN '6' THEN '(일)'
 END," ",DATE_FORMAT(Estimates.createdAt,'%H:%i'))AS createdDay,
 Estimates.estimateCost

FROM Estimates
INNER JOIN Hospitals ON Hospitals.hospitalIdx = Estimates.hospitalIdx
WHERE Estimates.userIdx = ?;


-- 유저 위도, 유저 경도, 위도
-- 37.5548732, 127.0246126
SELECT IFNULL(doctorImg,-1)AS doctorImg,
       subjectIdx,hospitalName,
       IFNULL((SELECT ROUND(SUM(reviewScore)/COUNT(reviewIdx),1) FROM Reviews WHERE Reviews.hospitalIdx = Hospitals.hospitalIdx),0)AS averageStar,
       CONCAT(hospitalAddress," ",hospitalAddressDetail)AS hospitalAddress,
       round((6371*acos(cos(radians(?))*cos(radians(hospitalLatitude))*cos(radians(hospitalLongitude)
       -radians(?))+sin(radians(?))*sin(radians(hospitalLatitude)))),1)as distance,
       hospitalIdx
FROM Hospitals
WHERE hospitalName Like concat('%',?,'%');


SELECT (6371*acos(cos(radians(userLatitude))*cos(radians(cafeLatitude))*cos(radians(cafeHardness) -radians(userHardness))+sin(radians(userLatitude))*sin(radians(cafeLatitude)))) AS distance FROM Cafe,User -- HAVING distance <= (이 값을 지정하면 특정거리 이하만 출력하게 할 수 있음) ORDER BY distance;


CREATE TABLE Subjects
(
    `subjectIdx`   INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '진료과목 인덱스',
    `subjectName`  VARCHAR(30)     NOT NULL    COMMENT '진료 과목명',
    `createdAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`    TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT  PRIMARY KEY (subjectIdx)
);

ALTER TABLE Subjects COMMENT '진료 과목 종류';

-- Examines Table Create SQL
CREATE TABLE Examines
(
    `examineIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '문진표 인덱스',
    `userIdx`     INT UNSIGNED    NOT NULL    COMMENT '유저인덱스',
    `subjectIdx`  INT UNSIGNED    NOT NULL    COMMENT '진료과목 인덱스',
    `status`      TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:삭제 1:미삭제',
    `createdAt`   TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`   TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Examines PRIMARY KEY (examineIdx)
);

ALTER TABLE Examines COMMENT '문진표';

-- ExamineQuestions Table Create SQL
CREATE TABLE ExamineQuestions
(
    `examineQuestionIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '문진표 질문 인덱스',
    `subjectIdx`          INT UNSIGNED    NOT NULL    COMMENT '진료과목 인덱스',
    `questionType`        TINYINT         NOT NULL    COMMENT '0:단일, 1:복수, 2:서술',
    `examineContent`      VARCHAR(100)    NOT NULL    COMMENT '질문내용',
    `createdAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineQuestions PRIMARY KEY (examineQuestionIdx)
);

ALTER TABLE ExamineQuestions COMMENT '문진표 질문';

CREATE TABLE ExamineUserAnswers
(
    `examineIdx`          INT UNSIGNED    NOT NULL    COMMENT '문진표 인덱스',
    `examineQuestionIdx`  INT UNSIGNED    NOT NULL    COMMENT '문진표 질문 인덱스',
    `examineAnswer`       TEXT            NOT NULL    COMMENT '문진표 응답 내용',
    `createdAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`           TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ExamineUserAnswers PRIMARY KEY (examineIdx, examineQuestionIdx)
);

ALTER TABLE ExamineUserAnswers COMMENT '문진표 유저 응답';

-- 리뷰 이미지
SELECT hospitalImg FROM Hospitals WHERE hospitalIdx = ?;

-- 리뷰 총 평점
SELECT
       IFNULL(ROUND(SUM(reviewScore)/COUNT(reviewIdx),1),0)AS averageStar,
       COUNT(reviewIdx)AS reviewCount,
       COUNT(CASE WHEN reviewScore = 5 THEN 1 END)AS 5PointCount,
       COUNT(CASE WHEN reviewScore >=4 AND reviewScore < 5 THEN 1 END) AS 4PointCount,
       COUNT(CASE WHEN reviewScore >=3 AND reviewScore < 4 THEN 1 END) AS 3PointCount,
       COUNT(CASE WHEN reviewScore >=2 AND reviewScore < 3 THEN 1 END) AS 2PointCount,
       COUNT(CASE WHEN reviewScore < 2 THEN 1 END) AS 1PointCount

FROM Reviews WHERE hospitalIdx = ?;

-- 리뷰 가져오기
SELECT
@rownum:=@rownum + 1 as rNum,

reviewIdx,reviewScore,DATE_FORMAT(createdAt,'%Y.%m.%d')AS createdAt,review,
    (SELECT reviewImg FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx
        AND reviewImgIdx IN (SELECT MAX(reviewImgIdx) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)
    )AS reviewImg,
    (SELECT COUNT(reviewImg) FROM ReviewImg WHERE Reviews.reviewIdx = ReviewImg.reviewIdx)AS reviewImgCount

FROM Reviews,(SELECT @rownum:=0) t2
WHERE hospitalIdx = ? LIMIT 1,1;

-- 리뷰 사진 가져오기
SELECT
reviewImg
FROM ReviewImg WHERE reviewIdx = ?;

-- HospitalClosedDay Table Create SQL
CREATE TABLE HospitalClosedDay
(
    `closedDayIdx`  INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '휴뮤일 인덱스',
    `hospitalIdx`   INT UNSIGNED    NOT NULL    COMMENT '병원 인덱스',
    `monClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `tueClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `wedClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `thuClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `friClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `satClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `sunClosed`     TINYINT         NOT NULL    DEFAULT 1 COMMENT '0:휴무 1:오픈',
    `createdAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP       NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_HospitalClosedDay PRIMARY KEY (closedDayIdx)
);

ALTER TABLE HospitalClosedDay COMMENT '병원 정기 휴무일';

-- 병원 정보
SELECT IFNULL(hospitalImg,-1) AS hospitalImg,IFNULL(hospitalLogo,-1) AS hospitalLogo,hospitalName,CONCAT(hospitalAddress," ",hospitalAddressDetail)AS hospitalAddress,
       IFNULL(hospitalInfo,-1) AS hospitalInfo,hospitalPhonenumber,
       DATE_FORMAT(hospitalStratTime,'%H:%i')AS hospitalStratTime,
       DATE_FORMAT(hospitalEndTime,'%H:%i')AS hospitalEndTime,
       hospitalHoliday,monClosed,tueClosed,wedClosed,tueClosed,friClosed,satClosed,sunClosed

FROM Hospitals
INNER JOIN HospitalClosedDay ON HospitalClosedDay.hospitalIdx = Hospitals.hospitalIdx
WHERE Hospitals.hospitalIdx = ?;



SELECT hospitalTag FROM HospitalTags WHERE hospitalIdx = ?;

SELECT userIdx FROM UserHospitalHearts WHERE userIdx = ? AND hospitalIdx = ?;

INSERT INTO UserHospitalHearts (userIdx, hospitalIdx) VALUES (?,?);


UPDATE UserHospitalHearts SET status = IF(status = 0, 1, 0) WHERE userIdx = ? AND hospitalIdx = ?;

SELECT COUNT(CASE WHEN status=1 THEN 1 END)AS heartStatus FROM UserHospitalHearts WHERE userIdx = ? AND hospitalIdx = ?;

-- 병원이야기 상단
SELECT storyImg,storyTitle,storySubTitle FROM HospitalStory WHERE hospitalIdx = ? AND status = 1 AND storyFixed = 'Y' ORDER BY createdAt desc
limit 1;

-- 병원로고, 병원 이름
SELECT hospitalLogo,hospitalName FROM Hospitals WHERE hospitalIdx = ?;

-- 병원 이야기 가져오기
SELECT DATE_FORMAT(createdAt,'%Y.%m.%d')AS createdAt,storyImg,storyTitle,story,storySubTitle FROM HospitalStory WHERE hospitalIdx = ? AND status = 1 ORDER BY createdAt DESC
LIMIT ?,?;


INSERT INTO Reviews(hospitalIdx, userIdx, review, reviewScore) VALUES (1,1,"최고",3.7);

SELECT LAST_INSERT_ID() AS reviewIdx;

SELECT reviewIdx FROM Reviews WHERE hospitalIdx = ? AND userIdx=? AND review = ? AND reviewScore = ?;

INSERT INTO ReviewImg(reviewIdx, reviewImg) VALUES (?,?);


INSERT INTO Hospitals(subjectIdx,hospitalName,hospitalAddress,hospitalAddressDetail,hospitalPhonenumber,hospitalLatitude,hospitalLongitude)
VALUES (?,?,?,?,?,?,?);

INSERT INTO HospitalClosedDay(hospitalIdx) VALUES (?);

ALTER TABLE Hospitals AUTO_INCREMENT 42;
ALTER TABLE HospitalClosedDay AUTO_INCREMENT 42;