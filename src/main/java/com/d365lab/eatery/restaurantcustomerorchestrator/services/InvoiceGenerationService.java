package com.d365lab.eatery.restaurantcustomerorchestrator.services;

import com.d365lab.eatery.restaurantcustomerorchestrator.model.OrderInvoice;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceGenerationService {

    OrderInvoice generateInvoice(Integer restaurantOrderId);

}
