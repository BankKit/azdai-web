/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.azdai.core.das.dal.dto.UserInfoDTO;


/**
 * A dao interface provides methods to access database table <tt>azdai_user_info</tt>.
 */
public interface UserInfoDAO extends BaseDAO {
    /** The name of the DAO */
    public static final String NAME = "UserInfoDAO";

	/**
	 *  Insert one <tt>UserInfoDTO</tt> object to DB table <tt>azdai_user_info</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into azdai_user_info(no,nick_name,state,sex,login_state,email_state,mobile_state,passwd,passwd_err_count,regist_date,active_date,auth_date,mobile,email,real_name,avatar,birth_date,post_code,province_code,city_code,county_code,street_info,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param userInfo
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insert(UserInfoDTO userInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_user_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_user_info set state=?, sex=?, login_state=?, email_state=?, mobile_state=?, passwd=?, passwd_err_count=?, regist_date=?, active_date=?, auth_date=?, mobile=?, email=?, real_name=?, avatar=?, birth_date=?, post_code=?, province_code=?, city_code=?, county_code=?, street_info=?, gmt_modify='NOW' where (no = ?)</tt>
	 *
	 *	@param userInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(UserInfoDTO userInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_user_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_user_info set passwd='PWD', gmt_modify='NOW' where (no = 'NO')</tt>
	 *
	 *	@param no
	 *	@param passwd
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updatePassword(String no, String passwd) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_user_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_user_info set passwd_err_count='PEC', gmt_modify='NOW' where (no = 'NO')</tt>
	 *
	 *	@param no
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int increasePasswdErrCount(String no) throws DataAccessException;

	/**
	 *  Update DB table <tt>azdai_user_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update azdai_user_info set passwd_err_count='PEC', gmt_modify='NOW' where (no = 'NO')</tt>
	 *
	 *	@param no
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int clearPasswdErrCount(String no) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_info where (no = ?)</tt>
	 *
	 *	@param no
	 *	@return UserInfoDTO
	 *	@throws DataAccessException
	 */	 
    public UserInfoDTO findByNo(String no) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_info where ((nick_name = 'LN') OR (email = 'EM') OR (mobile = 'MB'))</tt>
	 *
	 *	@param name
	 *	@return UserInfoDTO
	 *	@throws DataAccessException
	 */	 
    public UserInfoDTO findByLoginName(String name) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_info where (email = ?)</tt>
	 *
	 *	@param email
	 *	@return UserInfoDTO
	 *	@throws DataAccessException
	 */	 
    public UserInfoDTO findByEmail(String email) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_info where (nick_name = ?)</tt>
	 *
	 *	@param nickName
	 *	@return UserInfoDTO
	 *	@throws DataAccessException
	 */	 
    public UserInfoDTO findByNickName(String nickName) throws DataAccessException;

	/**
	 *  Query DB table <tt>azdai_user_info</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from azdai_user_info order by no ASC</tt>
	 *
	 *	@return List<UserInfoDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserInfoDTO> findAll() throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>azdai_user_info</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from azdai_user_info where (no = ?)</tt>
	 *
	 *	@param no
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String no) throws DataAccessException;

}
