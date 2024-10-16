package org.example.model;

public class Produit {
    private String nom;
    private double prix;
    private int quantité;

    public Produit(String nom, double prix, int quantité) {
        this.nom = nom;
        this.prix = prix;
        this.quantité = quantité;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantité() {
        return quantité;
    }
}
