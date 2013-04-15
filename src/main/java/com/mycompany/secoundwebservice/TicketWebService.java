/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.secoundwebservice;

import com.entity.Ticket;
import com.persistence.TicketDAO;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hand
 */
@WebService(serviceName = "TicketWebService")
public class TicketWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchTicketId")
    public Ticket searchTicketId(@WebParam(name = "ticketId") int ticketId) {
        //TODO write your implementation code here:
        Ticket tk = null;
        TicketDAO tDao = new TicketDAO();
        tk = tDao.searchTicketId(ticketId);
        return tk;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "saveTicket")
    public Long saveTicket(@WebParam(name = "ticket") Ticket ticket) {
        //TODO write your implementation code here:
        Long id;
        TicketDAO tDao = new TicketDAO();
        id = tDao.saveTicket(ticket);
        return id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateTicket")
    @Oneway
    public void updateTicket(@WebParam(name = "ticket") Ticket ticket) {
        //TODO write your implementation code here:
        TicketDAO tDao = new TicketDAO();
        tDao.updateTicket(ticket);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteTicket")
    @Oneway    
    public void deleteTicket(@WebParam(name = "ticket") Ticket ticket) {
        //TODO write your implementation code here:
        TicketDAO tDao = new TicketDAO();
        tDao.deleteTicket(ticket);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchTicketUserName")
    public Ticket searchTicketUserName(@WebParam(name = "userName") String userName) {
        //TODO write your implementation code here:
        Ticket tk = null;
        TicketDAO tDao = new TicketDAO();
        tk = tDao.searchTicketUserName(userName);
        return tk;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTicketList")
    public ArrayList getTicketList() {
        //TODO write your implementation code here:
        ArrayList<Ticket> ticketList = null;
        TicketDAO tDao = new TicketDAO();
        ticketList = (ArrayList<Ticket>) tDao.getTicketList();
        return ticketList;
    }
}