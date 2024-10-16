package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    @Test
    void testPlaceOrder() {
        PaymentService paymentService = mock(PaymentService.class);
        when(paymentService.processPayment(anyString(), anyInt())).thenReturn(true);

        OrderService orderService = new OrderService(paymentService);
        boolean result = orderService.placeOrder("item1", 2);

        assertTrue(result);
        verify(paymentService).processPayment("item1", 200);
    }
}