package com.library.repository;

import com.library.model.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanRepository {

    private List<Loan> loans = new ArrayList<>();

    public boolean save(Loan loan) {
        return loans.add(loan);
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public Optional<Loan> findById(String loanId) {
        return loans.stream()
                .filter(loan -> loan.getId().equals(loanId))
                .findFirst();
    }

    public boolean deleteById(String loanId) {
        return loans.removeIf(loan -> loan.getId().equals(loanId));
    }

    public boolean update(Loan loan) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getId().equals(loan.getId())) {
                loans.set(i, loan);
                return true;
            }
        }
        return false;
    }
}
