package ua.lviv.lgs.zooclub;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println();
        System.out.println("Введіть 1, щоб Додати учасника клубу");
        System.out.println("Введіть 2, щоб Додати тваринку до учасника клубу");
        System.out.println("Введіть 3, щоб Видалити тваринку з учасника клубу");
        System.out.println("Введіть 4, щоб Видалити учасника з клубу");
        System.out.println("Введіть 5, щоб Видалити конкретну тваринку зі всіх власників");
        System.out.println("Введіть 6, щоб Вивести на екран зооклуб");
        System.out.println("Введіть 7, щоб Вийти з програми");
    }

    public static void main(String[] args) {
        ZooClub zooClub = new ZooClub();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();

            switch (scanner.nextInt()) {

                case 1: {
                    zooClub.addPerson();
                    break;
                }

                case 2: {
                    zooClub.addAnimal();
                    break;
                }

                case 3: {
                    zooClub.deletedAnimal();
                    break;
                }

                case 4: {
                    zooClub.deletetPerson();
                    break;
                }

                case 5: {
                    zooClub.removeTypeAnimal();
                    break;
                }

                case 6: {
                    zooClub.sout();
                    break;
                }

                case 7: {
                    zooClub.exit();
                }
            }
        }

    }
}
