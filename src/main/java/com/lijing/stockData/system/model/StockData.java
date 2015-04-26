package com.lijing.stockData.system.model;

import java.util.Date;

//@Entity
public class StockData {
	//表ID
	private int stockId;
	//交易币种
	private String currency;
	//证券名称
	private String stockName;
	//成交日期
	private Date tradingTime;
	//系统数据中的日期尾数
	private String tradingDcode;
	//成交价格
	private float strikePrice;
	//成交数量
	private  float strikeNum;
	//发生金额
	private float totalAmount;
	//资金余额
	private float balance;
	//合同编号
	private String contract;
	//业务名称
	private String bussinessName;
	//手续费
	private float fees;
	//印花税
	private float stampTax; 
	//过户费
	private float transferFee;
	//结算费
	private float clearingFees;
	//证券代码
	private String stockCode;
	//股东代码
	private String shareholderCode;
	//银证标示，银行0，证券1
	private int flag;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Date getTradingTime() {
		return tradingTime;
	}
	public void setTradingTime(Date tradingTime) {
		this.tradingTime = tradingTime;
	}
	
	public String getTradingDcode() {
		return tradingDcode;
	}
	public void setTradingDcode(String tradingDcode) {
		this.tradingDcode = tradingDcode;
	}
	public float getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}
	public float getStrikeNum() {
		return strikeNum;
	}
	public void setStrikeNum(float strikeNum) {
		this.strikeNum = strikeNum;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getBussinessName() {
		return bussinessName;
	}
	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}
	
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	
	public float getStampTax() {
		return stampTax;
	}
	public void setStampTax(float stampTax) {
		this.stampTax = stampTax;
	}
	public float getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(float transferFee) {
		this.transferFee = transferFee;
	}
	public float getClearingFees() {
		return clearingFees;
	}
	public void setClearingFees(float clearingFees) {
		this.clearingFees = clearingFees;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getShareholderCode() {
		return shareholderCode;
	}
	public void setShareholderCode(String shareholderCode) {
		this.shareholderCode = shareholderCode;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag() {
		return flag;
	}
	
}
