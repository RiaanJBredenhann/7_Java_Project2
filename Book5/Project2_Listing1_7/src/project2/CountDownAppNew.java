/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownAppNew {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(25);
        Runnable flood, ignition, liftoff;
        
        flood = new LaunchEventNew("Flood the pad!");
        ignition = new LaunchEventNew("Start engines!");
        liftoff = new LaunchEventNew("Liftoff!");
        
        for (int t = 20; t >= 0; t--)
            pool.schedule(new CountDownClockNew(t), (long) (20 - t), TimeUnit.SECONDS);
        
        pool.schedule(flood, 3L, TimeUnit.SECONDS);
        pool.schedule(ignition, 13L, TimeUnit.SECONDS);
        pool.schedule(liftoff, 19L, TimeUnit.SECONDS);
        pool.shutdown();
    }
    
}

class CountDownClockNew implements Runnable
{
    int t;
    
    public CountDownClockNew(int t)
    {
        this.t = t;
    }
    
    public void run()
    {
        System.out.println("T minus " + t);
    }
}

class LaunchEventNew implements Runnable
{
    private String message;
    
    public LaunchEventNew(String message)
    {
        this.message = message;
    }
    
    public void run()
    {
        System.out.println(message);
    }
}
