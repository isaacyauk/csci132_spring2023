public class Floor
{
    private String offeredClass;
    private String professorName;
    private String labType;

    public Floor (String n)
    {
        this.offeredClass = n;
    }

    public void printInfo()
    {
        System.out.println(this.offeredClass);
    }

}
