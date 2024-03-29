/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.mybatis;

import com.azdai.core.das.dal.dao.RightInfoDAO;

import com.azdai.core.das.dal.dto.RightInfoDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.azdai.core.das.dal.dao.RightInfoDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt>.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisRightInfoDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements RightInfoDAO {


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
    public String insert(RightInfoDTO rightInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.insert");
	try {
    	if (rightInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	

        this.getSqlSession().insert("AZDAI-RIGHT-INFO.insert", rightInfo);

        return rightInfo.getCode();
	} finally {
		Profiler.release();
	}
}

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
    public int update(RightInfoDTO rightInfo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.update");
	try {
    	if (rightInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("AZDAI-RIGHT-INFO.update", rightInfo);
	} finally {
		Profiler.release();
	}
}
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
    public RightInfoDTO find(String code) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.find");
	try {

        return this.getSqlSession().selectOne("AZDAI-RIGHT-INFO.find", code);

	} finally {
		Profiler.release();
	}
}
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
    public List<RightInfoDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.findAll");
	try {

        return this.getSqlSession().selectList("AZDAI-RIGHT-INFO.findAll", null);

	} finally {
		Profiler.release();
	}
}
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
    public List<RightInfoDTO> findUserRights(String userNo) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.findUserRights");
	try {

        return this.getSqlSession().selectList("AZDAI-RIGHT-INFO.findUserRights", userNo);

	} finally {
		Profiler.release();
	}
}
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
    public int delete(String code) throws DataAccessException{
	Profiler.enter("DAO: AZDAI-RIGHT-INFO.delete");
	try {

        return this.getSqlSession().delete("AZDAI-RIGHT-INFO.delete", code);
	} finally {
		Profiler.release();
	}
}
}
