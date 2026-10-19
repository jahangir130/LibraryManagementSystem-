package library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//--Jahangir--BUBT_CSE_55_8--//
public class Library {
    private String name;
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Library(String name) { this.name = name; }
    public void addItem(LibraryItem item) { items.add(item); }
    public void addMember(Member member) { members.add(member); }

    public LibraryItem findItem(String id) {
        for (LibraryItem item : items) if (item.getId().equals(id)) return item;
        return null;
    }
    private Member findMember(String id) {
        for (Member member : members) if (member.getMemberId().equals(id)) return member;
        return null;
    }
    public Loan issueItem(String itemId, String memberId) {
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);
        if (item == null || member == null) {
            System.out.println("Item or member not found.");
            return null;
        }
        if (item.getStatus().equals("Borrowed")) {
            System.out.println("Item is already borrowed.");
            return null;
        }
        LocalDate today = LocalDate.now();
        Loan loan = new Loan("L" + (loans.size() + 1), item, member, today, today.plusDays(14));
        item.markBorrowed();
        loans.add(loan);
        member.addLoan(loan);
        System.out.println(item.getTitle() + " borrowed by " + member.getMemberId());
        return loan;
    }
    public void returnItem(String loanId) {
        for (Loan loan : loans) {
            if (loan.getLoanId().equals(loanId)) {
                if (loan.getItem().getStatus().equals("Available")) {
                    System.out.println("This loan has already been returned.");
                } else {
                    loan.markReturned();
                    System.out.println(loan.getItem().getTitle() + " returned successfully.");
                }
                return;
            }
        }
        System.out.println("Loan not found.");
    }
}
