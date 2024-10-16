package com.library.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;

class LoanServiceTest {

    private LoanService loanService;
    private LoanRepository loanRepositoryMock;
    private BookRepository bookRepositoryMock;

    @BeforeEach
    void setUp() {
        // Création des mocks pour LoanRepository et BookRepository
        loanRepositoryMock = mock(LoanRepository.class);
        bookRepositoryMock = mock(BookRepository.class);

        // Initialisation de LoanService avec les mocks
        loanService = new LoanService(loanRepositoryMock, bookRepositoryMock);
    }

    @Test
    void testLoanBook() {
        // Préparation des données
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "1");
        book.setAvailable(true);
        User user = new User("1", "John Doe");

        // Configuration du comportement du mock pour save() de BookRepository et
        // LoanRepository
        when(bookRepositoryMock.save(book)).thenReturn(true);
        when(loanRepositoryMock.save(any(Loan.class))).thenReturn(true);

        // Appel de la méthode à tester
        boolean result = loanService.loanBook(book, user);

        // Vérification des résultats
        assertTrue(result); // Vérifie que l'emprunt du livre a réussi

        // Vérifie que les méthodes save() ont été appelées correctement
        verify(bookRepositoryMock, times(1)).save(book);
        verify(loanRepositoryMock, times(1)).save(any(Loan.class));
    }
}
