<%-- 
    Document   : post
    Created on : May 10, 2015, 9:21:23 PM
    Author     : ubuntu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %> 
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new post</title>
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
                <h4>List all the previous post of ${name}</h4><br/><br/>
                <div class="table">
                    <table class="order-table table" style="width: 535px;">
                        <thead>
                            <tr>
                                <th colspan="4">All new status posting</th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th colspan="3"><input style="margin-top: 10px; width:267px;height: 25px; margin-right:0px;font-size:14px;" type="search" class="light-table-filter" data-table="order-table" placeholder='Enter search..'></th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${newPosts}" var="newPostItem">
                                <tr>
                                    <td>${newPostItem.getId()}</td>
                                    <td>${newPostItem.getPostTitle()}</td>
                                    <td>${newPostItem.getPostDate()}</td>
                                    <td><a href="${pageContext.request.contextPath}/postDetail/${newPostItem.getId()}" class="button start">View</a> 
                                        <a href="#" class="button delete cd-popup-trigger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <br/>
                <div class="table">
                    <table class="order-table table start">
                        <thead>
                            <tr>
                                <th colspan="6">All booked status posting</th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th colspan="5"><input style="margin-top: 10px; width:267px;height: 25px; margin-right:0px;font-size:14px;" type="search" class="light-table-filter" data-table="order-table" placeholder='Enter search..'></th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Post Date</th>
                                <th>By</th>
                                 <th>Booked On</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${bookedPosts}" var="bookedPostItem">
                                <tr>
                                    <td>${bookedPostItem.getPostId()}</td>
                                    <td>${bookedPostItem.getPostTitle()}</td>
                                    <td>${bookedPostItem.getPostDate()}</td>
                                    <td><a href="${pageContext.request.contextPath}/user/${bookedPostItem.getUserId()}">${bookedPostItem.getFirstName()} &nbsp; ${bookedPostItem.getLastName()}</a></td>
                                    <td>${bookedPostItem.getActionDate()}</td>
                                    <td><a href="/post/${bookedPostItem.getPostId()}" class="button start">&nbsp;View&nbsp;</a> 
                                        <a href="#" class="button delete cd-popup-trigger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <br/>
                <div class="table">
                    <table class="order-table table start">
                        <thead>
                            <tr>
                                <th colspan="6">All wished status posting</th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th colspan="5"><input style="margin-top: 10px; width:267px;height: 25px; margin-right:0px;font-size:14px;" type="search" class="light-table-filter" data-table="order-table" placeholder='Enter search..'></th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Post Date</th>
                                <th>By</th>
                                 <th>Booked On</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${wishedPosts}" var="wishedPostItem">
                                <tr>
                                    <td>${wishedPostItem.getPostId()}</td>
                                    <td>${wishedPostItem.getPostTitle()}</td>
                                    <td>${wishedPostItem.getPostDate()}</td>
                                    <td><a href="${pageContext.request.contextPath}/user/${wishedPostItem.getUserId()}">${wishedPostItem.getFirstName()} &nbsp; ${wishedPostItem.getLastName()}</a></td>
                                    <td>${wishedPostItem.getActionDate()}</td>
                                    <td><a href="/post/${wishedPostItem.getPostId()}" class="button start">&nbsp;View&nbsp;</a> 
                                        <a href="#" class="button delete cd-popup-trigger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="pane right">
                <h4>Create a new posting</h4><br/>
                <form method="POST">
                    <label>Title</label><br/>
                    <input type="text" name="title" required placeholder="Enter post's title..."><br/>
                    <label class="category" name="category">Post in category</label>
                    <select class="category" name="category">
                        <option value="0">Category</option>
                        <c:forEach items="${categories}" var="category">
                        <option value="${category.getId()}">${category.getCategory()}</option>
                       </c:forEach>
                    </select>
                    <br/>
                    <label>Short Description(Max.100 words)</label><br/>
                    <textarea name="shortDescription" required rows="3"></textarea><br/>
                    <label>Full Description(Max.500 words)</label><br/>
                    <textarea name="fullDescription" required rows="6"></textarea><br/>
                    <input type="file" name="file" accept='image/*'/><br/>
                    <label>Price</label><br/>
                    <input type="text" name="price" required placeholder="Enter price..."><br/>
                    <label>Phone</label><br/>
                    <input type="text" name="phone" required placeholder="Enter phone number..."><br/>
                    <label>Email</label><br/>
                    <input type="text" name="email" required placeholder="Enter email address..."><br/>
                    <input type="submit" name="post" value="Post"/>
                </form>
            </div>
        </div>
        <script>
            var collapsed = 0;
            (function (document) {
                'use strict';
                var LightTableFilter = (function (Arr) {
                    var _input;
                    function _onInputEvent(e) {
                        _input = e.target;
                        var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                        Arr.forEach.call(tables, function (table) {
                            Arr.forEach.call(table.tBodies, function (tbody) {
                                Arr.forEach.call(tbody.rows, _filter);
                            });
                        });
                    }
                    function _filter(row) {
                        var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                        row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
                    }
                    return {
                        init: function () {
                            var inputs = document.getElementsByClassName('light-table-filter');
                            Arr.forEach.call(inputs, function (input) {
                                input.oninput = _onInputEvent;
                            });
                        }
                    };
                })(Array.prototype);
                document.addEventListener('readystatechange', function () {
                    if (document.readyState === 'complete') {
                        LightTableFilter.init();
                    }
                });
            })(document);
            function pic1()
            {
                document.getElementById("loading").src = "../static/img/loadingMap1.gif";
                document.getElementById("loadingTxt").innerHTML = "Please wait ... <br> Loading map file needs some minutes...";
            }
        </script>
    </script>            
</body>
</html>
