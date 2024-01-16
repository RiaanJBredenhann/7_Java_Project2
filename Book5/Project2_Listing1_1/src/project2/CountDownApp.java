/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

public class CountDownApp {

    public static void main(String[] args) {
        Thread clock = new CountDownClock();
        Runnable flood, ignition, liftoff;
        
        flood = new LaunchEvent(16, "Flood the pad!");
        ignition = new LaunchEvent(6, "Start engines!");
        liftoff = new LaunchEvent(0, "Liftoff!");
        
        clock.start(); 
        new Thread(flood).start(); 
        new Thread(ignition).start();
        new Thread(liftoff).start();
    }
    
}

class CountDownClock extends Thread
{
    public void run()
    {
        for (int t = 20; t >= 0; t--)
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
}

class LaunchEvent implements Runnable 
{
    private int start;
    private String message;
    
    public LaunchEvent(int start, String message)
    {
        this.start = start;
        this.message = message;
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(20000 - (start * 1000)); 
        }
        catch (InterruptedException e)
        {}
        System.out.println(message); 
    }
}
