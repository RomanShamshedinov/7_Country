import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        boolean exit = false;

        //Вывод списка стран
        for (Country country : Country.values()) {
            System.out.println(country);
        }
        Scanner in = new Scanner(System.in);
        //Бесконечный цикл с выходом exit
        while (!exit) {

            System.out.println("Введите страну. Для выхода из программы напишите: \"exit\"");
            String input = in.nextLine();

            if (input.equals("exit")) {
                System.out.println("Программа завершена.");
                break;
            }
            try {
                try {
                    Country country = Country.valueOf(input);
                    //Если введена страна по-английски
                    openOrClose(country);
                } catch (NullPointerException e) {
                    System.out.println("Введено пустое наименование страны!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Наименование страны на английском введено некорректно,"
                            + " проверяем русское название...");
                    Country country = Country.getByRuName(input);
                    //Если введена страна по-русски
                    if (country != null) {
                        openOrClose(country);
                    }
                }
            } catch (NoSuchCountryException e) {
                e.message(input);
            }
            System.out.println("________________________");
            System.out.println();
        }
    }

    public static final void openOrClose(final Country country) {
        if (country.getIsOpen()) {
            System.out.println("Страна [" + country + "] открыта для посещения.");
        } else {
            System.out.println("Страна [" + country + "] закрыта для посещения.");
        }
    }
}
