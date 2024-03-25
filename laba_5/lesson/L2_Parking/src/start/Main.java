package start;

import object.Car;
import object.Parking;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter how many place in first parking: ");
        Parking first = new Parking(1);
        System.out.print("Enter how many place in second parking: ");
        Parking second = new Parking(2);

        Semaphore bord1 = new Semaphore(first.getPlaceSize());
        Semaphore bord2 = new Semaphore(second.getPlaceSize());

        ExecutorService service = Executors.newCachedThreadPool();

        int cars = 30;

        System.out.print("How many car we have(from 1 to 100): ");
        try {
            cars = new Scanner(System.in).nextInt();

            if(cars < 1 || cars > 100)
                throw new Exception();
        }
        catch (Exception e){
            cars = 30;
        }

        for(int i = 0; i < cars;){
            service.execute(new Car(first, bord1, ++i));
            service.execute(new Car(second, bord2, ++i));
        }

        service.shutdown();
    }
}