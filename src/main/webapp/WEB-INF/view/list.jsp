<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/bootstrap/css/index2.css">
<script type="text/javascript" src="resource/css/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="resource/My97DatePicker/WdatePicker.js"></script>
</head>
<!-- 按规模搜索时，“小型企业”的条件是注册资金1-200万元，“中型企业”为201万-1000万元，“大型企业”是大于1000万元，“全部”则将该条件清空。
按类型搜索时，“有限公司”对应公司类型为“有限责任公司”，“股份公司”对应“股份有限公司”，“国企”对应“国有独资企业”，“其它”则对应除上述3个类型外其它所有类型，“全部”则将该条件清空。 -->
<body>
<table>
	<tr>
		<th>公司ID</th>
		<th>公司名称</th>
		<th>营业执照号</th>
		<th>公司法人</th>
		<th>注册资本</th>
		<th>公司类型</th>
		<th>成立时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${info.list }" var="c">
		<tr>
			<td>${c.id }</td>
			<td>${c.name }</td>
			<td>${c.regist_no }</td>
			<td>${c.corporation }</td>
			<td>${c.capital }</td>
			<td>${c.types.tname }</td>
			<td>${c.created }</td>
			<td>
				<button>查看</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>