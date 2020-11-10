/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import javax.swing.JOptionPane;
/**
 *
 * @author vishnu
 */
public class AlarmClock extends clock {
    
    private int SetSeconds,SetMinutes,SetHours,sec;
    
    public AlarmClock(int a, int b, int c) {
        SetHours = a;
        SetMinutes = b;
        SetSeconds = c;
        sec=c;
    }
    
    public void tick()
    {
        sec = sec-1;
        Seconds = Seconds+1;
        Minutes = Minutes+Seconds/60;
        Hours = Hours+Minutes/60;
        Seconds = Seconds%60;
        Minutes = Minutes%60;
        Hours = Hours%24;
        System.out.println(Hours+":"+Minutes+":"+Seconds+"        "+SetHours+":"+SetMinutes+":"+SetSeconds);
        //if(Hours == SetHours && Minutes == SetMinutes && Seconds == SetSeconds)
        if(sec==0)
        {
            //JOptionPane.showMessageDialog(null, "Alarm Working");
            Mp3Player mp = new Mp3Player("bip.mp3");
            System.out.println("***********************");
            System.out.println(Hours+":"+Minutes+":"+Seconds+"        "+SetHours+":"+SetMinutes+":"+SetSeconds);
            System.exit(0);
        }
    }
}