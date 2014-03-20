/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import com.azdai.core.das.dal.dto.RoleRightDTO;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_role_right</tt>.
 */
public interface RoleRightDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "RoleRightDAO";

	/**
	 *  Insert one <tt>RoleRightDTO</tt> object to DB table <tt>azdai_role_right</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_role_right(role_id,rgt_code,gmt_create,gmt_modify) values (?, ?, ?, ?)</tt>
	 *
	 *	@param roleRight
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(RoleRightDTO roleRight) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_right where ((role_id = ?) AND (rgt_code = ?))</tt>
	 *
	 *	@param roleId
	 *	@param rgtCode
	 *	@return RoleRightDTO
	 *	@throws DataAccessException
	 */	 
    public RoleRightDTO find(long roleId, String rgtCode) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_right where (role_id = ?) order by rgt_code ASC</tt>
	 *
	 *	@param roleId
	 *	@return List<RoleRightDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RoleRightDTO> findByRole(long roleId) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_right where (rgt_code = ?) order by role_id ASC</tt>
	 *
	 *	@param rgtCode
	 *	@return List<RoleRightDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RoleRightDTO> findByRight(String rgtCode) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_right order by role_id ASC, rgt_code ASC</tt>
	 *
	 *	@return List<RoleRightDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RoleRightDTO> findAll() throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_role_right</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_role_right where ((role_id = ?) AND (rgt_code = ?))</tt>
	 *
	 *	@param roleId
	 *	@param rgtCode
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long roleId, String rgtCode) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_role_right</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_role_right where (role_id = ?)</tt>
	 *
	 *	@param roleId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByRole(long roleId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_role_right</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_role_right where (rgt_code = ?)</tt>
	 *
	 *	@param rgtCode
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByRight(String rgtCode) throws DataAccessException;

}
