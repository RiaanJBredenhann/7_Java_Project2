/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThings {

    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClock clock = new CountDownClock(20);
    
    public static void main(String[] args) {
        new DoTwoThings();
    }
    
    DoTwoThings()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }
    
}

class CountDownClock extends Thread
{
    private int t;
    
    public CountDownClock(int start)
    {
        this.t = start;
    }
    
    public void run()
    {
        for (; t >= 0; t--)
        {
            System.out.println("T minus " + t);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {}
        }
    }
    
    public int getTime()
    {
        return t;
    }
}
