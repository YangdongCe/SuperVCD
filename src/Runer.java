import org.json.JSONArray;
import org.json.JSONObject;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

public class Runer {
    public static String ablumlist;
    public static JSONArray ablumlists;
    public static Newpage index;
    public static JSONArray ownablums;
    public static JSONArray ownmusics;
    public static PlayMusic player;
    public static JSONObject thisplaymusic;
    public static boolean isPlaymusic = false;
    public static void main(String[] args) {
        ablumlist = Client.getmsg("ablum");
        ablumlists =  new JSONArray(ablumlist);
        ownablums = new JSONArray();
        ownmusics = new JSONArray();
        index = new Newpage();
        index.setVisible(true);
        index.setinit(new JSONArray(ablumlist));

//在这里初始化后面直接控制

        // TODO code application logic here
    }
    public static JSONArray ablumdetail(String id){
        String musiclist = Client.getablumdetial("musiclist",id);
        return new JSONArray(musiclist);
    }
    public static void addown(int index){
        ownablums.put(ablumlists.getJSONObject(index));
        JSONArray musics =new JSONArray(Client.getablumdetial("musiclist",ablumlists.getJSONObject(index).getString("id")));
        for(int i=0;i<musics.length();i++){
            ownmusics.put(musics.getJSONObject(i));
        }
    }
    public static boolean isBuy(int index){
        if (ownablums.isEmpty())return false;
        String id = ablumlists.getJSONObject(index).getString("id");
        for(int i=0;i<ownablums.length();i++){
            if(id.equals(ownablums.getJSONObject(i).getString("id"))){
                return true;
            }
        }
        return false;
    }
    public static void close(){
        index.setVisible(false);
        player.Stop();
    }
    public static void playmusic(JSONObject item){//这里只控制播放和暂停

        if(isPlaymusic){
             player.Stop();
            System.out.println("stop");

        }
        else{
            isPlaymusic=!isPlaymusic;
        }
        thisplaymusic = item;
        player = new PlayMusic(thisplaymusic.getString("dir"));
        index.setMusicPlay(thisplaymusic.getString("name"),thisplaymusic.getString("songer"),thisplaymusic.getString("time"));
    }
    public static void stopmusic(){
        isPlaymusic=false;
        player.Stop();
        index.setMusicStop(thisplaymusic.getString("name"),thisplaymusic.getString("songer"),thisplaymusic.getString("time"));
    }
}
