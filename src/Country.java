public enum Country {
    RUSSIA("Россия", true),
    USA("Америка", false),
    ENGLAND("Англия", false),
    JAPAN("Япония", false),
    CHINA("Китай", true),
    FRANCE("Франция", true);

    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public String getRuName() {
        return this.ruName;
    }

    public static Country getByRuName(final String nameCountry) {
        try {
            for (Country country : Country.values()) {
                if (country.getRuName().equals(nameCountry)) {
                    return country;
                }
            }
            throw new NoSuchCountryException();
        } catch (NoSuchCountryException e) {
            System.out.println("Страны \'" + nameCountry + "\' не существует");
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.ruName + ")";
    }

    public static class NoSuchCountryException extends Exception {
        public NoSuchCountryException() {
        }
    }
}
