<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Online Auction Junk Shop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Auction Junk Shop</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css" />
        <script src="${pageContext.request.contextPath}/resources/js/javascript.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.min.js"></script>
    </head>
    <body>
        <nav>
            <div class="left">
                <h4>Hello,&nbsp;${name}</h4>
            </div>
            <form method="post">
                <div class="right">
                    <input type="text" placeholder="Enter search..."/>
                    <input type="submit" value="Search"/>
                    <input type="submit" value="Home"/>
                    <input type="submit" value="Logout"onclick="location.href = '${pageContext.request.contextPath}/'"/>
                </div>
            </form>
        </nav>
        <div id="wrapper">
            <section>
                <div id="addPost">
                    <input type="text" placeholder="Enter your post title.."/>
                    <input type="submit" value="Post" onclick="location.href = '${pageContext.request.contextPath}/post'"/>
                </div>
                <c:forEach items="${allPosts}" var="postItem">
                    <div id="post">
                        <div class="avata">
                            <img src="${pageContext.request.contextPath}/resources/images/avata/${postItem.getAvata()}"/>
                        </div>
                        <div class="name">
                            <a href="${pageContext.request.contextPath}/userPost/${postItem.getUserId()}"><h4>${postItem.getFirstName()} &nbsp; ${postItem.getLastName()}</h4></a>
                            <h6>${postItem.getPostDate()}</h6>
                        </div>
                        <div class="title">
                            <h4>${postItem.getPostTitle()}</h4>
                        </div>
                        <div class="content">
                            <p>${postItem.getShortDescription()}</p>
                            <h6>Price: ${postItem.getPrice()}</h6>
                            <h6>Tel: ${postItem.getPhone()}</h6>
                            <h6>Email: ${postItem.getEmail()}</h6>
                            <input class="readMore" type="button" onclick="location.href = '${pageContext.request.contextPath}/postDetail/${postItem.getPostId()}'" value="Read More » "/>
                            <input class="buy" type="button" onclick="buy(${postItem.getPostId()});" value="Buy"/>
                            <input class="wishList" type="button" onclick="wish(${postItem.getPostId()});" value="Add to Wish List"/>
                        </div>
                        <div class="picture">
                            <img src="${pageContext.request.contextPath}/resources/images/photo/${postItem.getPostPhoto()}"/>
                        </div>
                        <c:forEach items="${comments}" var="comment">
                            <div id="comment">
                                <div class="commentByAvata">
                                    <img  src="${pageContext.request.contextPath}/resources/images/avata/${comment.getAvata()}"/>
                                </div>
                                <div class="commentByName">
                                    <a href="${pageContext.request.contextPath}/userPost/${comment.getUserId()}"><h4>${comment.getFirstName()} &nbsp; ${comment.getLastName()}</h4></a>
                                    <h6>${comment.getCommentDate()}</h6>
                                </div>
                                <div class="commontText">
                                    <p>${comment.getComment()}</p>
                                </div>
                            </div>          
                        </c:forEach>
                        <div class="addCommentAction">
                            <div class="addCommentText">
                                <input type="text" placeholder="Enter your comment..."/>
                            </div>
                            <div class="addComment">
                                <input type="submit" value="Add Comment"/>
                            </div>    
                        </div>
                    </div> 
                </c:forEach>
            </section>
            <aside>
                <h3> Recent Posts</h3>
                <ul>
                    <c:forEach items="${recentPosts}" var="posts">
                        <li class="listItem"><a href="${pageContext.request.contextPath}/postDetail/${posts.getId()}">${posts.getPostTitle()}</a></li>
                        </c:forEach>
                </ul>
                <h3 style="margin-top: 15px;"> Categories</h3>
                <ul>
                    <c:forEach items="${categoryList}" var="category">
                        <li class="listItem"><a href="${pageContext.request.contextPath}/home/${category.getId()}">${category.getCategory()}</a></li>
                        </c:forEach>
                </ul>
            </aside>
        </div>
    </body>
</html>
