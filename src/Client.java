import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;


public class Client {
    public static final String IP_ADDR = "127.0.0.1";// 服务器地址  这里要改成服务器的 ip
    public static final int PORT = 12345;// 服务器端口号
    private static DataInputStream inputStream = null;
    private static DataOutputStream outputStream = null;
    private static String message = "";
    private static Socket socket = null;

    public static String getmsg(String opNum){
        try {
            socket = new Socket(IP_ADDR,PORT);
            System.out.println("连接已经建立");
            // 向服务器端发送数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("op",opNum);
            byte[] jsonByte = PackMsgUtil.packMsg(map);

            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(jsonByte);
            outputStream.flush();
            System.out.println("传输数据完毕");
            inputStream =new DataInputStream(socket.getInputStream());
            byte[] bytes = new byte[4];
            inputStream.read(bytes);
            int length = BytesUtils.byteArray2Int(bytes);
            bytes = new byte[length];
            inputStream.read(bytes);

            message = new String(bytes,"UTF-8");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端异常:" + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("客户端 finally 异常:");
                }
            }
        }

        return message;
    }
    public static String getablumdetial(String opNum,String id){
        try {
            socket = new Socket(IP_ADDR,PORT);
            System.out.println("连接已经建立");
            // 向服务器端发送数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("op",opNum);
            map.put("id",id);
            byte[] jsonByte = PackMsgUtil.packMsg(map);
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(jsonByte);
            outputStream.flush();
            System.out.println("传输数据完毕");
            inputStream =new DataInputStream(socket.getInputStream());
            byte[] bytes = new byte[4];
            try {
                inputStream.read(bytes);
                int length = BytesUtils.byteArray2Int(bytes);
                bytes = new byte[length];
                inputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            message = new String(bytes,"UTF-8");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端异常:" + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("客户端 finally 异常:" + e.getMessage());
                }
            }
        }

        return message;
    }
}
