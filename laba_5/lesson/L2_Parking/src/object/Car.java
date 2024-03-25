package object;

import resurs.Color;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    Parking parking;
    private Semaphore border;
    private int id;
    private int index;

    public Car(Parking park, Semaphore border, int id) {
        this.parking = park;
        this.border = border;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            border.acquire();
            System.out.println(Color.GREEN + "car number " +
                    Color.ORANGE + id + Color.GREEN +
                    " stay in the parking number " +
                    Color.ORANGE + parking.getId() + Color.RESET);

            Thread.sleep(new Random().nextInt(700)+300);
            border.release();

            System.out.println(Color.RED + "car number " +
                    Color.ORANGE + id + Color.RED +
                    " leave in the parking number " +
                    Color.ORANGE + parking.getId() + Color.RESET);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}