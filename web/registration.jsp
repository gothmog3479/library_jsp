<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
        <form class="register_form" name="registration" action="<c:url value="/registration"/>" method="POST">
            <table width="100%" cellpadding="4" cellspacing="2" border=0>
                <tr bgcolor="#1e90ff">
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Фамилия:
                        <input type="text" name="surName" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Имя:
                        <input type="text" name="firstName" value="" size="15" maxlength=30 style="width: 90%; margin: 4px "/>
                    </td>
                    <td  valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Отчество:
                        <input type="text" name="patronymic" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                </tr>
                <tr bgcolor="#1e90ff">
                    <td valign="top" colspan=3 style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Фамилия Имя Отчество:
                        <input type="text" name="fullName" value="" size="15" maxlength=200 style="width: 97%; margin: 4px "/>
                    </td>
                </tr>
                <tr bgcolor="#1e90ff">
                    <td valign="top" colspan=2 style="font-family:Palatino;font-style: italic; font-size: 16px">
                        e-mail:
                        <input type="text" name="email" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Телефон:
                        <input type="text" name="phone" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                </tr>
                <tr bgcolor="#1e90ff">
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Пользователь:
                        <input type="text" name="loginName" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Пароль:
                        <input type="password" name="password" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                    <td valign="top" style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Повторите пароль:
                        <input type="password" name="password" value="" size="15" maxlength=20 style="width: 90%; margin: 4px "/>
                    </td>
                </tr>
                <tr bgcolor="#1e90ff">
                    <td valign="top" colspan=3 style="font-family:Palatino;font-style: italic; font-size: 16px">
                        Вы хотите получать уведомления по электронной почте?
                        <input type="radio" name="notify" value="Yes" checked>Да

                        <input type="radio" name="notify" value="No" > Нет
                    </td>
                </tr>
                <tr bgcolor="#1e90ff">
                    <td  align=center colspan=3>
                        <input type="submit" value="Ок"> <input type="reset" value="Отмена" onclick="openPage('index.jsp')">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script type="text/javascript">
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>
    <div class="footer">
        Разработчик: Дмитрий Грушецкий, 2016 г
    </div>
</div>
</body>
</html>
