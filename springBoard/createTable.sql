-- DROP TABLE TB_BOARD;

CREATE TABLE TB_BOARD
(
    IDX INT not null auto_increment,
    PARENT_IDX INT,
    TITLE VARCHAR(100) NOT NULL,
    CONTENTS VARCHAR(4000) NOT NULL,
    HIT_CNT INT NOT NULL,
    DEL_GB VARCHAR(1) DEFAULT 'N' NOT NULL,
    CREA_DTM DATETIME DEFAULT CURRENT_TIMESTAMP,
    CREA_ID VARCHAR(30) NOT NULL,
    PRIMARY KEY(IDX)
);

DROP TABLE TB_FILE;
CREATE TABLE TB_FILE
(
	IDX	INT	NOT NULL	AUTO_INCREMENT,
	BOARD_IDX	INT	NOT NULL,
	ORIGINAL_FILE_NAME	VARCHAR(260)	NOT NULL,
	STORED_FILE_NAME	VARCHAR(36)	NOT NULL,
	FILE_SIZE	INT,
	CREA_DTM  DATETIME	DEFAULT	CURRENT_TIMESTAMP	NOT NULL,
	CREA_ID	VARCHAR(30)	NOT NULL,
	DEL_GB	VARCHAR(1)	DEFAULT 'N' NOT NULL,
	PRIMARY KEY (IDX)
);