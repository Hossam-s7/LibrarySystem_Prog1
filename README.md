# 📚 Library Management System — Java

A console-based Library Management System built with **Java**, allowing users to add, search, issue, return, and manage books through an interactive terminal menu.

---

## 📌 Project Overview

This project implements a simple library system using Java arrays to store book data. It was developed across multiple iterations, progressively adding more features and improving code structure.

---

## 🗂️ Project Structure

```
LibrarySystem/
│
├── App.java              # Version 1 — Basic add & display + search/issue/return
├── LibrarySystem.java    # Version 2 — Full system with array management
├── LibrarySystem1.java   # Version 3 — Enhanced array management with edit feature
└── Test.java             # Version 4 — OOP-based approach with capacity constructor
```

---

## 🛠️ Technologies Used

| Tool | Purpose |
|------|---------|
| **Java** | Core programming language |
| **Scanner** | Reading user input from terminal |
| **Arrays** | Storing book data (titles, descriptions, status) |

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or later installed

### Compile & Run

```bash
# Compile
javac LibrarySystem.java

# Run
java LibrarySystem
```

> You can replace `LibrarySystem.java` with any of the other files to run a different version.

---

## 📋 Features by File

### `App.java` — Basic Library
| Feature | Supported |
|---------|-----------|
| Add a book | ✅ |
| Display all books | ✅ |
| Search by title or ID | ✅ |
| Issue a book | ✅ |
| Return a book | ✅ |
| Dynamic capacity (user sets max) | ✅ |

---

### `LibrarySystem.java` — Full System
| Feature | Supported |
|---------|-----------|
| Add a book | ✅ |
| Display all books | ✅ |
| Search by title or ID | ✅ |
| Issue a book | ✅ |
| Return a book | ✅ |
| Manage & delete from book array | ✅ |

---

### `LibrarySystem1.java` — Enhanced System
| Feature | Supported |
|---------|-----------|
| All features of LibrarySystem | ✅ |
| Delete a book from array | ✅ |
| **Edit book title & description** | ✅ |

---

### `Test.java` — OOP Version
| Feature | Supported |
|---------|-----------|
| Constructor with custom capacity | ✅ |
| Add a book (instance method) | ✅ |
| Display all books (instance method) | ✅ |
| Object-oriented design | ✅ |

---

## 🖥️ Menu Options (LibrarySystem)

```
-- Library Management System --
1. Add a Book
2. Display All Books
3. Search for a Book
4. Issue a Book
5. Return a Book
6. Manage Array of Books
7. Exit
```

---

## 📦 Data Structure

Books are stored in three parallel arrays:

```java
String[] bookTitles       // Book titles
String[] bookDescriptions // Book descriptions
boolean[] bookIssued      // Issue status (true = issued, false = available)
int bookCount             // Current number of books
```

---

## 💡 Sample Interaction

```
Enter your choice: 1
Enter book title: Clean Code
Enter book description: A book about writing better code
Book added successfully.

Enter your choice: 4
Enter book ID to issue: 1
Book issued successfully.

Enter your choice: 3
Search by:
1. Title
2. ID
Enter book title: Clean Code
Book Found:
ID: 1
Title: Clean Code
Description: A book about writing better code
Status: Issued
```

---

## 👨‍💻 Author

Made with ❤️ using Java
