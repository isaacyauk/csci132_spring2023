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
        System.out.println("Current Car Wash Queue\n" + "----------------------");
        System.out.println(car_num + "." + " (" + ownerName + ")");
    }
}
