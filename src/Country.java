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

    public static Country getByRuName(final String nameCountry) throws NoSuchCountryException {
        for (Country country : Country.values()) {
            if (country.getRuName().equals(nameCountry)) {
                return country;
            }
        }
        throw new NoSuchCountryException();
    }

    public final void openOrClose(final Country country) {
        if (country.getIsOpen()) {
            System.out.println("Страна [" + country + "] открыта для посещения.");
        } else {
            System.out.println("Страна [" + country + "] закрыта для посещения.");
        }
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.ruName + ")";
    }
}