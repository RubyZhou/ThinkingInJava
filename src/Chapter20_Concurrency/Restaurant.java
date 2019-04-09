package Chapter20_Concurrency;


import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  生产者和消费者
 */

// 食物
class Meal {
    private final int orderNum;

    public  Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal-" + orderNum;
    }
}


// 服务员
class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public  WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public  void run() {
        try {
            while (!Thread.interrupted()) {
                // 1. 服务员先等待。 等厨师通知上菜, 直到收到厨师通知 notifyAll()
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait();     // .. for Chef to produce a meal
                }

                System.out.println("    Waitperson got " + restaurant.meal);
                // 2. 服务员收到订单通知。通知厨师开始制作下一份。
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();    // Ready for another
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

// 厨师
class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 1. 厨师通知服务员上菜后等待。 等服务员通知
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();             // .. for the meal to be taken
                    }
                }
                // 2. 制造食物
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up");

                // 3. 通知服务员上菜
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Chef interrupted!");
        }
    }
}


public class Restaurant {
    Meal    meal;   // 厨师和服务员通信的信号量
    Chef            chef       = new Chef(this);
    WaitPerson      waitPerson = new WaitPerson(this);
    ExecutorService exec       = Executors.newCachedThreadPool();

    // 餐厅开门就拉起厨师和服务员干活
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
