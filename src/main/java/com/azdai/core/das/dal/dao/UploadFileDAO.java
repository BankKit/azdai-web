/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.azdai.core.das.dal.query.UploadFileQuery;

import com.azdai.core.das.dal.dto.UploadFileDTO;


/**
 * A dao interface provides methods to access database table <tt>azdai_upload_file</tt>.
 */
public interface UploadFileDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "UploadFileDAO";

	/**
	 *  Insert one <tt>UploadFileDTO</tt> object to DB table <tt>azdai_upload_file</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_upload_file(id,user_no,nick_name,catg,file_type,title,length,path,name,ext,src_name,memo,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param uploadFile
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(UploadFileDTO uploadFile) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_upload_file</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_upload_file set catg=?, file_type=?, title=?, path=?, name=?, ext=?, src_name=?, memo=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param uploadFile
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(UploadFileDTO uploadFile) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_upload_file</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_upload_file set name=?, gmt_modify='NOW' where (id = ?)</tt>
	 *
	 *	@param uploadFile
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateName(UploadFileDTO uploadFile) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_upload_file where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return UploadFileDTO
	 *	@throws DataAccessException
	 */	 
    public UploadFileDTO find(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_upload_file where (user_no = ?) order by gmt_create DESC</tt>
	 *
	 *	@param userNo
	 *	@return List<UploadFileDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UploadFileDTO> findByUser(String userNo) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_upload_file where (catg = ?) order by gmt_create DESC</tt>
	 *
	 *	@param catg
	 *	@return List<UploadFileDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UploadFileDTO> findByCatg(String catg) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_upload_file where (file_type = ?) order by gmt_create DESC</tt>
	 *
	 *	@param fileType
	 *	@return List<UploadFileDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UploadFileDTO> findByFileType(String fileType) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_upload_file where (id = 'FUZZY')</tt>
	 *
	 *	@param args
	 *	@return List<UploadFileDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UploadFileDTO> findFuzzy(UploadFileQuery args) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_upload_file</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from azdai_upload_file where (id = 'FUZZY')</tt>
	 *
	 *	@param args
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findFuzzyCount(UploadFileQuery args) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_upload_file</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_upload_file where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_upload_file</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_upload_file where (user_no = ?)</tt>
	 *
	 *	@param userNo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUser(String userNo) throws DataAccessException;

}
