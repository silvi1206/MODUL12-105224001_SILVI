// Interface pencarian buku
interface BookSearcher {
    void searchBook(String title);
}

// Interface perhitungan denda
interface FineCalculator {
    double calculateFine(int lateDays);
}

// Interface format struk
interface ReceiptFormatter {
    String formatReceipt(double fine);
}

// Implementasi pencarian buku
class BookSearchService implements BookSearcher {
    public void searchBook(String title) {
        System.out.println("Mencari buku: " + title);
    }
}

// Implementasi perhitungan denda
class StandardFineCalculator implements FineCalculator {
    public double calculateFine(int lateDays) {
        return lateDays * 2000;
    }
}

// Implementasi format struk tabel
class TableReceiptFormatter implements ReceiptFormatter {
    public String formatReceipt(double fine) {
        return "| Total Denda | Rp " + fine + " |";
    }
}

// LibraryManager
public class LibraryManager {

    private BookSearcher searcher;
    private FineCalculator calculator;
    private ReceiptFormatter formatter;

    public LibraryManager(BookSearcher searcher,
                          FineCalculator calculator,
                          ReceiptFormatter formatter) {
        this.searcher = searcher;
        this.calculator = calculator;
        this.formatter = formatter;
    }

    public void searchBook(String title) {
        searcher.searchBook(title);
    }

    public void borrowBook(String memberId, String bookId) {
        System.out.println("Proses peminjaman buku");
    }

    public String generateFineReceipt(int lateDays) {
        double fine = calculator.calculateFine(lateDays);
        return formatter.formatReceipt(fine);
    }

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager(
                new BookSearchService(),
                new StandardFineCalculator(),
                new TableReceiptFormatter()
        );

        manager.searchBook("Java");
        manager.borrowBook("M001", "B001");

        System.out.println(manager.generateFineReceipt(5)
        );
    }
}