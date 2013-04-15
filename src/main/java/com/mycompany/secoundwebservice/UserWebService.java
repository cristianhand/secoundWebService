/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.secoundwebservice;

import com.entity.User;
import com.persistence.UserDAO;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author hand
 */
@WebService(serviceName = "UserWebService")
public class UserWebService {

    private @Resource
    WebServiceContext webServiceContext;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "saveUser")
    public Long saveUser(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        Long id;
        UserDAO uDao = null;
        id = uDao.saveUser(user);
        return id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    @Oneway
    public void updateUser(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        UserDAO uDao = null;
        uDao.updateUser(user);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    @Oneway
    public void deleteUser(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        UserDAO uDao = null;
        uDao.deleteUser(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchUserId")
    public User searchUserId(@WebParam(name = "idUser") int idUser) {
        //TODO write your implementation code here:
        User user = null;
        UserDAO uDao = null;
        user = uDao.searchUserId(idUser);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchUserbyUserName")
    public User searchUserbyUserName(@WebParam(name = "userName") String userName, @WebParam(name = "columName") String columName) {
        //TODO write your implementation code here:
        User user = null;
        UserDAO uDao = null;
        user = uDao.searchUserbyUserName(columName, userName);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserList")
    public ArrayList getUserList() {
        //TODO write your implementation code here:
        ArrayList<User> userList = null;
        UserDAO uDao = new UserDAO();
        userList = (ArrayList<User>) uDao.getUserList();
        return userList;
    }

    /**
     * Get ServletContext.
     *
     * @return ServletContext object
     */
    private ServletContext getServletContext() {
        return (ServletContext) webServiceContext.getMessageContext().get(
                MessageContext.SERVLET_CONTEXT);
    }
}
