/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import com.azdai.core.das.dal.query.ForumTopicQuery;

import org.springframework.dao.DataAccessException;

import com.azdai.core.das.dal.dto.ForumTopicDTO;


/**
 * A dao interface provides methods to access database table <tt>azdai_forum_topic</tt>.
 */
public interface ForumTopicDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "ForumTopicDAO";

	/**
	 *  Insert one <tt>ForumTopicDTO</tt> object to DB table <tt>azdai_forum_topic</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_forum_topic(id,catg,forum,state,top_flag,elite_flag,reply_flag,topic,post_user_no,post_nick_name,gmt_post,visit_count,reply_count,reply_user_no,reply_nick_name,gmt_reply,style,title,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Insert one <tt>ForumTopicDTO</tt> object to DB table <tt>azdai_forum_topic</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_forum_topic(id,catg,forum,state,top_flag,elite_flag,reply_flag,post_user_no,post_nick_name,gmt_post,visit_count,reply_count,style,title,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertTopic(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Insert one <tt>ForumTopicDTO</tt> object to DB table <tt>azdai_forum_topic</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_forum_topic(id,catg,forum,topic,reply_user_no,reply_nick_name,gmt_reply,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertReply(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set forum=?, state=?, top_flag=?, elite_flag=?, reply_flag=?, topic=?, post_user_no=?, post_nick_name=?, visit_count=?, reply_count=?, reply_user_no=?, reply_nick_name=?, style=?, title=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set forum=?, state=?, top_flag=?, elite_flag=?, reply_flag=?, visit_count=?, reply_count=?, style=?, title=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateTopic(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set forum=?, state=?, top_flag=?, elite_flag=?, reply_flag=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateMeta(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set style=?, title=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param forumTopic
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateContent(ForumTopicDTO forumTopic) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set visit_count='VC', gmt_modify='NOW' where (id = 'ID')</tt>
	 *
	 *	@param id
	 *	@param delta
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateVisitDelta(long id, int delta) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set reply_count='RC', gmt_modify='NOW' where (id = 'ID')</tt>
	 *
	 *	@param id
	 *	@param delta
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateReplyDelta(long id, int delta) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_topic set reply_count='RC', reply_user_no='RUN', reply_nick_name='RNN', gmt_modify='NOW' where (id = 'ID')</tt>
	 *
	 *	@param id
	 *	@param replyDelta
	 *	@param replyUserNo
	 *	@param replyNickName
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateReplyInfo(long id, int replyDelta, String replyUserNo, String replyNickName) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return ForumTopicDTO
	 *	@throws DataAccessException
	 */	 
    public ForumTopicDTO find(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where ((catg = 'CATG') AND (topic = 'TOPIC'))</tt>
	 *
	 *	@param catg
	 *	@param topic
	 *	@return List<ForumTopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumTopicDTO> findByTopic(String catg, long topic) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where ((forum = 'FORUM') AND (catg = 'CATG') AND (state = 'STATE') AND (top_flag = 'TF'))</tt>
	 *
	 *	@param forum
	 *	@param catg
	 *	@param state
	 *	@param topFlag
	 *	@return List<ForumTopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumTopicDTO> findTopTopics(String forum, String catg, String state, String topFlag) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where ((forum = 'FORUM') AND (catg = 'CATG') AND (state = 'STATE') AND (top_flag = 'TF'))</tt>
	 *
	 *	@param offset
	 *	@param pageSize
	 *	@param forum
	 *	@param catg
	 *	@param state
	 *	@param topFlag
	 *	@return List<ForumTopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumTopicDTO> findNormalTopics(int offset, int pageSize, String forum, String catg, String state, String topFlag) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from azdai_forum_topic where ((forum = 'FORUM') AND (catg = 'CATG') AND (state = 'STATE') AND (top_flag = 'TF'))</tt>
	 *
	 *	@param forum
	 *	@param catg
	 *	@param state
	 *	@param topFlag
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findNormalTopicCount(String forum, String catg, String state, String topFlag) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where ((catg = 'CATG') AND (topic = 'TOPIC'))</tt>
	 *
	 *	@param offset
	 *	@param pageSize
	 *	@param catg
	 *	@param topic
	 *	@return List<ForumTopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumTopicDTO> findTopicView(int offset, int pageSize, String catg, long topic) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from azdai_forum_topic where ((catg = 'CATG') AND (topic = 'TOPIC'))</tt>
	 *
	 *	@param catg
	 *	@param topic
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findTopicViewCount(String catg, long topic) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_topic where (forum = 'FUZZY')</tt>
	 *
	 *	@param args
	 *	@return List<ForumTopicDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumTopicDTO> findFuzzy(ForumTopicQuery args) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_forum_topic</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from azdai_forum_topic where (forum = 'FUZZY')</tt>
	 *
	 *	@param args
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findFuzzyCount(ForumTopicQuery args) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_topic where ((id = 'ID') OR (topic = 'ID'))</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_forum_topic</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_topic where ((post_user_no = 'UN') OR (reply_user_no = 'UN'))</tt>
	 *
	 *	@param userNo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUserNo(String userNo) throws DataAccessException;

}
