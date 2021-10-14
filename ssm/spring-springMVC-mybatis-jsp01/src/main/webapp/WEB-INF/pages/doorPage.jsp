<%@ page pageEncoding="UTF-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.doorPageWrap{text-align:center;}
.doorPageWrap>h3{}
.doorPageWrap>span{display:inline-block;margin:10px 0;cursor:pointer;color: #545492;text-decoration: underline;}
.doorPageWrap>ul{margin:20px;font-size:18px;border-left:1px solid;border-top:1px solid;}
.doorPageWrap>ul>li:first-child{background:#f3d6d6;}
.doorPageWrap>ul>li{display:flex;}
.doorPageWrap>ul>li>span{justify-content: center;display:flex;align-items: center;border-right:1px solid;border-bottom:1px solid;}
.doorPageWrap>ul>li>span:nth-child(1){width:10%;}
.doorPageWrap>ul>li>span:nth-child(2){width:20%;}
.doorPageWrap>ul>li>span:nth-child(3){width:20%;}
.doorPageWrap>ul>li>span:nth-child(4){width:30%;}
.doorPageWrap>ul>li>span:nth-child(5){width:20%;}
.doorPageWrap>ul>li>span .delete{cursor: pointer;color: #545492;}
.doorPageWrap>ul>li>span .edit{cursor: pointer;color: #545492;}
</style>
</head>
<body>
<div class='doorPageWrap'>
	<h3>门店管理</h3>
	<span to='addDoor'>新增门店</span>
	<hr/>
	<ul>
		<li>
			<span>序号</span>
			<span>门店名称</span>
			<span>联系电话</span>
			<span>门店地址</span>
			<span>操作</span>
		</li>		
		<c:forEach items="${list}" var="door" varStatus="status">
			<li>
				<span>${status.count}</span>
				<span>${door.name}</span>
				<span>${door.tel}</span>
				<span>${door.addr}</span>
				<span>
					<span class='delete' onclick="deleteDoor(${door.id})">删除 </span>
					<span>|</span>
					<span class='edit' onclick="goToEdit(${door.id})"> 修改</span>
				</span>
			</li>
		</c:forEach>
		
	</ul>
</div>
<script>
	addDoor();
	function addDoor(){
		const doorPageWrap = document.querySelector('.doorPageWrap');
		const addBtn = doorPageWrap.querySelector('span');
		addBtn.addEventListener('click',(event)=>{
			const iframe = window.parent.document.querySelector('iframe');
			//console.log(iframe);
			//console.log(event.target.getAttribute('to'));
			const src = event.target.getAttribute('to');
			iframe.setAttribute('src',src);
		});
	}
	function deleteDoor(id){
		const flag = confirm("确定删除吗？");
		if(flag){
			location.href = "deleteDoorById?id="+id;
		}
	}
	function goToEdit(id){
		location.href = "doorInfo?id="+id;
	}
</script>
</body>
</html>