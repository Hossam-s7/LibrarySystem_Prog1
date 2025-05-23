import java.util.Scanner;
public class App {
    

    private static String[] bookTitles;
    private static String[] bookDescriptions;
    private static boolean[] bookIssued;
    private static int bookCount;
    private static int maxBooks;

    public App(int capacity) {
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
        App library = new App(capacity);

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


    // For the main data
    //static String[] bookTitles = new String[100];
    //static String[] bookDescriptions = new String[100];
    //static boolean[] bookIssued = new boolean[100];
   // static int bookCount = 0;

    public static void main(String[] args) {
        Scanner Basis = new Scanner(System.in);
        int choice;

        do {
            // The main lists
            System.out.println("\n-- <Library Management System >--");
            System.out.println("1. Search for a Book");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Basis.nextInt();

            switch (choice) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        Basis.close();
    }

    // For Search for a Book
    public static void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by: \n1. Title\n2. ID");
        int choice = scanner.nextInt();
        scanner.nextLine(); //For Consume newline
        if (choice == 1) {
            System.out.println("Enter book title:");
            String title = scanner.nextLine();
            boolean found = false;

            for (int i = 0; i < bookCount; i++) {
                if (bookTitles[i] != null && bookTitles[i].equalsIgnoreCase(title)) {
                    System.out.println("Book Found:");
                    System.out.println("ID: " + (i + 1));
                    System.out.println("Title: " + bookTitles[i]);
                    System.out.println("Description: " + bookDescriptions[i]);
                    System.out.println("Status: " + (bookIssued[i] ? "Issued" : "Available"));
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found.");
            }
        } else if (choice == 2) {
            System.out.println("Enter book ID:");
            int id = scanner.nextInt();

            if (id > 0 && id <= bookCount && bookTitles[id - 1] != null) {
                System.out.println("Book Found:");
                System.out.println("ID: " + id);
                System.out.println("Title: " + bookTitles[id - 1]);
                System.out.println("Description: " + bookDescriptions[id - 1]);
                System.out.println("Status: " + (bookIssued[id - 1] ? "Issued" : "Available"));
            } else {
                System.out.println("Invalid ID or book not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // For Issue abook
    public static void issueBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to issue:");
        int id = scanner.nextInt();

        if (id > 0 && id <= bookCount) {
            if (!bookIssued[id - 1]) {
                bookIssued[id - 1] = true;
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Invalid book ID.");
        }
    }

    // For Return a Book
    public static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to return:");
        int id = scanner.nextInt();

        if (id > 0 && id <= bookCount) {
            if (bookIssued[id - 1]) {
                bookIssued[id - 1] = false;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book is not issued.");
            }
        } else {
            System.out.println("Invalid book ID.");
        }
    }
}



