import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMusic extends Thread{
    private String filename;
    private Player player;

    public PlayMusic(String filename) {
        this.filename = filename;
        new Thread(this).start();
    }

    public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(buffer);
            player.play();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Stop() {
        player.close();
    }
    public void run() {
       play();
    }
//    public static void main(String[] args) {
//        PlayMUsic mp3 = new PlayMUsic("./src/music/Time/AkaDaliang.mp3");
//        mp3.play();
//    }
}