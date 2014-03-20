/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import com.azdai.core.das.dal.dto.UserRoleDTO;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_user_role</tt>.
 */
public interface UserRoleDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "UserRoleDAO";

	/**
	 *  Insert one <tt>UserRoleDTO</tt> object to DB table <tt>azdai_user_role</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_user_role(user_no,nick_name,role_id,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param userRole
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(UserRoleDTO userRole) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_role</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_role where ((user_no = ?) AND (role_id = ?))</tt>
	 *
	 *	@param userNo
	 *	@param roleId
	 *	@return UserRoleDTO
	 *	@throws DataAccessException
	 */	 
    public UserRoleDTO find(String userNo, long roleId) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_role</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_role where (user_no = ?) order by role_id ASC</tt>
	 *
	 *	@param userNo
	 *	@return List<UserRoleDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserRoleDTO> findByUser(String userNo) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_role</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_role where (role_id = ?) order by user_no ASC</tt>
	 *
	 *	@param roleId
	 *	@return List<UserRoleDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserRoleDTO> findByRole(long roleId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_user_role</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_user_role where ((user_no = ?) AND (role_id = ?))</tt>
	 *
	 *	@param userNo
	 *	@param roleId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String userNo, long roleId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_user_role</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_user_role where (user_no = ?)</tt>
	 *
	 *	@param userNo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUser(String userNo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_user_role</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_user_role where (role_id = ?)</tt>
	 *
	 *	@param roleId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByRole(long roleId) throws DataAccessException;

}
