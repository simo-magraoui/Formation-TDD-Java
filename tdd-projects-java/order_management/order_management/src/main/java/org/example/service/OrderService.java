package org.example.service;

import org.example.model.Commande;

class OrderService {
    private DiscountService serviceReduction;

    public OrderService(DiscountService serviceReduction) {
        this.serviceReduction = serviceReduction;
    }

    public double calculerTotalCommande(Commande commande) {
        double prixTotal = commande.calculerPrixTotal();
        double reduction = serviceReduction.appliquerReduction(prixTotal);
        return prixTotal - reduction;
    }
}
