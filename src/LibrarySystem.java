
import java.util.Scanner;
/**
 *
 * LibrarySystem 
 */
public class LibrarySystem {
        


    // Data structure for library
    static String[] bookTitles = new String[100];
    static String[] bookDescriptions = new String[100];
    static boolean[] bookIssued = new boolean[100];
    static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n-- Library Management System --");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Issue a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Manage Array of Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook(scanner);
                    break;
                case 4:
                    issueBook(scanner);
                    break;
                case 5:
                    returnBook(scanner);
                    break;
                case 6:
                    manageBookArray(scanner);
                    break;
                case 7:
                    System.out.println("Exiting the library system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add a book
    public static void addBook(Scanner scanner) {
        if (bookCount >= bookTitles.length) {
            System.out.println("Error: No space available in the library to add a new book.");
            return;
        }
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book description: ");
        String description = scanner.nextLine();

        bookTitles[bookCount] = title;
        bookDescriptions[bookCount] = description;
        bookIssued[bookCount] = false;
        bookCount++;
        System.out.println("Book added successfully.");
    }

    // Display all books
    public static void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books available in the library.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.println("Title: " + bookTitles[i]);
            System.out.println("Description: " + bookDescriptions[i]);
            System.out.println("Issued: " + (bookIssued[i] ? "Yes" : "No"));
            System.out.println();
        }
    }

    // Search for a book
    public static void searchBook(Scanner scanner) {
        System.out.println("Search by: \n1. Title\n2. ID");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice == 1) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            for (int i = 0; i < bookCount; i++) {
                if (bookTitles[i].equalsIgnoreCase(title)) {
                    printBookDetails(i);
                    return;
                }
            }
            System.out.println("Book not found.");
        } else if (choice == 2) {
            System.out.print("Enter book ID: ");
            int id = scanner.nextInt();
            if (id > 0 && id <= bookCount) {
                printBookDetails(id - 1);
            } else {
                System.out.println("Invalid ID or book not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Issue a book
    public static void issueBook(Scanner scanner) {
        System.out.print("Enter book ID to issue: ");
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

    // Return a book
    public static void returnBook(Scanner scanner) {
        System.out.print("Enter book ID to return: ");
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

    // Manage books using array
    public static void manageBookArray(Scanner scanner) {
        String[][] books = {
            {"Arabic", "This book is for learning Arabic language"},
            {"German", "This book is for learning German language"},
            {"English", "This book is for learning English language"},
            {"French", "This book is for learning French language"}
        };

        System.out.println("Array of Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Title: " + books[i][0] + ", Description: " + books[i][1]);
        }

        System.out.print("Choose the book to delete: ");
        String bookToDelete = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i][0].equalsIgnoreCase(bookToDelete)) {
                found = true;
                String[][] newBooks = new String[books.length - 1][2];
                int index = 0;
                for (int j = 0; j < books.length; j++) {
                    if (!books[j][0].equalsIgnoreCase(bookToDelete)) {
                        newBooks[index++] = books[j];
                    }
                }
                books = newBooks;
                System.out.println("Book deleted. Updated array:");
                for (String[] book : books) {
                    System.out.println("Title: " + book[0] + ", Description: " + book[1]);
                }
                return;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Print book details
    private static void printBookDetails(int index) {
        System.out.println("Book Found:");
        System.out.println("ID: " + (index + 1));
        System.out.println("Title: " + bookTitles[index]);
        System.out.println("Description: " + bookDescriptions[index]);
        System.out.println("Status: " + (bookIssued[index] ? "Issued" : "Available"));
    }
}

