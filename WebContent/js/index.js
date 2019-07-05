/**
 * 键盘事件
 */

// 按Enter键发送信息
$(document).keydown(function(event){
    if(event.keyCode == 13){
        SendMsg();
    }
});

/**
 * 前台信息处理
 */
//发送信息
function SendMsg()
{
    var text = document.getElementById("text");
    if (text.value == "" || text.value == null)
    {
        return null;
    }
    else
    {
        AddMsg('default', SendMsgDispose(text.value));
        var retMsg = AjaxSendMsg(text.value);
        AddMsg('鬼赞赞', retMsg);
        text.value = "";
    }
    $('#show').scrollTop($('#show')[0].scrollHeight);
}
// 发送的信息处理
function SendMsgDispose(detail)
{
    detail = detail.replace(" ", "&nbsp;");
    return detail;
}

// 增加信息
function AddMsg(user,content)
{
    var str = CreadMsg(user, content);
    var msgs = document.getElementById("msgs");
    msgs.innerHTML = msgs.innerHTML + str;
}

// 生成内容
function CreadMsg(user, content)
{
    var str = "";
    if(user == 'default')
    {
        str = "<div class=\"msg guest\"><div class=\"msg-right\"><div class=\"msg-host headDefault\"></div><div class=\"msg-ball\" title=\"今天 17:52:06\">" + content +"</div></div></div>";
    }
    else
    {
        str = "<div class=\"msg robot\"><div class=\"msg-left\" worker=\"" + user + "\"><div class=\"msg-host photo\" style=\"background-image: url(images/head.jpg)\"></div><div class=\"msg-ball\" title=\"今天 17:52:06\">" + content + "</div></div></div>";
    }
    return str;
}


/**
 *  后台信息处理 
 */

// 发送
function AjaxSendMsg(_content)
{
    var retStr = "";
    $.ajax({
        type: "POST",
        async: false, //是否异步处理
        url: "Receive",
        data: {
           content : _content
        },
        dataType:'json',
        error: function (request) {
            retStr = "干嘛";
        },
        success: function (data){ 
            retStr = data.text;     /* +"<br />你喜不喜欢我的回答呀？"*/
        }
    });
    return retStr;
}

/**
 *  json匹配
 */

/*data =[
   {
   "content":"你好" ,
   "info": "你好个屁"
   },
   {
   "content":"你是谁",
   "info": "我是拥有十万软丝的鬼赞赞"
    },
    {
    "content":"你会什么",
    "info" : "我会和你聊天"},
    {
    "content":"你的功能只有聊天么",
    "info": "没错"
    }
    ];*/

/**
 *  搜索效果
 */
$(function(){
	//移入移出效果
	$(".atcom-item").hover(function(){
		$(this).css('background-color','#1C86EE').css('color','white');
	}, function(){
		$(this).css('background-color','white').css('color','black');
	});
	//隐藏列表框
	$('body').click(function(){
		$('.atcom-item').addClass('hide');
	});
	
	//文本框输入
	$("#text").keyup(function(){
		//$('.atcom-item').removeClass('hide'); //只要输入就显示列表框

		if($('#text').val().length <=0){
			$('.atcom-itcom').addClass('hide');//如果什么都没填，跳出，保持全部隐藏状态  
			return;  
		}else{
			$('.atcom-item').addClass('hide');//如果填了，先将所有的选项隐藏  
			for (var i = 0; i < $(".atcom-item").length; i++) {  
				//模糊匹配，将所有匹配项显示[匹配首字母]  
					/*  if($(".atcom-item").eq(i).text().substr(2, $("#text").val().length )== $("#text").val()){ */
					if($(".atcom-item").eq(i).text().indexOf( $("#text").val() )!=-1 ){
						$('.atcom-item').eq(i).removeClass('hide');
				};  
			};
		};
	});  //问题：在此处不成功，复制到控制台成功。解决：浏览器缓存清理掉

//	项点击  
	$(".atcom-item").click(function () {  
		$("#text").val($(this).text());  
		SendMsg();
	});
	
//   右边项点击
	$(".rel-item").click(function(){
		$("#text").val($(this).text());
		SendMsg();
	});
	
	//关闭页面时弹出窗口
	$(window).bind('beforeunload',function(){
		return '您能做个评价么';
		}
	);
	
});



