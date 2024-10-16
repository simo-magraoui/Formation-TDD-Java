package com.library.service;

public class LoanManager {
    private final LateFeeCalculationStrategy lateFeeCalculationStrategy;

    public LoanManager(LateFeeCalculationStrategy lateFeeCalculationStrategy) {
        this.lateFeeCalculationStrategy = lateFeeCalculationStrategy;
    }

    public double calculateLateFee(int daysLate) {
        return lateFeeCalculationStrategy.calculateLateFee(daysLate);
    }
}
