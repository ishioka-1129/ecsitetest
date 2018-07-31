package com.ishioka.ecsitetest.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ishioka.ecsitetest.dao.CartInfoDAO;
import com.ishioka.ecsitetest.dao.MCategoryDAO;
import com.ishioka.ecsitetest.dto.CartInfoDTO;
import com.ishioka.ecsitetest.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	private String categoryId;

	private String keywords;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;

	//cartの処理
	public String execute() {

		String result = ERROR;

		String userId = null;

		//管理者として買い物できないようにする
		if(session.containsKey("status")) {
			return LOGIN;
		}

		//インスタンス化
		CartInfoDAO cartInfoDao = new CartInfoDAO();

		//リストを作る
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		//もしloginIdならばuserIdにsession.get("loginId”)を代入する
		if (session.containsKey("loginId")) {
			userId = String.valueOf(session.get("loginId"));

			//それ以外ならばuserIdにsessionでゲットしてきたtempUserIdを代入する
		} else if (session.containsKey("tempUserId")) {
			userId = String.valueOf(session.get("tempUserId"));
		}

		//作ってきたリストにDAOのgetCartInfoDTOListに代入する
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);

		//代入したリストをiteratorを使ってリストを回す
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();

		if (!(iterator.hasNext())) {
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		//totalPriceをsessionに入れる
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;

		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
