/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import com.azdai.core.das.dal.dto.ForumInfoDTO;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_forum_info</tt>.
 */
public interface ForumInfoDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "ForumInfoDAO";

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
    public String insert(ForumInfoDTO forumInfo) throws DataAccessException;

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
    public int update(ForumInfoDTO forumInfo) throws DataAccessException;

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
    public ForumInfoDTO find(String code) throws DataAccessException;

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
    public List<ForumInfoDTO> findState(String state) throws DataAccessException;

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
    public List<ForumInfoDTO> findAll() throws DataAccessException;

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
    public int delete(String code) throws DataAccessException;

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
    public int deleteState(String state) throws DataAccessException;

}
