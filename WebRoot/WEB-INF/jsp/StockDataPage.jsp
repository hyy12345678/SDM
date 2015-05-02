
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<title>股票交易数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

    <link href="css/stockPage.css" type="text/css" rel="stylesheet"/>
    <link href="css/stockTable.css" type="text/css" rel="stylesheet"/>
    <link href="https://ss0.bdstatic.com/5a21bjqh_Q23odCf/static/message/css/message_33dce38c.css"  type="text/css" rel="stylesheet"/>

    <script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="js/stockDataPage.js"></script>
  </head>
  
 <body>
 <script type="text/javascript">
	sumPageNum=<%=request.getAttribute("sumPageNum")%>;
 </script>

<h3>股票交易数据</h3>

<div id="main">

    <div id="acount">
        <label id="acountCode">股票帐号：<%=request.getAttribute("Account")%></label>
    </div>

    <div id="mainContent">
        <ul id="tabs">
            <li><a href="#" title="tab1">股票交易数据</a></li>
            <li><a href="#" title="tab2">银证转帐数据</a></li>
            <li><a href="#" title="tab3">个股数据统计</a></li>
            <li><a href="#" title="tab4">指标统计</a></li>
        </ul>

        <div id="content">

            <div id="filter">
                过滤条件
            </div>
            <p>-</p>

            <div id="tab1" class="title">
                <h3>股票交易数据</h3>
            </div>

            <div id="tab2" class="title">
                <h3>银证转帐数据</h3>
            </div>

            <div id="tab3" class="title">
                <h3>个股数据统计</h3>
            </div>

            <div id="tab4" class="title">
                <h3>指标统计</h3>
            </div>
			<div style="overflow:auto;height:220">
				<table id="stockTable"></table>
			</div>

            <div id="page-bar">
                <a id="prePage"  class="normal">
                	<span>上一页</span>
                </a>
                <a id="nextPage"   class="normal">
                	<span>下一页</span>
                </a>
                <span>
               		 每页
                <select id="pageSize">
                	<option>10</option>
                	<option>20</option>
                	<option>30</option>
                </select>
                	项
                </span>
                <span>
                	第<label id="currentPage"></label>页/共<label id="sumPageNum"></label>页
                </span>
                	
            </div>
        </div>

    </div>
</div>
<br>
<br>
</body>
</html>
