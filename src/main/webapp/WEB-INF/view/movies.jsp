<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影列表</title>

<link href="/resource/css/index3.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
//默认的排序方式

var orderMethod ='${movieVO.orderMethod=='asc'?'desc':'asc'}';
function query(orderField){
	location.href="/selects?orderField="+orderField+"&orderMethod="+orderMethod
}


//为下拉框赋值

$(function(){
 //获取查询条件
 var year ='${movieVO.year}';
 $("#year").val(year);
	
})
//全选/反选
function chkAll(flag){
	if(flag==1){//全选
		$(".ck").prop("checked",true);
	}else{//反选
		$(".ck").each(function(){
			this.checked=!this.checked;
		})	
	}
	
	
}
//执行批量删除
function deleteBatch(){
	var ids =new Array();
	//获取选中的电影
	$(".ck:checked").each(function(i){
	   ids[i] =$(this).val();
	});
	//检查是否选中,如果没有选中,则不再执行删除
	if(ids.length==0){
		alert("请至少选中一条");
		return ;
	}
	
	$.post("/deleteBatch",{ids:ids},function(flag){
		if(flag){
			alert("成功");
			location.reload();//重新加载
		}else{
			alert("失败");
		}
	})
}

//更新
function update(id,status){
	$.post("/update",{id:id,status:status},function(flag){
		if(flag){
			alert("成功");
			location.reload();//重新加载
		}else{
			alert("失败");
		}
	})
}
</script>
</head>
<body>

	<form action="/selects" method="post">
		影片名称:<input type="text" name="name" value="${movieVO.name }">
		上映时间:<input type="date" name="startDate" value="${movieVO.startDate }">--
		<input type="date" name="endDate" value="${movieVO.endDate }"><br>
		导演:<input type="text" name="actor" value="${movieVO.actor }">
		价格:<input type="text" name="startPrice" value="${movieVO.startPrice }">--
		<input type="text" name="endPrice" value="${movieVO.endPrice }"><br>
		电影年代:<select name="year" id="year">
			<option value="">请选择</option>
			<option value="2010">2010</option>
			<option value="2012">2012</option>
			<option value="2013">2013</option>
			<option value="2014">2014</option>

		</select> 电影时长<input type="text" name="startLongtime"
			value="${movieVO.startLongtime }">--<input type="text"
			name="endLongtime" value="${movieVO.endLongtime }"><br>
		<button type="submit">查询</button>
		<button type="button" onclick="deleteBatch()">批量删</button>
	</form>


	<table>
		<tr>
			<td><input type="checkbox" onclick="chkAll(1)">全选 <input
				type="checkbox" onclick="chkAll(-1)">反选</td>
			<td>名称</td>
			<td>导演</td>
			<td>票价</td>
			<td><a href="javascript:query('uptime')">上映时间</a></td>
			<td><a href="javascript:query('longtime')">时间长度</a></td>
			<td>类型</td>
			<td><a href="javascript:query('year')">年代</a></td>
			<td>区域</td>
			<td>状态</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${movies }" var="m">

			<tr>
				<td><input type="checkbox" value="${m.id}" class="ck"></td>
				<td>${m.name }</td>
				<td>${m.actor }</td>
				<td>${m.price }</td>
				<td><fmt:formatDate value="${m.uptime }" pattern="yyyy-MM-dd" />
				</td>
				<td>${m.longtime }</td>
				<td>${m.type }</td>
				<td>${m.year }</td>
				<td>${m.area }</td>
				<td>${m.status }</td>
				<td>
					<!--即将上映---热映 --下架  --> <c:if test="${m.status=="热映"}">
						<button type="button" onclick="update('${m.id}','下架')">下架</button>
					</c:if> <c:if test="${m.status=="即将上映"}">
						<button type="button" onclick="update('${m.id}','热映')">热映</button>
					</c:if> <c:if test="${m.status=="下架"}">
						<button type="button" onclick="update('${m.id}','即将上映')">即将上映</button>
					</c:if>
				</td>

			</tr>


		</c:forEach>


	</table>
	${page }

</body>
</html>