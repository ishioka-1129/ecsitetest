package com.ishioka.ecsitetest.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ishioka.ecsitetest.dao.MCategoryDAO;
import com.ishioka.ecsitetest.dao.ProductInfoDAO;
import com.ishioka.ecsitetest.dto.MCategoryDTO;
import com.ishioka.ecsitetest.dto.PaginationDTO;
import com.ishioka.ecsitetest.dto.ProductInfoDTO;
import com.ishioka.ecsitetest.util.InputChecker;
import com.ishioka.ecsitetest.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {
	private String keywords;
	private int categoryId;
	private int pageNo = 1;
	private Map<String, Object> session;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsCheckList = new ArrayList<String>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	ProductInfoDAO productInfoDAO = new ProductInfoDAO();

	public String execute() throws SQLException {
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		//管理者として買い物できないようにする
				if(session.containsKey("status")) {
					return LOGIN;
				}

		//keywordsがnullの時、空文字を代入
		if (keywords == null) {
			keywords = "";
		}



		//カタカナだけNG
		keywordsCheckList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true,
				true, true, true, true, false, true);

		if(keywordsCheckList.isEmpty()) {
			//categoryIdが0or1の時、すべてのカテゴリーからキーワード検索
			if (categoryId == 1 || categoryId == 0) {
				result = SUCCESS;
				productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
			} else if(categoryId == 2 || categoryId == 3 || categoryId == 4) {//categoryIdとキーワードから検索
				result = SUCCESS;
				productInfoDTOList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "),
						categoryId);
			} else {
				return result;
			}
		}


		//記号とカタカナNG
		keywordsErrorMessageList = inputChecker.doCheckSearch("検索ワード", keywords, 0, 16, true,
				true, true, true, false, false, false);

		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

		//検索結果にデータが入っているか確認。なければnullを代入
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if (!(iterator.hasNext())) {
			productInfoDTOList = null;
		}

		//mCategoryDtoListをセッションに挿入
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if (!(productInfoDTOList == null)) {//検索結果がnullでなければ
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			int totalPageSize = pagination.getTotalPageSize(productInfoDTOList, 9);
			if (pageNo == 1) {//現在のページが１ページ目の時のページデータ
				paginationDTO = pagination.initialize(productInfoDTOList, 9);
			} else if (pageNo > 1 && pageNo <= totalPageSize) {//現在のページが2ページ目以降の時のページデータ
				paginationDTO = pagination.getPage(productInfoDTOList, 9, pageNo);
			} else {
				return ERROR;
			}//ページデータをセッションに挿入
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalPageSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordSize", paginationDTO.getEndRecordNo());
			session.put("pageNumberList", paginationDTO.getPageNumberList());
			session.put("productInfoDTOList", paginationDTO.getCurrentProductInfoPage());
			session.put("hasNextPage", paginationDTO.hasNextPage());
			session.put("hasPreviousPage", paginationDTO.hasPreviousPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
		} else {//検索結果がnullならセッションにnullを挿入
			session.put("productInfoDTOList", null);
		}

		return result;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public List<String> getKeywordsCheckList() {
		return keywordsCheckList;
	}

	public void setKeywordsCheckList(List<String> keywordsCheckList) {
		this.keywordsCheckList = keywordsCheckList;
	}

	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public ProductInfoDAO getProductInfoDAO() {
		return productInfoDAO;
	}

	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}

}
