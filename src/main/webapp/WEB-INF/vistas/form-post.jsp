<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div id="caja1">
			<h1>Trabajo Practico, punto nº5</h1>
			<form:form action="operaciones" method="POST" modelAttribute="formulario">
			<h2>Ingrese un texto</h2>
			Texto:<br/>
            <form:input path="texto" /><br/>		
	            <h2>Ingrese operacion a realizar</h2> 	           
	            <form:radiobutton class="radio" path="operacion"  name="gender" value="Pasar a mayuscula"/> Pasar a Mayuscula<br>
	  			<form:radiobutton path="operacion" name="gender" value="Pasar a Minuscula"/> Pasar a Minuscula<br>
	  			<form:radiobutton path="operacion" name="gender" value="Invertir orden del texto"/> Invertir orden del texto<br>
	  			<form:radiobutton path="operacion" name="gender" value="Cantidad de caracteres del texto"/> Cantidad de caracteres del texto<br/>
     			<form:button class="btn btn-primary" type="submit">Aplicar</form:button>  
            </form:form>
		</div>
		<div>
			<c:if test="${not empty error}">
				${error}
			</c:if>
		</div>
	</body>
</html>