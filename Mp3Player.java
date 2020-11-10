/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

/**
 *
 * @author vishnu
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Mp3Player 
{
    private Player player; 
    public Mp3Player(String filename) 
    {
        try 
        {   
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(buffer);
            player.play();
        }
        catch (FileNotFoundException | JavaLayerException e) 
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Mp3Player mp = new Mp3Player("bip.mp3");
    }
}


