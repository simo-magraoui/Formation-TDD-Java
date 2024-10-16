package org.example.service;

class FixedDiscountService implements DiscountService {
    private double montantReduction;

    public FixedDiscountService(double montantReduction) {
        this.montantReduction = montantReduction;
    }

    @Override
    public double appliquerReduction(double montant) {
        if (montant >= montantReduction) {
            return montantReduction;
        } else {
            return montant;
        }
    }
}
