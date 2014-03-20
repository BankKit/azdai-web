/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_role_right</tt>.
 */
public class RoleRightDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:role_id */
	private long roleId;

	/** column:rgt_code */
	private String rgtCode;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRgtCode() {
		return rgtCode;
	}

	public void setRgtCode(String rgtCode) {
		this.rgtCode = rgtCode;
	}

}
