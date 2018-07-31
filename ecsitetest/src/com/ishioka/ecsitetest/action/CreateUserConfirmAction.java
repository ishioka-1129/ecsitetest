package com.ishioka.ecsitetest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ishioka.ecsitetest.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private String email;
	private String loginId;
	private String password;
	private String UserIdCheckError;

	//ErrorMessageは1つの入力項目に複数あるためListを作成
	private List<String> family_nameErrorMessageList = new ArrayList<String>();
	private List<String> first_nameErrorMessageList = new ArrayList<String>();
	private List<String> family_name_kanaErrorMessageList = new ArrayList<String>();
	private List<String> first_name_kanaErrorMessageList = new ArrayList<String>();
	private List<String> sexList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> user_idErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	public String execute() {

		String result = ERROR;

		//InputCheckerをインスタンス化し入力された値をsessionに入れる
		InputChecker inputChecker = new InputChecker();

		session.put("family_name", familyName);
		session.put("first_name", firstName);
		session.put("family_name_kana", familyNameKana);
		session.put("first_name_kana", firstNameKana);
		session.put("sex", sex);
		session.put("email", email);
		session.put("loginId", loginId);
		session.put("password", password);

		//InputCheckerのdoCheckにそれぞれのErrorMessageListの値を渡す
		family_nameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false,
				false, false);
		first_nameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false,
				false);
		family_name_kanaErrorMessageList = inputChecker.doCheck("せい", familyNameKana, 1, 16, false, false, true,
				false, false, false, false);
		first_name_kanaErrorMessageList = inputChecker.doCheck("めい", firstNameKana, 1, 16, false, false, true,
				false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false,
				false);
		user_idErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false,
				false, false);

		//ErrorMessageが１つもないか確認。なければresultをSUCCESSにする
		if (family_nameErrorMessageList.size() == 0
				&& first_nameErrorMessageList.size() == 0
				&& family_name_kanaErrorMessageList.size() == 0
				&& first_name_kanaErrorMessageList.size() == 0
				&& emailErrorMessageList.size() == 0
				&& user_idErrorMessageList.size() == 0
				&& passwordErrorMessageList.size() == 0) {
			result = SUCCESS;

		//もしエラーがある場合は該当するErrorMessageをsessionに入れresultをERRORにする
		} else {
			session.put("family_nameErrorMessageList", family_nameErrorMessageList);
			session.put("first_nameErrorMessageList", first_nameErrorMessageList);
			session.put("family_name_kanaErrorMessageList", family_name_kanaErrorMessageList);
			session.put("first_name_kanaErrorMessageList", first_name_kanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("user_idErrorMessageList", user_idErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			result = ERROR;

		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
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

	public String getUserIdCheckError() {
		return UserIdCheckError;
	}

	public void setUserIdCheckError(String userIdCheckError) {
		UserIdCheckError = userIdCheckError;
	}

	public List<String> getFamily_nameErrorMessageList() {
		return family_nameErrorMessageList;
	}

	public void setFamily_nameErrorMessageList(List<String> family_nameErrorMessageList) {
		this.family_nameErrorMessageList = family_nameErrorMessageList;
	}

	public List<String> getFirst_nameErrorMessageList() {
		return first_nameErrorMessageList;
	}

	public void setFirst_nameErrorMessageList(List<String> first_nameErrorMessageList) {
		this.first_nameErrorMessageList = first_nameErrorMessageList;
	}

	public List<String> getFamily_name_kanaErrorMessageList() {
		return family_name_kanaErrorMessageList;
	}

	public void setFamily_name_kanaErrorMessageList(List<String> family_name_kanaErrorMessageList) {
		this.family_name_kanaErrorMessageList = family_name_kanaErrorMessageList;
	}

	public List<String> getFirst_name_kanaErrorMessageList() {
		return first_name_kanaErrorMessageList;
	}

	public void setFirst_name_kanaErrorMessageList(List<String> first_name_kanaErrorMessageList) {
		this.first_name_kanaErrorMessageList = first_name_kanaErrorMessageList;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public List<String> getUser_idErrorMessageList() {
		return user_idErrorMessageList;
	}

	public void setUser_idErrorMessageList(List<String> user_idErrorMessageList) {
		this.user_idErrorMessageList = user_idErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public static String getMale() {
		return MALE;
	}

	public static String getFemale() {
		return FEMALE;
	}

}
