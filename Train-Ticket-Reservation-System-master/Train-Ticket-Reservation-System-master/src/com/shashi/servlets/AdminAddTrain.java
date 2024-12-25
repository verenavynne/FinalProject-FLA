package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainBean;
import com.shashi.beans.TrainException;
import com.shashi.constant.ResponseCode;
import com.shashi.constant.UserRole;
import com.shashi.service.TrainService;
import com.shashi.service.impl.TrainServiceImpl;
import com.shashi.utility.TrainUtil;

@WebServlet("/adminaddtrain")
public class AdminAddTrain extends BaseAdminTrain {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected TrainService createTrainService() {
		return new TrainServiceImpl();
	}

	@Override
	protected String handleOperation(HttpServletRequest req) throws Exception {
		TrainBean train = new TrainBean();
        train.setTr_no(Long.parseLong(req.getParameter("trainno")));
        train.setTr_name(req.getParameter("trainname").toUpperCase());
        train.setFrom_stn(req.getParameter("fromstation").toUpperCase());
        train.setTo_stn(req.getParameter("tostation").toUpperCase());
        train.setSeats(Integer.parseInt(req.getParameter("available")));
        train.setFare(Double.parseDouble(req.getParameter("fare")));
        return getTrainService().addTrain(train);
	}

	@Override
	protected String getPage() {
		 return "AddTrains.html";
		 
	}

	@Override
	protected String generateSuccessMessage(String message, HttpServletRequest req) {
		return "<div class='tab'><p1 class='menu'>Train Added Successfully!</p1></div>";
	}

	@Override
	protected String generateErrorMessage(String message, HttpServletRequest req) {
		 return "<div class='tab'><p1 class='menu'>Error in filling the train details.</p1></div>";
	}

	
}
