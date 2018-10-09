<%-- 
    Document   : register
    Created on : May 10, 2015, 3:04:34 PM
    Author     : ubuntu
--%>

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
        </nav>
        <div class="panes">
            <div class="pane left">
                <form  method="POST">
                    <h4>Already have a login account</h4><br/><br/>
                    <label>Email</label><br/>
                    <span class="errorLogin">${logedStatus}</span>
                    <input type="text" name="email" placeholder="Enter email address..."/><br/>
                    <label>Password</label><br/>
                    <input type="password" name="password" placeholder="Enter password..."/><br/>
                    <input type="submit" name="login" value="Login"/>
                </form>
            </div>
            
            <div class="pane right">
                <form  method="POST">
                    <h4>Register a new login account</h4><br/>
                    <label>Name</label><br/>
                    <input type="text" class="name" name="firstName" placeholder="Enter first name..."/>
                    <input type="text" class="last name" name="lastName" placeholder="Enter last name..."/><br/>
                    <label>Gender</label>
                    <input type="radio" name="gender" value="male">Male
                    <input type="radio" name="gender" value="female">Female
                    <br/>
                    <label>Birthdate</label><br/>
                    <select class="month" name="month">
                        <option value="0">Month</option>
                        <option value="1">January</option>
                        <option value="2">February</option>
                        <option value="3">March</option>
                        <option value="4">April</option>
                        <option value="5">May</option>
                        <option value="6">June</option>
                        <option value="7">July</option>
                        <option value="8">August</option>
                        <option value="9">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12">December</option>
                    </select>
                    <select class="day" name="date">
                        <option value='10'>Date</option>
                        <%
                            int day;
                            for (day = 1; day <= 31; day++) {
                        %>
                        <option value="<% System.out.print(day); %>"><% System.out.print(day); %></option>
                        <% } %>
                    </select>
                    <select class="year" name="year">
                        <option value='1988'>Year</option>
                        <%
                            int year;
                            for (year = 1945; year <= 2015; year++) {
                        %>
                        <option value="<% System.out.print(year); %>"><% System.out.print(year); %></option>
                        <% }%>
                    </select>
                    <br/>
                    <label>Email</label><br/>
                    <input type="text" name="regEmail" placeholder="Enter email address..."/><br/>
                    <label>Password</label><br/>
                    <input type="password" name="regPassword" placeholder="Enter password..."/><br/>
                    <label>Confirm</label><br/>
                    <input type="password" placeholder="Confirm password..."/><br/>
                    <input type="file" accept='image/*' name="avata"/><br/>
                    <input type="submit" name="register" value="Register"/>
                </form>
            </div>
        </div>
    </body>
</html>