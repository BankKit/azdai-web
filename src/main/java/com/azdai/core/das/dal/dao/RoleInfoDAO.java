/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.azdai.core.das.dal.dto.RoleInfoDTO;


/**
 * A dao interface provides methods to access database table <tt>azdai_role_info</tt>.
 */
public interface RoleInfoDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "RoleInfoDAO";

	/**
	 *  Insert one <tt>RoleInfoDTO</tt> object to DB table <tt>azdai_role_info</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_role_info(id,title,memo,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param roleInfo
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(RoleInfoDTO roleInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_role_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_role_info set title=?, memo=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param roleInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(RoleInfoDTO roleInfo) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_info where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return RoleInfoDTO
	 *	@throws DataAccessException
	 */	 
    public RoleInfoDTO find(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_role_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_role_info order by id ASC</tt>
	 *
	 *	@return List<RoleInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RoleInfoDTO> findAll() throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_role_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_role_info where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException;

}
