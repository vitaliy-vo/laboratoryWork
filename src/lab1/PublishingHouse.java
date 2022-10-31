package lab1;

public class PublishingHouse {
    protected String namePublishingHouse;
    protected String city;




    public PublishingHouse(String namePublishingHouse, String city) {
        this.namePublishingHouse = namePublishingHouse;
        this.city = city;
    }



    public void setNamePublishingHouse(String namePublishingHouse) throws NullPointerException {
        if (namePublishingHouse == null) throw new NullPointerException ("Значение поля /Издание/ не долно быть пустое");
        this.namePublishingHouse = namePublishingHouse;
    };



    public void setCity(String city) throws NullPointerException {
        if (city == null) throw new NullPointerException ("Значение поля /Город/ не долно быть пустое");
        this.city = city;

    };



    public String getNamePublishingHouse() {
        return namePublishingHouse;
    }

    public String getCity() {
        return city;
    }
}
