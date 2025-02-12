package com.example.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.OrderService;
import com.example.PaymentService;

class OrderServiceIntegrationTest {
    @Test
    void testPlaceOrder() {
        PaymentService paymentService = Mockito.mock(PaymentService.class);
        Mockito.when(paymentService.processPayment("item1", 200)).thenReturn(true);

        OrderService orderService = new OrderService(paymentService);
        boolean result = orderService.placeOrder("item1", 2);
        assertTrue(result);

        Mockito.verify(paymentService).processPayment("item1", 200);
    }
}