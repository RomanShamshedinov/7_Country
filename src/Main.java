import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        boolean exit = false;

        //Вывод списка стран
        for (Country country : Country.values()) {
            System.out.println(country);
        }
        //Бесконечный цикл с выходом exit
        while (!exit) {

            System.out.println("Введите страну. Для выхода из программы напишите: \"exit\"");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equals("exit")) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                Country country = Country.valueOf(input);
                //Если введена страна по-английски
                if (country.name().equals(input)) {
                    if (country.getIsOpen()) {
                        System.out.println("Страна [" + country + "] открыта для посещения.");
                    } else {
                        System.out.println("Страна [" + country + "] закрыта для посещения.");
                    }
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Наименование страны на английском введено некорректно,"
                        + " проверяем русское название...");
                Country country = Country.getByRuName(input);
                //Если введена страна по-русски
                if (country != null && country.getRuName().equals(input)) {
                    if (country.getIsOpen()) {
                        System.out.println("Страна [" + country + "] открыта для посещения.");
                    } else {
                        System.out.println("Страна [" + country + "] закрыта для посещения.");
                    }
                }
            }

            System.out.println("________________________");
            System.out.println();
        }


    }
}
