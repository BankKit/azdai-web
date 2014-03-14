/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal;

/**
 * A fields const object database.
 */
public interface DBSize {

	//
	public static interface CRAWL {
		//
		public static final String ID = "id";
		//
		public static final String NAME = "name";
		//
		public static final int NAME_MAX = 255;
		//
		public static final String CONTENT = "content";
		//
		public static final int CONTENT_MAX = 65535;
		//
		public static final String GMT_CREATE = "gmt_create";
		//
		public static final String GMT_MODIFY = "gmt_modify";
	}
	
	//
	public static interface FORUM_INFO {
		//
		public static final String CODE = "code";
		//
		public static final int CODE_MAX = 32;
		//
		public static final String SORT = "sort";
		//
		public static final int SORT_MAX = 4;
		//
		public static final String STATE = "state";
		//
		public static final int STATE_MAX = 20;
		//
		public static final String OPEN_EXT = "open_ext";
		//
		public static final int OPEN_EXT_MAX = 20;
		//
		public static final String TITLE = "title";
		//
		public static final int TITLE_MAX = 128;
		//
		public static final String SUMMARY = "summary";
		//
		public static final int SUMMARY_MAX = 512;
		//
		public static final String GMT_CREATE = "gmt_create";
		//
		public static final String GMT_MODIFY = "gmt_modify";
	}
	
	//
	public static interface FORUM_TOPIC {
		//
		public static final String ID = "id";
		//
		public static final String CATG = "catg";
		//
		public static final int CATG_MAX = 10;
		//
		public static final String FORUM = "forum";
		//
		public static final int FORUM_MAX = 32;
		//
		public static final String STATE = "state";
		//
		public static final int STATE_MAX = 10;
		//
		public static final String TOP_FLAG = "top_flag";
		//
		public static final int TOP_FLAG_MAX = 10;
		//
		public static final String ELITE_FLAG = "elite_flag";
		//
		public static final int ELITE_FLAG_MAX = 10;
		//
		public static final String REPLY_FLAG = "reply_flag";
		//
		public static final int REPLY_FLAG_MAX = 10;
		//
		public static final String TOPIC = "topic";
		//
		public static final String POST_USER_NO = "post_user_no";
		//
		public static final int POST_USER_NO_MAX = 32;
		//
		public static final String POST_NICK_NAME = "post_nick_name";
		//
		public static final int POST_NICK_NAME_MAX = 32;
		//
		public static final String GMT_POST = "gmt_post";
		//
		public static final String VISIT_COUNT = "visit_count";
		//
		public static final String REPLY_COUNT = "reply_count";
		//
		public static final String REPLY_USER_NO = "reply_user_no";
		//
		public static final int REPLY_USER_NO_MAX = 32;
		//
		public static final String REPLY_NICK_NAME = "reply_nick_name";
		//
		public static final int REPLY_NICK_NAME_MAX = 32;
		//
		public static final String GMT_REPLY = "gmt_reply";
		//
		public static final String STYLE = "style";
		//
		public static final int STYLE_MAX = 255;
		//
		public static final String TITLE = "title";
		//
		public static final int TITLE_MAX = 255;
		//
		public static final String CONTENT = "content";
		//
		public static final int CONTENT_MAX = 65535;
		//
		public static final String GMT_CREATE = "gmt_create";
		//
		public static final String GMT_MODIFY = "gmt_modify";
	}
	
	//
	public static interface FORUM_USER {
		//
		public static final String FORUM_CODE = "forum_code";
		//
		public static final int FORUM_CODE_MAX = 32;
		//
		public static final String FORUM_TITLE = "forum_title";
		//
		public static final int FORUM_TITLE_MAX = 128;
		//
		public static final String USER_NO = "user_no";
		//
		public static final int USER_NO_MAX = 32;
		//
		public static final String NICK_NAME = "nick_name";
		//
		public static final int NICK_NAME_MAX = 32;
		//
		public static final String RIGHT_EXT = "right_ext";
		//
		public static final int RIGHT_EXT_MAX = 1024;
		//
		public static final String GMT_EXPIRE = "gmt_expire";
		//
		public static final String GMT_CREATE = "gmt_create";
		//
		public static final String GMT_MODIFY = "gmt_modify";
	}
	
	//
	public static interface IMAGE {
		//
		public static final String ID = "id";
		//
		public static final int ID_MAX = 32;
		//
		public static final String FLAG = "flag";
		//
		public static final int FLAG_MAX = 20;
		//
		public static final String TOPIC = "topic";
		//
		public static final int TOPIC_MAX = 32;
		//
		public static final String TITLE = "title";
		//
		public static final int TITLE_MAX = 255;
		//
		public static final String SIZE = "size";
		//
		public static final String WIDTH = "width";
		//
		public static final String HEIGHT = "height";
		//
		public static final String URL = "url";
		//
		public static final int URL_MAX = 255;
		//
		public static final String SUMMARY = "summary";
		//
		public static final int SUMMARY_MAX = 255;
		//
		public static final String GMT_CREATE = "gmt_create";
		//
		public static final String GMT_MODIFY = "gmt_modify";
	}
	
}
