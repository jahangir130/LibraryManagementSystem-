package library;

//--Jahangir--BUBT_CSE_55_8--//
public class Book implements LibraryItem {
    private String isbn, title, author, publisher;
    private boolean borrowed;

    public Book(String isbn, String title, String author, String publisher) {
        this.isbn = isbn; this.title = title; this.author = author;
        this.publisher = publisher; this.borrowed = false;
    }
    public String getId() { return isbn; }
    public String getTitle() { return title; }
    public String getStatus() { return borrowed ? "Borrowed" : "Available"; }
    public void markBorrowed() { borrowed = true; }
    public void markReturned() { borrowed = false; }
}
