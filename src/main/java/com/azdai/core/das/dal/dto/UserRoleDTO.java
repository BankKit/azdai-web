/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_user_role</tt>.
 */
public class UserRoleDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:user_no */
	private String userNo;

	/** column:nick_name */
	private String nickName;

	/** column:role_id */
	private long roleId;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
