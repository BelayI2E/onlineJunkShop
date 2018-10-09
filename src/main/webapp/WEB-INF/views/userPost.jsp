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
    </head>
    <body>
        <nav>
            <div class="left">
                <h4>Hello,&nbsp;${name}</h4>
            </div>
            <div class="right">
                <input type="text" placeholder="Enter search..."/>
                <input type="submit" value="Search"/>
                <input type="submit" value="Home" onclick="location.href = '${pageContext.request.contextPath}/home'"/>
                <input type="submit" value="Logout"onclick="location.href = '${pageContext.request.contextPath}/'"/>
            </div>
        </nav>
        <div id="wrapper">
            <section>
                <c:forEach items="${allPostsBy}" var="postItem">
                    <div id="post">
                        <div class="avata">
                            <img src="${pageContext.request.contextPath}/resources/images/avata/${postItem.getAvata()}"/>
                        </div>
                        <div class="name">
                            <a href="${pageContext.request.contextPath}/user/${postItem.getUserId()}"><h4>${postItem.getFirstName()} &nbsp; ${postItem.getLastName()}</h4></a>
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
                            <input class="readMore" type="button" onclick="location.href='${pageContext.request.contextPath}/postDetail/${postItem.getPostId()}'" value="Read More » "/>
                            <input class="buy" type="button"  value="Buy"/>
                            <input class="wishList" type="button"  value="Add to Wish List"/>
                        </div>
                        <div class="picture">
                            <img src="${pageContext.request.contextPath}/resources/images/photo/${postItem.getPostPhoto()}"/>
                        </div>
                        <div id="comment">
                            <div class="commentByAvata">
                                <img  src="${pageContext.request.contextPath}/resources/images/avata/bunna.png"/>
                            </div>
                            <div class="commentByName">
                                <h4>Chhorn Channak</h4>
                                <h6>20 May,2015</h6>
                            </div>
                            <div class="commontText">
                                <p>I want it please sell it to me.</p>
                            </div>
                        </div> 
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
                <h3> ${nam} Recent Posts</h3>
                <ul>
                    <c:forEach items="${recentPosts}" var="posts">
                        <li class="listItem"><a href="#">${posts.getPostTitle()}</a></li>
                        </c:forEach>
                </ul>
            </aside>
        </div>
    </body>
</html>
