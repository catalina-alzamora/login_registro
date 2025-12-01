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
    <!-- Registro -->
    <form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
        <h2>Registrarse</h2>

        <form:label path="nombreUsuario">Nombre de usuario:</form:label>
        <div>
            <form:input path="nombreUsuario"/>
            <form:errors path="nombreUsuario" cssClass="error"/>
        </div>

        <form:label path="fechaNacimiento">Fecha de nacimiento:</form:label>
        <div>
            <form:input path="fechaNacimiento" type="date"/>
            <form:errors path="fechaNacimiento" cssClass="error"/>
        </div>

        <form:label path="nombre">Nombre:</form:label>
        <div>
            <form:input path="nombre"/>
            <form:errors path="nombre" cssClass="error"/>
        </div>

        <form:label path="apellido">Apellido:</form:label>
        <div>
            <form:input path="apellido"/>
            <form:errors path="apellido" cssClass="error"/>
        </div>

        <form:label path="correo">Correo Electrónico:</form:label>
        <div>
            <form:input path="correo"/>
            <form:errors path="correo" cssClass="error"/>
        </div>

        <form:label path="password">Contraseña:</form:label>
        <div>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error"/>
        </div>

        <form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
        <div>
            <form:password path="confirmarPassword"/>
            <form:errors path="confirmarPassword" cssClass="error"/>
        </div>
        
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

</body>
</html>
