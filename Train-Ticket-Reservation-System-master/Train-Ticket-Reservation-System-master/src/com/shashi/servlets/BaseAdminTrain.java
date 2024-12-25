package com.shashi.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainException;
import com.shashi.constant.UserRole;
import com.shashi.service.TrainService;
import com.shashi.utility.TrainUtil;

public abstract class BaseAdminTrain extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	    private TrainService trainService;

	    public BaseAdminTrain() {
	        this.trainService = createTrainService(); 
	    }
	    protected abstract TrainService createTrainService();
	    protected abstract String handleOperation(HttpServletRequest req) throws Exception;
	    protected abstract String getPage();
	    protected abstract String generateSuccessMessage(String message, HttpServletRequest req);
	    protected abstract String generateErrorMessage(String message, HttpServletRequest req);

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        res.setContentType("text/html");
	        PrintWriter pw = res.getWriter();

	        TrainUtil.validateUserAuthorization(req, UserRole.ADMIN);

	        try {
	            String message = handleOperation(req);
	            if (message.equalsIgnoreCase("SUCCESS")) {
	                RequestDispatcher rd = req.getRequestDispatcher(getPage());
	                rd.include(req, res);
	                pw.println(generateSuccessMessage(message, req));
	            } else {
	                RequestDispatcher rd = req.getRequestDispatcher(getPage());
	                rd.include(req, res);
	                pw.println(generateErrorMessage(message, req));
	            }
	        } catch (Exception e) {
	            throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
	        }
	    }

	    protected TrainService getTrainService() {
	        return trainService;
	    }
}
