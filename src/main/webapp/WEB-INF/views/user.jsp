<%-- 
    Document   : register
    Created on : May 10, 2015, 3:04:34 PM
    Author     : ubuntu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register login account</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Auction Junk Shop</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css" />
        <script src="${pageContext.request.contextPath}/resources/js/javascript.js"></script>
    </head>
    <body>
        <nav>
            <div class="left">
                <h4>Online Auction Junk Shop!</h4>
            </div>
            <div class="right">
                <input type="submit" value="Home" onclick="location.href = '${pageContext.request.contextPath}/home'"/>
                <input type="submit" value="Logout"onclick="location.href = '${pageContext.request.contextPath}/'"/>
            </div>
        </nav>
        <div class="panes">
            <div class="pane left">
                <form  method="POST">
                    <h4>Detail information of ${name} </h4><br/><br/>
                    <hr style="width: 450px;float: right;margin-right: 50px;margin-top: 25px;"/>
                    <ul style="float: right;margin-right: 50px; text-align: right;list-style-type: none;">
                        <li style="padding: 10px;">First Name : ${user.getFirstName()}</li>
                        <li style="padding: 10px;">Last Name : ${user.getLastName()}</li>
                        <li style="padding: 10px;">Gender : ${user.getGender()}</li>
                        <li style="padding: 10px;">Birthdate : ${user.getBirthdate()}</li>
                        <li style="padding: 10px;">Email : ${user.getEmail()}</li>
                    </ul>
                </form>
            </div>
            <div class="pane right">
                <form  method="POST">
                    <h4>Send an email to ${name} </h4><br/>
                    <label>Name</label><br/>
                    <input type="text" name="name" placeholder="Enter name..."/><br/>
                    <label>Subject</label><br/>
                    <input type="text" name="subject" placeholder="Enter subject..."/><br/>
                    <label>Email</label><br/>
                    <input type="text" name="email" value="${user.getEmail()}" placeholder="Enter email..."/><br/>
                    <label>Message(Max.1000 words)</label><br/>
                    <textarea name="shortDescription" rows="10"></textarea><br/>
                    <input type="submit" name="send" value="Send"/>
                </form>
            </div>
        </div>
    </body>
</html>