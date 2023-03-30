public class Floor
{
    private int floor_number;
    private String type_of_floor;
    private String info;

    public Floor (String room_type, String name, int n)
    {
        this.floor_number = n;
        this.type_of_floor = room_type;
        this.info = name; // info will hold the 2nd thing you pass into the construt
    }

    public void printInfo()
    {
        // TODO: Format and make things more pretty here!
        System.out.println(this.floor_number + "\n" + this.type_of_floor + "(" + this.info + ")");
    }

    public String getInfo()
    {
        return this.info;
    }

    public String getFloorType()
    {
        return this.type_of_floor;
    }

}
