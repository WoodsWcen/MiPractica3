<%@page import="com.emergentes.entidades.Contacto"%>
<%
    Contacto con = (Contacto) request.getAttribute("contacto");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CONTACTO</h1>

        <form action="MainController" method="post">
            <input type="hidden" name="id" value="<%=con.getId() %>">
            <label>Nombre: </label>
            <input type="text" name="nombre" value="<%=con.getNombre() %>"><br><br>
            <label>Correo: </label>
            <input type="text" name="correo" value="<%=con.getCorreo() %>"><br><br>
            <label>Telefono: </label>
            <input type="text" name="telefono" value="<%=con.getTelefono() %>"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
