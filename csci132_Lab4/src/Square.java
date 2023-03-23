public class Square implements RegularPolygon
{
    // My instance field. Think of this as the 'ingredients' of my class
    private double side_length;

    // My constructor method. Think of this as the 'recipe' of my class -it puts it all together!
    public Square(double length)
    {
       this.side_length = length;
    }
    public double area()
    {
        return (side_length * side_length);
    }

    public double perimeter()
    {
        return(side_length * 4);
    }

}
