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


}
