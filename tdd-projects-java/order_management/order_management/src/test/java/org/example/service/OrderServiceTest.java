package org.example.service;

import org.example.model.Commande;
import org.example.model.Produit;
import org.junit.jupiter.api.Test; // Import pour l'annotation @Test
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.mockito.Mock; // Import pour l'annotation @Mock

import org.mockito.junit.jupiter.MockitoExtension; // Import pour l'extension Mockito JUnit 5

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*; // Import pour l'assertion assertEquals
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private DiscountService serviceReduction;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testCalculerTotalCommandeSansReduction() {
        Produit produit1 = new Produit("Produit 1", 10.0, 2);
        Produit produit2 = new Produit("Produit 2", 5.0, 1);
        List<Produit> produits = Arrays.asList(produit1, produit2);
        Commande commande = new Commande(produits);

        // Mocker discountService pour retourner une réduction de 0
        when(serviceReduction.appliquerReduction(anyDouble())).thenReturn(0.0);

        double totalAttendu = 25.0;
        double totalReel = orderService.calculerTotalCommande(commande);

        assertEquals(totalAttendu, totalReel);
    }

    @Test
    void testCalculerTotalCommandeAvecReductionFixe() {
        Produit produit1 = new Produit("Produit 1", 20.0, 1);
        Produit produit2 = new Produit("Produit 2", 15.0, 2);
        List<Produit> produits = Arrays.asList(produit1, produit2);
        Commande commande = new Commande(produits);

        // Mocker discountService pour appliquer une réduction fixe de 10
        when(serviceReduction.appliquerReduction(anyDouble())).thenReturn(10.0);

        double totalAttendu = 40.0;
        double totalReel = orderService.calculerTotalCommande(commande);

        assertEquals(totalAttendu, totalReel);
    }

    @Test
    void testCalculerTotalCommandeAvecReductionFixed() {
        Produit produit1 = new Produit("Produit 1", 20.0, 1);
        Produit produit2 = new Produit("Produit 2", 15.0, 2);
        List<Produit> produits = Arrays.asList(produit1, produit2);
        Commande commande = new Commande(produits);

        // Mocker discountService pour appliquer une réduction fixe de 10
        when(serviceReduction.appliquerReduction(anyDouble())).thenReturn(10.0);

        double totalAttendu = 40.0;

        // Utiliser assertEqualsInts pour vérifier la valeur entière du total
        //assertEquals(totalAttendu, orderService.calculerTotalCommande(commande), "Le total de la commande ne correspond pas à la valeur attendue");

        // Vérifier plusieurs valeurs avec assertAll
        assertAll(
                () -> assertEquals(totalAttendu, orderService.calculerTotalCommande(commande),"Total attendu différent du total réel"),
                () -> assertTrue(orderService.calculerTotalCommande(commande) > 0,"Le total de la commande doit être positif"),
                () -> assertFalse(orderService.calculerTotalCommande(commande) < 0,"Le total de la commande doit être positif")
        );
    }

    @Test
    void testCalculerTotalCommandeAvecProduitNull() {
        List<Produit> produits = null;
        Commande commande = new Commande(produits);
        assertThrows(NullPointerException.class, () -> {
            orderService.calculerTotalCommande(commande);
        }, "Un NullPointerException doit être lancé liste de produit vide");
        System.out.println("NullPointerException");
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 'Produit 1'",
            "5.0, 'Produit 2'",
            "10.0, 'Produit 3'",
            "1.0, 'Produit 4'"
    })
    void testCalculerTotalCommandeAvecParametres(double reduction, String nomProduit) {
        // Créer des produits et une commande avec les paramètres fournis
        Produit produit = new Produit(nomProduit, 10.0, 1);
        List<Produit> produits = Arrays.asList(produit);
        Commande commande = new Commande(produits);

        // Mocker discountService pour appliquer la réduction spécifiée
        when(serviceReduction.appliquerReduction(anyDouble())).thenReturn(reduction);
        // Calculer le total de la commande et vérifier le résultat
        double totalAttendu = (10.0 - reduction);
        double totalReel = orderService.calculerTotalCommande(commande);
        assertEquals(totalAttendu, totalReel, 0.01);
    }

    @Test
    void testCalculerTotalCommandeAvecProduitEtReduction() {
        Produit produit1 = new Produit("Produit 1", 20.0, 2);
        Produit produit2 = new Produit("Produit 2", 10.0, 3);
        List<Produit> produits = Arrays.asList(produit1,produit2);
        Commande commande = new Commande(produits);

        // Mocker discountService pour appliquer une réduction de 10
        when(serviceReduction.appliquerReduction(anyDouble())).thenReturn(10.0);

        double totalAttendu = 60.0;
        // Vérifier que la commande contient le produit attendu

        assertThat(commande.getProduits(), contains(produit1,produit2));

        // Vérifier que le prix total de la commande correspond à la valeur attendue
        assertThat(orderService.calculerTotalCommande(commande), is(equalTo(totalAttendu)));
    }

}

