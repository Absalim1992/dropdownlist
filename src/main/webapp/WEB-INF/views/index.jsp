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
		$('#comboboxCity option').remove();
		
		var countryId = $('#comboboxCountry option:selected').val();
		alert(countryId);
		
		$.ajax({
			type: 'GET',
			url: 'loadState/' + countryId,
			success: function(result){
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxState').html(s);
			}
		});
	});
	
	$('#comboboxState').on('change', function(){
		var stateId = $('#comboboxState option:selected').val();
		alert(countryId);
		
		$.ajax({
			type: 'GET',
			url: 'loadCities/' + stateId,
			success: function(result){
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++){
					s += '<option value="'+ result[i].id +'">' + result[i].name + '</option>';
				}
				$('#comboboxCity').html(s);
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
			<option value="-1">Select a Country</option>
			<c:forEach var="country" items="${countries }">
				<option value="${country.id }">${country.name }</option>
			</c:forEach>
		</select><br/>
		
		<label>State:</label>
		<select id="comboboxState">
			
		</select><br/>
		
		<label>City:</label>
		<select id="comboboxCity">
			
		</select><br/>
	</div>
	</form>


</body>
</html>