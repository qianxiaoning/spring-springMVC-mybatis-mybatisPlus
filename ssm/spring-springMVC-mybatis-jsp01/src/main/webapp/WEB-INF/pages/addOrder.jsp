<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
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
.addOrderWrap{text-align:center;}
.addOrderWrap>h3{}
.addOrderWrap>hr{margin:20px auto;}
.addOrderWrap .pop{width:400px;margin:0 auto;border:1px solid;border-bottom:0;}
.addOrderWrap .pop>li{border-bottom:1px solid;}
.addOrderWrap .pop>li>span{border-right:1px solid;margin-right: 10px;padding: 5px 10px 5px 0;width:108px;}
.addOrderWrap .pop>li>input{height: 20px;}
.addOrderWrap .pop>li>select{width: 173px;}
.addOrderWrap .pop>li>a{border:1px solid;color:#000;padding: 0 10px;border-radius: 4px;background: #efefef;margin:5px 0;}
</style>
</head>
<body>
<div class='addOrderWrap'>
	<h3>新增订单</h3>
	<hr/>
	<form>
		<ul class='pop'>
			<li class='flex ai-c jc-c'>
				<span>所属门店</span>
				<select name='doorId'>
					<c:forEach items="${doorList}" var="door">
						<option value="${door.id}">${door.name}</option>					
					</c:forEach>
				</select>
			</li>
			<li class='flex ai-c jc-c'>
				<span>订单编号</span>
				<input type='text' name='orderNo'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>订单类型</span>
				<input type='text' name='orderType'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>用餐人数</span>
				<input type='text' name='pnum'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>收银员</span>
				<input type='text' name='cashier'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>支付方式</span>
				<input type='text' name='payType'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>支付金额</span>
				<input type='text' name='price'/>
			</li>
			<li class='flex ai-c jc-c'>
				<a href="javascript:void(0)">提交</a>
			</li>
		</ul>
	</form>
</div>
<script>
	addOrderSubmit();
	function addOrderSubmit(){
		const form = document.querySelector('form');
		const popUl = document.querySelector('.pop');
		const a = popUl.querySelector('a');
		form.action="addOrderCon";
		form.method="post";
		a.addEventListener('click',()=>{
			form.submit();
		});
	}
</script>
</body>
</html>