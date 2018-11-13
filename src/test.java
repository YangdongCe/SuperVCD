import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class test {

    public static JSONObject getone(String id,String name,String songer,String message,String img,String time){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("name", name);
        jsonObject.put("songer", songer);
        jsonObject.put("meg", message);
        jsonObject.put("img", img);
        jsonObject.put("time",time);
        return jsonObject;
    }
    public static JSONObject getmusic(String dir,String name,String songer,String time)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dir",dir);
        jsonObject.put("name",name);
        jsonObject.put("songer", songer);
        jsonObject.put("time", time);
        return jsonObject;

    }
        public static void main(String[] args) throws InterruptedException {
        PlayMusic mp3 = new PlayMusic("./src/music/Time/AkaDaliang.mp3");
        Thread.sleep(5000);
        mp3.wait(1000);




    }
}
