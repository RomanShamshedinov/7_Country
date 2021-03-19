public class NoSuchCountryException extends Exception {
    public final void message(final String nameCountry) {
        System.out.println("Страны \'" + nameCountry + "\' не существует");
    }
}
