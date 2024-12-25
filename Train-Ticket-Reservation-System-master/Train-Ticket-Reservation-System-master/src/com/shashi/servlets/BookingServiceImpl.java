package com.shashi.servlets;

import java.util.List;

import com.shashi.beans.HistoryBean;
import com.shashi.beans.TrainBean;
import com.shashi.beans.TrainException;
import com.shashi.service.BookingService;

public class BookingServiceImpl implements BookingService {

    @Override
    public HistoryBean bookTrain(TrainBean train, int seats, String seatClass, String userEmail, String journeyDate) {
        // Business logic to perform booking
        double totalAmount = train.getFare() * seats;

        // Create and populate a HistoryBean
        HistoryBean history = new HistoryBean();
//        history.setTr_no(train.getTr_no());
        history.setFrom_stn(train.getFrom_stn());
        history.setTo_stn(train.getTo_stn());
        history.setSeats(seats);
        history.setMailId(userEmail);
        history.setDate(journeyDate);
        history.setAmount(totalAmount);

        // Simulate saving booking and generating transaction ID
        history.setTransId("PNR123456789"); // Replace with actual logic for generating PNR
        return history;
    }

	@Override
	public List<HistoryBean> getAllBookingsByCustomerId(String customerEmailId) throws TrainException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryBean createHistory(HistoryBean bookingDetails) throws TrainException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
