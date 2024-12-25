package com.shashi.factory;

import com.shashi.service.BookingService;
import com.shashi.service.TrainService;
import com.shashi.service.impl.BookingServiceImpl;
import com.shashi.service.impl.TrainServiceImpl;

public class ServiceFactory {

    // Factory methods to provide service instances
    public static TrainService getTrainService() {
        return new TrainServiceImpl();
    }

    public static BookingService getBookingService() {
        return new BookingServiceImpl();
    }
}
