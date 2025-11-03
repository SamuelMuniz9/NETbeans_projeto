<%-- 
    Document   : login
    Created on : 21 de out. de 2025, 21:13:39
    Author     : alunocmc
--%>

<%@page import="model.DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Empresa</title>
    </head>
    <body>
        <h2>Acessar</h2>
        <%
            //Instância
            UsuarioDAO usuDAO = new UsuarioDAO();
            
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            if (usuDAO.logar(login, senha)){
                out.println("Acesso Permitido!");
                session.setAttribute("autorizado", "sim");
        %>
                <script> window.location.href='menu.jsp'; </script>
        <%
            }else{
                out.println("Acesso Negado!!!");
                session.setAttribute("autorizado", "não");
            }
        
        %>
    </body>
</html>
