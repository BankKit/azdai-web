/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;


	import java.util.Date;


import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_forum_topic</tt>.
 */
public class ForumTopicDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:id */
	private long id;

	/** column:catg */
	private String catg;

	/** column:forum */
	private String forum;

	/** column:state */
	private String state;

	/** column:top_flag */
	private String topFlag;

	/** column:elite_flag */
	private String eliteFlag;

	/** column:reply_flag */
	private String replyFlag;

	/** column:topic */
	private long topic;

	/** column:post_user_no */
	private String postUserNo;

	/** column:post_nick_name */
	private String postNickName;

	/** column:gmt_post */
	private Date gmtPost;

	/** column:visit_count */
	private int visitCount;

	/** column:reply_count */
	private int replyCount;

	/** column:reply_user_no */
	private String replyUserNo;

	/** column:reply_nick_name */
	private String replyNickName;

	/** column:gmt_reply */
	private Date gmtReply;

	/** column:style */
	private String style;

	/** column:title */
	private String title;

	/** column:content */
	private String content;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getCatg() {
		return catg;
	}

	public void setCatg(String catg) {
		this.catg = catg;
	}
	public String getForum() {
		return forum;
	}

	public void setForum(String forum) {
		this.forum = forum;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}
	public String getEliteFlag() {
		return eliteFlag;
	}

	public void setEliteFlag(String eliteFlag) {
		this.eliteFlag = eliteFlag;
	}
	public String getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(String replyFlag) {
		this.replyFlag = replyFlag;
	}
	public long getTopic() {
		return topic;
	}

	public void setTopic(long topic) {
		this.topic = topic;
	}
	public String getPostUserNo() {
		return postUserNo;
	}

	public void setPostUserNo(String postUserNo) {
		this.postUserNo = postUserNo;
	}
	public String getPostNickName() {
		return postNickName;
	}

	public void setPostNickName(String postNickName) {
		this.postNickName = postNickName;
	}
	public Date getGmtPost() {
		return gmtPost;
	}

	public void setGmtPost(Date gmtPost) {
		this.gmtPost = gmtPost;
	}
	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getReplyUserNo() {
		return replyUserNo;
	}

	public void setReplyUserNo(String replyUserNo) {
		this.replyUserNo = replyUserNo;
	}
	public String getReplyNickName() {
		return replyNickName;
	}

	public void setReplyNickName(String replyNickName) {
		this.replyNickName = replyNickName;
	}
	public Date getGmtReply() {
		return gmtReply;
	}

	public void setGmtReply(Date gmtReply) {
		this.gmtReply = gmtReply;
	}
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
