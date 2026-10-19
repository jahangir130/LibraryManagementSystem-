package library;

//--Jahangir--BUBT_CSE_55_8--//
public class Magazine implements LibraryItem {
    private String issn, title, publicationDate;
    private int issueNumber;
    private boolean borrowed;

    public Magazine(String issn, String title, int issueNumber, String publicationDate) {
        this.issn = issn; this.title = title; this.issueNumber = issueNumber;
        this.publicationDate = publicationDate; this.borrowed = false;
    }
    public String getId() { return issn; }
    public String getTitle() { return title; }
    public String getStatus() { return borrowed ? "Borrowed" : "Available"; }
    public void markBorrowed() { borrowed = true; }
    public void markReturned() { borrowed = false; }
}
