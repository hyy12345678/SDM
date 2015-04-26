
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

    <script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="js/stockDataPage.js"></script>
  </head>
  
  <body>
<br/>

<h2>股票交易数据</h2>

<div id="main">

    <div id="acount">
        <label id="acountCode"></label>
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

            <table id="stockTable">

                <tr id="thtab1" class="tableHead">
                    <th>stock1</th>
                    <th>stock1</th>
                    <th>stock1</th>
                </tr>
                <tr id="thtab2" class="tableHead">
                    <th>bank1</th>
                    <th>bank1</th>
                    <th>bank1</th>
                </tr>
                <tr>
                    <td>数据1</td>
                    <td>数据2</td>
                    <td>数据3</td>
                </tr>
            </table>

            <span id="page-bar">
                <a href="" onclick="testjs()">上一页</a>
                <a href="">下一页</a>
            </span>
        </div>

    </div>
</div>
<br>
<br>
</body>
</html>
