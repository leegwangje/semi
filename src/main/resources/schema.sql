create table if not exists members(
    mno int auto_increment primary key,
    userid varchar(18) unique not NULL ,
    passwd varchar(64)  not NULL ,
    name varchar(50) not null,
    email varchar(100) not null,
    regdate datetime default current_timestamp
);

create table if not exists boards(
    bno int auto_increment ,
    title varchar(128)  not NULL ,
    userid varchar(18)  not NULL ,
    regdate datetime default current_timestamp,
    thumbs int default 0,
    views int default 0,
    contents text not null,
    primary key(bno),
    foreign key (userid) references members(userid)
    );

create table if not exists replys(
    rno int auto_increment ,
    userid varchar(18)  not NULL ,
    comments text not null ,
    regdate datetime default current_timestamp,
    ref int not null,
    pno int not null ,
    primary key(rno)
       /* foreign key (userid) references members(userid)
        foreign key (pno) references boards(bno)*/
);

create table if not exists gallerys(
     gno int auto_increment ,
     title varchar(128)  not NULL ,
     userid varchar(18)  not NULL ,
     regdate datetime default current_timestamp,
     thumbs int default 0,
     views int default 0,
     contents text not null,
     simgname varchar(128) not null,
     primary key(gno),
     foreign key (userid) references members(userid)
);

create table if not exists gallery_images (
    gino int auto_increment ,
    gno int not null ,
    imgname varchar(128)  not NULL ,
    imgsize int not NULL ,
    regdate datetime default current_timestamp,
    primary key(gino),
    foreign key (gno) references gallerys(gno)
);

create table if not exists animal (
  ANIMAL_NO INT PRIMARY KEY,                -- 동물 번호
  NM VARCHAR(100) NOT NULL,                 -- 동물 이름
  ENTRNC_DATE DATE NOT NULL,                -- 입소 날짜
  SPCS VARCHAR(50) NOT NULL,                -- 종 (예: 개, 고양이)
  BREEDS VARCHAR(50),                       -- 품종
  SEXDSTN VARCHAR(10),                      -- 성별 (예: 남자, 여자)
  AGE varchar(50),                                  -- 나이
  BDWGH DECIMAL(5,2),                       -- 몸무게 (예: 10.5 kg)
  ADP_STTUS VARCHAR(20),                    -- 입양 상태 (예: 대기, 입양완료)
  TMPR_PRTC_STTUS VARCHAR(20),              -- 임시 보호 상태 (예: 보호 중, 보호 완료)
  INTRCN_MVP_URL VARCHAR(255),              -- 이동 URL (예: 이미지나 동영상 URL)
  INTRCN_CN TEXT,                           -- 소개 내용 (예: 동물에 대한 설명)
  TMPR_PRTC_CN TEXT                         -- 임시 보호자 연락처 (예: 보호자 연락처)
);


create table if not exists animal_pic (
    ANIMAL_NO INT NOT NULL,         -- 동물 번호
    PHOTO_KND VARCHAR(50) NOT NULL, -- 사진 종류 (예: 얼굴, 전체 등)
    PHOTO_NO INT NOT NULL,          -- 사진 번호 (같은 동물에 대한 여러 장의 사진을 구분)
    PHOTO_URL VARCHAR(255) NOT NULL, -- 사진 URL (사진이 저장된 경로 또는 URL)
    PRIMARY KEY (ANIMAL_NO, PHOTO_KND, PHOTO_NO),
    FOREIGN KEY (ANIMAL_NO) REFERENCES animal(ANIMAL_NO) -- 동물 테이블과 연관
    );

-- animal_status 테이블 수정 (동물 번호 연관 추가)
CREATE TABLE IF NOT EXISTS animal_status
(
    district         VARCHAR(100) NOT NULL,               -- 지역 구분 (예: 지역 이름)
    total            INT          NOT NULL,               -- 전체 동물 수
    total_dogs       INT          NOT NULL,               -- 전체 개 수
    returned_dogs    INT          NOT NULL,               -- 반환된 개 수
    adopted_dogs     INT          NOT NULL,               -- 입양된 개 수
    euthanized_dogs  INT          NOT NULL,               -- 안락사된 개 수
    transferred_dogs INT          NOT NULL,               -- 다른 곳으로 이송된 개 수
    total_cats       INT          NOT NULL,               -- 전체 고양이 수
    returned_cats    INT          NOT NULL,               -- 반환된 고양이 수
    adopted_cats     INT          NOT NULL,               -- 입양된 고양이 수
    euthanized_cats  INT          NOT NULL,               -- 안락사된 고양이 수
    transferred_cats INT          NOT NULL,               -- 다른 곳으로 이송된 고양이 수
    report_date      DATE         NOT NULL,               -- 보고 날짜 (데이터 기록일)
    ANIMAL_NO        INT,                                 -- 동물 번호 (연관 추가)
    PRIMARY KEY (district, report_date),                  -- 구역별로 날짜 기준으로 유니크하게 설정
    FOREIGN KEY (ANIMAL_NO) REFERENCES animal (ANIMAL_NO) -- 동물 테이블과 연관


);
