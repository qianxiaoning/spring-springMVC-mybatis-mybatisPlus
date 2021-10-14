<%@ page pageEncoding="UTF-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
*{margin:0;padding:0;}
li{list-style:none;}
a{text-decoration:none;}
html,body{height:100%;}
body{font-size:24px;}
/*flex布局*/
.flex{display: flex;display: -webkit-flex;}
/*水平轴是主轴 垂直轴是交叉轴*/
/*单根主轴方向*/
.fd-r{flex-direction: row;}
.fd-rr{flex-direction: row-reverse;}
.fd-c{flex-direction: column;}
.fd-cr{flex-direction: column-reverse;}
/*单根换行*/
.fw-n{flex-wrap: nowrap;}
.fw-w{flex-wrap: wrap;}
.fw-wr{flex-wrap: wrap-reverse;}
/*单根主轴对齐方式*/
.jc-fs{justify-content: flex-start;}
.jc-fe{justify-content: flex-end;}
.jc-c{justify-content: center;}
.jc-sb{justify-content: space-between;}
.jc-sa{justify-content: space-around;}
/*单根交叉轴对齐方式*/
.ai-fs{align-items: flex-start;}
.ai-fe{align-items: flex-end;}
.ai-c{align-items: center;}
.ai-b{align-items: baseline;}
.ai-s{align-items: stretch;}
/*多根交叉轴对齐方式*/
/*父层配合fd-r,fw-w。子层配合width:100%。使用*/ 
.ac-fs{align-content: flex-start;}
.ac-fe{align-content: flex-end;}
.ac-c{align-content: center;}
.ac-sb{align-content: space-between;}
.ac-sa{align-content: space-around;}
.ac-s{align-content: stretch;} 
/*item属性*/
/*项目放大比例 默认0*/
.fg-1{flex-grow:1;}
/*项目缩小比例 默认1*/
.fs-0{flex-shrink:0;}
/*优先 项目自动缩放*/
.f-a{flex: auto;}  
/*优先 项目不缩放*/
.f-n{flex: none;}
.orderPageWrap{text-align:center;}
.orderPageWrap>h3{}
.orderPageWrap>span{display:inline-block;margin:10px 0;cursor:pointer;color: #545492;text-decoration: underline;}
.orderPageWrap>ul{margin:20px;font-size:18px;border-left:1px solid;border-top:1px solid;}
.orderPageWrap>ul>li:first-child{background:#f3d6d6;}
.orderPageWrap>ul>li{display:flex;}
.orderPageWrap>ul>li>span{justify-content: center;display:flex;align-items: center;border-right:1px solid;border-bottom:1px solid;}
.orderPageWrap>ul>li>span:nth-child(1){width:4%;}
.orderPageWrap>ul>li>span:nth-child(2){width:12%;}
.orderPageWrap>ul>li>span:nth-child(3){width:8%;}
.orderPageWrap>ul>li>span:nth-child(4){width:8%;}
.orderPageWrap>ul>li>span:nth-child(5){width:8%;}
.orderPageWrap>ul>li>span:nth-child(6){width:8%;}
.orderPageWrap>ul>li>span:nth-child(7){width:12%;}
.orderPageWrap>ul>li>span:nth-child(8){width:12%;}
.orderPageWrap>ul>li>span:nth-child(9){width:8%;}
.orderPageWrap>ul>li>span:nth-child(10){width:8%;}
.orderPageWrap>ul>li>span:nth-child(11){width:12%;}
.orderPageWrap>ul>li>span .delete{cursor: pointer;color: #545492;}
.orderPageWrap>ul>li>span .edit{cursor: pointer;color: #545492;}
</style>
</head>
<body>
<div class='orderPageWrap'>
	<h3>订单管理</h3>
	<span to='goToAdd'>新增订单</span>
	<hr/>
	<ul>
		<li>
			<span>序号</span>
			<span>所属门店</span>
			<span>订单号</span>
			<span>类型</span>
			<span>人数</span>
			<span>收银员</span>
			<span>下单时间</span>
			<span>结账时间</span>
			<span>支付方式</span>
			<span>金额</span>
			<span>操 作</span>
		</li>		
		<c:forEach items="${list}" var="order" varStatus="status">
			<li>
				<span>${status.count}</span>
				<span>
					<c:forEach items="${doorList}" var="door">
						${door.id==order.doorId?door.name:""}
						<%--<c:if test="${door.id==order.doorId}">
							${door.name}
						</c:if> --%>
					</c:forEach>
				</span>
				<span>${order.orderNo}</span>
				<span>${order.orderType}</span>
				<span>${order.pnum}</span>
				<span>${order.cashier}</span>
				<span>
					<%-- ${order.orderTime}--%>
					<fmt:formatDate value="${order.orderTime}" 
					pattern="yyyy/MM/dd HH:mm:ss"/>
				</span>
				<span>
					<%-- ${order.payTime}--%>
					<fmt:formatDate value="${order.payTime}" 
					pattern="yyyy/MM/dd HH:mm:ss"/>
				</span>
				<span>${order.payType}</span>
				<span>${order.price}</span>
				<span>
					<span class='delete' onclick="deleteOrder(${order.id})">删除 </span>
					<span>|</span>
					<span class='edit' onclick="goToEdit(${order.id})"> 修改</span>
				</span>
			</li>
		</c:forEach>
		
	</ul>
</div>
<script>
	addOrder();
	function addOrder(){
		const orderPageWrap = document.querySelector('.orderPageWrap');
		const addBtn = orderPageWrap.querySelector('span');
		addBtn.addEventListener('click',(event)=>{
			const iframe = window.parent.document.querySelector('iframe');
			//console.log(iframe);
			//console.log(event.target.getAttribute('to'));
			const src = event.target.getAttribute('to');
			iframe.setAttribute('src',src);
		});
	}
	function deleteOrder(id){
		const flag = confirm("确定删除吗？");
		if(flag){
			location.href = "deleteOrderById?id="+id;
		}
	}
	function goToEdit(id){
		location.href = "orderInfo?id="+id;
	}
</script>
</body>
</html>