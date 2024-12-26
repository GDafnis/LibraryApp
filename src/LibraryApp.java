import java.util.Scanner;

public class LibraryApp {

    public void run() {
        LibraryRepository repository = new LibraryRepository();
        LibraryUI ui = new LibraryUI();
        int option = 0;
        do {
            ui.mainMenu();
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ui.searchMenu();
                    int searchSelect = sc.nextInt();
                    switch (searchSelect) {
                        case 1:
                            repository.findTitle();
                            break;
                        case 2:
                            repository.findCategory();
                            break;
                        case 3:
                            repository.findISBN();
                            break;
                        case 0:
                            System.out.println("Returning to Main Menu");
                    }
                    break;
                case 2:
                    repository.addBook();
                    break;
                case 3:
                    ui.editMenu();
                    int editSelect = sc.nextInt();
                    switch (editSelect) {
                        case 1:
                            repository.editTitle();
                            break;
                        case 2:
                            repository.editCategory();
                            break;
                        case 0:
                            System.out.println("Returning to Main Menu");
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (option != 0);
    }

    public static void main(String[] args) {
        LibraryApp libraryApp = new LibraryApp();
        libraryApp.run();
    }
}

