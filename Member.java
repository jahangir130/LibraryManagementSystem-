package library;

import java.util.ArrayList;
import java.util.List;

//--Jahangir--BUBT_CSE_55_8--//
public class Member {
    private String memberId, name, email;
    private List<Loan> loans = new ArrayList<>();

    public Member(String memberId, String name, String email) {
        this.memberId = memberId; this.name = name; this.email = email;
    }
    public Loan borrowItem(String itemId, Library library) {
        return library.issueItem(itemId, memberId);
    }
    public void returnItem(String loanId, Library library) {
        library.returnItem(loanId);
    }
    public List<LibraryItem> getBorrowedItems() {
        List<LibraryItem> result = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getItem().getStatus().equals("Borrowed")) result.add(loan.getItem());
        }
        return result;
    }
    public String getMemberId() { return memberId; }
    public void addLoan(Loan loan) { loans.add(loan); }
}
