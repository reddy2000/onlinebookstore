/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishnu
 */
public class Base extends Thread{
    int hours,mins,secs;
    /**
     * @param args the command line arguments
     */
    Base(int a,int b,int c,int d)
    {
        hours = a;
        mins = b;
        secs = c;
    }

    Base(int hours, int mins, int secs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void run()
    {
        int n;
        n = timer.newsec;
        //int n=10;
        AlarmClock A = new AlarmClock(hours,mins,secs);
        for(int i=0;i<n;i++)
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
            A.tick();
        }
    }
}
