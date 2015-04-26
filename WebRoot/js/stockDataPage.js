$(document).ready(function() {
	// alert("i am ready");

		init();

		$('#tabs a').click(function(e) {
			e.preventDefault();
			$("#content div.title").hide(); // Hide all content
				$("#tabs li").attr("id", ""); // Reset id's
				$(this).parent().attr("id", "current"); // Activate this
				$('#' + $(this).attr('title')).fadeIn(); // Show content for
															// current tab
				if ("tab1" == $(this).attr('title')) {
					getStockTradeData(0,10);
				} else if ("tab2" == $(this).attr('title')) {
					getStockBankData();
				}
			});
	});

function testjs(testdata) {
	alert(testdata);
}


function init() {

	$("#acountCode").html("股票代号：上证资金账号、深证资金账号");

	$("#content div.title").hide(); // Initially hide all content
	$("tr.tableHead").hide();
	$("#tabs li:first").attr("id", "current"); // Activate first tab
	$("#content div.title:first").fadeIn(); // Show first tab content
	$("#thtab1").show();

	getStockTradeData(0,10);
}

function initStockTradeData(){
	
}

//page页码，pageSize每页显示数量
function getStockTradeData( page, pageSize) {
	
	var data = "jstr={\"page\":"+page+",\"pageSize\":"+pageSize+"}";

	$.ajax( {
		url : "stockData/getStockData.do",
		type : 'post',
		data : data,
		dataType : 'json',
		success : function(data, status) {
			var liststock = data.liststock;
			encodeStockData(liststock);
		}
	});
}

function encodeStockData(data)
{
	var tableStr = "<tr><th>" + "证券名称" 
				+ "</th><th>" + "证券代码"
				+ "</th><th>" + "成交日期" 
				+ "</th><th>" + "成交价格" 
				+ "</th><th>" + "成交数量" 
				+ "</th><th>" + "发生金额" 
				+ "</th><th>" + "资金余额"
				+ "</th><th>" + "业务名称" 
				+ "</th><th>" + "手续费" 
				+ "</th><th>" + "印花税" 
				+ "</th><th>" + "过户费" 
				+ "</th><th>" + "结算费"
				+ "</th></tr>";
	for ( var i = 0; i < data.length; i++) {
		tableStr += "<tr><td>" + data[i].stockName + "</td><td>"
		+ data[i].stockCode + "</td><td>"
		+ data[i].tradingData + "</td><td>"
		+ data[i].strikePrice + "</td><td>"
		+ data[i].strikeNum + "</td><td>"
		+ data[i].totalAmount + "</td><td>"
		+ data[i].balance + "</td><td>"
		+ data[i].bussinessName + "</td><td>"
		+ data[i].fees + "</td><td>"
		+ data[i].stampTax + "</td><td>"
		+ data[i].transferFee + "</td><td>"
		+ data[i].closingCost + "</td></tr>";
	}
	$("#stockTable").html(tableStr);
	
}

function getStockBankData() {
	$.ajax( {
		url : "stockData/getBankData.do",
		type : 'post',
		data : '',
		dataType : 'json',
		success : function(data, status) {
			var listBank = data.listBank;
			encodeBankData(listBank);
		}
	});
}

function encodeBankData(data)
{
	var tableStr = "<tr><th>" + "业务名称" 
				+ "</th><th>" + "成交日期"
				+ "</th><th>" + "发生金额" 
				+ "</th><th>" + "资金余额"
				+ "</th></tr>";
for ( var i = 0; i < data.length; i++) {
tableStr += "<tr><td>" + data[i].bussinessName
		+ "</td><td>" + data[i].tradingData 
		+ "</td><td>" + data[i].totalAmount 
		+ "</td><td>" + data[i].balance + "</td></tr>";
}
$("#stockTable").html(tableStr);
}
