package com.ishioka.ecsitetest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private String email;
	private String loginId;
	private String password;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		//前回の値が表示されないようsessionに格納されている値を削除
		session.remove("family_nameErrorMessageList");
		session.remove("first_nameErrorMessageList");
		session.remove("family_name_kanaErrorMessageList");
		session.remove("first_name_kanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("user_idErrorMessageList");
		session.remove("passwordErrorMessageList");

		//sessionに値を入れる
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);

		//性別に値が何もないことを確認。なければMALEをsessionに入れ、あればsessionから文字列として取得し性別に値を入れる
		if (sex == null) {
			session.put("sex", MALE);
		} else {
			session.put("sex", String.valueOf(session.get("sex")));
		}

		//性別リストに値を入れ、それぞれsessionに値を入れる。resultにSUCCESSを入れresultを返す
		sexList.add(MALE);
		sexList.add(FEMALE);
		session.put("sexList", sexList);
		session.put("email", email);
		session.put("loginId", loginId);
		session.put("password", password);
		result = SUCCESS;
		return result;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public static String getMale() {
		return MALE;
	}

	public static String getFemale() {
		return FEMALE;
	}

}
