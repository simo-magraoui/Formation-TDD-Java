package com.library.service;

public class ShortTermLateFeeCalculationStrategy implements LateFeeCalculationStrategy {
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50; // 0.50$ par jour de retard
    }
}
