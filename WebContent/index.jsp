<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head lang="zh-CN">
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <!-- 确保适当的绘制和触屏缩放 -->
  	<base target="_blank" />
  	<title>聊天机器人</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  	<link rel="stylesheet"  href="css/index.css" >
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
  </head>
  <body>
  	<img style="width:100%;height:100%" src="images/background.jpg">
  	 <div class="abs cover contaniner">
        <div class="abs cover pnl">
            <div class="top pnl-head"></div>
            <div class="abs cover pnl-body" id="pnlBody">
                <div class="abs cover pnl-left">
                    <div class="abs cover pnl-msgs scroll" id="show">
                        <!-- <div class="msg min time" id="histStart">加载历史消息</div> -->
                        <div class="pnl-list" id="hists">
                            <!-- 历史消息 -->
                        </div>
                        <div class="pnl-list" id="msgs">
                            <div class="msg robot">
                                <div class="msg-left" worker="赞赞 ">
                                    <div class="msg-host photo" style="background-image: url(images/head.jpg)"></div>
                                    <div class="msg-ball" title="今天 17:52:06">你好，我是只能打字的聊天机器人                <br /><br />您是想要了解哪些方面呢？
                                    <br />输入相应数字或文字可获得答案：<br />
                                    1.快递查询<br />
                                    2.新闻浏览 <br />
                                    3.电视剧 <br />
                                    4.评价 <br />
                                    </div>
                                </div>
                            </div>
                            <div class="msg guest">
                                <div class="msg-right">
                                    <div class="msg-host headDefault"></div>
                                </div>
                            </div>
                        </div>
                        <div class="pnl-list hide" id="unreadLine">
                            <div class="msg min time unread">未读消息</div>
                        </div>
                    </div>
                    <div class="abs bottom pnl-text">
                        <div class="abs top pnl-warn" id="pnlWarn">
                        <div class="fl btns rel pnl-warn-free">
                        <div style="height:20px;"></div></div>
                        </div>
                        
                        <div class="abs cover pnl-input">
                            <textarea class="scroll" id="text" wrap="hard" placeholder="在此输入文字信息..."></textarea>                  	
                        	<div class="abs atcom-pnl scroll">
                        	<ul class="atcom">
                        		<li class="atcom-item hide" title="回车或点击选择">你好</li>
                        		<li class="atcom-item hide" title="回车或点击选择">你是谁</li>
                        		<li class="atcom-item hide" title="回车或点击选择">湖南天气</li>
                        		<li class="atcom-item hide" title="回车或点击选择">北京天气</li>
                        		<li class="atcom-item hide" title="回车或点击选择">广州天气</li>
                        		<li class="atcom-item hide" title="回车或点击选择">新闻</li>
                        	</ul>
                         </div>
                        </div>
                        
                        <div class="abs br pnl-btn" id="submit" style="background-color: rgb(32, 196, 202); color: rgb(255, 255, 255);" onclick="SendMsg()">发送</div>
                        <div class="pnl-support" id="copyright"><a href="#">版权什么的</a></div>
                    </div>
                </div>
                <div class="abs right pnl-right">
                    <div class="slider-container hide"></div>
                    <div class="pnl-right-content">
                        <div class="pnl-tabs">
                            <div class="tab-btn active" id="hot-tab">常见问题</div>
                        </div>
                        <div class="pnl-hot">
                            <ul class="rel-list unselect" id="hots">
                                 <li class="rel-item" title="点击发送问题">快递查询</li> 
                                 <li class="rel-item" title="点击发送问题">新闻浏览</li> 
                                 <li class="rel-item" title="点击发送问题">电视剧</li> 
                                 <li class="rel-item" title="点击发送问题">评价</li> 
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
 </body>
</html>