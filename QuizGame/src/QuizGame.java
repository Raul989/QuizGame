import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QuizGame {
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Medal> medalList = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        medalList.add(new Medal("Gold"));
        medalList.add(new Medal("Silver"));
        medalList.add(new Medal("Bronze"));

        while (!exitGame) {
            System.out.println("===== MENIU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumăm caracterul newline rămas în buffer

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit();
                    exitGame = true;
                    break;
                default:
                    System.out.println("Opțiune invalidă. Vă rugăm să încercați din nou.");
                    break;
            }

            if (currentUser != null) {
                boolean loggedIn = true;

                while (loggedIn) {
                    System.out.println("===== MENIU UTILIZATOR =====");
                    System.out.println("1. Joacă jocul");
                    System.out.println("2. Vizualizează clasamentul");
                    System.out.println("3. Logout");

                    int userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consumăm caracterul newline rămas în buffer

                    switch (userChoice) {
                        case 1:
                            playGame();
                            break;
                        case 2:
                            viewRanking();
                            break;
                        case 3:
                            logout();
                            loggedIn = false;
                            break;
                        default:
                            System.out.println("Opțiune invalidă. Vă rugăm să încercați din nou.");
                            break;
                    }
                }
            }
        }

        scanner.close();
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== ÎNREGISTRARE =====");
        System.out.print("Introduceți nume de utilizator: ");
        String username = scanner.nextLine();

        // Verificăm dacă utilizatorul există deja
        if (findUserByUsername(username) != null) {
            System.out.println("Nume de utilizator deja existent. Vă rugăm să alegeți altul.");
            return;
        }

        System.out.print("Introduceți parola: ");
        String password = scanner.nextLine();

        User newUser = new User(username, password);
        userList.add(newUser);

        System.out.println("Înregistrare reușită!");
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== AUTENTIFICARE =====");
        System.out.print("Introduceți nume de utilizator: ");
        String username = scanner.nextLine();

        System.out.print("Introduceți parola: ");
        String password = scanner.nextLine();

        User foundUser = findUserByUsername(username);

        if (foundUser != null && foundUser.getPassword().equals(password)) {
            currentUser = foundUser;
            System.out.println("Autentificare reușită. Bun venit, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Nume de utilizator sau parolă incorectă. Vă rugăm să încercați din nou.");
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("===== JOACĂ JOCUL =====");
        System.out.println("Întrebare 1: Ce limbaj de programare este folosit pentru dezvoltarea aplicațiilor Android?");
        System.out.println("a) Java");
        System.out.println("b) C++");
        System.out.println("c) Python");
        System.out.println("Răspunsul tău: ");
        String answer1 = scanner.nextLine();

        if (answer1.equals("a")) {
            score += 1;
        }

        System.out.println("Întrebare 2: Care este capitala Franței?");
        System.out.println("a) Londra");
        System.out.println("b) Paris");
        System.out.println("c) Berlin");
        System.out.println("Răspunsul tău: ");
        String answer2 = scanner.nextLine();

        if (answer2.equals("b")) {
            score += 1;
        }

        System.out.println("Întrebare 3: Care este cel mai mare ocean al Pământului?");
        System.out.println("a) Oceanul Atlantic");
        System.out.println("b) Oceanul Indian");
        System.out.println("c) Oceanul Pacific");
        System.out.print("Răspunsul tău: ");
        String answer3 = scanner.nextLine();

        if (answer3.equals("c")) {
            score++;
        }

        System.out.println("Întrebare 4: Care este capitala Japoniei?");
        System.out.println("a) Beijing");
        System.out.println("b) Tokyo");
        System.out.println("c) Seul");
        System.out.print("Răspunsul tău: ");
        String answer4 = scanner.nextLine();
        if (answer4.equals("b")) {
            score++;
        }

        System.out.println("Întrebare 5: Cine a pictat Mona Lisa?");
        System.out.println("a) Vincent van Gogh");
        System.out.println("b) Pablo Picasso");
        System.out.println("c) Leonardo da Vinci");
        System.out.print("Răspunsul tău: ");
        String answer5 = scanner.nextLine();
        if (answer5.equals("c")) {
            score++;
        }

        System.out.println("Întrebare 6: Care este cel mai înalt munte din lume?");
        System.out.println("a) Mont Blanc");
        System.out.println("b) Kilimanjaro");
        System.out.println("c) Everest");
        System.out.print("Răspunsul tău: ");
        String answer6 = scanner.nextLine();
        if (answer6.equals("c")) {
            score++;
        }

        System.out.println("Întrebare 7: Câte planete are sistemul nostru solar?");
        System.out.println("a) 6");
        System.out.println("b) 7");
        System.out.println("c) 8");
        System.out.print("Răspunsul tău: ");
        String answer7 = scanner.nextLine();
        if (answer7.equals("c")) {
            score++;
        }

        System.out.println("Întrebare 8: Care este cel mai mare animal de pe Pământ?");
        System.out.println("a) Elefantul african");
        System.out.println("b) Balena albastră");
        System.out.println("c) Ursul polar");
        System.out.print("Răspunsul tău: ");
        String answer8 = scanner.nextLine();
        if (answer8.equals("b")) {
            score++;
        }

        System.out.println("Întrebare 9: Care este cel mai mare continent al lumii?");
        System.out.println("a) America de Nord");
        System.out.println("b) Europa");
        System.out.println("c) Asia");
        System.out.print("Răspunsul tău: ");
        String answer9 = scanner.nextLine();
        if (answer9.equals("c")) {
            score++;
        }

        System.out.println("Întrebare 10: Care dintre acestea este un sistem de operare mobil?");
        System.out.println("a) Windows");
        System.out.println("b) Android");
        System.out.println("c) Linux");
        System.out.print("Răspunsul tău: ");
        String answer10 = scanner.nextLine();
        if (answer10.equals("b")) {
            score++;
        }


        System.out.println("Ai răspuns corect la " + score + " întrebări!");

        if (currentUser != null) {
            currentUser.setScore(score);
            System.out.println("Scorul tău a fost înregistrat.");
        }
    }

    private static void viewRanking() {
        System.out.println("===== CLASAMENT =====");
        System.out.println("Locul\tNume Utilizator\t\tScor\tMedală");

        userList.sort(Comparator.comparing(User::getScore).reversed());

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            Medal medal = getMedalByRank(i + 1);

            System.out.println((i + 1) + "\t\t" + user.getUsername() + "\t\t\t\t" + user.getScore() + "\t\t" +
                    (medal != null ? medal.getName() : ""));
        }
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Delogare reușită. La revedere!");
    }

    private static void exit() {
        System.out.println("Ieșire din joc. La revedere!");
    }

    private static User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private static Medal getMedalByRank(int rank) {
        if (rank >= 1 && rank <= medalList.size()) {
            return medalList.get(rank - 1);
        }
        return null;
    }
}

