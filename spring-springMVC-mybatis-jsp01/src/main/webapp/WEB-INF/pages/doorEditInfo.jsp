<%@ page pageEncoding="UTF-8"%>
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
.addDoorWrap{text-align:center;}
.addDoorWrap>h3{}
.addDoorWrap>hr{margin:20px auto;}
.addDoorWrap .pop{width:400px;margin:0 auto;border:1px solid;border-bottom:0;}
.addDoorWrap .pop>li{border-bottom:1px solid;}
.addDoorWrap .pop>li>span{border-right:1px solid;margin-right: 10px;padding: 5px 10px 5px 0;}
.addDoorWrap .pop>li>input{height: 20px;}
.addDoorWrap .pop>li>a{border:1px solid;color:#000;padding: 0 10px;border-radius: 4px;background: #efefef;margin:5px 0;}
</style>
</head>
<body>
<div class='addDoorWrap'>
	<h3>新增门店</h3>
	<hr/>
	<form>
		<ul class='pop'>
			<input type="hidden" name="id" value="${door.id}">
			<li class='flex ai-c jc-c'>
				<span>门店名称</span>
				<input type='text' name='name' value='${door.name}'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>联系电话</span>
				<input type='text' name='tel' value='${door.tel}'/>
			</li>
			<li class='flex ai-c jc-c'>
				<span>门店地址</span>
				<input type='text' name='addr' value='${door.addr}'/>
			</li>
			<li class='flex ai-c jc-c'>
				<a href="javascript:void(0)">提交</a>
			</li>
		</ul>
	</form>
</div>
<script>
	updateInfo();
	function updateInfo(){
		const form = document.querySelector('form');
		const popUl = document.querySelector('.pop');
		const a = popUl.querySelector('a');
		form.action="updateDoorById";
		form.method="post";
		a.addEventListener('click',()=>{
			form.submit();
		});
	}
</script>
</body>
</html>