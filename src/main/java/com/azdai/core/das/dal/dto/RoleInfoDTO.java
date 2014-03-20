/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_role_info</tt>.
 */
public class RoleInfoDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:id */
	private long id;

	/** column:title */
	private String title;

	/** column:memo */
	private String memo;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
