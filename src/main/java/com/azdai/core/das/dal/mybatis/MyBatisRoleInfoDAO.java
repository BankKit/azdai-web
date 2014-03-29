/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.RoleInfoDAO;

import java.util.List;
import com.azdai.core.das.dal.dto.RoleInfoDTO;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.RoleInfoDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Fri Mar 28 12:36:19 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisRoleInfoDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements RoleInfoDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


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
    public long insert(RoleInfoDTO roleInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-ROLE-INFO.insert");
	try {
    	if (roleInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            roleInfo.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("AZDAI-ROLE-INFO.insert", roleInfo);

        return roleInfo.getId();
	} finally {
		Profiler.release();
	}
}

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
    public int update(RoleInfoDTO roleInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-ROLE-INFO.update");
	try {
    	if (roleInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-ROLE-INFO.update", roleInfo);
	} finally {
		Profiler.release();
	}
}
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
    public RoleInfoDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-ROLE-INFO.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("AZDAI-ROLE-INFO.find", param);

	} finally {
		Profiler.release();
	}
}
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
    public List<RoleInfoDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: AZDAI-ROLE-INFO.findAll");
	try {

        return this.getSqlSession().selectList("AZDAI-ROLE-INFO.findAll", null);

	} finally {
		Profiler.release();
	}
}
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
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-ROLE-INFO.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("AZDAI-ROLE-INFO.delete", param);
	} finally {
		Profiler.release();
	}
}
}
