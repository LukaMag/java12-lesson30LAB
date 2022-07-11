package CLASSWORK30LAB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }
    static void run(){
        Random r = new Random();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <=999; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        Cars cars = new Cars(new ArrayList<>());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            carList.add(new Car(numbers.get(i) + 1000,CarState.DRIVING,0,0,0,0));
        }
        cars.setCars(carList);
//        int d = 0;
//        int days = 0;
//        while(days <= 30) {
//            while (d <= 288) {
//                cars.getCars().get(0).setTimeEveryDay(cars.getCars().get(0).getTimeEveryDay() + r.nextInt(4) + 1);
//                if (cars.getCars().get(0).getTimeEveryDay() >= 30) {
//                    cars.getCars().get(0).setPaymentTime(cars.getCars().get(0).getPaymentTime() + r.nextInt(5) + 1 + (cars.getCars().get(0).getTimeEveryDay() - 30));
//                }
//                cars.getCars().get(0).setTimeOnPark(cars.getCars().get(0).getTimeOnPark() + cars.getCars().get(0).getTimeEveryDay() + r.nextInt(4) + 1);
//                d++;
//            }
//            cars.getCars().get(0).setTimeEveryDay(0);
//            days++;
//        }
//        System.out.println(cars.getCars().get(0));
        action(cars);
    }
    static void action(Cars cars){
        Random r = new Random();
        int days = 0;
        int frequency = 0;
        System.out.println(cars.getCars().size());
        while(days <= 30) {
            while(frequency <= 288) {
                for (int i = 0; i < cars.getCars().size(); i++) {
                    int ch = r.nextInt(100) + 1;
                    if (ch < 4) {
                        if (cars.getCars().get(i).getCarState() == CarState.DRIVING) {
                            cars.getCars().get(i).setCarState(CarState.ONPARK);
                            cars.getCars().get(i).setTimeEveryDay(cars.getCars().get(i).getTimeEveryDay() + r.nextInt(4) + 1);
                            if(cars.getCars().get(i).getTimeEveryDay() >= 30){
                                cars.getCars().get(i).getCarState().countMinute(cars.getCars().get(i), frequency);
                            }
                        } else {
                            cars.getCars().get(i).setCarState(CarState.DRIVING);
                            cars.getCars().get(i).setTimeEveryDay(cars.getCars().get(i).getTimeEveryDay() + r.nextInt(4) + 1);
                            if(cars.getCars().get(i).getTimeEveryDay() >= 30){
                                cars.getCars().get(i).getCarState().countMinute(cars.getCars().get(i), frequency);
                            }
                        }
                    } else {
                        if (cars.getCars().get(i).getCarState() == CarState.ONPARK) {
                            cars.getCars().get(i).setTimeEveryDay(cars.getCars().get(i).getTimeEveryDay() + r.nextInt(4) + 1);
                            if(cars.getCars().get(i).getTimeEveryDay() >= 30){
                                cars.getCars().get(i).getCarState().countMinute(cars.getCars().get(i), frequency);
                            }
                        }
                    }
                }
                    frequency++;
            }
            for (Car c:
                 cars.getCars()) {
                c.setTimeEveryDay(0);
            }
            days++;
        }
        for (Car c:
                cars.getCars()) {
            c.setDebt(c.debtCount(c.getPaymentTime()));
        }
       printCars(cars);
    }
        static void printCars(Cars cars){
            System.out.println("------------- Cars -------------");
            System.out.println("# | State |    ID     | Time on park | Paid time | To pay");
            for (int i = 0; i < cars.getCars().size(); i++) {
                System.out.println(String.format("%d | %s | id - %d | %d        | %d        |%f",i + 1,cars.getCars().get(i).getCarState().name(),cars.getCars().get(i).getId(),cars.getCars().get(i).getTimeOnPark(),cars.getCars().get(i).getPaymentTime(),cars.getCars().get(i).getDebt()));
            }
        }

}
