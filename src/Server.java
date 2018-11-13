
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Server {
    public static final int PORT = 12345;// 监听的端口号     

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        //  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Server server = new Server();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接    
                Socket client = serverSocket.accept();
                // 处理这次连接    
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常:" + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {

            try {
                // 读取客户端数据    
                System.out.println("客户端数据已经连接");
                DataInputStream inputStream = null;
                DataOutputStream outputStream = null;
                String strInputstream ="";
                inputStream =new DataInputStream(socket.getInputStream());
                byte[] bytes = new byte[4];
                inputStream.read(bytes);
                int length = BytesUtils.byteArray2Int(bytes);
                bytes = new byte[length];
                inputStream.read(bytes);

                JSONObject jsonReceive = new JSONObject(new String(bytes));
                String op = jsonReceive.getString("op");
                System.out.println(op);
                String mes = new String();
                switch (op){
                    case "ablum":{
                        mes = ablum.ReadFile("./src/data/ablum.json");
                        System.out.println(mes);
                        break;
                    }
                    case "musiclist":{

                        String name = jsonReceive.getString("id");
                        System.out.println(name);
                        mes = ablum.ReadFile("./src/data/"+name+".json");
                        break;
                    }
                }
                byte[] msgByte = mes.getBytes();
                // 计算消息长度
                int len = msgByte.length;
                // 将消息长度加在首部
                // 消息格式： 长度 + 消息
                msgByte = BytesUtils.connectBytes(BytesUtils.int2ByteArrays(len), msgByte);
                outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.write(msgByte);
                outputStream.flush();
                System.out.println("传输数据完毕");
                //                System.out.println("接受到的数据长度为："+strInputstream);
                // 处理客户端数据    
                // 将 socket 接受到的数据还原为 JSONObject



            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("服务器 run 异常:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}    