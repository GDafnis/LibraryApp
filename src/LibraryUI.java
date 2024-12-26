public class LibraryUI {

    public void mainMenu() {
        System.out.println("1. Search Library");
        System.out.println("2. Add Book");
        System.out.println("3. Modify Book");
        System.out.println("0. EXIT");
        System.out.println("Select an option (0-3): ");
    }

    public void searchMenu() {
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Category");
        System.out.println("3. Search by ISBN");
        System.out.println("0. Back");
        System.out.println("Select an option (0-3): ");
    }

    public void editMenu() {
        System.out.println("1. Edit Title");
        System.out.println("2. Edit Category");
        System.out.println("0. Back");
        System.out.println("Select an option (0-2): ");
    }
}
