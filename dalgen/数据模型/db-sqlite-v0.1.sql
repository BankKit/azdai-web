/**
 * 统一单据数据表
 */
CREATE TABLE atom_ticket (
  name varchar(64) NOT NULL COMMENT '单据名称',
  version bigint(20) DEFAULT '1',
  step bigint(20) DEFAULT '10',
  ticket bigint(20) DEFAULT '1' COMMENT '单据值',
  minv bigint(20) DEFAULT '1',
  maxv bigint(20) DEFAULT '9999999999',
  cycle varchar(16) DEFAULT 'TRUE',
  PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO atom_ticket VALUES ('TB-ForumTopic-ID', 6, 10, 50, 1, 9999999999, 'TRUE');
INSERT INTO atom_ticket VALUES ('TB-HelpCenter-ID', 1, 10, 1, 1, 9999999999, 'TRUE');
INSERT INTO atom_ticket VALUES ('TB-UserInfo-ID', 5, 10, 41, 1, 9999999999, 'TRUE');
INSERT INTO atom_ticket VALUES ('TB-RoleInfo-ID', 5, 10, 1, 1, 9999999999, 'TRUE');
INSERT INTO atom_ticket VALUES ('TB-UploadFile-ID', 5, 10, 1, 1, 9999999999, 'TRUE');

/**
 * 系统参数数据表
 */
CREATE TABLE azdai_param_config (
  catg 	VARCHAR(64),
  name	VARCHAR(64),
  title VARCHAR(128),
  value VARCHAR(1024),
  value_ext  TEXT,
  gmt_create DATETIME,
  gmt_modify DATETIME,
  PRIMARY KEY(catg, name)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT '系统参数数据表';


/**
 * 论坛信息数据表
 */
CREATE TABLE azdai_forum_info (
  code 		VARCHAR(32),
  sort		VARCHAR(4),
  state		VARCHAR(20),
  open_ext	VARCHAR(20),
  title 	VARCHAR(128),
  summary 	VARCHAR(512),
  gmt_create DATETIME,
  gmt_modify DATETIME,
  PRIMARY KEY (code),
  CONSTRAINT azdai_forum_info_title_u UNIQUE (title)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 关系模型数据表
 */
CREATE TABLE azdai_forum_user (
  forum_code 	VARCHAR(32),
  forum_title	VARCHAR(128),
  user_no 		VARCHAR(32),
  nick_name 	VARCHAR(32),
  right_ext 	VARCHAR(1024),
  gmt_expire	DATETIME,
  gmt_create 	DATETIME,
  gmt_modify 	DATETIME,
  PRIMARY KEY (forum_code, user_no)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 主题信息数据表
 */
CREATE TABLE azdai_forum_topic (
  id				BIGINT,
  catg				VARCHAR(10),
  forum				VARCHAR(32),
  state 			VARCHAR(10),
  top_flag			VARCHAR(10),
  elite_flag		VARCHAR(10),
  reply_flag		VARCHAR(10),
  topic 			BIGINT,
  post_user_no 		VARCHAR(32),
  post_nick_name 	VARCHAR(32),
  gmt_post 			DATETIME,
  visit_count 		INT(10) DEFAULT '0',
  reply_count 		INT(10) DEFAULT '0',
  reply_user_no 	VARCHAR(32),
  reply_nick_name 	VARCHAR(32),
  gmt_reply 		DATETIME,
  style 			VARCHAR(255),
  title 			VARCHAR(255),
  content 			TEXT,
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE INDEX azdai_forum_topic_catg_idx ON azdai_forum_topic (catg);
CREATE INDEX azdai_forum_topic_forum_idx ON azdai_forum_topic (forum);
CREATE INDEX azdai_forum_topic_topic_idx ON azdai_forum_topic (topic);
CREATE INDEX azdai_forum_topic_puno_idx ON azdai_forum_topic (post_user_no);
CREATE INDEX azdai_forum_topic_runo_idx ON azdai_forum_topic (reply_user_no);

/**
 * 用户信息数据表
 */
CREATE TABLE azdai_user_info (
  no VARCHAR(32),
  nick_name VARCHAR(32),
  state VARCHAR(20),
  sex VARCHAR(2),
  login_state VARCHAR(10),
  email_state VARCHAR(10),
  mobile_state VARCHAR(10),
  passwd VARCHAR(64),
  passwd_err_count INT DEFAULT '0',
  regist_date VARCHAR(10),
  active_date VARCHAR(10),
  auth_date VARCHAR(10),
  mobile VARCHAR(16),
  email VARCHAR(64),
  real_name VARCHAR(64),
  avatar VARCHAR(128),
  birth_date VARCHAR(10),
  post_code VARCHAR(10),
  province_code VARCHAR(10),
  city_code VARCHAR(10),
  county_code VARCHAR(10),
  street_info VARCHAR(128),
  gmt_create DATETIME,
  gmt_modify DATETIME,
  PRIMARY KEY (no),
  CONSTRAINT azdai_user_info_nick_u UNIQUE (nick_name),
  CONSTRAINT azdai_user_info_mobile_u UNIQUE (mobile),
  CONSTRAINT azdai_user_info_email_u UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 帮助中心数据表
 */
CREATE TABLE azdai_help_center (
  id				BIGINT,
  catg				BIGINT,
  show_flag			VARCHAR(10),
  sort				VARCHAR(10),
  accept_count		INT,
  reject_count		INT,
  clazz				VARCHAR(128),
  title				VARCHAR(255),
  content 			TEXT,
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (id)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 权限信息数据表
 */
CREATE TABLE azdai_right_info (
  code				VARCHAR(64),
  title				VARCHAR(128),
  memo				VARCHAR(256),
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (code)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 角色信息数据表
 */
CREATE TABLE azdai_role_info (
  id				BIGINT,
  title				VARCHAR(128),
  memo				VARCHAR(256),
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (id)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 角色权限数据表
 */
CREATE TABLE azdai_role_right (
  role_id			BIGINT,
  rgt_code			VARCHAR(64),
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (role_id, rgt_code)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 角色权限数据表
 */
CREATE TABLE azdai_user_role (
  user_no			VARCHAR(32),
  nick_name			VARCHAR(32),
  role_id			BIGINT,
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (user_no, role_id)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

/**
 * 角色权限数据表
 */
CREATE TABLE azdai_upload_file (
  id				BIGINT,
  user_no			VARCHAR(32),
  nick_name			VARCHAR(32),
  catg				VARCHAR(20),
  file_type			VARCHAR(20),
  title				VARCHAR(128),
  length			BIGINT,
  path				VARCHAR(128),
  name				VARCHAR(128),
  ext				VARCHAR(20),
  src_name			VARCHAR(128),
  memo				VARCHAR(256),
  gmt_create 		DATETIME,
  gmt_modify 		DATETIME,
  PRIMARY KEY (id)
/**);*/
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE INDEX azdai_upload_file_uno_idx ON azdai_upload_file (user_no);

