import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryRepository {

    /**
     * Runs a query for a book by title
     */
    public void findTitle() {
        Connection con = DBConnection.getConnection();
        System.out.println("Search by Title: ");
        Scanner findSc = new Scanner(System.in);
        String title = findSc.nextLine();
        if (con != null) {
            String query = "SELECT * FROM books WHERE title = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, title);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println("title: " + rs.getString("title") +
                            " Category: " + rs.getString("category") +
                            " ISBN: " + rs.getString("ISBN"));
                    }
                } catch (SQLException e) {
                System.out.println("No results");
            }
        }
    }


    /**
     * Run query for a book by Category
     */
    public void findCategory() {
        Connection con = DBConnection.getConnection();
        Scanner cat = new Scanner(System.in);
        System.out.println("Search by Category: ");
        String category = cat.nextLine();
        if (con != null) {
            String query = "SELECT * FROM books WHERE category = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, category);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println("title: " + rs.getString("title") +
                            " Category: " + rs.getString("category") +
                            " ISBN: " + rs.getString("ISBN"));
                }
            } catch (SQLException e) {
                System.out.println("No results");
            }
        }
    }

    /**
     * Searches for a book by ISBN
     */
    public void findISBN() {
        Connection con = DBConnection.getConnection();
        Scanner isbnSc = new Scanner(System.in);
        System.out.println("Search by ISBN: ");
        String isbn = isbnSc.nextLine();
        if (con != null) {
            String query = "SELECT * FROM books WHERE ISBN = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, isbn);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println("title: " + rs.getString("title") +
                            " Category: " + rs.getString("category") +
                            " ISBN: " + rs.getString("ISBN"));
                }
            } catch (SQLException e) {
                System.out.println("No results");
            }
        }
    }

    /**
     * Adds Book to Database
     */
    public void addBook() {
        Connection con =  DBConnection.getConnection();
        Scanner ab = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = ab.nextLine();
        System.out.println("Enter Category: ");
        String category = ab.nextLine();
        System.out.println("Enter ISBN: ");
        String isbn = ab.nextLine();
        if (con != null) {
            String query = "INSERT INTO books (title, category, ISBN) VALUES (?, ?, ?)";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, title);
                st.setString(2, category);
                st.setString(3, isbn);
                st.executeUpdate();
                System.out.println("Book Added");
            } catch (SQLException e) {
                System.out.println("Book not Added");
            }
        }
    }

    /**
     * Edits the title of a book in the Database
     */
    public void editTitle() {
        Connection con = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book id:");
        int id = sc.nextInt();
        sc.nextLine();  // Necessary to not return empty string afterward
        System.out.println("Enter new title: ");
        String title = sc.nextLine();
        if (con != null) {
            String query = "UPDATE books SET title = ? WHERE id = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, title);
                st.setInt(2, id);
                st.executeUpdate();
                System.out.println("Title changed to" + title);
            } catch (SQLException e) {
                System.out.println("Edit Cancelled");
            }
        }
    }

    /**
     * Edits the Category of a book in the Database
     */
    public void editCategory() {
        Connection con = DBConnection.getConnection();
        Scanner editCat = new Scanner(System.in);
        System.out.println("Enter Book id:");
        int id = editCat.nextInt();
        System.out.println("Enter new Category: ");
        String category = editCat.nextLine();
        if (con != null) {
            String query = "UPDATE books SET category = ? WHERE id = ?";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, category);
                st.setInt(2, id);
                st.executeUpdate();
                System.out.println("Category changed to" + category);
            } catch (SQLException e) {
                System.out.println("Edit Cancelled");
            }
        }
    }
}
