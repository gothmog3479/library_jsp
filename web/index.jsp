<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Онлайн библиотека:Вход</title>
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

    <div class="content">
        <p class="title"><span class="text"><img src="resources/images/lib.png" width="76" height="77" hspace="10" vspace="10"
                                                 align="middle"></span></p>
        <p class="title">Онлайн библиотека</p>
        <p class="text">Добро пожаловать в онлайн библиотеку, где вы сможете найти любую книгу на ваш вкус. Доступны
            функции поиска, просмотра, сортировки и многие другие.Для регистрации пройдите по ссылке <input type="button" value="Регистрация" name="registration" onclick="openPage('registration.jsp')"/></p>
        <p class="text">Проект находится в разработке, поэтому дизайн и функционал будет постоянно дорабатываться.</p>
        <p class="text">По всем вопросам обращайтесь по адресу <a href="mailto:support@testlibrary.com">support@testlibrary.com</a>
        </p>
        <p>&nbsp;</p>

    </div>
    <script type="text/javascript">
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>
    <div class="login_div">
        <p class="title">Для входа введит свои данные:</p>
        <form class="login_form" name="username" action="pages/main.jsp" method="POST">
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
