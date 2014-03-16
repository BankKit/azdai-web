/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.dto;




import com.github.obullxl.lang.biz.BaseDTO;

/**
 * A data object class directly models database table <tt>azdai_user_info</tt>.
 */
public class UserInfoDTO extends BaseDTO {
    private static final long serialVersionUID = 741231858441822688L;



	/** column:no */
	private String no;

	/** column:nick_name */
	private String nickName;

	/** column:state */
	private String state;

	/** column:sex */
	private String sex;

	/** column:login_state */
	private String loginState;

	/** column:email_state */
	private String emailState;

	/** column:mobile_state */
	private String mobileState;

	/** column:passwd */
	private String passwd;

	/** column:passwd_err_count */
	private int passwdErrCount;

	/** column:regist_date */
	private String registDate;

	/** column:active_date */
	private String activeDate;

	/** column:auth_date */
	private String authDate;

	/** column:mobile */
	private String mobile;

	/** column:email */
	private String email;

	/** column:real_name */
	private String realName;

	/** column:birth_date */
	private String birthDate;

	/** column:post_code */
	private String postCode;

	/** column:province_code */
	private String provinceCode;

	/** column:city_code */
	private String cityCode;

	/** column:county_code */
	private String countyCode;

	/** column:street_info */
	private String streetInfo;




    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}
	public String getEmailState() {
		return emailState;
	}

	public void setEmailState(String emailState) {
		this.emailState = emailState;
	}
	public String getMobileState() {
		return mobileState;
	}

	public void setMobileState(String mobileState) {
		this.mobileState = mobileState;
	}
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getPasswdErrCount() {
		return passwdErrCount;
	}

	public void setPasswdErrCount(int passwdErrCount) {
		this.passwdErrCount = passwdErrCount;
	}
	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	public String getAuthDate() {
		return authDate;
	}

	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getStreetInfo() {
		return streetInfo;
	}

	public void setStreetInfo(String streetInfo) {
		this.streetInfo = streetInfo;
	}

}
