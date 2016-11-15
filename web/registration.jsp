<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Онлайн библиотека:Регистрация</title>
    <link href="resources/css/style_index.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
    if (request.getParameter("session") != null && request.getParameter("session").equals("0")) {
        session.invalidate();
        request.getSession(true);
    }
%>
<div class="main">
    <div class="content_register">
        <p class="title"><span class="text"><img src="resources/images/lib.png" width="76" height="77" hspace="10" vspace="10"
                                                 align="middle"></span></p>
        <p class="title">Онлайн библиотека</p>

    </div>
    <div class="register_div">
        <p class="title">Для регистрации введит свои данные:</p>
        <form class="register_form" name="username" action="pages/main.jsp" method="POST">
            <table width="100%" cellpadding="0" cellspacing="0">
                <tr>
                    <td align="right" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Имя:
                    </td>
                    <td align="left">
                        <input type="text" name="username" value="" size="20" style="width: 100%; margin: 2px "/>
                    </td>
                </tr>
                <tr>
                    <td align="right" colspan='2'>
                        <input type="submit" value="Войти" style="margin: 2px"/>
                    </td>
                </tr>
            </table>

        </form>

    </div>

    <div class="footer">
        Разработчик: Дмитрий Грушецкий, 2016 г
    </div>
</div>
</body>
</html>
