package com.ishioka.ecsitetest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ishioka.ecsitetest.dao.UserInfoDAO;
import com.ishioka.ecsitetest.dto.UserInfoDTO;
import com.ishioka.ecsitetest.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {
	private String loginId;
	private String password;
	private String newPassword;
	private String reConfirmationPassword;
	private String passwordCheck;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> passwordCheckList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		if (loginId == null) {
			return result;
		}

		InputChecker inputChecker = new InputChecker();

		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false,
				false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true,
				false, false, false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード(確認用）", reConfirmationPassword, 1, 16,
				true, false, false, true, false, false, false);
		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);

		passwordCheckList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);


		if (loginIdErrorMessageList.size() == 0
				&& passwordErrorMessageList.size() == 0
				&& newPasswordErrorMessageList.size() == 0
				&& reConfirmationNewPasswordErrorMessageList.size() == 0
				&& newPasswordIncorrectErrorMessageList.size() == 0
				&& passwordCheckList.size() == 0) {

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			UserInfoDTO userInfoDTO = new UserInfoDTO();

			if(!(password.equals(userInfoDTO.getPassword())) && !(loginId.equals("")) && !(password.equals(""))){
				passwordCheck = "入力されたパスワードが異なります。(現在のパスワード)";
				result = ERROR;
			}

			if (userInfoDAO.isExistsUserInfo(loginId, password)) {
				String concealPassword = userInfoDAO.concealPassword(newPassword);
				session.put("loginId", loginId);
				session.put("newPassword", newPassword);
				session.put("concealPassword", concealPassword);
				result = SUCCESS;
			}
		} else {
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("newPasswordErrorMessageList", newPasswordErrorMessageList);
			session.put("reConfirmationNewPasswordErrorMessageList", reConfirmationNewPasswordErrorMessageList);
			session.put("newPasswordIncorrectErrorMessageList", newPasswordIncorrectErrorMessageList);
			session.put("passwordCheckList", passwordCheckList);
		}
		session.put("checked", 1);
		return result;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReConfirmationPassword() {
		return reConfirmationPassword;
	}

	public void setReConfirmationPassword(String reConfirmationPassword) {
		this.reConfirmationPassword = reConfirmationPassword;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList() {
		return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String> passwordIncorrectErrorMessageList) {
		this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}

	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList) {
		this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList() {
		return newPasswordIncorrectErrorMessageList;
	}

	public void setNewPasswordIncorrectErrorMessageList(List<String> newPasswordIncorrectErrorMessageList) {
		this.newPasswordIncorrectErrorMessageList = newPasswordIncorrectErrorMessageList;
	}

	public List<String> getPasswordCheckList() {
		return passwordCheckList;
	}

	public void setPasswordCheckList(List<String> passwordCheckList) {
		this.passwordCheckList = passwordCheckList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
