import java.util.Scanner;

public class Test {
    private static String[] bookTitles;
    private static String[] bookDescriptions;
    private static boolean[] bookIssued;
    private static int bookCount;
    private static int maxBooks;

    public Test(int capacity) {
        maxBooks = capacity;
        bookTitles = new String[maxBooks];
        bookDescriptions = new String[maxBooks];
        bookIssued = new boolean[maxBooks];
        bookCount = 0;
    }

    public void addBook(String title, String description) {
        if (bookCount >= maxBooks) {
        System.out.println("Error: No space available in the library to add a new book.");
            return;
        }

        bookTitles[bookCount] = title;
        bookDescriptions[bookCount] = description;
        bookIssued[bookCount] = false;
        bookCount++;
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if(bookCount==0) {
            System.out.println("No books available in the library.");
         return;
        }

        for (int i = 0; i < bookCount; i++) {
            System.out.println("Book " + (i + 1) +":"); 
            System.out.println("Title: " + bookTitles[i]);
            System.out.println("Description: " + bookDescriptions[i]);
            System.out.println("Issued: " + (bookIssued[i]? "Yes" : "No"));
            System.out.println();
}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the library: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Test library = new Library(capacity);

        while(true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
        switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book description: ");
                    String description = scanner.nextLine();
                    library.addBook(title, description);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.println("Exiting the library system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
}
        }
    }
}
