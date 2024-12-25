package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainException;
import com.shashi.constant.ResponseCode;
import com.shashi.constant.UserRole;
import com.shashi.service.TrainService;
import com.shashi.service.impl.TrainServiceImpl;
import com.shashi.utility.TrainUtil;

@WebServlet("/admincancletrain")
public class AdminCancleTrain extends BaseAdminTrain {

	private static final long serialVersionUID = 1L;

	@Override
	protected TrainService createTrainService() {
		return new TrainServiceImpl();
	}

	@Override
	protected String handleOperation(HttpServletRequest req) throws Exception {
		String trainNo = req.getParameter("trainno");
        return getTrainService().deleteTrainById(trainNo);
	}

	@Override
	protected String getPage() {
		 return "CancleTrain.html";
	}

	@Override
	protected String generateSuccessMessage(String message, HttpServletRequest req) {
		 String trainNo = req.getParameter("trainno");
	        return "<div class='main'><p1 class='menu'>Train number " + trainNo + " has been Deleted Successfully.</p1></div>";
	}

	@Override
	protected String generateErrorMessage(String message, HttpServletRequest req) {
		String trainNo = req.getParameter("trainno");
        return "<div class='tab'><p1 class='menu'>Train No." + trainNo + " is Not Available!</p1></div>";
        
	}
	

}
