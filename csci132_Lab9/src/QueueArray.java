public class QueueArray
{
    private Car[] car_line;
    private int size;
    private int front;
    private int back;
    private int capacity;
    private int cars_served;
    private double earnings;

    public QueueArray(int size)
    {
        this.car_line = new Car[size];
        this.size = 0;
        this.front = 0;
        this.back = 0;
        this.capacity = this.car_line.length;
    }

    public void enqueue(Car newCar)
    {
        System.out.println("Adding " + newCar.getMake() + " (" + newCar.getOwnerName() + ")");
        if(this.size == this.capacity)
        {
            System.out.println("Error: Queue is full- Cannot add " + newCar.getMake() + " (" + newCar.getOwnerName() + ")");
            return;
        }
        else
        {
            this.car_line[this.back] = newCar;
            this.back++;
            this.size++;
        }
    }

    public void dequeue()
    {
        if(this. size == 0)
        {
            System.out.println("Error... Line is empty");
            return;
        }
        else
        {
            Car removed = this.car_line[front];
            if(removed.isVIPStatus())
            {
                earnings += 6.00;
            }
            else
            {
                earnings += 10.00;
            }

            System.out.println("Car has been washed. Removing " + this.car_line[front].getMake()
                    + " (" + this.car_line[front].getOwnerName() + ") from the queue.");
            for (int i = 0; i < back - 1; i++)
            {
                this.car_line[i] = this.car_line[i+1];
            }

            cars_served++;

            // Checking the back and eventrually setting it to null once the queue
            if (back < capacity)
            {
                this.car_line[back] = null;
            }
            this.back--;
            this.size--;
        }
    }

    public void printQueue()
    {
        int counter = 1;

        System.out.println("Current Car Wash Queue\n" + "----------------------");
        for (int i = 0; i < this.back; i++)
        {
            this.car_line[i].printCar(counter);
            counter++;
        }
    }

    public Car peek()
    {
        if (this.size != 0)
        {
            return this.car_line[front];
        }
        else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printStats()
    {
        System.out.println("Car Wash Statistics\n" + "----------------------");
        System.out.println("Number of Cars Serviced: " + cars_served);
        System.out.println("Today's earnings: $" + earnings);
    }


}
