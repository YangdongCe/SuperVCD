import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ablum {

    /**
     * @param args
     * @throws JSONException
     * @throws IOException
     */
    public static void main(String[] args) throws JSONException, IOException {
        // TODO Auto-generated method stub

//        String s = ReadFile("./src/1.json");
//
//        JSONArray ablum = new JSONArray(s);
//        for (int i = 0; i < ablum.length(); i++) {
//            JSONObject object = (JSONObject) ablum.get(i);
//            String name = object.getString("name");
//            System.out.println(name);
//        }
        JSONArray ablum = new JSONArray();
        JSONArray musiclist = new JSONArray();

        musiclist = new JSONArray();
        JSONObject jsonObject = test.getone("1","世界","逃跑计划"," 逃跑计划 (Escape Plan) 首张专辑。","./src/img/世界.jpg","2012-01-01");
        ablum.put(jsonObject);
        JSONObject jsonObject1 = test.getmusic("./src/music/世界/逃跑计划 - Apple.mp3","Apple","逃跑计划","03:49");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/世界/逃跑计划 - Chemical Bus.mp3"," Chemical Bus","逃跑计划","04:10");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/世界/逃跑计划 - Is This Love.mp3","Is This Love","逃跑计划","03:36");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/世界/逃跑计划 - Take Me Away.mp3","Take Me Away","逃跑计划","03:28");
        musiclist.put(jsonObject1);
        System.out.println(musiclist.toString());
        writeFile("./src/data/1.json", musiclist.toString());

        musiclist = new JSONArray();
        jsonObject = test.getone("2","一个人去巴黎","董又霖"," 2018  Jeffrey董又霖全新单曲《一个人去巴黎》上线","./src/img/一个人去巴黎.jpg","2016-09-15");
        ablum.put(jsonObject);
        jsonObject1 = test.getmusic("./src/music/一个人去巴黎/董又霖 - 一个人去巴黎 (和声版伴奏).mp3","一个人去巴黎 (和声版伴奏)","董又霖","04:12");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/一个人去巴黎/董又霖 - 一个人去巴黎 (无和声版伴奏).mp3","一个人去巴黎 (无和声版伴奏)","董又霖","04:12");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/一个人去巴黎/董又霖 - 一个人去巴黎.mp3","一个人去巴黎","董又霖","04:12");
        musiclist.put(jsonObject1);
        System.out.println(musiclist.toString());
        writeFile("./src/data/2.json", musiclist.toString());



        musiclist = new JSONArray();
        jsonObject = test.getone("3","Time","Alan Walker"," 早期的做的一些,有原创,有翻唱,有Remix..都是我个人很喜欢才做的.录音有很多瑕疵,但是问题不大。","./src/img/Time.jpg","2018-03-29");
        ablum.put(jsonObject);
        jsonObject1 = test.getmusic("./src/music/Time/AkaDaliang - Faded.mp3","Faded","Alan Walker","01:45");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/Time/AkaDaliang - 廖效浓 - 不会是你男友Remix（AkaDaliang remix）.mp3","不会是你男友Remix","Alan Walker","04:06");
        musiclist.put(jsonObject1);
        jsonObject1 = test.getmusic("./src/music/Time/AkaDaliang - 梦里面（Cover Tizzy T）.mp3","梦里面（Cover Tizzy T）","Alan Walker","04:16");
        musiclist.put(jsonObject1);
        System.out.println(musiclist.toString());
        writeFile("./src/data/3.json", musiclist.toString());

        musiclist = new JSONArray();
        jsonObject = test.getone("4","白羊","徐秉龙/沈以诚","《白羊》是徐秉龙、沈以诚演唱的一首歌曲，由徐秉龙作词、作曲，于2017年10月26日以单曲形式发行","./src/img/白羊.jpg","2017-10-26");
        ablum.put(jsonObject);
        jsonObject1 = test.getmusic("./src/music/白羊/白羊.mp3","白羊","徐秉龙/沈以诚","02:48");
        musiclist.put(jsonObject1);

        System.out.println(musiclist.toString());
        writeFile("./src/data/4.json", musiclist.toString());

        musiclist = new JSONArray();
        jsonObject = test.getone("5","等你下课","周杰伦"," 歌曲主打校园纯情风，歌词则阐述年轻人暗恋女孩，苦苦追求、每天等对方下课的心情","./src/img/等你下课.jpg","2018-02-22");
        ablum.put(jsonObject);
        jsonObject1 = test.getmusic("./src/music/等你下课/等你下课.mp3","等你下课","周杰伦","04:30");
        musiclist.put(jsonObject1);

        System.out.println(musiclist.toString());
        writeFile("./src/data/5.json", musiclist.toString());


        writeFile("./src/data/ablum.json", ablum.toString());


//
//        writeFile("./src/ablums.json", ablum.toString());
    }

    public static void writeFile(String filePath, String sets)
            throws IOException {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }

    public static String ReadFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }
}
