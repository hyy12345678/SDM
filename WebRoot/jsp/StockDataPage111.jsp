<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>股票交易数据</title>
    <link href="../css/stockPage.css" type="text/css" rel="stylesheet"/>
    <link href="../css/stockTable.css" type="text/css" rel="stylesheet"/>

    <script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="../js/stockDataPage.js"></script>
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
                <a href="">上一页</a>
                <a href="">下一页</a>
            </span>
        </div>

    </div>
</div>
<br/>
<br/>

</body>
</html>
