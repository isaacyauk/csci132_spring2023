public class RegularPentagon implements RegularPolygon
{
    // My instance field. Think of this as the 'ingredients' of my class
    private double side_length;

    // My constructor method. Think of this as the 'recipe' of my class -it puts it all together!
    public RegularPentagon(double length)
    {
        this.side_length = length;
    }

    public double area()
    {
        // Breaking out the equation into two parts here, since the compiler
        //      was a little angry with me trying to do all of it at once.
        double sqrtQty = (5+2*Math.sqrt(5));
       return (0.25)*(Math.sqrt(5 * sqrtQty) * (Math.pow(side_length, 2) ));
    }

    public double perimeter()
    {
        return (5 * side_length);
    }

}
