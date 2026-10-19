package library;

//--Jahangir--BUBT_CSE_55_8--//
public interface LibraryItem {
    String getId();
    String getTitle();
    String getStatus();
    void markBorrowed();
    void markReturned();
}
