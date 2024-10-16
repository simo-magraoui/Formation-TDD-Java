package com.library.service;

public class LongTermLateFeeCalculationStrategy implements LateFeeCalculationStrategy {
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00; // 1.00$ par jour de retard
    }
}
