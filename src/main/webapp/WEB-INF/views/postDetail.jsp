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
                <input type="submit" value="Home" onclick="location.href = '${pageContext.request.contextPath}/home'"/>
                <input type="submit" value="Logout" onclick="location.href = '${pageContext.request.contextPath}/'"/>
            </div>
        </nav>
        <div id="wrapper">
            <section>
                <div id="addPost">
                    <input type="text" placeholder="Enter your post title.."/>
                    <input type="submit" value="Post" onclick="location.href = '${pageContext.request.contextPath}/post'"/>
                </div>
                <div id="post">
                    <div class="avata">
                        <img src="${pageContext.request.contextPath}/resources/images/avata/${posts.getAvata()}"/>
                    </div>
                    <div class="name">
                        <a href="${pageContext.request.contextPath}/userPost/${posts.getUserId()}"><h4>${posts.getFirstName()} &nbsp; ${posts.getLastName()}</h4></a>
                        <h6>${posts.getPostDate()}</h6>
                    </div>
                    <div class="title">
                        <h4>${posts.getPostTitle()}</h4>
                    </div>
                    <div class="content">
                        <p>${posts.getShortDescription()}</p>
                        <h6>Price: ${posts.getPrice()}</h6>
                        <h6>Tel: ${posts.getPhone()}</h6>
                        <h6>Email: ${posts.getEmail()}</h6>
                        <input class="buy" style="margin: 10px 5px 0px 60px; width: 170px;" type="button"  value="Buy"/>
                        <input class="wishList" style="width: 170px;" type="button"  value="Add to Wish List"/>
                    </div>
                    <div class="picture">
                        <img src="${pageContext.request.contextPath}/resources/images/photo/${posts.getPostPhoto()}"/>
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
            </section>
            <aside>
                <h3> Related Posts</h3>
                <ul>
                    <c:forEach items="${relatedPosts}" var="relatedPost">
                    <li class="listItem"><a href="${pageContext.request.contextPath}/postDetail/${relatedPost.getId()}">${relatedPost.getPostTitle()}</a></li>  
                    </c:forEach>
                </ul>
            </aside>
        </div>
    </body>
</html>
