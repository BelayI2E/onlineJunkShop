/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auction.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.auctionsite.jdbcDaoSupport.PostJdbcDaoSupportDAO;
import org.auctionsite.jdbcDaoSupport.UserJdbcDaoSupportDAO;
import org.auctionsite.model.ActionEntity;
import org.auctionsite.model.CommentInfo;
import org.auctionsite.model.PostEntity;
import org.auctionsite.model.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ubuntu
 */
@Controller
public class HomeController {

    /**
     *
     */
   // @Resource(mappedName = "jms/NewMessageFactory")*/
    private QueueConnectionFactory connectionFactory;
   // @Resource(mappedName = "jms/NewMessage")
    private Queue queue;

    /**
     * This method use for map to the root for OnlineJunkShop application. When
     * ever you open the this application this method will be invoked. In the
     * function definition there are two main part. They are login and register.
     * When the button login in the welcome page is clicked, then the login
     * parameter will have a value. When the button register in the welcome page
     * is clicked, then the register parameter will have a value.
     *
     * @param mav
     * @param login accept the login button click on the welcome page.
     * @param register accept the register button click on the welcome page.
     * @param request accept all the form parameters when submit form button
     * click.
     * @return ModelAndView with some sent parameters to render in view of JSP
     * file called welcome.jsp
     */
    @RequestMapping(value = "/", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView index(
            ModelAndView mav,
            @RequestParam(required = false, value = "login") String login,
            @RequestParam(required = false, value = "register") String register,
            HttpServletRequest request) {
        if (login != null) {
            String logedStatus = null;
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (getUserService().isAbleToLogin(email, password)) {
                setUserId(getUserService().getUserInfo(email, password).getId());
                setFirstName(getUserService().getUserInfo(email, password).getFirstName());
                //System.out.println("Loged true");
                mav.setViewName("redirect:home");
                return mav;
            } else {
                //System.out.println("Loged false");
                logedStatus = "Incorrect email or password";
                mav.addObject("logedStatus", logedStatus);
            }

        } else if (register != null) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String month = request.getParameter("month");
            String date = request.getParameter("date");
            String year = request.getParameter("year");
            Date birthdate = new Date(Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(date));
            String email = request.getParameter("regEmail");
            String password = request.getParameter("regPassword");
            String avata = request.getParameter("avata");
           try {
                try (QueueConnection connection = connectionFactory.createQueueConnection()) {
                    QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                    try (QueueSender sender = session.createSender(queue)) {
                        ObjectMessage message = session.createObjectMessage();
                        // here we create UserEntity, that will be sent in JMS message
                        UserEntity user = new UserEntity();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        user.setGender(gender);
                        user.setBirthdate(birthdate);
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setAvata(avata);
                        user.setPrivilege("user");
                        message.setObject(user);
                       // sender.send(message);
                    }
                }
            } catch (JMSException ex) {
                System.out.println(ex.toString());
            }
            mav.addObject("recentPost", getPostService().getAllRecentPostTitle());
            mav.setViewName("redirect:home");
            return mav;
        }

        mav.setViewName("welcome");
        return mav;
    }

    /**
     * This method use for route to home page. When ever we redirect to home
     * page the definition of this method will be made a query to get all the
     * recent post id, post title on the right hand side. And for the left hand
     * side will list all the past posted which sorted by post date DESC.
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/home", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView home(ModelAndView mav) {

        mav.addObject("name", getFirstName());
        mav.addObject("categoryList", getPostService().getAllCategory());
        mav.addObject("recentPosts", getPostService().getAllRecentPostTitle());
        mav.addObject("allPosts", getPostService().getAllPostInfo());

        List<PostEntity> idList = getPostService().getAllPostId();
        String asList = "";
        for (int i = 0; i < idList.size() - 1; i++) {
            if (i == idList.size() - 2) {
                asList += idList.get(i).getId();
                break;
            }
            asList += idList.get(i).getId() + ",";
        }
        System.out.println("idList: " + asList);
        List<CommentInfo> comments = getPostService().getCommentByPosts(asList);
        mav.addObject("comments", comments);

        ArrayList listComment = null;
        Map<Integer, ArrayList> dictionary = new HashMap<Integer, ArrayList>();
        for (CommentInfo comment : comments) {
            // check by post id
            if (dictionary.get(comment.getCommnentOn()) == null) {
                listComment = new ArrayList();
                dictionary.put(comment.getCommnentOn(), listComment);
            } else {
                // get existing list of comment
                listComment = dictionary.get(comment.getCommnentOn());
            }
            listComment.add(comment);
        }
        for (Object listComment1 : listComment) {
            System.out.println("List: " + listComment1);
        }
        
        System.out.println("List:" + listComment);

        mav.setViewName("home");
        return mav;
    }

    /**
     *
     * @param mav
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "/home/{categoryId}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView home(ModelAndView mav, @PathVariable("categoryId") Long categoryId) {

        mav.addObject("name", getFirstName());
        mav.addObject("categoryList", getPostService().getAllCategory());
        mav.addObject("recentPosts", getPostService().getAllRecentPostTitleInCategory(categoryId));
        mav.addObject("allPosts", getPostService().getAllPostInfoInCategory(categoryId));

        mav.setViewName("home");
        return mav;
    }

    /**
     *
     * @param mav
     * @param request
     * @param post
     * @return
     */
    @RequestMapping(value = "/post", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView post( ModelAndView mav,
            @RequestParam(required = false, value = "post") String post,
            HttpServletRequest request
    ) {

        mav.addObject("name", this.getFirstName());
        mav.addObject("categories", this.getPostService().getAllCategory());
        mav.addObject("newPosts", this.getPostService().getAllPostByUser(getUserId()));
        
        List<PostEntity> idList = getPostService().getAllPostId();
        String asList = "";
        for (int i = 0; i < idList.size() - 1; i++) {
            if (i == idList.size() - 2) {
                asList += idList.get(i).getId();
                break;
            }
            asList += idList.get(i).getId() + ",";
        }
        
        mav.addObject("bookedPosts",getPostService().getAllBookedPost(asList));
        mav.addObject("wishedPosts",getPostService().getAllWishedPost(asList));
        
        if (post != null) {
            String title = request.getParameter("title");
            Date postDate = new Date();
            String shortDescription = request.getParameter("shortDescription");
            String fullDescription = request.getParameter("fullDescription");
            String photoName = request.getParameter("file");
            String price = request.getParameter("price");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String categoryId = request.getParameter("category");
            Long userId = getUserId();//get from session
            try {
                try (QueueConnection connection = connectionFactory.createQueueConnection()) {
                    QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                    try (QueueSender sender = session.createSender(queue)) {
                        ObjectMessage message = session.createObjectMessage();
                        // here we create PostEntity, that will be sent in JMS message
                        PostEntity p = new PostEntity();
                        p.setPostTitle(title);
                        p.setPostDate(postDate);
                        p.setShortDescription(shortDescription);
                        p.setFullDescription(fullDescription);
                        p.setPostPhoto(photoName);
                        p.setStatus("new");
                        p.setPrice(Double.parseDouble(price));
                        p.setPhone(phone);
                        p.setEmail(email);
                        p.setInCategory(Long.parseLong(categoryId));
                        p.setPostBy(userId);
                        message.setObject(p);
                        sender.send(message);

                        //call upload file to the server
                        //System.out.println(fileUpload(file, photo));
                    }
                }
            } catch (JMSException ex) {
                System.err.println(ex.toString());
            }
            mav.setViewName("redirect:home");
        }

        mav.setViewName("post");
        return mav;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView user(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", getFirstName());
        mav.addObject("user", getUserService().findByUserId(id));
        mav.setViewName("user");
        return mav;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/postDetail/{id}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView postDetail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("name", getFirstName());
        mav.addObject("posts", getPostService().findByPostId(id));
        mav.addObject("comments", getPostService().getALLCommentInPost(id));
        Long categoryId = getPostService().getCategoryByPost(id);
        mav.addObject("relatedPosts", getPostService().getAllRelatedPost(categoryId));

        mav.setViewName("postDetail");
        return mav;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/userPost/{id}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public ModelAndView userPost(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", getFirstName());
        mav.addObject("allPostsBy", getPostService().findAllPostByUser(id));
        mav.addObject("recentPosts",getPostService().getAllRecentPostTitle(id));
        mav.setViewName("userPost");
        return mav;
    }
    
    /**
     * 
     * @param postId
     * @return 
     */
    @RequestMapping(value = "/buy/{postId}", method = RequestMethod.GET)
    public void buy(@PathVariable("postId") Long postId) {
        
        this.getPostService().updatePostToBooked(postId);
        ActionEntity action=new ActionEntity();
        action.setActionDate(new Date());
        action.setActionStatus("Booked");
        action.setActionBy(this.getUserId());
        action.setActionOn(postId);
        this.getPostService().insertAction(action);
        
    }
    
    /**
     * 
     * @param postId 
     */
    @RequestMapping(value = "/wish/{postId}", method = RequestMethod.GET)
    public void wish(@PathVariable("postId") Long postId) {
        
        this.getPostService().updatePostToWished(postId);
        ActionEntity action=new ActionEntity();
        action.setActionDate(new Date());
        action.setActionStatus("Wished");
        action.setActionBy(this.getUserId());
        action.setActionOn(postId);
        this.getPostService().insertAction(action);
        
    }

    /**
     *
     */
    private final String XML = "/XMLBeanResources/Spring-Module.xml";
    private UserJdbcDaoSupportDAO userDAO;
    private PostJdbcDaoSupportDAO postDAO;
    private Long id;
    private String name;

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return id;
    }

    public String getFirstName() {
        return name;
    }

    /**
     * This method is use for get the current configuration of XML Bean
     * resource.
     *
     * @return context the context with the specific path given by XML
     * parameter.
     */
    public ApplicationContext getApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext(XML);
        return context;
    }

    /**
     * This method is used to get the service of user which enable user to
     * access to the interface to perform the business transaction such as
     * SELECT, UPDATE, DELETE etc.
     *
     * @return userDAO the interface instance to access to the business methods.
     */
    public UserJdbcDaoSupportDAO getUserService() {
        userDAO = (UserJdbcDaoSupportDAO) getApplicationContext().getBean("userDAO");
        return userDAO;
    }

    /**
     *
     * @return
     */
    public PostJdbcDaoSupportDAO getPostService() {
        postDAO = (PostJdbcDaoSupportDAO) getApplicationContext().getBean("postDAO");
        return postDAO;
    }

}
