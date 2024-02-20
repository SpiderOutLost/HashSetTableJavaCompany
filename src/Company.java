public class Company {
    private String Country;
    private String City;
    private String Street;
    private String numberHouse;
    public Company(String country, String city, String street, String numberHouse) {
        this.Country = country;
        this.City = city;
        this.Street = street;
        this.numberHouse = numberHouse;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public String getNumberHouse() {
        return numberHouse;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Company){
            Company company = (Company) obj;

            return company.getCountry().equals(this.Country) &&
                    company.getCity().equals(this.City) &&
                    company.getStreet().equals(this.Street) &&
                    company.getNumberHouse().equals(this.numberHouse);
        }
        else {
            return false;
        }
    }
    public  String PrintCompany(){
        return getCountry() + " " + getCity() +" " + getStreet() + " " + getNumberHouse();
    }
    public int hashCode() {
        return City.hashCode()+Street.hashCode() + numberHouse.hashCode();
    }
}
