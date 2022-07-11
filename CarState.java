package CLASSWORK30LAB;

import java.util.Random;

public enum CarState {
    DRIVING{
        @Override
        public void countMinute(Car car,int time) {
            int minutes = r.nextInt(4) + 1;
            if(time >= 108 && time <=252){
                car.setPaymentTime(car.getPaymentTime() + minutes);
            }
            car.setTimeOnPark(car.getTimeOnPark()+minutes);
        }
    },
    ONPARK{
        @Override
        public void countMinute(Car car,int time) {
            if(time >= 108 && time <=252){
                car.setPaymentTime(car.getPaymentTime() + 5);
            }
            car.setTimeOnPark(car.getTimeOnPark() + 5);
        }
    };
    public Random r = new Random();
    public void countMinute(Car car,int time){
        System.out.println();
    }
}
