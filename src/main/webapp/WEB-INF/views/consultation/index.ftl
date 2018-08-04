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
                background-color:#eee;
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
            .wrapBox{
                width:100%;
                position:absolute;
            }
            .wrapContext{
                width:100%;
                position:absolute;
            }
            .bannerBox{
                position:relative;
                overflow:hidden;
            }
            .bannerPic{
                width:500%;
                height:2.9rem;
                font-size:0
            }
            .bannerPic li{
               // width:100%;
                display:inline-block;
            }
            .bannerPic img{
                width:7.5rem;
                height:2.9rem;
                float:left;
            }
            .bannerDot{
                width:100%;
                margin:0 auto;
                text-align:center;
                position:absolute;
                bottom:-1rem;
            }
            .bannerDot  i{
                width:0.16rem;
                height:0.16rem;
                border-radius:0.1rem;
                margin-right:-0.15rem;
                display:inline-block; 
                background:#91c3fd;
                opacity:0.7;
                vertical-align:1rem;
            }
            .bannerDotNostyle{
                background:#91c3fd!important;
                opacity:0.7!important;
            }
            .bannerDotstyle{
                background:#fd91a0!important;
                opacity:1!important;
            }
            .bannerDot  i:nth-of-type(1){
                opacity:1;
                background:#fd91a0;
            }
            .noticeBox{
                background:#fff;
                border-bottom:1px solid #eee
            }
            .noticeBox ul{
                overflow:hidden;
                height:0.7rem;
            }
            .noticeBox ul li{
                padding:0 0.36rem;
                height:0.7rem;
                line-height:0.7rem;
            }
            .noticeBox .icon-gonggao{
            	vertical-align:-1px;
            }
            .noticeBox span{
                font-size:12px;
                color:#666;
                float:left;
                width:5.5rem;
            }
            .noticeBox p{
                font-size:12px;
                color:#999;
                float:right;
                line-height: 0.7rem;
            }
            .advantageBox{
                padding:0.25rem 0.36rem;
                font-size:14px;
                background-color:#fff
            }
            .advantageBox ul li{
                float:left;
                margin-right:0.22rem;
            }
            .advantageBox ul li:nth-of-type(3){
                margin-right:0;
            }
            .advantageBox ul li a{
                display:inline-block;
            }
            .advantageBox ul li img{
                width:2.1rem;
                height:1.2rem;
                display:inline-block;
            }
           
            .borrowBox{
                margin:0.2rem 0;
                padding:0.35rem 0.36rem 0.45rem;
                background:#FFF;
                background:url("../../../static/images/bg@3x.png") no-repeat;
                background-size:100% 100%;
            }
            .borrowBox .borrowTitle{
                margin-bottom:0.75rem;
            }
            .borrowBox .borrowTitle h2{
                font-size:18px;
                color:#333;
            }
            .borrowBox .borrowTitle h2 span{
                font-size:12px;
                color:#FA6900;
                width:1.6rem;
                height:0.4rem;
                line-height:0.4rem;
                text-align:center;
                background:url("../../../static/images/passApr@3x.png") no-repeat;
                background-size:100% 100%;
                display:inline-block;
                margin-left:0.2rem;
            }
            .borrowBox .borrowContext div{
                float:left
            }
            .borrowBox .borrowContext a{
                font-size:16px;
                color:#fff;
                display:block;
                width:2.5rem;
                height:0.68rem;
                line-height:0.68rem;
                text-align:center;
                background:#208FE9;
                border-radius:0.5rem;
                float:right;
                margin-top:0.8rem;
            }
            .borrowBox .borrowContext h3{
                font-size:16px;
                color:#666;
                margin-bottom:0.2rem;
                font-weight: normal;
            }
            .borrowBox .borrowContext p{
                font-size:32px;
                color:#208FE9;
                font-weight:normol;
            }
            .newCenter{
                padding:0.35rem 0.36rem 0rem 0.36rem;
                background:#FFF;
            }
            .newCenter .newTitle h2{
                font-size:18px;
                color:#333;
                float:left;
            }
            .newCenter .newTitle a{
                font-size:12px;
                color:#999;
                float:right;
                line-height:24px;
            }
            .newCenter .newContext li{
                padding:0.3rem 0;
                border-bottom:1px solid #eee
            }
            .newCenter .newContext li span{
                font-size:16px;
                color:#333;
                width:5rem;
                display:block;
                float:left;
            }
            .newCenter .newContext li img{
                width:1.2rem;
                height:1.2rem;
                float:right;
            }
            .newCenter .newContext li h2{
                font-size:16px;
                color:#333;
                height:0.8rem;
                line-height:0.4rem;
                width:5rem;
                word-wrap: break-word;
                padding-bottom:0.1rem;
                font-weight: normal;
            }
            .newCenter .newContext li p{
                font-size:14px;
                color:#999;
            }
            .columnBox{
                padding:0.22rem 0.36rem;
                background:#FFF;
                margin:0.2rem 0 0 0;
            }
            .columnBox ul li.aboutUs{
                float:left;
                width:2.5rem;
                background:url("../../../static/images/aboutUs@3x.png") no-repeat 0.2rem 0.2rem;
                background-size:0.6rem 0.6rem;
                padding-left:0.9rem;
                border-right:1px solid #eee;
            }
            .columnBox ul li.inviteFriend{
                float:left;
                background:url("../../../static/images/inviteFriend@3x.png") no-repeat 0.2rem 0.2rem;
                background-size:0.6rem 0.6rem;
                padding-left:0.9rem;
                margin-left:0.2rem;
            }
            .columnBox ul li h2{
                font-size:16px;
                margin-bottom:0.15rem;
                color:#333;
            }
            .columnBox ul li p{
                font-size:12px;
                color:#999;
            }
        </style>
<script>
</script>
</head>
<body>
     <div class="wrapBox">
        <div class="wrapContext">
       	 <#if (infoIndexBanner)??>
            <div class="bannerBox">
                <ul  class="bannerPic">
                    <#list infoIndexBanner as sh>
                        <li class="${(sh_index)!}"  >
                        	<a href="/api/app/detail.htm?id=${(sh.id)!}" class="${(sh.id)!}">
                        		<img src="${(sh.thumbnail)!}"></img>
                        	</a>
                        </li>
                    </#list>
                </ul>
                <div class="bannerDot">
                    <span>
                        <#list infoIndexBanner as sh>
                            <i></i>
                        </#list>
                    </span>
                </div>
            </div>
           </#if>
            <div class="noticeBox">
                <ul class="noticeContent">
			                <#list list as map>
								<#list map?keys as itemKey>
								     <#if itemKey="value">
								     <li class="clearfix">
					                      <span><i class="iconfont icon-gonggao"></i>${map[itemKey]}.</span>
					                      <p>5分钟前</p>
                                     </li>
								     </#if>
								</#list>
							</#list>     
                </ul>
            </div>
            <#if (advertisement)??>
	            <div class="advantageBox clearfix">
	                <ul>
	                    <#list advertisement as ad>
	                        <li>
	                          <a href="/api/app/detail.htm?id=${(ad.id)!}">
	                        	<img src="${(ad.thumbnail)!}"></img>
	                          </a>
	                        </li>
	                    </#list>
	                </ul>
	            </div>
	        </#if>
            <div class="borrowBox">
                <div class="borrowTitle">
                    <h2>${(cashloan.name)!}<span>超高通过率</span></h2>
                </div>
                <div class="borrowContext clearfix">
                    <div>
                        <h3>信用额度(元)<h3>
                        <p>${(initCredit)!}</p>
                    </div>
                    <a href="javascript:;" onclick="loanNow()" >我要借款</a>
                </div>
            </div>
            
            <#if (consultation)??>
	            <div class="newCenter">
	                <div class="newTitle clearfix">
	                    <h2>${(platform.name)!}</h2>
	                </div>
	                <ul class="newContext">
	                    <#list consultation as cl>
	                        <li class="clearfix">
	                            <a href="/api/app/detail.htm?id=${(cl.id)!}">
	                                <span>
	                                	<#if cl.title?length gt 20>   
										    <h2>${(cl.title?substring(0,20))!}...</h2>
										<#else><h2>${(cl.title)!}</h2>   
										</#if>
	                                    <p>${(cl.createTime?date)!} </p>
	                                </span>
	                                <img src="${(cl.thumbnail)!}" />
	                            </a>
	                         </li>
	                    </#list>
	                </ul>
	            </div>
	        </#if>
            <div class="columnBox">
                <ul class="clearfix">
                    <li class="aboutUs">
                        <a href="javascript:;" onclick="aboutUs()">
                            <h2>关于我们</h2>
                            <p>了解团队及资讯</p>
                        </a>
                    </li>
                    <li class="inviteFriend">
                        <a href="javascript:;" onclick="inviteFriends()">
                            <i></i>
                            <h2>邀请好友</h2>
                            <p>呼朋唤友来借款</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <script type="text/javascript" >
        function move(){
            var bannerPicNumber = $(".bannerPic").children("li").length;
            if(bannerPicNumber > 1){
                $(".bannerPic li:first").animate({marginLeft:-7.5+'rem',opacity:0},1000
                ,function(){
                
                    $(".bannerPic li:last").after($(".bannerPic li:first"));
                    $(".bannerPic li:last").css({marginLeft:0,opacity:1});
                    var currentPic = $(".bannerPic").children("li")[0].className;
                    $(".bannerDot i").addClass("bannerDotNostyle").removeClass("bannerDotstyle")
                    $(".bannerDot i").eq(currentPic).addClass("bannerDotstyle").removeClass("bannerDotNostyle")
                })
            }
        }
        function moveNotice(){
            var noticeNumber = $(".noticeContent").children("li").length;
            if(noticeNumber > 1){
                $(".noticeContent li:first").animate({marginTop:-0.7+'rem',opacity:0},1000
                ,function(){
                    
                    $(".noticeContent li:last").after($(".noticeContent li:first"));
                    $(".noticeContent li:last").css({marginTop:0,opacity:1});	
                })
            }
        }
        setInterval(moveNotice,3000);
        var IntervalSet = setInterval(move,3000);
        $(".bannerBox").on("touchstart", function(e) {
            e.preventDefault();
            startX = e.originalEvent.changedTouches[0].pageX,
            startY = e.originalEvent.changedTouches[0].pageY;
            clearInterval(IntervalSet)
        });
        $(".bannerBox").on("touchend", function(e) {
            e.preventDefault();
            moveEndX = e.originalEvent.changedTouches[0].pageX,
            moveEndY = e.originalEvent.changedTouches[0].pageY,
            X = moveEndX - startX,
            Y = moveEndY - startY;
        
            if ( X > 0 ) {
                var bannerPicNumber = $(".bannerPic").children("li").length;
                if(bannerPicNumber > 1){
                    $(".bannerPic li:first").animate({marginLeft:7.5+'rem',opacity:0},500
                    ,function(){
                    
                        $(".bannerPic li:first").before($(".bannerPic li:last"));
                        $(".bannerPic li:first").css({marginLeft:0,opacity:1});
                        var currentPic = $(".bannerPic").children("li")[0].className;
                        $(".bannerDot i").addClass("bannerDotNostyle").removeClass("bannerDotstyle")
                        $(".bannerDot i").eq(currentPic).addClass("bannerDotstyle").removeClass("bannerDotNostyle")
                    })
                }
                IntervalSet = setInterval(move,3000);
            }else if ( X < 0 ) {
                var bannerPicNumber = $(".bannerPic").children("li").length;
                if(bannerPicNumber > 1){
                    $(".bannerPic li:first").animate({marginLeft:-7.5+'rem',opacity:0},1000
                    ,function(){
                    
                        $(".bannerPic li:last").after($(".bannerPic li:first"));
                        $(".bannerPic li:last").css({marginLeft:0,opacity:1});
                        var currentPic = $(".bannerPic").children("li")[0].className;
                        $(".bannerDot i").addClass("bannerDotNostyle").removeClass("bannerDotstyle")
                        $(".bannerDot i").eq(currentPic).addClass("bannerDotstyle").removeClass("bannerDotNostyle")
                    })
                }
                IntervalSet = setInterval(move,3000);
            }else{
                IntervalSet = setInterval(move,3000);
                var currentPicLi = $(".bannerPic").children("li")[0];
                window.location.href="/api/app/detail.htm?id="+$(currentPicLi).children("a")[0].className; 
            }
        });
        function loanNow(){
            var ua = navigator.userAgent;
            setTimeout(returnApp(), 100);
            function returnApp() {     
                if (ua=='Android') {
                    window.webReturn.loanNow('')
                }else if(ua=='iPhone'){
                    window.webkit.messageHandlers.loanNow.postMessage(null);
                }
            }
        }
        function aboutUs(){
            var ua = navigator.userAgent;
            setTimeout(returnApp(), 100);
            function returnApp() {     
                if (ua=='Android') {
                    window.webReturn.aboutUs('')
                }else if(ua=='iPhone'){
                    window.webkit.messageHandlers.aboutUs.postMessage(null);
                }
            }
        }
        function inviteFriends(){
            var ua = navigator.userAgent;
            setTimeout(returnApp(), 100);
            function returnApp() {     
                if (ua=='Android') {
                    window.webReturn.inviteFriends('')
                }else if(ua=='iPhone'){
                    window.webkit.messageHandlers.inviteFriends.postMessage(null);
                }
            }
        }
        
    </script>
</body>
<html>