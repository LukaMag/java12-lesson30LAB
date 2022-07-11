package CLASSWORK30LAB;

public class Car {
    private int id;
    private CarState carState;
    private int timeOnPark;
    private int paymentTime;
    private double debt;
    private int timeEveryDay;

    public Car(int id, CarState carState, int timeOnPark, int paymentTime, double debt, int timeEveryDay) {
        this.id = id;
        this.carState = carState;
        this.timeOnPark = timeOnPark;
        this.paymentTime = paymentTime;
        this.debt = debt;
        this.timeEveryDay = timeEveryDay;
    }

    public int getTimeEveryDay() {
        return timeEveryDay;
    }

    public void setTimeEveryDay(int timeEveryDay) {
        this.timeEveryDay = timeEveryDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carState=" + carState +
                ", timeOnPark=" + timeOnPark +
                ", paymentTime=" + paymentTime +
                ", debt=" + debt +
                ", timeEveryDay=" + timeEveryDay +
                '}';
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public int getTimeOnPark() {
        return timeOnPark;
    }

    public void setTimeOnPark(int timeOnPark) {
        this.timeOnPark = timeOnPark;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public int getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(int paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double debtCount(double paymentTime){
        paymentTime *= 2;
        return paymentTime;
    }
}
