package efrei.m1.se.model;

public class User {
    private String name;
    private String surname;
    private String personalPhone;
    private String mobilePhone;
    private String workPhone;
    private String adress;
    private String postalCode;
    private String city;
    private String email;
    private static int count = 0;

    public User() {
        name = "";
        surname = "";
        personalPhone = "";
        mobilePhone = "";
        workPhone = "";
        adress = "";
        postalCode = "";
        city = "";
        email = "";
        count++;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPersonalPhone() {
        return this.personalPhone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public String getWorkPhone() {
        return this.workPhone;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.postalCode;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public void setSurname(String prenom) {
        this.surname = prenom;
    }

    public void setPersonalPhone(String phone) {
        this.personalPhone = phone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "USER " + count + " \n**IDENTITY** \n| Name : " + this.name + "\n| Surname : " + this.surname + "\n"
                + "**PHONES** \n| Personal phone : " + personalPhone + "\n| Mobile phone " + mobilePhone + "\n| Work Phone : " + workPhone + "\n"
                + "**ADRESS**\n| Street : " + adress + "\n| Code : " + postalCode + "\n| City : " + city + "\n"
                + "**CONTACT** \n|Mail : " + email + "\n\n";
    }
}