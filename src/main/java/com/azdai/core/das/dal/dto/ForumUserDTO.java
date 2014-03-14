/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;


	import java.util.Date;


import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_forum_user</tt>.
 */
public class ForumUserDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:forum_code */
	private String forumCode;

	/** column:forum_title */
	private String forumTitle;

	/** column:user_no */
	private String userNo;

	/** column:nick_name */
	private String nickName;

	/** column:right_ext */
	private String rightExt;

	/** column:gmt_expire */
	private Date gmtExpire;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public String getForumCode() {
		return forumCode;
	}

	public void setForumCode(String forumCode) {
		this.forumCode = forumCode;
	}
	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRightExt() {
		return rightExt;
	}

	public void setRightExt(String rightExt) {
		this.rightExt = rightExt;
	}
	public Date getGmtExpire() {
		return gmtExpire;
	}

	public void setGmtExpire(Date gmtExpire) {
		this.gmtExpire = gmtExpire;
	}

}
