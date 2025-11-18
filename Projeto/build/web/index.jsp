
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<%@page import="dao.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="d-flex align-items-center justify-content-center vh-100 bg-light">
    <main class="form-signin text-center bg-white p-5 rounded shadow" style="width: 360px;">
        <form action="LoginServlet" method="post">
            <img class="mb-4" src="https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg"
                 alt="" width="72" height="57" />
            <h1 class="h4 mb-3 fw-normal">Acesse sua conta</h1>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingUser" name="usuario"
                       placeholder="Usuário" required>
                <label for="floatingUser">Usuário</label>
            </div>

            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" name="senha"
                       placeholder="Senha" required>
                <label for="floatingPassword">Senha</label>
            </div>

            <button class="btn btn-primary w-100 py-2" type="submit">Entrar</button>

            <p class="mt-4 mb-0 text-muted">&copy; 2025 - Sistema De Estoque </p>

            <%-- Mostra erro, se houver --%>
            <%
                String erro = (String) request.getAttribute("erro");
                if (erro != null) {
            %>
                <div class="alert alert-danger mt-3"><%= erro %></div>
            <%
                }
            %>
        </form>
    </main>
</body>
</html>