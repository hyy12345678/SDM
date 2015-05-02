//当前页的页面，从1开始
var page=1;
//每页展示的条数
var pageSize=10;
//总页数
var sumPageNum=1;
//查询数据的类型，0为银行数据，1为业务数据
var flag=1;
$(document).ready(function(){

    //初始化控件函数
    //tab的点击事件，显示数据表不同的title
    $('#tabs a').click(function(e) {
        e.preventDefault();
        $("#content div.title").hide(); // Hide all content
        $("#tabs li").attr("id", ""); // Reset id's
        $(this).parent().attr("id", "current"); // Activate this
        $('#' + $(this).attr('title')).fadeIn(); // Show content for
        //初始化页面参数
        page=1;
        pageSize=10;
        $("#pageSize").val(10);
        getDataByTabs();
        getSumPageNum();
    });

    //定义翻页控件的样式事件
    $("#page-bar a").mouseover(function(){
        $(this).removeClass("normal");
        $(this).addClass("highlight");
    }).mouseout(function(){
        $(this).removeClass("highlight");
        $(this).addClass("normal");
    });

    //定义翻页控件的点击事件
    //向前翻页
    $("#prePage").click(function () {
        if(page==1)
        {
            alert("这已经是首页");
        }else{
            page=page-1;
            pageSize=$("#pageSize").val();
            getDataByTabs();
        }
    });

    //向后翻页
    $("#nextPage").click(function () {
        if(page==sumPageNum)
        {
            alert("这已经是最后一页！");
        }else{
            page=page+1;
            $("#prePage").removeClass("hidden");
            pageSize=$("#pageSize").val();
            getDataByTabs();
        }
    });
    
    //定义每页显示项变化的请求事件
    $("#pageSize").change(function(){
        page=1;
        pageSize=$("#pageSize").val();
        getSumPageNum();
        getDataByTabs();

    })

    init();
});

//初始化页面，页面控件显示，及获取表格的数据，需要传递，每页展示的数据个数，数据类型
function init()
{
    // Initially hide all content
    $("#content div.title").hide();
    $("tr.tableHead").hide();
    // Activate first tab
    $("#tabs li:first").attr("id", "current");
    // Show first tab content
    $("#content div.title:first").fadeIn();
    $("#thtab1").show();

    $("#currentPage").html(page);
    getSumPageNum();
    getStockTradeData();
}

//根据类型获取数据
function getDataByTabs(){
    var type = $("#current a").attr('title');
    $("#currentPage").html(page);
    switch(type) {
        case "tab1":
            flag=1;
            getStockTradeData();
            break;
        case "tab2":
            flag=0;
            getStockBankData();
            break;

        default :
            break;
    }
}

//获取交易数据，page页码，pageSize每页显示数量
function getStockTradeData () {
    var data = "jstr={\"page\":"+page+",\"pageSize\":"+pageSize+",flag:1}";

    $.ajax( {
        url : "stockData/getTradingData.do",
        type : 'post',
        data : data,
        dataType : 'json',
        success : function(data, status) {
            var liststock = data.resultList;
            encodeStockData(liststock);
        }
    });
}

//解析股票交易数据
function encodeStockData(data)
{
    var index=0;
    var tableStr = "<tr><th>" + "序号"
        + "</th><th>" + "证券代码"
        + "</th><th>" + "证券名称"
        + "</th><th>" + "成交日期"
        + "</th><th>" + "业务名称"
        + "</th><th>" + "成交价格"
        + "</th><th>" + "成交数量"
        + "</th><th>" + "发生金额"
        + "</th><th>" + "资金余额"
        + "</th><th>" + "手续费"
        + "</th><th>" + "印花税"
        + "</th><th>" + "过户费"
        + "</th><th>" + "结算费"
        + "</th></tr>";
    for ( var i = 0; i < data.length; i++) {
        tableStr += "<tr><td>"+ (++index) +"</td><td>"
            + data[i].stockName + "</td><td>"
            + data[i].stockCode + "</td><td>"
            + data[i].tradingTimeStr + "</td><td>"
            + data[i].bussinessName + "</td><td>"
            + data[i].strikePrice + "</td><td>"
            + data[i].strikeNum + "</td><td>"
            + data[i].totalAmount + "</td><td>"
            + data[i].balance + "</td><td>"
            + data[i].fees + "</td><td>"
            + data[i].stampTax + "</td><td>"
            + data[i].transferFee + "</td><td>"
            + data[i].clearingFees + "</td></tr>";
    }
    $("#stockTable").html(tableStr);
}

//获取银行数据，page页码，pageSize每页显示数量
function getStockBankData () {
    var data = "jstr={\"page\":"+page+",\"pageSize\":"+pageSize+",flag:0}";
    $.ajax( {
        url : "stockData/getTradingData.do",
        type : 'post',
        data : data,
        dataType : 'json',
        success : function(data, status) {
            var listBank = data.resultList;
            encodeBankData(listBank);
        }
    });
}

//解析银行数据
function encodeBankData(data)
{
    var index=0;
    var tableStr = "<tr><th>" + "序号"
			+ "</th><th>" + "业务名称"
			+ "</th><th>" + "成交日期"
			+ "</th><th>" + "发生金额"
			+ "</th><th>" + "资金余额"
			+ "</th></tr>";
    for ( var i = 0; i < data.length; i++) {
        tableStr += "<tr><td>"+ (++index)
            + "</td><td>" + data[i].bussinessName
            + "</td><td>" + data[i].tradingTimeStr
            + "</td><td>" + data[i].totalAmount
            + "</td><td>" + data[i].balance + "</td></tr>";
    }
    $("#stockTable").html(tableStr);
}

//获取数据总页数
function getSumPageNum(){
    var data = "jstr={\"pageSize\":"+pageSize+",flag:"+flag+"}";
    $.ajax({
        url:"stockData/getSumPageNum.do",
        type:"post",
        data:data,
        dataType:'json',
        success:function(data){
            sumPageNum=data.sumPageNum;
            $("#sumPageNum").html(sumPageNum);
        }
    });
}

//获取个股数据资料，每页展示一支股票
function getEachStockData(){
    var data = "jstr={flag:"+flag+"}";
    $.ajax({
        url:"stockData/getEachStockData.do",
        type:"post",
        data:data,
        dataType:'json',
        success:function(data){
            alert("test");
        }
    })
}