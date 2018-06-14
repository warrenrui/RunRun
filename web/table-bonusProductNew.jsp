<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%String path=request.getContextPath() + "/";%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- 移动端 -->
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>Amaze UI Admin form Examples</title>
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=path %>assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=path %>assets/css/admin.css">
  <script src="<%=path%>assets/js/amazeui.datetimepicker.min.js"></script>
</head>
<body>
<!-- <header class="am-topbar admin-header"> -->
<%--   <jsp:include page="../head.jsp"></jsp:include> --%>
<!-- </header> -->
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <img src="<%=path%>assets/i/logo.png" height=25 alt="集享卡">&nbsp&nbsp&nbsp&nbsp<strong>支付平台</strong>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <!-- <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">0</span></a></li> -->
      <c:if test="${fn:contains(user.funcs, 'useBonus') }">
	      <li id="num"><a href="<%=path%>virtcard/bonus/getBonus?key=use&value=1"><span class="am-icon-hourglass-2"></span> 使用中券数 <span class="am-badge am-badge-warning">${activeNumber }</span></a></li>
	     </c:if>
	     <c:if test="${fn:contains(user.funcs, 'check') }">
	      <li id=""><a href="<%=path%>virtcard/bonusProduct/bonusProductCheck"><span class="am-icon-pencil-square-o"></span> 待审核券数 <span class="am-badge am-badge-warning">${checkNumber }</span></a></li>
	     </c:if>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> ${USER.trueName}<span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <!-- <li><a href="javascript:userinfo(${USER.employeeId});"><span class="am-icon-user"></span> 资料</a></li> -->
          <li><a href="javascript:edituserinfo();"><span class="am-icon-cog"></span>更改密码</a></li>
          <li><a href="<%=path%>user/logout"><span class="am-icon-power-off"></span>退出账户</a></li>
        </ul>
      </li>
      <!-- <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li> -->
    </ul>
  </div>
</header>

<div class="am-cf admin-main" >
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
      	<c:forEach var="menu" items="${MENUS}" varStatus="statusName" >
      		<c:if test="${menu.hasSubMenu}">
		   		<li class="admin-parent">
		   			<a class="am-cf" data-am-collapse="{target: '#collapse-nav${menu.module.moduleName}'}"><span class="am-icon-file"></span>${menu.module.moduleName}<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
		   			<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav${menu.module.moduleName}">
		   				<c:forEach var="item" items="${menu.childModules}" varStatus="statusName" >
		   				<li><a href="<%=path%>${item.module.url}"><span class="${item.module.icon}"></span>${item.module.moduleName}</a></li>
		   				</c:forEach>
		   			</ul>
		   		</li>
		    </c:if>
		    <c:if test="${!menu.hasSubMenu}">
		   		<li><a href="<%=path%>${menu.module.url}"><span class="${menu.module.icon}"></span>${menu.module.moduleName}</a></li>
		    </c:if>
      	</c:forEach>
      </ul>
    </div>
  </div>
<div class="am-cf admin-main">
  <!-- sidebar start -->
<%--   <jsp:include page="../head.jsp"></jsp:include> --%>
  <!-- sidebar end -->

<!-- content start -->
<div class="admin-content">
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
    	<strong class="am-text-primary am-text-lg">添加商品和券信息</strong> / <small>form</small>
    	<button class="am-btn am-btn-default am-btn-xs" id="return"><span class="am-icon-arrow-circle-left"></span>返回</button>
    </div>
  </div>

  <div class="am-tabs am-margin" id="myDiv">
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a>券信息</a></li>
      <li><a>商品信息</a></li>
      <li><a>商品-券</a></li>
    </ul>

    <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade am-in am-active">
      <div class="am-modal-bd">
		<legend>添加商品券信息</legend>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>券号:
			</div>
			<div class="am-u-sm-8 am-u-md-6" align="left">
				<input type="text" id="bonusId" name="bonusId" class="am-form-field" placeholder="长度为10位且只能是数字" required>
				<span class="am-text-sm" style="color:gray">注：券号确定后不可更改</span>
			</div>
			<div class="am-u-md-1" id="right" style="display:none;"><span class="am-icon-check am-text-success"></span></div>
			<div class="am-u-md-1" id="wrong" style="display:none;"><span class="am-icon-close am-text-danger"></span></div>
			<div class="am-u-md-2" id="bonusMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>类型:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<select id="bonusType" name="bonusType" class="am-form-field">
					<option value="">请选择券类型</option>
					<option value="P">商品券(P)</option>
					<option value="C">代金券(C)</option>
					<option value="S">点标券(S)</option>
				</select>
			</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>描述信息:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="bonusDesc" name="bonusDesc" class="am-form-field" required>
			</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right" id="customerPay">
				会员到店付:
			</div>
			<div class="am-u-sm-8 am-u-md-6" align="left">
				<input type="text" id="amt" name="amt" class="am-form-field" placeholder="请输入价格(单位：元，默认为0元)" required>
			</div>
			<div class="am-u-md-2" id="bamtMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left"></div>
		</div>
		<div class="am-g am-margin-top-sm">
		<div class="am-u-sm-4 am-u-md-2 am-text-right">
			失效时间:
            </div>
        <div class="am-u-sm-8 am-u-md-6 am-u-end">
           <div class="am-input-group date" id="datetimepicker2" data-date="2016/01/11 13:25" data-date-format="yyyy/mm/dd hh:ii">
           	<span class="am-input-group-label add-on"><i class="icon-th am-icon-calendar"></i></span>
			  <input size="16" type="text" id="endTime" name="endTime" value="${PARA.endTime}" class="am-form-field" readonly style="cursor:pointer">
			</div>
        </div>
        </div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>商户id:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<select id="memId" name="memId" class="am-form-field">
					<option value="">请选择所属商户</option>
					<option value="21000002">全家(21000002)</option>
					<option value="21000003">康师傅牛肉面(21000003)</option>
					<option value="21000004">德克士(21000004)</option>
				</select>
			</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
      </div>
      <div class="am-margin" align="center">
	    <button type="button" class="am-btn am-btn-primary am-btn-xs" id="oneNext">下一步</button>
	  </div>
      </div>

      <div class="am-tab-panel am-fade">
      <div class="am-modal-bd">
      <legend>添加商品信息</legend>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>商品货号:
			</div>
			<div class="am-u-sm-8 am-u-md-6" align="left">
				<input type="text" id="productId" name="productId" class="am-form-field" placeholder="长度至少7位且只能是数字" required>
				<span class="am-text-sm" style="color:gray">注：商品货号确定后不可更改</span>
			</div>
			<div class="am-u-md-1" id="right2" style="display:none;"><span class="am-icon-check am-text-success"></span></div>
			<div class="am-u-md-1" id="wrong2" style="display:none;"><span class="am-icon-close am-text-danger"></span></div>
			<div class="am-u-md-2" id="productMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>商品名称:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="productName" name="productName" class="am-form-field" required>
			</div>
			<div class="am-hide-sm-only am-u-md-2" align="left">*必填</div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>商品原价:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="productAmt" name="productAmt" class="am-form-field" placeholder="请输入价格(单位：元)" required>
			</div>
			<div class="am-u-md-2" id="pamtMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left"></div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>活动价格:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="campaignAmt" name="campaignAmt" class="am-form-field" placeholder="请输入价格(单位：元)" required>
			</div>
			<div class="am-u-md-2" id="pcmtMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left"></div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				继续添加:
			</div>
			<div class="am-u-sm-8 am-u-md-6" id="addConfig">
					<input type="radio" name="yy" value="" id="yesAdd"/>是
					<input type="radio" name="yy" value="" id="noAdd" checked/>否<br><br>
			</div>
		</div>	
		<div class="am-g am-margin-top" id="addInfo" style="padding-left:12rem;display:none;">
			<table id="oldProductTable" style="width:770px">
			</table>
		</div>
		<div class="am-g am-margin-top" id=spcialProducts>
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red; >*</span>特价商品:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
			    <div id="special1">
					<input type="radio" name="bb" value="" id="yesSpecial1"/>有
					<input type="radio" name="bb" value="" id="noSpecial1" checked/>无<br>
			    </div>
			    <div id="special2" style="display:none;">
					<table border='1' id='showSpecial' style='width:470px'></table>
					<div id="storeDiv">
			    	是否增加特价区域：<input type="radio" name="cc" value="" id="yesSpecial2"/>是
					<input type="radio" name="cc" value="" id="noSpecial2" checked/>否<br>
					</div>
			    </div>
				<div style="display:none;" id="specialArea"></div>
				<button id='addSpecial' value="" style="display:none;" class="am-btn am-btn-default am-btn-xs"><span class='am-icon-plus' style='color: gray'></span> 增加</button>
			</div>
			<div class="am-hide-sm-only am-u-md-2" align="left"></div>
			</div>
		 </div>
      <div class="am-margin" align="center">
	    <button type="button" class="am-btn am-btn-primary am-btn-xs" id="twoPre">上一步</button>
	    <button type="button" class="am-btn am-btn-primary am-btn-xs" id="twoNext">下一步</button>
	  </div>
      </div>

      <div class="am-tab-panel am-fade">
      <div class="am-modal-bd">
      <legend>添加商品-券信息</legend>
	  	<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>券信息:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="bp_bonusId" name="bonusId" class="am-form-field" placeholder="请输入券id" required>
			</div>
			<div class="am-hide-sm-only am-u-md-4"></div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>商品信息:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="bp_productId" name="productId" class="am-form-field" placeholder="请输入商品id" required>
			</div>
			<div class="am-hide-sm-only am-u-md-4"></div>
		</div>
		<div class="am-g am-margin-top">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>活动ID:
			</div>
			<div class="am-u-sm-8 am-u-md-6">
				<input type="text" id="marketingActivityId" name="marketingActivityId" class="am-form-field" placeholder="请输入活动ID" required>
			</div>
			<div class="am-u-md-2" id="pactivityMessage" style="display:none;"><span class="am-icon-close am-text-danger"></span>输入不合法!</div>
			<div class="am-hide-sm-only am-u-md-2" align="left"></div>
		</div>
		<div class="am-g am-margin-top" id="country">
			<div class="am-u-sm-4 am-u-md-2 am-text-right">
				<span style=color:red;>*</span>活动区域:
			</div>
			<div class="am-u-sm-8 am-u-md-6" id="country">
				全国：<input type="radio" name="aa" value="yes" id="yes"/>是
				<input type="radio" name="aa" value="no" id="no"/>否<br><br>
				<div style="display:none;" id="area" class="">
					<table class="am-table am-table-bordered">
						<thead class="am-text-default">请选择地区</thead>
						<tr bgcolor="#f4f4f4" align="left">
							<td><input type="checkbox" id="east" value="east"/>华东地区</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr align="left" id="east-city">
							<td id="shanghai">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="21000002" name="place1" value="21000002" disabled/>上海<span class="21000002"></span></td>
							<td id="suzhou"><input type="checkbox" id="51000001" name="place1" value="51000001" disabled/>苏州<span class="51000001"></span></td>
							<td id="hangzhou"><input type="checkbox" id="57000001" name="place1" value="57000001" disabled/>杭州<span class="57000001"></span></td>
							<td id="wuxi"><input type="checkbox" id="51000002" name="place1" value="51000002" disabled/>无锡<span class="51000002"></span></td>
						</tr>
						<tr bgcolor="#f4f4f4" align="left">
							<td><input type="checkbox" id="south" value="south"/>华南地区</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr align="left" id="south-city">
							<td id="guangzhou">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="20000001" name="place2" value="20000001" />广州<span class="20000001"></span></td>
							<td id="shenzhen"><input type="checkbox" id="75000001" name="place2" value="75000001" disabled/>深圳<span class="75000001"></span></td>
							<td id="dongguan"><input type="checkbox" id="76000001" name="place2" value="76000001" disabled/>东莞<span class="76000001"></span></td>
							<td></td>
						</tr>
						<tr bgcolor="#f4f4f4" align="left">
							<td id="chengdu"><input type="checkbox" id="28000001" value="28000001" />成都<span class="28000001"></span></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr bgcolor="#f4f4f4" align="left">
							<td id="beijing"><input type="checkbox" id="10000001" value="10000001" />北京<span class="10000001"></span></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="am-hide-sm-only am-u-md-4"></div>
		</div>
      </div>
      
	  <div class="am-margin" align="center">
	   <button type="button" class="am-btn am-btn-primary am-btn-xs" id="threePre">上一步</button>
	    <button type="button" class="am-btn am-btn-primary am-btn-xs" id="save">保存</button>
	    <button type="button" class="am-btn am-btn-primary am-btn-xs" id="exit" name="exit">取消</button>
	  </div>
	</div>
    </div>
  </div>
</div>
<!-- content end -->
</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
  <div class="am-modal-dialog">
    <div class="am-modal-bd">
      确定要退出吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-save">
  <div class="am-modal-dialog">
    <div class="am-modal-bd">
     还要继续添加吗？
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>不了，谢谢</span>
      <span class="am-modal-btn" data-am-modal-confirm>再来一条吧</span>
    </div>
  </div>
</div>
<!-- <footer> -->
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
<!-- </footer> -->
<script src="<%=path%>assets/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var bonusId, bonusType, bonusDesc, amt="0000000000", memId, productId, productName, productAmt="0000000000", campaignAmt="0000000000",marketingActivityId;
		var re;//正则校验
		var errMessage = "";//门店号错误信息
		$("#oneNext").click(function(){
			bonusId = $("#bonusId").val();
			bonusType = $("#bonusType").val();
			bonusDesc = $("#bonusDesc").val();
			memId = $("#memId").val();
			if(bonusId.trim() == "" || bonusType.trim() == "" || bonusDesc.trim() == "" || memId.trim() == "" || !$("#bonusMessage").is(":hidden") || !$("#bamtMessage").is(":hidden")){
				alert("再检查检查你的信息吧！");
			}else{
				if((memId.trim() == "21000003") || (memId.trim() == "21000004")){
					$("input[name='productId']").attr("placeholder","请输入商品货号");
					$("#spcialProducts").hide();
					$("#myDiv").tabs('open',1);
				}else{
					$("#spcialProducts").show();
					$("#myDiv").tabs('open',1);
				}
				$("#myDiv").tabs('open',1);
			}
		});
		$("#twoPre").click(function(){
			$("#myDiv").tabs('open',0);
		});
		$("#twoNext").click(function(){
			productId = $("#productId").val();
			productName = $("#productName").val();
			var arr = [10000001, 20000001, 21000002, 28000001, 51000001, 51000002, 57000001, 75000001, 76000001];
			for(i = 0;i < arr.length; i++){
				$(":checkbox[id='"+arr[i]+"']").prop('checked',false);
				//$("#"+arr[i]+"").prop('checked',false);
				$("."+arr[i]+"").empty();
			}
			if(productId.trim() == "" || productName.trim() == "" || !$("#productMessage").is(":hidden") || !$("#pamtMessage").is(":hidden") || !$("#pcmtMessage").is(":hidden")){
				alert("再检查检查你的信息吧！");
			}else{
				if((memId.trim() == "21000003") || (memId.trim() == "21000004")){
					if($("#productAmt") != $("#campaignAmt")){
						alert("请确认价格一致！");
					}
				}
				if($("#yesSpecial1").prop("checked")==true||$("#yesSpecial2").prop("checked")==true){
					var bool = true;
					for(i = 0;i < 10; i++){
						if($("#"+i+"").length>0){
							v = $("#"+i+"").val();//特价区域
							s = $("#"+i+"").nextAll("input:eq('0')").val().trim();//单店
							am = $("#"+i+"").nextAll("input:eq('1')").val().trim();//原价
							cm = $("#"+i+"").nextAll("input:eq('2')").val().trim();//活动价
							re = /^\d+(\.\d+)?$/;
							if((v==""&&s=="")||am==""||cm==""||!re.test(Number(am))||!re.test(Number(cm))){
								bool = false;
								break;
							}else{
								if(v != ""){
									$(":checkbox[id='"+v+"']").prop('checked',true);
									$("."+v+"").empty();
									$("."+v+"").append("<br>(原价:"+Number(am)+"元,活动价:"+Number(cm)+"元)");
								}
								if(s!="") {
									$("#country").hide();//如果选择单店，不必选择全国
									$.ajax({
										type:"POST",
										data:{storeId : s},
										dataType:"text",
										url:"<%=path%>virtcard/bonusProduct/selectPurchaseIdByStoreId",
										success:function(data){
											if(data == "" || data == null){
	 											errMessage = " 门店号不存在！请检查您的信息";
	 										}else{
	 											errMessage = "";
	 										}
										},
										error:function(data){
											console.log("error" + data);
										}
									});
								}else{
									
								}
							}
						}
					}
					console.log(bool);
					if(!bool){
						alert("再检查检查你的信息吧！" + errMessage);
					}else{
						$("#myDiv").tabs('open',2);
						$("#bp_bonusId").val(bonusDesc+"("+bonusId+")");
						$("#bp_productId").val(productName+"("+productId+")");
						$("#bp_bonusId").prop("disabled",true);
						$("#bp_productId").prop("disabled",true);
					}
				}else{
					$("#myDiv").tabs('open',2);
					$("#bp_bonusId").val(bonusDesc+"("+bonusId+")");
					$("#bp_productId").val(productName+"("+productId+")");
					$("#bp_bonusId").prop("disabled",true);
					$("#bp_productId").prop("disabled",true);
				}
			}
		});
		$("#threePre").click(function(){
			errMessage = "";
			$("#myDiv").tabs('open',1);
			$("#country").show();
		});
		$("#save").click(function(){
			if(errMessage == ""){//如果门店号正确
				var specialArea = "";//特价区域
				var storeId = "";//单店
				var storeIdFlag = false;
				var specialAmt = "";//特价原价
				var specialCmt = "";//特价活动价
				marketingActivityId=$("#marketingActivityId").val();
				for(i = 0;i < 10; i++){
					if($("#"+i+"").length>0){
						storeId = $("#"+i+"").nextAll("input:eq('0')").val();
						if(storeId != ""){
							storeIdFlag = true;
							var str = "0000000000";
							am = Number($("#"+i+"").nextAll("input:eq('1')").val());
							str += parseInt(am*100)+"";
							specialAmt = str.substring(str.length-10, str.length);//③原价
							str = "0000000000";
							cm = Number($("#"+i+"").nextAll("input:eq('2')").val());
							str += parseInt(cm*100)+"";
							specialCmt = str.substring(str.length-10, str.length);//④活动价
							break;
						}
						specialArea += $("#"+i+"").val() + ",";//①区域
						var str = "0000000000";
						am = Number($("#"+i+"").nextAll("input:eq('1')").val());
						str += parseInt(am*100)+"";
						specialAmt += str.substring(str.length-10, str.length) + ",";//③原价
						str = "0000000000";
						cm = Number($("#"+i+"").nextAll("input:eq('2')").val());
						str += parseInt(cm*100)+"";
						specialCmt += str.substring(str.length-10, str.length) + ",";//④活动价
					}
				}
				if(storeIdFlag){
					$.post("<%=path%>virtcard/bonusProduct/insertBonusProductNew",
		        			{storeId:storeId, specialArea:specialArea, specialAmt:specialAmt, specialCmt:specialCmt, 
		        			 bonusId:bonusId, bonusType:bonusType, bonusDesc:bonusDesc, amt:amt, memId:memId, 
		        			 productId:productId, productName:productName, productAmt:productAmt, campaignAmt:campaignAmt,marketingActivityId:marketingActivityId},
		        			function(result){
								$("#my-save").modal({
							        onConfirm: function() {
							        	document.location="<%=path%>virtcard/bonusProduct/bonusProductNew";
							        },
							        onCancel: function() {
							        	document.location="<%=path%>virtcard/bonusProduct/bonusProduct";
							        }
							    });
					 },"json");
				}else{
					var PCId = "";
					if($(":checkbox[id='21000002']").prop("checked")==true || $(":checkbox[id='51000001']").prop("checked")==true
							|| $(":checkbox[id='57000001']").prop("checked")==true || $(":checkbox[id='51000002']").prop("checked")==true
							|| $(":checkbox[id='east']").prop("checked")==true){
						PCId += 10 + ",";
					}
					if($(":checkbox[id='76000001']").prop("checked")==true || $(":checkbox[id='20000001']").prop("checked")==true
							|| $(":checkbox[id='75000001']").prop("checked")==true || $(":checkbox[id='south']").prop("checked")==true){
						PCId += 20 + ",";
					}
					if($(":checkbox[id='28000001']").prop("checked")==true ){
						PCId += 30 + ",";
					}
					if($(":checkbox[id='10000001']").prop("checked")==true ){
						PCId += 40;
					}
					if(PCId == ""|| $("#marketingActivityId").val()==""){
						alert("再检查检查你的信息吧！");
					}else{
			        	$.post("<%=path%>virtcard/bonusProduct/insertBonusProductNew",
			        			{PCId:PCId, specialArea:specialArea, specialAmt:specialAmt, specialCmt:specialCmt, 
			        			 bonusId:bonusId, bonusType:bonusType, bonusDesc:bonusDesc, amt:amt, memId:memId, 
			        			 productId:productId, productName:productName, productAmt:productAmt, campaignAmt:campaignAmt,marketingActivityId:marketingActivityId},
			        			function(result){
									$("#my-save").modal({
								        onConfirm: function() {
								        	document.location="<%=path%>virtcard/bonusProduct/bonusProductNew";
								        },
								        onCancel: function() {
								        	document.location="<%=path%>virtcard/bonusProduct/bonusProduct";
								        }
								    });
						 },"json");
					}
				}
			}else{
				alert(errMessage);
			}
		});
		
		$("#yes").click(function(){
			$("#area").hide();
			$(":checkbox[id='east']").prop('checked',true);
			$(":checkbox[id='south']").prop('checked',true);
			$(":checkbox[id='28000001']").prop('checked',true);
			$(":checkbox[id='10000001']").prop('checked',true);
		});
		$("#no").click(function(){
			$("#area").show();
			$(":checkbox[id='east']").prop('checked',false);
			$(":checkbox[id='south']").prop('checked',false);
			$(":checkbox[id='28000001']").prop('checked',false);
			$(":checkbox[id='10000001']").prop('checked',false);
		});
		var count;
		$("#yesSpecial1").click(function(){
			count = 1;
			$("#specialArea").show();
			$("#specialArea").empty();
			$("#specialArea").append("<table id='specialTable' style='width:770px'><tr><td><select id='0' class='am-u-md-3'><option value=''>选择特价区</option><c:forEach items='${allMember }' var='member'><option id='${member.memId }' value='${member.memId }'>${member.memName }</option></c:forEach></select><input type='text' class='am-u-md-3' placeholder='请输入门店号'/><input type='text' class='am-u-md-3' placeholder='请输入商品原价'/><input type='text' class='am-u-md-3' placeholder='请输入活动价格'/></td></tr></table>")
// 							 .find("a").click(function(){
// 								 count--;
// 				            	  $(this).parent().parent().remove();
// 				            	  if($("#addSpecial").is(":hidden")){
// 				            		  $("#addSpecial").show();
// 				            	  }
// 				              })
				              ;
		});
		$("#noSpecial1").click(function(){
			$("#specialArea").hide();
			$("#specialArea").empty();
		});
		var data=[];
		$("#yesAdd").click(function(){
			count = 1;
			$("#addInfo").show();
			var productId = $('#productId').val();
			var productName = $('#productName').val();
			var productAmt = $('#productAmt').val();
			var campaignAmt = $('#campaignAmt').val();
			var obj = {};
			obj.productId=productId;
			obj.productName=productName;
			obj.productAmt=productAmt;
			obj.campaignAmt=campaignAmt;
			data.push(obj);
			var html = "<tr><td><input type='text' class='am-u-md-3' value="+productId+" placeholder='商品货号' /><input type='text' value="+productName+" class='am-u-md-3' placeholder='商品名称' /><input type='text' value="+productAmt+" class='am-u-md-3' placeholder='商品原价' /><input type='text' value="+campaignAmt+" class='am-u-md-3' placeholder='活动价格' /></td></tr>"
			$("#oldProductTable").append(html);
		});
		$("#noAdd").click(function(){
			$("#addInfo").hide();
		});
		$("#yesSpecial2").click(function(){
			count = 1;
// 			$("#addSpecial").show();
			$("#specialArea").show();
			$("#specialArea").empty();
			$("#specialArea").append("<table id='specialTable' style='width:770px'><tr><td><select id='0' class='am-u-md-3'><option value=''>选择特价区</option><c:forEach items='${allMember }' var='member'><option id='${member.memId }' value='${member.memId }'>${member.memName }</option></c:forEach></select><input type='text' class='am-u-md-3' placeholder='请输入门店号'/><input type='text' class='am-u-md-3' placeholder='请输入商品原价'/><input type='text' class='am-u-md-3' placeholder='请输入活动价格'/></td></tr></table>")
// 							 .find("a").click(function(){
// 								count--;
// 					   			$(this).parent().parent().remove();
// 					       		if($("#addSpecial").is(":hidden")){
// 					           		$("#addSpecial").show();
// 					           	}
// 							 })
							 ;
		});
		$("#noSpecial2").click(function(){
			$("#specialArea").hide();
			$("#specialArea").empty();
		});
		
		$("#addSpecial").click(function(){
			$("<tr></tr>").append("<td><select id='"+count+"' class='am-u-md-3'><option value=''>选择特价区</option><c:forEach items='${allMember }' var='member'><option id='${member.memId }' value='${member.memId }'>${member.memName }</option></c:forEach></select><input type='text' class='am-u-md-3' placeholder='请输入门店号'/><input type='text' class='am-u-md-3' placeholder='请输入商品原价'/><input type='text' class='am-u-md-3' placeholder='请输入活动价格'/></td>")
			              .append("<td><a><span class='am-icon-minus-circle am-text-danger am-text-lg'></span></a></td>")
			              .appendTo("#specialTable")
			              .find("a").click(function(){
			            	  count--;
			            	  $(this).parent().parent().remove();
			            	  if($("#addSpecial").is(":hidden")){
			            		  $("#addSpecial").show();
			            	  }
			              });
			if(count ++ > 8){
				$("#addSpecial").hide();
			}
		});
		$("#bonusType").change(function(){
			if($("#bonusType").val() == "S"){
				$("#amt").hide();
				$(customerPay).hide();
			}else if($("#bonusType").val() == "P"){
				if($("#amt").val() == null){
					$("input[name='amt']").attr("placeholder","请输入到付价格(单位：元，默认为0元)");
				}
				$("#amt").show();
				$(customerPay).show();
			}else if($("#bonusType").val() == "C"){
				if($("#amt").val() == null){
					$("input[name='amt']").attr("placeholder","请输已付价格(单位：元，默认为0元)");
				}
				$("#amt").show();
				$(customerPay).show();
			}
		});
		$("#bonusId").change(function(){
			$("#bonusMessage").hide();
			$("#bamtMessage").hide();
			$("#right").hide();
			$("#wrong").hide();
			re = /^[0-9]*$/;
			var val = $(this).val();
			var $this = $(this);
			if(re.test(Number(val))){
				val = val.trim();
				if(val.length == 10 && val[0] == 7){
					$.post("<%=path%>virtcard/bonus/selectByPrimaryKey",{val:val},function(data){
						if(data != ""){
							data = eval("("+data+")");
							$("#bonusId").val(data.bonusId);
							bonus(data.bonusType,data.bonusDesc,Number(data.amt)/100,data.memId,true);
							$("#wrong").show();
						}else{
							bonus("","","","",false);
							$("#right").show();
						}
					});
				}else{
					$("#bonusMessage").show();
				}
			}else{
				$("#bonusMessage").show();
			}
		});
		$("#productId").change(function(){
			$("#storeDiv").show();
			$("#yesSpecial2").prop("checked",false);
			$("#noSpecial2").prop("checked",true);
// 			$("#addSpecial").hide();
			$("#right2").hide();
			$("#wrong2").hide();
			$("#specialArea").empty();
			$("#productMessage").hide();
			$("#pamtMessage").hide();
			$("#pcmtMessage").hide();
			re = /^[0-9]*$/;
			var val = $(this).val();
			var $this = $(this);
			if(re.test(Number(val))){
				val = val.trim();
				if((memId.trim() == "21000003" || memId.trim() == "21000004")&&val.length >= 1 || val.length >= 7){
					$.post("<%=path%>virtcard/product/selectByProductId",{val:val},function(data){
						if(data != ""){
							data = eval("("+data+")");
							$("#productId").val(data[0].productId);
							$("#productName").val(data[0].productName);
							var storeFlag = false;
							$.each(data, function(i, ii){
								storeFlag = ii.storeFlag;
								console.log(ii.memId);
								if(ii.memId.indexOf("21000002")>0 || ii.memId.indexOf("21000003")>0 || ii.memId.indexOf("21000004")>0 ){
									$("#productAmt").val(Number(ii.productAmt)/100);
									$("#campaignAmt").val(Number(ii.campaignAmt)/100);
									productAmt = ii.productAmt;
									campaignAmt = ii.campaignAmt;
								}
							})
							$("#productName").prop("disabled",false);
							$("#productAmt").prop("disabled",false);
							$("#campaignAmt").prop("disabled",false);
							
							$("#wrong2").show();
							if((memId.trim() == "21000003") || (memId.trim() == "21000004")){
								$("#spcialProducts").hide();
							}else{
								$("#special1").hide();
								$("#special2").show();
							}
							if(storeFlag){
								console.log("进来了..");
								$("#storeDiv").hide();
								$("#yesSpecial2").prop("checked",true);
								$("#noSpecial2").prop("checked",false);
								
								count = 1;
// 								$("#addSpecial").show();
								$("#specialArea").show();
								$("#specialArea").empty();
								$("#specialArea").append("<table id='specialTable' style='width:770px'><tr><td><select id='0' class='am-u-md-3'><option value=''>选择特价区</option><c:forEach items='${allMember }' var='member'><option id='${member.memId }' value='${member.memId }'>${member.memName }</option></c:forEach></select><input type='text' class='am-u-md-3' placeholder='请输入门店号'/><input type='text' class='am-u-md-3' placeholder='请输入商品原价'/><input type='text' class='am-u-md-3' placeholder='请输入活动价格'/></td><td><a><span class='am-icon-minus-circle am-text-danger am-text-lg'></a></td></tr></table>")
												 .find("a").click(function(){
													count--;
										   			$(this).parent().parent().remove();
										       		if($("#addSpecial").is(":hidden")){
										           		$("#addSpecial").show();
										           	}
												 });
							}
							
// 							$("#showSpecial").empty();
// 							$("#showSpecial").append("<tr><td>区域</td><td>活动价格</td></tr>");
// 							$.each(data, function(i, ii){
// 								$("#showSpecial").append("<tr><td>"+ii.memId+"</td><td>"+Number(ii.campaignAmt)/100+"元</td></tr>");
// 							})
						}else{
							$("#productName").val("");
							$("#productAmt").val("");
							$("#campaignAmt").val("");
							$("#productName").prop("disabled",false);
							$("#productAmt").prop("disabled",false);
							$("#campaignAmt").prop("disabled",false);
							
							$("#right2").show();
							if((memId.trim() == "21000003") || (memId.trim() == "21000004")){
								$("#spcialProducts").hide();
							}else{
								$("#special1").show();
								$("#special2").hide();
							}
						}
					});
				}else{
					$("#productMessage").show();
				}
			}else{
				$("#productMessage").show();
			}
		});
		$("#amt").change(function(){
			var str = "0000000000";
			$("#bamtMessage").hide();
			re = /^\d+(\.\d+)?$/;
			var num = Number($("#amt").val());
			if(re.test(num)){
				str += parseInt((num*100).toFixed(2))+"";
				amt = str.substring(str.length-10, str.length);
			}else{
				$("#bamtMessage").show();
			}
		});
	    $("#marketingActivityId").change(function(){
			$("#pactivityMessage").hide();
			fm = /^FM[0-9]{4,10}$/;
			dicos = /^DICOS[0-9]{4,10}$/;
			nrm = /^NRM[0-9]{4,10}$/;
			var activityId=$("#marketingActivityId").val();
				if(memId.trim() == "21000002"){
					if(!fm.test(activityId)){
						$("#pactivityMessage").show();
					}
				}	
				else if(memId.trim() == "21000003"){
					if(!nrm.test(activityId)){
						$("#pactivityMessage").show();
					}
				}else if(memId.trim() == "21000004"){
					if(!dicos.test($(activityId))){
						$("#pactivityMessage").show();
				}
			}
		});
		$("#productAmt").change(function(){
			var str = "0000000000";
			$("#pamtMessage").hide();
			re = /^\d+(\.\d+)?$/;
			var num = Number($("#productAmt").val());
			if(re.test(num)){
				str += parseInt((num*100).toFixed(2))+"";
				productAmt = str.substring(str.length-10, str.length);
				campaignAmt = productAmt;
			}else{
				$("#pamtMessage").show();
			}
		});
		$("#campaignAmt").change(function(){
			var str = "0000000000";
			$("#pcmtMessage").hide();
			re = /^\d+(\.\d+)?$/;
			var num = Number($("#campaignAmt").val());
			if(re.test(num)){
				str += parseInt((num*100).toFixed(2))+"";
				campaignAmt = str.substring(str.length-10, str.length);
			}else{
				$("#pcmtMessage").show();
			}
		});
		$("#east").change(function(e){
			var _ctryNode = $('#east-city').find('input[type="checkbox"]');
			_ctryNode.each(function(k,v){
				if(v.checked){
					v.checked=false;
				}
				$(v).attr("disabled",false);
			});
			var _ck = e.target.checked;
			var _node1 = $("#21000002");
			var _node2  = $("#51000001");
			var _node3 = $("#57000001");
			var _node4 = $("#51000002");
			if(_ck){
				checkParen(_node1,e.target,true);
				checkParen(_node2,e.target,true);
				checkParen(_node3,e.target,true);
				checkParen(_node4,e.target,true);
			}else{
				checkParen(_node1,e.target,false);
				checkParen(_node2,e.target,false);
				checkParen(_node3,e.target,false);
				checkParen(_node4,e.target,false);
			}
		});
		$("#south").change(function(e){
			var _ctryNode = $('#south-city').find('input[type="checkbox"]');
			_ctryNode.each(function(k,v){
				if(v.checked){
					v.checked=false;
				}
				$(v).attr("disabled",false);
			});
			var _ck = e.target.checked;
			var _node1 = $("#20000001");
			var _node2  = $("#75000001");
			var _node3 = $("#76000001");
			if(_ck){
				checkParen(_node1,e.target,true);
				checkParen(_node2,e.target,true);
				checkParen(_node3,e.target,true);
			}else{
				checkParen(_node1,e.target,false);
				checkParen(_node2,e.target,false);
				checkParen(_node3,e.target,false);
			}
		});
		function checkParen(obj,node,flag){
				var _check = node.checked;
				if(_check&&flag){
					$(obj).attr('disabled',false);
					return false;
				}else{
					$(obj).attr('disabled',true);
					return false;
				}
				return false;
		}
		
		$("#return").add("#exit").click(function(){
			$("#my-confirm").modal({
		        onConfirm: function() {
		        	document.location="<%=path%>virtcard/bonusProduct/bonusProduct";
		        },
			});
		});
		
	});
	function bonus(type, desc, amt, memId, flag){
		$("#bonusType").val(type);
		$("#bonusDesc").val(desc);
		$("#amt").val(amt);
		$("#memId").val(memId);
		
		$("#bonusType").prop("disabled",flag);
		$("#bonusDesc").prop("disabled",flag);
		$("#amt").prop("disabled",flag);
		$("#memId").prop("disabled",flag);
	}
</script>
<!--<![endif]-->
<script src="<%=path%>assets/js/amazeui.min.js"></script>
<script src="<%=path%>assets/js/app.js"></script>
</body>
</html>
