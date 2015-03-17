<jsp:directive.include file="/WEB-INF/views/layout/include.jsp"/>
<script type="text/javascript">
 	$( document ).ready(function() {
 		var data = {
 			studentId : 1,
 			 studentName : 'tuan',
 			birthday: '2012-01-10'
 		};
 		$.ajax({
 		    type: "post",
 		    url: "ajax/list1", //your valid url
 		    contentType: "application/json", //this is required for spring 3 - ajax to work
 		   	dataType: 'json',
 		    data: JSON.stringify(data), //json object or array of json objects
 		    success: function(result) {
 		        alert(result);
 		    },
 		    error: function(jqXHR, textStatus, errorThrown){
 		        alert(jqXHR.responseText);
 		    }
 		});
 		});
	</script>
<h1>Hello World!</h1>	
	<div class = "ErrorMsg" id="errorsDisplay" >
	   	<ul>
			<c:forEach items="${errors}" var="error">
				<li><fmt:message key="${error.code}" /> </li>
			</c:forEach>
		</ul>
	</div>
	
	<form action="<c:url value="/student/save"/>" method="post">
		<input type="text" name="studentName"/>
		<input type="submit" value="Save"/>
	</form>
<p>This is the homepage!</p>
