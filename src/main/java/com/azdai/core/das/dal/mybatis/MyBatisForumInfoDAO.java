/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.ForumInfoDAO;

import com.azdai.core.das.dal.dto.ForumInfoDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.ForumInfoDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Mon Mar 17 21:59:21 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisForumInfoDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ForumInfoDAO {


	/**
	 *  Insert one <tt>ForumInfoDTO</tt> object to DB table <tt>azdai_forum_info</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_forum_info(code,sort,state,open_ext,title,summary,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param forumInfo
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(ForumInfoDTO forumInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.insert");
	try {
    	if (forumInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	

        this.getSqlSession().insert("AZDAI-FORUM-INFO.insert", forumInfo);

        return forumInfo.getCode();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>azdai_forum_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_forum_info set sort=?, state=?, open_ext=?, title=?, summary=?, gmt_modify='NOW' where (code = ?)</tt>
	 *
	 *	@param forumInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(ForumInfoDTO forumInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.update");
	try {
    	if (forumInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-FORUM-INFO.update", forumInfo);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_info where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return ForumInfoDTO
	 *	@throws DataAccessException
	 */	 
    public ForumInfoDTO find(String code) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.find");
	try {

        return this.getSqlSession().selectOne("AZDAI-FORUM-INFO.find", code);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_info where (state = ?) order by sort ASC</tt>
	 *
	 *	@param state
	 *	@return List<ForumInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumInfoDTO> findState(String state) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.findState");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-INFO.findState", state);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>azdai_forum_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_forum_info order by sort ASC</tt>
	 *
	 *	@return List<ForumInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ForumInfoDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.findAll");
	try {

        return this.getSqlSession().selectList("AZDAI-FORUM-INFO.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_info where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String code) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.delete");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-INFO.delete", code);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>azdai_forum_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_forum_info where (state = ?)</tt>
	 *
	 *	@param state
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteState(String state) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-FORUM-INFO.deleteState");
	try {

        return this.getSqlSession().delete("AZDAI-FORUM-INFO.deleteState", state);
	} finally {
		Profiler.release();
	}
}
}