package app;

import library.Book;
import library.Library;
import library.Loan;
import library.Magazine;
import library.Member;

//--Jahangir--BUBT_CSE_55_8--//
public class Jahangir__20255103295 {
    public static void main(String[] args) {
        Library library = new Library("BUBT Central Library");
        Book book = new Book("CSE_342", "Java Programming", "Herbert Schildt", "McGraw Hill");
        Magazine magazine = new Magazine("MAG_005", "Tech Monthly", 5, "2026-10-01");
        Member member = new Member("Jahangir_295", "Jahangir Alam", "20255103295@cse.bubt.edu.bd");

        library.addItem(book);
        library.addItem(magazine);
        library.addMember(member);

        Loan loan = member.borrowItem("CSE_342", library);
        System.out.println("Book status: " + book.getStatus());
        if (loan != null) member.returnItem(loan.getLoanId(), library);
        System.out.println("Book status after return: " + book.getStatus());
    }
}
