/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.CrawlDAO;

import com.azdai.core.das.dal.dto.CrawlDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.CrawlDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Fri Mar 14 16:33:55 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisCrawlDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements CrawlDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>CrawlDTO</tt> object to DB table <tt>atom_crawl</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_crawl(id,name,content,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param crawl
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(CrawlDTO crawl) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.insert");
	try {
    	if (crawl == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            crawl.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-CRAWL.insert", crawl);

        return crawl.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>atom_crawl</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_crawl set name=?, content=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param crawl
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(CrawlDTO crawl) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.update");
	try {
    	if (crawl == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-CRAWL.update", crawl);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_crawl</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_crawl where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return CrawlDTO
	 *	@throws DataAccessException
	 */	 
    public CrawlDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-CRAWL.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_crawl</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, name, '' content, gmt_create, gmt_modify from atom_crawl</tt>
	 *
	 *	@return List<CrawlDTO>
	 *	@throws DataAccessException
	 */	 
    public List<CrawlDTO> findNames() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.findNames");
	try {

        return this.getSqlSession().selectList("ATOM-CRAWL.findNames", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_crawl</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_crawl</tt>
	 *
	 *	@return List<CrawlDTO>
	 *	@throws DataAccessException
	 */	 
    public List<CrawlDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-CRAWL.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_crawl</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_crawl where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("ATOM-CRAWL.delete", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_crawl</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_config where (id >= 0)</tt>
	 *
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CRAWL.deleteAll");
	try {

        return this.getSqlSession().delete("ATOM-CRAWL.deleteAll", null);
	} finally {
		Profiler.release();
	}
}
}
