<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$('#comboboxCountry').on('change', function(){
		var countryId = $('#comboboxCountry option:selected').val();
		alert(countryId);
		
		$.ajax({
			type: 'GET',
			url: 'loadState/' + countryId,
			success: function(result){
				alert(result);
			},
			error:function(){
	            alert("error");
	        }
		});
	});
	
});
/* url: '${pageContext.request.contextPath}/loadState/' + countryId + '.html', */
</script>

</head>
<body>

	<form method="POST">
	<div align="center">
		<label>Country:</label>
		<select id="comboboxCountry">
			<c:forEach var="country" items="${countries }">
				<option value="${country.id }">${country.name }</option>
			</c:forEach>
		</select>
	</div>
	</form>


</body>
</html>