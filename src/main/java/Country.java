public class Country {
    private int countryID;
    private String country;
    private String lastUpdate;

    public Country() {

    }

    public Country(int countryID, String country, String lastUpdate) {
        this.countryID = countryID;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryID=" + countryID +
                ", country='" + country + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
