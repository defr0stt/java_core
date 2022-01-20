package hashCode_equals;

public class Car {
    private int rating;
    private String color;

    public Car(int rating, String color) {
        this.rating = rating;
        this.color = color;
    }

    public int getRating() {
        return rating;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) { this.color = color; }

    public void setRating(int rating) { this.rating = rating; }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        return this.getRating() == car.getRating() && this.getColor().equals(car.getColor());
    }

    @Override
    public int hashCode() {                                  // auxiliary method for determining the equality of objects
                                                             // for start checks hashCode and then equals
        System.out.println("called hashcode " + this );      // if equals = true => hashcode = true
        return this.rating;                                  // if hashcode = true => not always equals = true  --  collision
                                                             // minimize search field for faster equality check
    }

    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + "{ rating = " + this.getRating() +
                ";" + "color = " + this.color + " }");
    }

}