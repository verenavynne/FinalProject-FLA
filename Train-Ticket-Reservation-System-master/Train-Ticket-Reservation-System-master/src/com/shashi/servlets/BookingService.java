package com.shashi.servlets;

import com.shashi.beans.HistoryBean;
import com.shashi.beans.TrainBean;

public interface BookingService {
    HistoryBean bookTrain(TrainBean train, int seats, String seatClass, String userEmail, String journeyDate);
}

