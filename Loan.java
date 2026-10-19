package library;

import java.time.LocalDate;

//--Jahangir--BUBT_CSE_55_8--//
public class Loan {
    private String loanId;
    private LocalDate issueDate, dueDate, returnDate;
    private LibraryItem item;
    private Member member;

    public Loan(String loanId, LibraryItem item, Member member, LocalDate issueDate, LocalDate dueDate) {
        this.loanId = loanId; this.item = item; this.member = member;
        this.issueDate = issueDate; this.dueDate = dueDate; this.returnDate = null;
    }
    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }
    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public String getLoanId() { return loanId; }
    public void markReturned() {
        returnDate = LocalDate.now();
        item.markReturned();
    }
}
