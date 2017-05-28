package com.medical.servlet;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MsgHelper helper=new MsgHelper();
		         String action=request.getParameter("action");
		      
			 if(action.equals("sendMessage")){
				String select= request.getSession().getAttribute("select").toString();
				String patientId=null;
				String doctorId=null;
				String sender=null;
				if(select.equals("Patient")){
				 patientId=request.getSession().getAttribute("patientId").toString();
					 doctorId=request.getParameter("doctorId");
					sender="P";
					
				}else{
					 doctorId=request.getSession().getAttribute("doctorId").toString();
					 patientId=request.getParameter("patientId");
					 sender="D";
					
				}
				List Messages=(List)helper.getMessagesList(patientId,doctorId);	
				request.setAttribute("Messages",Messages);
				request.setAttribute("sender", sender);
				request.setAttribute("select", select);
				request.getRequestDispatcher("Msg.jsp").forward(request, response);
				 
			 }else if(action.equals("createMessage")){
			 String select= request.getSession().getAttribute("select").toString();
			 
			 String patientId=null;
			 String doctorId=null;
			 String sender=null;
			 if(select.equals("Patient")){
				 patientId=request.getSession().getAttribute("patientId").toString();
				  doctorId=request.getParameter("doctorId");
				  sender="P";
			 }else{
				 doctorId=request.getSession().getAttribute("doctorId").toString();
				 patientId=request.getParameter("patientId");
				 sender="D";
			 }
			 System.out.println(patientId);
			  System.out.println(doctorId);
				 String msgBox=request.getParameter("msgBox"); 
				  boolean status=helper.createMessage(Integer.parseInt(patientId),Integer.parseInt(doctorId),msgBox,sender);
		 
				  if(status){
					 String message=null;
					 request.setAttribute("messageSent",message);
					 }
				  List Messages=(List)helper.getMessagesList(patientId,doctorId);	
					request.setAttribute("Messages",Messages);
					request.setAttribute("sender",sender);
				 request.getRequestDispatcher("Msg.jsp").forward(request, response);
			 
			 
		 }else if(action.equals("completeMsgList")){
			 
			 String select=request.getSession().getAttribute("select").toString();
			 String patientId=null;
			 String doctorId=null;
			 List messagesList=null;
			 if(select.equals("Patient")){
				 patientId=request.getSession().getAttribute("patientId").toString();
				 messagesList=(List)helper.getPatientMsgList(patientId);
				 System.out.println(messagesList);
				request.setAttribute("messagesList", messagesList);
				 request.setAttribute("select",select);
				 request.getRequestDispatcher("CompleteMsgList.jsp").forward(request,response);
			 }else{
				 doctorId=request.getSession().getAttribute("doctorId").toString();
				  messagesList=(List)helper.getDoctorMsgList(doctorId); 
				  System.out.println(messagesList);
			       request.setAttribute("messagesList", messagesList);
			       request.setAttribute("select",select);
			       request.getRequestDispatcher("CompleteMsgList.jsp").forward(request,response);
			       
		 }
		 }
			 /*else if(action.equals("conversation")){
			 
			
			 String select= request.getSession().getAttribute("select").toString();
				String doctorId=null;
				String patientId=null;
				String sender=null;
				if(select.equals("Patient")){
				 patientId=request.getSession().getAttribute("patientId").toString();
				 String firstName=request.getParameter("firstName");
				 String lastName=request.getParameter("lastName");
				int	doctorDetails=helper.getDoctorDetails(firstName,lastName);
				 doctorId=Integer.valueOf(doctorDetails).toString();
					sender="P";
					
				}else{
					 doctorId=request.getSession().getAttribute("doctorId").toString();
					 String firstName=request.getParameter("firstName");
					 String lastName=request.getParameter("lastName");
					 int patientDetails =helper.getPatientDetails(firstName,lastName);
					 patientId=Integer.valueOf(patientDetails).toString();
					 sender="D";
					 
					 }
				List Messages=(List)helper.getMessagesList(patientId,doctorId);	
				request.setAttribute("Messages",Messages);
				request.setAttribute("sender", sender);
				request.setAttribute("select", select);
				request.setAttribute("patientId", patientId);
				request.setAttribute("doctorId", doctorId);
				request.getRequestDispatcher("Msg.jsp").forward(request, response);
				 
			 
		 } */
			
	}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
