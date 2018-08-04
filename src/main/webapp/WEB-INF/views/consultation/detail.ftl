<!doctype html>
<html>
<head>
<title>index页面</title>
<link rel=stylesheet href="../../../static/css/font/iconfont.css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0">

        
        <script type="text/javascript" src="../../../static/js/common2.js"></script>
        <script type="text/javascript" src="../../../static/js/jquery.min.js"></script>
        <style type="text/css">
            body {
                background-color:#fff;
                position: relative;
            }
            * {
                margin: 0;
                padding: 0;
                list-style: none;
                text-decoration: none;
            }
            .clearfix:after {
                content: " ";
                display: block;
                clear: both;
                height: 0;
            }
            .clearfix {
                zoom: 1;
            }
            .topNav{
              background-color:#1e81d2;
              position:fixed;
              top:0;
              width:100%;
              padding:0.4rem 0 0.2rem 0;
              color:#fff;
              margin: 0 auto;
              text-align: center;
              font-size: 18px;
              z-index:1;
            }
            .topNav a{
                position:absolute;
                left:.3rem;
                font-size: 18px;
                color:#fff;
            }
            .wrapBox{
                width:100%;
                position:absolute;
                top:1.1rem;
            }
            .wrapBox .articleBox{
                padding:0.3rem;
            }
            .wrapBox .articleTitle h2{
                font-size:16px;
                color:#333;
            }
            .wrapBox .articleTime{
                font-size:12px;
                color:#999;
                margin:0.3rem 0;
            }
            .wrapBox img{
                width:100%;
                display: inline-block; 
            }
            .articleContent{
            	font-size:14px;
            }
        </style>
<script>
</script>
</head>
<body>
    <div class="topNav">
        <a href="/api/app/index.htm">＜</a>资讯详情
    </div>
    <div class="wrapBox">
        <div class="articleBox">
            <div class="articleTitle">
                <h2>${(detail.title)!}</2>
            </div>
            <div class="articleTime">
                ${(detail.createTime)?date} 
            </div>
            <div class="articleContent">
                ${(detail.content)!} 
            </div>
        </div>
    </div>
</body>
<html>
</body>
<html>