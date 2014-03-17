/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.ForumUserDAO;

import com.azdai.core.das.dal.dto.ForumUserDTO;
import java.util.Map;
import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.ForumUserDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Mon Mar 17 21:59:21 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisForumUserDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ForumUserDAO {


	/**
	 *  Insert one <tt>ForumUserDTO</tt> object to DB table <tt>azdai_forum_user</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_forum_user(forum_code,forum_title,user_no,nick_name,right_ext,gmt_expire,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param forumUser
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(ForumUserDTO forumUser) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.insert");
	try {
    	if (forumUser == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	

        this.getSqlSession().insert("AZDAI-FORUM-USER.insert", forumUser);

        return forumUser.getUserNo();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>azdai_forum_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_user set forum_title=?, nick_name=?, right_ext=?, gmt_expire=?, gmt_modify='NOW' where ((forum_code = ?) AND (user_no = ?))</tt>
	 *
	 *	@param forumUser
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(ForumUserDTO forumUser) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.update");
	try {
    	if (forumUser == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-USER.update", forumUser);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_user where ((forum_code = ?) AND (user_no = ?))</tt>
	 *
	 *	@param forumCode
	 *	@param userNo
	 *	@return ForumUserDTO
	 *	@throws DataAccessException
	 */	 
    public ForumUserDTO find(String forumCode, String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.find");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("forumCode", forumCode);
        param.put("userNo", userNo);

        return this.getSqlSession().selectOne("AZDAI-FORUM-USER.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_user where (forum_code = ?) order by user_no ASC</tt>
	 *
	 *	@param forumCode
	 *	@return List<ForumUserDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumUserDTO> findForum(String forumCode) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.findForum");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-USER.findForum", forumCode);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_user where (user_no = ?) order by forum_code ASC</tt>
	 *
	 *	@param userNo
	 *	@return List<ForumUserDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumUserDTO> findUserNo(String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.findUserNo");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-USER.findUserNo", userNo);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_user where (gmt_expire <= ?)</tt>
	 *
	 *	@param gmtExpire
	 *	@return List<ForumUserDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumUserDTO> findExpire(Date gmtExpire) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.findExpire");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-USER.findExpire", gmtExpire);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_user</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_user order by forum_code ASC, user_no ASC</tt>
	 *
	 *	@return List<ForumUserDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumUserDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.findAll");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-USER.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_user where ((forum_code = ?) AND (user_no = ?))</tt>
	 *
	 *	@param forumCode
	 *	@param userNo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String forumCode, String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.delete");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("forumCode", forumCode);
        param.put("userNo", userNo);

        return this.getSqlSession().delete("AZDAI-FORUM-USER.delete", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_user where (forum_code = ?)</tt>
	 *
	 *	@param forumCode
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteForum(String forumCode) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.deleteForum");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-USER.deleteForum", forumCode);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_user where (user_no = ?)</tt>
	 *
	 *	@param userNo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteUserNo(String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.deleteUserNo");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-USER.deleteUserNo", userNo);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_user</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_user where (gmt_expire <= ?)</tt>
	 *
	 *	@param gmtExpire
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteExpire(Date gmtExpire) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-USER.deleteExpire");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-USER.deleteExpire", gmtExpire);
	} finally {
		Profiler.release();
	}
}
}
