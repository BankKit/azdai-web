/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_forum_info</tt>.
 */
public class ForumInfoDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:code */
	private String code;

	/** column:sort */
	private String sort;

	/** column:state */
	private String state;

	/** column:open_ext */
	private String openExt;

	/** column:title */
	private String title;

	/** column:summary */
	private String summary;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getOpenExt() {
		return openExt;
	}

	public void setOpenExt(String openExt) {
		this.openExt = openExt;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
