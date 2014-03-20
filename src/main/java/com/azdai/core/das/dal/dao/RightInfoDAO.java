/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import com.azdai.core.das.dal.dto.RightInfoDTO;

import java.util.List;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_right_info</tt>.
 */
public interface RightInfoDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "RightInfoDAO";

	/**
	 *  Insert one <tt>RightInfoDTO</tt> object to DB table <tt>azdai_right_info</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_right_info(code,title,memo,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param rightInfo
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(RightInfoDTO rightInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_right_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_right_info set title=?, memo=?, gmt_modify='NOW' where (code = ?)</tt>
	 *
	 *	@param rightInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(RightInfoDTO rightInfo) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_right_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_right_info where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return RightInfoDTO
	 *	@throws DataAccessException
	 */	 
    public RightInfoDTO find(String code) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_right_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_right_info order by code ASC</tt>
	 *
	 *	@return List<RightInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RightInfoDTO> findAll() throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_right_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_right_info order by code ASC</tt>
	 *
	 *	@param userNo
	 *	@return List<RightInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RightInfoDTO> findUserRights(String userNo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_right_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_right_info where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String code) throws DataAccessException;

}
