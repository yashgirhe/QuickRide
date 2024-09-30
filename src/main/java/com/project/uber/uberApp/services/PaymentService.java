package com.project.uber.uberApp.services;

import com.project.uber.uberApp.entities.Payment;
import com.project.uber.uberApp.entities.Ride;
import com.project.uber.uberApp.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
