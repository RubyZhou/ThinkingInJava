package Chapter20_Concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static Fourth_util.Print.print;

/**
 *  新类库构件 : CyclicBarrier       // 循环关口. ['saɪklɪk] ['beriər]
 */

// 任务类 : 马
class Horse implements Runnable {
    /*-----------------------------------------------------*/
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;                    /* 已经跑过的步子 */
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        this.barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }
    /*-----------------------------------------------------*/
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3); /* Produces 0,1,2 */
                }
                barrier.await();
            }
        }catch (InterruptedException e) {
            // A legitimate way to exit
        }catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
    }
    /*-----------------------------------------------------*/
    public String toString() {
        return "Horse [" + id + "]";
    }

    // 打印 : 跟踪（马跑的进展情况）
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
    /*-----------------------------------------------------*/
}

// 马赛道
public class HorseRace {
    /*---------------------------------------------------------------------------*/
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();    /* 参赛马的队列 */
    private CyclicBarrier barrier;
    private ExecutorService exec = Executors.newCachedThreadPool();
    /*---------------------------------------------------------------------------*/
    /**
     * 马赛道构造
     * @param nHorse    参赛马匹数量
     * @param pause     完成栅栏处动作后, 暂停的秒数
     */
    public HorseRace(int nHorse, final int pause) {
        /**
         *  CyclicBarrier 构造器 ：通过匿名内部类, 创建栅栏处所需完成的任务
         *        1) 根据 FINISH_LINE 打印栅栏
         *        2) 调用每匹马的 tracks() 打印自己的路径
         *        3) 检查每匹马的 strides 是否到达了终点。到达 -> 停止线程
         *        4) 暂定数秒, 等下一次栅栏任务
         */
        barrier = new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                /*---------------------1. 打印栅栏---------------------------*/
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    // The fence on the racetrack (模拟马赛道的栅栏)
                    s.append("=");
                }
                print(s);

                /*---------------------2. 打印每匹马的路径----------------------*/
                for (Horse horse : horses) {    // 打印所跟踪每批马的行驶路径
                    print(horse.tracks());
                }

                /*---------------------3. 检查是否到达终点---------------------*/
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        print(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                /*---------------------4. 暂定数秒, 等下一次栅栏任务-------------------*/
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch (InterruptedException e) {
                    print("barrier-action sleep interrupted");
                }
                /*-----------------------------------------*/
            }
        }); /* End : barrier = new CyclicBarrier(...) */

        /*------- 根据传入参数, new 实体任务, 并插入列表中. 拉起实体任务 ------------*/
        for (int i = 0; i < nHorse; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
    /*---------------------------------------------------------------------------*/
    public static void main(String[] args) {
        /*-----------------------------------------*/
        int nHorses = 7;
        int pause   = 200;
        if (args.length > 0) {
            int n = Integer.valueOf(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if (args.length > 1) {
            int p = Integer.valueOf(args[1]);
            pause = p > -1 ? p : pause;
        }
        /*-----------------------------------------*/
        new HorseRace(nHorses, pause);
        /*-----------------------------------------*/
    }
}
