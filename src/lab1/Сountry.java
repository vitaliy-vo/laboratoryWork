package lab1;

public class Сountry {
    private String country;
    private double square;
    private int population;
    private String capital;
    private int populationCapital;


    public Сountry(String country, double square, int population, String capital, int populationCapital) {
        this.country = country;
        this.square = square;
        this.population = population;
        this.capital = capital;
        this.populationCapital = populationCapital;
    }

    public Сountry(String country, double square, int population) {
        this.country = country;
        this.square = square;
        this.population = population;
        this.capital="Страна-государство";

    }


    /** Метод print() распечатает в консоле информацию об стране :
     * Страна,площадь страны,население страны,столица, население столицы
     */

    public Сountry print(){
        System.out.println(getCountry() + "," + getSquare() + ","+  getPopulation() + ","+  getCapital());

        return null;
    }


    /**
     *
     * @param сountries Передает обьект Сountry в массив Сountry[]
     */
    public static void printAll(Сountry[] сountries){
        for(int i=0 ; i<сountries.length ; i++){
            сountries[i].print();
        }
    }


    //Get-metods
    public String getCountry() {

        return country;
    }

    public double getSquare() {

        return square;
    }

    public int getPopulation() {


        return population;
    }

    public String getCapital() {

        return capital;
    }

    public int getPopulationCapital() {

        return populationCapital;
    }

    public double getPopulationDensity(){

        return population/square;
    }

    // Set-metods
    public void setCountry(String country) throws NullPointerException{
        if (country == null) throw new NullPointerException("Значение поля /Cтрана/ не долно быть пустое");
            this.country = country;
        };



    public void setSquare(double square) throws IllegalArgumentException {
        if (square <= 0)  throw new IllegalArgumentException("Площадь не можеть принимать отрицательные занчания или равнятся нулю");
            this.square = square;
            };




    public void setPopulation(int population) throws IllegalArgumentException {
        if (population < 0)  throw new IllegalArgumentException("Население не может принимать отрицательные заначения");
            this.population = population;
            };


    public void setCapital(String capital) {

        this.capital = capital;
    }

    public void setPopulationCapital(int populationCapital) {

        this.populationCapital = populationCapital;
    }


    public void setResetCapital(String capital){
        this.capital=capital;
        capital=null;


    }

}
