public class Car
{
    // make & model
    // owner name
    // VIP member holder
    private String makeAndModel;
    private String ownerName;
    private boolean VIPStatus;

    public Car (String mdl, String name, Boolean isVIP)
    {
        this.makeAndModel = mdl;
        this.ownerName = name;
        this.VIPStatus = isVIP;
    }

    public void printCar(int car_num)
    {
        System.out.println(car_num + ". " + this.makeAndModel + " (" + ownerName + ")");
    }

    public String getMake()
    {
        return this.makeAndModel;
    }

    public String getOwnerName()
    {
        return this.ownerName;
    }

    public String getInfo()
    {
        return this.makeAndModel + " (" + this.ownerName + ")";
    }

    public boolean isVIPStatus()
    {
        return this.VIPStatus;
    }
}
