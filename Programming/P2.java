import json

class Book:
    def __init__(self, title, author, year):
        self.title = title
        self.author = author
        self.year = year

    def __str__(self):
        return f"'{self.title}' by {self.author} ({self.year})"

class Library:
    def __init__(self):
        self.books = []

    def add_book(self, book):
        self.books.append(book)

    def remove_book(self, title):
        for book in self.books:
            if book.title == title:
                self.books.remove(book)
                return True
        return False

    def find_book(self, title):
        for book in self.books:
            if book.title == title:
                return book
        return None

    def list_books(self):
        return self.books

    def save_to_file(self, filename):
        with open(filename, 'w') as file:
            json.dump([book.__dict__ for book in self.books], file, indent=4)

    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as file:
                books_data = json.load(file)
                self.books = [Book(**data) for data in books_data]
        except FileNotFoundError:
            print(f"File '{filename}' not found.")
        except json.JSONDecodeError:
            print(f"Error decoding JSON from file '{filename}'.")

def main():
    library = Library()

    while True:
        print("\nLibrary Menu:")
        print("1. Add a book")
        print("2. Remove a book")
        print("3. Find a book")
        print("4. List all books")
        print("5. Save library to file")
        print("6. Load library from file")
        print("7. Exit")

        choice = input("Enter your choice: ")

        if choice == '1':
            title = input("Enter book title: ")
            author = input("Enter book author: ")
            year = input("Enter year of publication: ")
            book = Book(title, author, year)
            library.add_book(book)
            print(f"Added book: {book}")

        elif choice == '2':
            title = input("Enter the title of the book to remove: ")
            if library.remove_book(title):
                print(f"Removed book with title '{title}'")
            else:
                print(f"No book found with title '{title}'")

        elif choice == '3':
            title = input("Enter the title of the book to find: ")
            book = library.find_book(title)
            if book:
                print(f"Found book: {book}")
            else:
                print(f"No book found with title '{title}'")

        elif choice == '4':
            books = library.list_books()
            if books:
                print("Books in the library:")
                for book in books:
                    print(f"- {book}")
            else:
                print("No books in the library.")

        elif choice == '5':
            filename = input("Enter filename to save to: ")
            library.save_to_file(filename)
            print(f"Library saved to '{filename}'")

        elif choice == '6':
            filename = input("Enter filename to load from: ")
            library.load_from_file(filename)
            print(f"Library loaded from '{filename}'")

        elif choice == '7':
            print("Exiting the program.")
            break

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
