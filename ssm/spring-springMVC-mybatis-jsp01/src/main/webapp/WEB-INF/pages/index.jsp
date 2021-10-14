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
.jc-fs{justify-content: space-around;}
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
html,body{height:100%;}
body{font-size:24px;}
.indexWrap{height:100%;}
.indexTop{color:#fff;background:#3c8dbc;padding:20px;}
.indexTop>span{cursor:pointer;}
.indexBottom{}
.indexLeft{background:#222d32;}
.indexLeft>span{display:block;color:#fff;cursor:pointer;padding:20px;border-bottom:1px solid #fff;}
.indexLeft>span:hover{background:#5c7784;}
.indexRight{padding:20px;}
.indexRight>iframe{display:none;}
</style>
</head>
<body>
	<div class='indexWrap flex fd-c'>
		<div class='indexTop f-n'>
			<span>汉堡王管理系统</span>			
		</div>
		<div class='indexBottom f-a flex'>
			<div class='indexLeft f-n'>
				<span to='doorPage'>门店管理</span>
				<span to='orderPage'>订单管理</span>
			</div>
			<div class='indexRight f-a'>
				<span>欢迎登录汉堡王管理系统</span>				
				<iframe src='' frameborder=0 width=100% height=100%></iframe>
			</div>
		</div>
	</div>
	<script>
		leftNavToggle();
		function leftNavToggle(){
			const indexRight = document.querySelector(".indexRight");
			//console.log(indexRight);
			const span = indexRight.querySelector("span");
			const iframe = indexRight.querySelector("iframe");
			//console.log(iframe);
			const leftNav = document.querySelector(".indexLeft");
			const leftBtns = leftNav.querySelectorAll("span");
			//console.log(leftBtns[0].getAttribute('to'));
			for(let i=0;i<leftBtns.length;i++){
				leftBtns[i].addEventListener("click",()=>{
					//console.log(leftBtns[i].getAttribute('to'));
					setTimeout(()=>{
						span.style.display='none';
						iframe.style.display='block';
					},0);
					const mySrc = leftBtns[i].getAttribute('to');
					iframe.setAttribute('src',mySrc);
				});
			}
			const logoWrap = document.querySelector('.indexTop');
			const logo = logoWrap.querySelector('span');
			logo.addEventListener("click",()=>{				
				setTimeout(()=>{
					span.style.display='block';
					iframe.style.display='none';
					iframe.setAttribute('src','');
				},0);
			});
		}
	</script>
</body>
</html>