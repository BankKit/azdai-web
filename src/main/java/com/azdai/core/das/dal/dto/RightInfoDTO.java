/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_right_info</tt>.
 */
public class RightInfoDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:code */
	private String code;

	/** column:title */
	private String title;

	/** column:memo */
	private String memo;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
