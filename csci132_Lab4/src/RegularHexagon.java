public class RegularHexagon implements RegularPolygon
{
    // My instance field. Think of this as the 'ingredients' of my class
    private double side_length;

    // My constructor method. Think of this as the 'recipe' of my class -it puts it all together!
    public RegularHexagon(double length)
    {
        this.side_length = length;
    }

    public double area()
    {
        double coeiff = (3 * Math.sqrt(3)) / 2;
        return (coeiff * Math.pow(side_length, 2));
    }

    public double perimeter()
    {
        return (6 * side_length);
    }

}
