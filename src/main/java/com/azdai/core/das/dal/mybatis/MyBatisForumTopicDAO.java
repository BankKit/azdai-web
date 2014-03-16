/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.ForumTopicDAO;

import java.util.Map;
import java.util.List;
import com.azdai.core.das.dal.query.ForumTopicQuery;
import com.azdai.core.das.dal.dto.ForumTopicDTO;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.ForumTopicDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Sun Mar 16 19:35:58 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisForumTopicDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ForumTopicDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


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
    public long insert(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.insert");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            forumTopic.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("AZDAI-FORUM-TOPIC.insert", forumTopic);

        return forumTopic.getId();
	} finally {
		Profiler.release();
	}
}

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
    public long insertTopic(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.insertTopic");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            forumTopic.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("AZDAI-FORUM-TOPIC.insertTopic", forumTopic);

        return forumTopic.getId();
	} finally {
		Profiler.release();
	}
}

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
    public long insertReply(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.insertReply");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            forumTopic.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("AZDAI-FORUM-TOPIC.insertReply", forumTopic);

        return forumTopic.getId();
	} finally {
		Profiler.release();
	}
}

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
    public int update(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.update");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.update", forumTopic);
	} finally {
		Profiler.release();
	}
}
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
    public int updateTopic(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateTopic");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateTopic", forumTopic);
	} finally {
		Profiler.release();
	}
}
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
    public int updateMeta(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateMeta");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateMeta", forumTopic);
	} finally {
		Profiler.release();
	}
}
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
    public int updateContent(ForumTopicDTO forumTopic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateContent");
	try {
    	if (forumTopic == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateContent", forumTopic);
	} finally {
		Profiler.release();
	}
}
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
    public int updateVisitDelta(long id, int delta) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateVisitDelta");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", new Long(id));
        param.put("delta", new Integer(delta));

        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateVisitDelta", param);
	} finally {
		Profiler.release();
	}
}
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
    public int updateReplyDelta(long id, int delta) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateReplyDelta");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", new Long(id));
        param.put("delta", new Integer(delta));

        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateReplyDelta", param);
	} finally {
		Profiler.release();
	}
}
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
    public int updateReplyInfo(long id, int replyDelta, String replyUserNo, String replyNickName) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.updateReplyInfo");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", new Long(id));
        param.put("replyDelta", new Integer(replyDelta));
        param.put("replyUserNo", replyUserNo);
        param.put("replyNickName", replyNickName);

        return this.getSqlSession().update("AZDAI-FORUM-TOPIC.updateReplyInfo", param);
	} finally {
		Profiler.release();
	}
}
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
    public ForumTopicDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("AZDAI-FORUM-TOPIC.find", param);

	} finally {
		Profiler.release();
	}
}
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
    public List<ForumTopicDTO> findByTopic(String catg, long topic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findByTopic");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("topic", new Long(topic));

        return this.getSqlSession().selectList("AZDAI-FORUM-TOPIC.findByTopic", param);

	} finally {
		Profiler.release();
	}
}
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
    public List<ForumTopicDTO> findTopTopics(String forum, String catg, String state, String topFlag) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findTopTopics");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("forum", forum);
        param.put("catg", catg);
        param.put("state", state);
        param.put("topFlag", topFlag);

        return this.getSqlSession().selectList("AZDAI-FORUM-TOPIC.findTopTopics", param);

	} finally {
		Profiler.release();
	}
}
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
    public List<ForumTopicDTO> findNormalTopics(int offset, int pageSize, String forum, String catg, String state, String topFlag) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findNormalTopics");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("offset", new Integer(offset));
        param.put("pageSize", new Integer(pageSize));
        param.put("forum", forum);
        param.put("catg", catg);
        param.put("state", state);
        param.put("topFlag", topFlag);

        return this.getSqlSession().selectList("AZDAI-FORUM-TOPIC.findNormalTopics", param);

	} finally {
		Profiler.release();
	}
}
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
    public long findNormalTopicCount(String forum, String catg, String state, String topFlag) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findNormalTopicCount");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("forum", forum);
        param.put("catg", catg);
        param.put("state", state);
        param.put("topFlag", topFlag);

	    Long retObj = (Long) this.getSqlSession().selectOne("AZDAI-FORUM-TOPIC.findNormalTopicCount", param);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

	} finally {
		Profiler.release();
	}
}
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
    public List<ForumTopicDTO> findTopicView(int offset, int pageSize, String catg, long topic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findTopicView");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("offset", new Integer(offset));
        param.put("pageSize", new Integer(pageSize));
        param.put("catg", catg);
        param.put("topic", new Long(topic));

        return this.getSqlSession().selectList("AZDAI-FORUM-TOPIC.findTopicView", param);

	} finally {
		Profiler.release();
	}
}
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
    public long findTopicViewCount(String catg, long topic) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findTopicViewCount");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("topic", new Long(topic));

	    Long retObj = (Long) this.getSqlSession().selectOne("AZDAI-FORUM-TOPIC.findTopicViewCount", param);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

	} finally {
		Profiler.release();
	}
}
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
    public List<ForumTopicDTO> findFuzzy(ForumTopicQuery args) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findFuzzy");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-TOPIC.findFuzzy", args);

	} finally {
		Profiler.release();
	}
}
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
    public long findFuzzyCount(ForumTopicQuery args) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.findFuzzyCount");
	try {

	    Long retObj = (Long) this.getSqlSession().selectOne("AZDAI-FORUM-TOPIC.findFuzzyCount", args);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

	} finally {
		Profiler.release();
	}
}
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
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("AZDAI-FORUM-TOPIC.delete", param);
	} finally {
		Profiler.release();
	}
}
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
    public int deleteByUserNo(String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-TOPIC.deleteByUserNo");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-TOPIC.deleteByUserNo", userNo);
	} finally {
		Profiler.release();
	}
}
}
