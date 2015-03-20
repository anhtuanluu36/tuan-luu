<jsp:directive.include file="/WEB-INF/views/layout/include.jsp" />
<fmt:setLocale value="fr"/>
<fmt:setBundle basename="messages.student" var="msg"/>
<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			studentId : 1,
			studentName : 'tuan',
			birthday : '2012-01-10'
		};
		$.ajax({
			type : "post",
			url : "ajax/list1", //your valid url
			contentType : "application/json", //this is required for spring 3 - ajax to work
			dataType : 'json',
			data : JSON.stringify(data), //json object or array of json objects
			success : function(result) {
				alert(result.status);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			}
		});
	});
</script>
<h1>Hello World!</h1>
<fmt:message key="name.required" bundle="${msg}"/>
<div class="ErrorMsg" id="errorsDisplay">
	<ul>
		<c:forEach items="${errors}" var="error">
			<li><fmt:message key="${error.code}" bundle="${msg}"/></li>
		</c:forEach>
	</ul>
</div>

<form action="<c:url value="/student/save"/>" method="post">
	<input type="text" name="studentName" /> <input type="submit"
		value="Save" />
</form>

<table>
	<thead>
		<tr>
			<th>Student Name</th>
			<th>Birthday</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.studentName}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${student.birthday}" /></td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<p>This is the homepage!</p>
