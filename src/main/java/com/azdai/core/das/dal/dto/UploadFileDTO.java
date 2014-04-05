/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_upload_file</tt>.
 */
public class UploadFileDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:id */
	private long id;

	/** column:user_no */
	private String userNo;

	/** column:nick_name */
	private String nickName;

	/** column:catg */
	private String catg;

	/** column:file_type */
	private String fileType;

	/** column:title */
	private String title;

	/** column:length */
	private long length;

	/** column:path */
	private String path;

	/** column:name */
	private String name;

	/** column:ext */
	private String ext;

	/** column:src_name */
	private String srcName;

	/** column:memo */
	private String memo;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
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
	public String getCatg() {
		return catg;
	}

	public void setCatg(String catg) {
		this.catg = catg;
	}
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
