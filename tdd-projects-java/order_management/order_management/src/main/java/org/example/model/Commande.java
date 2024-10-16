package org.example.model;
import java.util.Objects; // Import pour la classe Objects
import java.util.List; // Import pour la classe List

public class Commande {
    private List<Produit> produits;
    public Commande(List<Produit> produits) {
        this.produits = produits;
    }
    public double calculerPrixTotal() {
        double prixTotal = 0.0;
        for (Produit produit : produits) {
            prixTotal += produit.getPrix() * produit.getQuantité();
        }
        return prixTotal;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
