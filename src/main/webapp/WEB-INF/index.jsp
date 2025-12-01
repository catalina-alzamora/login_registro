<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<div class="content">

    <!-- Registro -->
    <form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
        <h2>Registrarse</h2>

        <form:label path="nombreUsuario">Nombre de usuario:</form:label>
        <form:input path="nombreUsuario"/>

        <form:label path="fechaNacimiento">Fecha de nacimiento:</form:label>
        <form:input path="fechaNacimiento" type="date"/>

        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre"/>

        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido"/>

        <form:label path="correo">Correo Electrónico:</form:label>
        <form:input path="correo"/>

        <form:label path="password">Contraseña:</form:label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>

        <form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
        <form:password path="confirmarPassword"/>
        <form:errors path="confirmarPassword" cssClass="error"/>

        <input type="submit" value="Registrarse">
    </form:form>


    <!--Login-->
    <form:form action="/procesa/login" method="POST" modelAttribute="loginUsuario">
        <h2>Iniciar Sesión</h2>

        <form:label path="nombreUsuario">Nombre de usuario:</form:label>
        <form:input path="nombreUsuario"/>

        <form:label path="password">Contraseña:</form:label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>

        <input type="submit" value="Ingresar">
    </form:form>

</div>

</body>
</html>
