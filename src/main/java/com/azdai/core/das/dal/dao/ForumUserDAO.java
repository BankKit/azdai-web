/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import com.azdai.core.das.dal.dto.ForumUserDTO;

import java.util.List;

import java.util.Date;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_forum_user</tt>.
 */
public interface ForumUserDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "ForumUserDAO";

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
    public String insert(ForumUserDTO forumUser) throws DataAccessException;

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
    public int update(ForumUserDTO forumUser) throws DataAccessException;

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
    public ForumUserDTO find(String forumCode, String userNo) throws DataAccessException;

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
    public List<ForumUserDTO> findForum(String forumCode) throws DataAccessException;

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
    public List<ForumUserDTO> findUserNo(String userNo) throws DataAccessException;

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
    public List<ForumUserDTO> findExpire(Date gmtExpire) throws DataAccessException;

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
    public List<ForumUserDTO> findAll() throws DataAccessException;

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
    public int delete(String forumCode, String userNo) throws DataAccessException;

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
    public int deleteForum(String forumCode) throws DataAccessException;

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
    public int deleteUserNo(String userNo) throws DataAccessException;

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
    public int deleteExpire(Date gmtExpire) throws DataAccessException;

}
