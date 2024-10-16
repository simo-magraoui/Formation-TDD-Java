package com.library;

import com.library.service.LoanManager;
import com.library.service.ShortTermLateFeeCalculationStrategy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanManagerTest {
    private LoanManager loanManager;

    @BeforeEach
    public void setUp() {
        loanManager = new LoanManager(new ShortTermLateFeeCalculationStrategy());
    }

    @Test
    void testCalculateLateFee() {
        double lateFee = loanManager.calculateLateFee(3);
        assertEquals(1.5, lateFee, 0.001);
    }
}
