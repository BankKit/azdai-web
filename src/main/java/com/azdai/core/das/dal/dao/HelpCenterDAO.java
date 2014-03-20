/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import com.azdai.core.das.dal.dto.HelpCenterDTO;

import org.springframework.dao.DataAccessException;


/**
 * A dao interface provides methods to access database table <tt>azdai_help_center</tt>.
 */
public interface HelpCenterDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "HelpCenterDAO";

	/**
	 *  Insert one <tt>HelpCenterDTO</tt> object to DB table <tt>azdai_help_center</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_help_center(id,catg,show_flag,sort,accept_count,reject_count,title,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param helpCenter
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(HelpCenterDTO helpCenter) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_help_center set catg=?, show_flag=?, sort=?, title=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param helpCenter
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(HelpCenterDTO helpCenter) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_help_center set catg=?, show_flag=?, sort=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param helpCenter
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateMeta(HelpCenterDTO helpCenter) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_help_center set title=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param helpCenter
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateContent(HelpCenterDTO helpCenter) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_help_center set accept_count='AC', gmt_modify='NOW' where (id = 'ID')</tt>
	 *
	 *	@param id
	 *	@param delta
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateAcceptCount(long id, int delta) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_help_center set reject_count='AC', gmt_modify='NOW' where (id = 'ID')</tt>
	 *
	 *	@param id
	 *	@param delta
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateRejectCount(long id, int delta) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_help_center</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_help_center where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return HelpCenterDTO
	 *	@throws DataAccessException
	 */	 
    public HelpCenterDTO find(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_help_center</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_help_center where (show_flag = 'SHOW')</tt>
	 *
	 *	@param showFlag
	 *	@return List<HelpCenterDTO>
	 *	@throws DataAccessException
	 */	 
    public List<HelpCenterDTO> findByShow(String showFlag) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_help_center</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_help_center where (catg = 'CATG')</tt>
	 *
	 *	@param catg
	 *	@return List<HelpCenterDTO>
	 *	@throws DataAccessException
	 */	 
    public List<HelpCenterDTO> findByCatg(long catg) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_help_center</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_help_center order by sort ASC</tt>
	 *
	 *	@return List<HelpCenterDTO>
	 *	@throws DataAccessException
	 */	 
    public List<HelpCenterDTO> findAll() throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_help_center</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_help_center where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException;

}
