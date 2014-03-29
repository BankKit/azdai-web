/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_help_center</tt>.
 */
public class HelpCenterDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:id */
	private long id;

	/** column:catg */
	private long catg;

	/** column:show_flag */
	private String showFlag;

	/** column:sort */
	private String sort;

	/** column:accept_count */
	private int acceptCount;

	/** column:reject_count */
	private int rejectCount;

	/** column:clazz */
	private String clazz;

	/** column:title */
	private String title;

	/** column:content */
	private String content;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getCatg() {
		return catg;
	}

	public void setCatg(long catg) {
		this.catg = catg;
	}
	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getAcceptCount() {
		return acceptCount;
	}

	public void setAcceptCount(int acceptCount) {
		this.acceptCount = acceptCount;
	}
	public int getRejectCount() {
		return rejectCount;
	}

	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
