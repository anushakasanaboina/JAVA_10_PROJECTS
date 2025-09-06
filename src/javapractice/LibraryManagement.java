import java.util.Scanner;
import java.util.ArrayList;

// User class
class User {
    int id;
    String name;
    String role;
    String password;
}

// Roles class
class Roles {
    String r1 = "student";
    String r2 = "librarian";
}

// Book class
class Book {
    int id;
    String title;
    String author;
    boolean isBorrowed = false;
    int borrowedByUserId = -1; // track who borrowed
}

// Library class
class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(".......WELCOME TO LIBRARY........");
        Roles rl = new Roles();
        Library lib = new Library();

        // Sample books
        Book b1 = new Book(); b1.id = 1; b1.title = "Java"; b1.author = "Anusha";
        Book b2 = new Book(); b2.id = 2; b2.title = "Python"; b2.author = "Rahul";
        Book b3 = new Book(); b3.id = 3; b3.title = "C"; b3.author = "Ravi";

        lib.books.add(b1);
        lib.books.add(b2);
        lib.books.add(b3);

        // Registration
        System.out.println("REGISTER HERE:");
        User ur = new User();


        System.out.print("Enter ID: ");
        ur.id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        ur.name = sc.nextLine();

        System.out.print("Enter Role (student/librarian): ");
        ur.role = sc.nextLine();

        System.out.print("Enter Password: ");
        ur.password = sc.nextLine();

        lib.users.add(ur);

        // Login
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\nLOGIN:");
            System.out.print("Enter your registration ID: ");
            int loginId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter your password: ");
            String loginPass = sc.nextLine();

            if (loginId == ur.id && loginPass.equals(ur.password)) {
                System.out.println("Login successful! Welcome " + ur.name);
                loggedIn = true;
            } else {
                System.out.println("Incorrect ID or password. Try again.");
            }
        }

        // STUDENT MENU
        if (ur.role.equalsIgnoreCase(rl.r1)) {
            int choice;
            do {
                System.out.println("\n----- STUDENT MENU -----");
                System.out.println("1. View Books");
                System.out.println("2. Search Book");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. View Borrowed Books");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: // View all books
                        System.out.println("All Books in Library:");
                        for (Book b : lib.books) {
                            System.out.println(b.id + ". " + b.title + " by " + b.author +
                                    (b.isBorrowed ? " [Borrowed]" : " [Available]"));
                        }
                        break;

                    case 2: // Search book
                        System.out.print("Enter title or author keyword: ");
                        String keyword = sc.nextLine();
                        boolean found = false;
                        for (Book b : lib.books) {
                            if (b.title.toLowerCase().contains(keyword.toLowerCase()) ||
                                b.author.toLowerCase().contains(keyword.toLowerCase())) {
                                System.out.println("Found: " + b.id + ". " + b.title + " by " + b.author +
                                        (b.isBorrowed ? " [Borrowed]" : " [Available]"));
                                found = true;
                            }
                        }
                        if (!found) System.out.println("No books found for: " + keyword);
                        break;

                    case 3: // Borrow book
                        System.out.print("Enter Book ID to borrow: ");
                        int borrowId = sc.nextInt();
                        sc.nextLine();
                        Book bookToBorrow = null;
                        for (Book b : lib.books) {
                            if (b.id == borrowId) {
                                bookToBorrow = b;
                                break;
                            }
                        }
                        if (bookToBorrow == null) {
                            System.out.println("Book not found.");
                        } else if (bookToBorrow.isBorrowed) {
                            System.out.println("Book is already borrowed.");
                        } else {
                            bookToBorrow.isBorrowed = true;
                            bookToBorrow.borrowedByUserId = ur.id;
                            System.out.println("Successfully borrowed: " + bookToBorrow.title);
                        }
                        break;

                    case 4: // Return book
                        System.out.print("Enter Book ID to return: ");
                        int returnId = sc.nextInt();
                        sc.nextLine();
                        Book bookToReturn = null;
                        for (Book b : lib.books) {
                            if (b.id == returnId) {
                                bookToReturn = b;
                                break;
                            }
                        }
                        if (bookToReturn == null) {
                            System.out.println("Book not found.");
                        } else if (!bookToReturn.isBorrowed || bookToReturn.borrowedByUserId != ur.id) {
                            System.out.println("You cannot return this book.");
                        } else {
                            bookToReturn.isBorrowed = false;
                            bookToReturn.borrowedByUserId = -1;
                            System.out.println("Successfully returned: " + bookToReturn.title);
                        }
                        break;

                    case 5: // View borrowed books
                        System.out.println("Your Borrowed Books:");
                        boolean anyBorrowed = false;
                        for (Book b : lib.books) {
                            if (b.isBorrowed && b.borrowedByUserId == ur.id) {
                                System.out.println(b.id + ". " + b.title + " by " + b.author);
                                anyBorrowed = true;
                            }
                        }
                        if (!anyBorrowed) System.out.println("You have not borrowed any books.");
                        break;

                    case 6:
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 6);
        }

        sc.close();
    }
}

