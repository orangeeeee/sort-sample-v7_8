package bean;

public class TestDataBean {

	/** 名前 */
	private String name;

	/** 金額 */
	private String kngk;

	/** ユーザ番号 */
	private String userNo;

	/** 支店コード */
	private String shtnCd;

	/** 開始日 */
	private String startDate;


	/**
	 * Default constractor
	 */
	public TestDataBean() {

	}

	/**
	 *
	 * @param kngk
	 * @param name
	 */
	public TestDataBean(String kngk,String name) {

		this.kngk = kngk;
		this.name = name;
	}


	/**
	 *
	 * @param name
	 * @param userNo
	 * @param shtnCd
	 * @param kngk
	 * @param startDate
	 */
	public TestDataBean(String name ,String userNo, String shtnCd, String kngk, String startDate) {

		this.name = name;
		this.userNo = userNo;
		this.shtnCd = shtnCd;
		this.kngk = kngk;
		this.startDate = startDate;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return kngk
	 */
	public String getKngk() {
		return kngk;
	}

	/**
	 * @param kngk セットする kngk
	 */
	public void setKngk(String kngk) {
		this.kngk = kngk;
	}

	/**
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate セットする startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo セットする userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return shtnCd
	 */
	public String getShtnCd() {
		return shtnCd;
	}

	/**
	 * @param shtnCd セットする shtnCd
	 */
	public void setShtnCd(String shtnCd) {
		this.shtnCd = shtnCd;
	}

}
