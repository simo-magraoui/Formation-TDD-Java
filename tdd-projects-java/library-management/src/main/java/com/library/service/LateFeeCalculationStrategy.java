package com.library.service;

public interface LateFeeCalculationStrategy {
    double calculateLateFee(int daysLate);
}
