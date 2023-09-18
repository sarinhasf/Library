package dao.loan;

import dao.CRUD;
import model.Loan;

public interface LoanDAO extends CRUD<Loan> {
    public void returnLoan(Loan loan);
}
