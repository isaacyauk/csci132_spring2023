public class QueueArray
{
    private Car[] car_line;
    private int size;
    private int front;
    private int back;
    private int capacity;

    public QueueArray(int size)
    {
        this.car_line = new car_line[size];
        this.size = 0;
        this.front = 0;
        this.back = 0;
        this.capacity = this.car_line.length;
    }

    public void enqueue(Car newCar)
    {
        if(this.capacity == 0)
        {
            System.out.println("Error; Queue is full!");
            return;
        }
        else
        {
            this.car_line[this.back] = newCar;
            this.back++;
            this.size++;
        }
    }

}
