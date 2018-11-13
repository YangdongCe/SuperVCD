import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.factories.*;

import net.miginfocom.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;
/*
 * Created by JFormDesigner on Tue Oct 23 19:08:27 CST 2018
 */



/**
 * @author jframe
 */
public class Newpage extends JFrame {
    public Newpage() {
        initComponents();
    }
    public static int this_ablum = 0;
    public static boolean isStore = true;
    private void label6MouseClicked(MouseEvent e) {
        Runer.close();
        // TODO add your code here
    }

    private void scrollPane1MouseClicked(MouseEvent e) {

    }

    private void table1MouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            if (isStore){
                this_ablum = table1.getSelectedRow();
                JSONObject item = Runer.ablumlists.getJSONObject(table1.getSelectedRow());
                System.out.println(item.toString());
                setalbum(item);

            }
            else{
                Runer.playmusic(Runer.ownmusics.getJSONObject(table1.getSelectedRow()));

            }


        }


    }

    private void label11MousePressed(MouseEvent e) {
        // TODO add your code here

    }

    private void label11MouseClicked(MouseEvent e) {

        if(Runer.isBuy(this_ablum)){
            return;
        }
        Runer.addown(this_ablum);
        setlabel(label11,"./src/img/oks.png",85,85);
        // TODO add your code here
    }

    private void table2MouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            if(Runer.isBuy(this_ablum)){
                JSONArray musics =new JSONArray(Client.getablumdetial("musiclist",Runer.ablumlists.getJSONObject(this_ablum).getString("id")));
                Runer.playmusic(musics.getJSONObject(musiclist.getSelectedRow()));
            }

        }
    }

    private void label15MouseClicked(MouseEvent e) {
        if (isStore) {
            setlabel(tablebutton, "./src/img/mymusic.png", 184, 30);
            setMymusic();


        }
        else{
            setlabel(tablebutton, "./src/img/store.png", 184, 30);
            setStore();

        }
        isStore=!isStore;
    }

    private void label16MouseClicked(MouseEvent e) {
        Runer.stopmusic();
    }

    private void initComponents() {
        this.setUndecorated(true);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        panel1 = new JPanel();
        panel2 = new JPanel();
        jphotobg = new JPanel();
        jphoto = new JLabel();
        label9 = compFactory.createLabel("text");
        albumname = compFactory.createLabel("text");
        songerLab = compFactory.createLabel("\u6b4c\u624b");
        scrollPane2 = new JScrollPane();
        musiclist = new JTable();
        panel5 = new JPanel();
        label13 = new JLabel();
        label14 = compFactory.createLabel("text");
        scrollPane3 = new JScrollPane();
        message = new JTextPane();
        label11 = compFactory.createLabel("text");
        panel3 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        title = compFactory.createLabel("");
        close = compFactory.createLabel("text");
        label7 = compFactory.createLabel("text");
        label8 = compFactory.createLabel("text");
        tablebutton = new JLabel();
        panel6 = new JPanel();
        playsonger = new JLabel();
        playstategif = new JLabel();
        playtime = new JLabel();
        playname = new JLabel();
        label20 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(79, 134, 198));
                panel2.setBorder(null);
                panel2.setForeground(new Color(214, 236, 250));
                panel2.setLayout(null);

                //======== jphotobg ========
                {
                    jphotobg.setBackground(new Color(214, 236, 250));
                    jphotobg.setBorder(new LineBorder(Color.white, 10, true));
                    jphotobg.setLayout(null);
                    jphotobg.add(jphoto);
                    jphoto.setBounds(5, 5, 160, 160);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < jphotobg.getComponentCount(); i++) {
                            Rectangle bounds = jphotobg.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = jphotobg.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        jphotobg.setMinimumSize(preferredSize);
                        jphotobg.setPreferredSize(preferredSize);
                    }
                }
                panel2.add(jphotobg);
                jphotobg.setBounds(86, 35, 170, 170);

                //---- label9 ----
                label9.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\album.png"));
                panel2.add(label9);
                label9.setBounds(40, 215, 50, 45);

                //---- albumname ----
                albumname.setText("music");
                albumname.setForeground(Color.white);
                albumname.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 18));
                albumname.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(albumname);
                albumname.setBounds(85, 215, 165, 40);

                //---- songerLab ----
                songerLab.setForeground(new Color(165, 223, 249));
                songerLab.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 14));
                panel2.add(songerLab);
                songerLab.setBounds(250, 215, 90, 40);

                //======== scrollPane2 ========
                {
                    scrollPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
                    scrollPane2.setBackground(Color.white);
                    scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

                    //---- musiclist ----
                    musiclist.setSelectionForeground(Color.white);
                    musiclist.setForeground(new Color(102, 102, 102));
                    musiclist.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                    musiclist.setAutoCreateRowSorter(true);
                    musiclist.setBorder(new LineBorder(Color.white, 1, true));
                    musiclist.setBackground(Color.white);
                    musiclist.setGridColor(Color.white);
                    musiclist.setVerifyInputWhenFocusTarget(false);
                    musiclist.setUpdateSelectionOnSort(false);
                    musiclist.setSelectionBackground(new Color(132, 177, 237));
                    musiclist.setModel(new DefaultTableModel());
                    musiclist.setFocusable(false);
                    musiclist.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            table2MouseClicked(e);
                        }
                    });
                    scrollPane2.setViewportView(musiclist);
                }
                panel2.add(scrollPane2);
                scrollPane2.setBounds(15, 380, 325, 95);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(132, 177, 237));
                    panel5.setLayout(null);

                    //---- label13 ----
                    label13.setText("\u6b4c\u540d");
                    label13.setHorizontalAlignment(SwingConstants.CENTER);
                    label13.setForeground(Color.white);
                    label13.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 12));
                    panel5.add(label13);
                    label13.setBounds(0, 0, 160, 25);

                    //---- label14 ----
                    label14.setHorizontalAlignment(SwingConstants.CENTER);
                    label14.setText("\u65f6\u957f");
                    label14.setForeground(Color.white);
                    label14.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 12));
                    panel5.add(label14);
                    label14.setBounds(160, 0, 160, 25);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel5.getComponentCount(); i++) {
                            Rectangle bounds = panel5.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel5.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel5.setMinimumSize(preferredSize);
                        panel5.setPreferredSize(preferredSize);
                    }
                }
                panel2.add(panel5);
                panel5.setBounds(15, 355, 325, 25);

                //======== scrollPane3 ========
                {
                    scrollPane3.setBorder(null);
                    scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                    scrollPane3.setViewportBorder(null);

                    //---- message ----
                    message.setText("     2018  Jeffrey\u8463\u53c8\u9716\u5168\u65b0\u5355\u66f2\u300a\u4e00\u4e2a\u4eba\u53bb\u5df4\u9ece\u300b\u4e0a\u7ebf");
                    message.setBackground(new Color(79, 134, 198));
                    message.setBorder(null);
                    message.setForeground(new Color(214, 236, 250));
                    message.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 12));
                    message.setEditable(false);
                    scrollPane3.setViewportView(message);
                }
                panel2.add(scrollPane3);
                scrollPane3.setBounds(30, 280, 285, 50);

                //---- label11 ----
                label11.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\buys.png"));
                label11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        label11MouseClicked(e);
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        label11MousePressed(e);
                    }
                });
                panel2.add(label11);
                label11.setBounds(0, 0, 85, 85);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(0, 0, 360, 510);

            //======== panel3 ========
            {
                panel3.setBackground(new Color(79, 134, 198));
                panel3.setLayout(null);

                //---- label1 ----
                label1.setText("\u97f3\u4e50\u6807\u9898");
                label1.setBackground(Color.white);
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setForeground(Color.white);
                label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                panel3.add(label1);
                label1.setBounds(0, 0, 160, 30);

                //---- label2 ----
                label2.setText("\u6b4c\u624b");
                label2.setBackground(new Color(255, 238, 228));
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setForeground(Color.white);
                label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                panel3.add(label2);
                label2.setBounds(150, 0, 160, 30);

                //---- label3 ----
                label3.setText("\u65f6\u95f4");
                label3.setBackground(new Color(255, 238, 228));
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                label3.setForeground(Color.white);
                label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                panel3.add(label3);
                label3.setBounds(300, 0, 165, 30);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(415, 165, 460, 30);

            //---- title ----
            title.setForeground(new Color(79, 134, 198));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 40));
            title.setVisible(false);
            panel1.add(title);
            title.setBounds(430, 15, 414, 80);

            //---- close ----
            close.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\close.png"));
            close.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label6MouseClicked(e);
                }
            });
            panel1.add(close);
            close.setBounds(900, 5, 25, 25);

            //---- label7 ----
            label7.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\zhuidahua.png"));
            panel1.add(label7);
            label7.setBounds(865, 5, 25, 25);

            //---- label8 ----
            label8.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\diplay.png"));
            panel1.add(label8);
            label8.setBounds(825, 5, 25, 25);

            //---- tablebutton ----
            tablebutton.setHorizontalAlignment(SwingConstants.CENTER);
            tablebutton.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\store.png"));
            tablebutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label15MouseClicked(e);
                }
            });
            panel1.add(tablebutton);
            tablebutton.setBounds(540, 125, 205, 32);

            //======== panel6 ========
            {
                panel6.setBackground(Color.white);
                panel6.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
                panel6.setLayout(null);

                //---- playsonger ----
                playsonger.setText(" Ryanair");
                playsonger.setForeground(new Color(102, 102, 102));
                playsonger.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));
                playsonger.setHorizontalAlignment(SwingConstants.LEFT);
                panel6.add(playsonger);
                playsonger.setBounds(105, 50, 115, 20);

                //---- playstategif ----
                playstategif.setHorizontalAlignment(SwingConstants.CENTER);
                playstategif.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\music.png"));
                playstategif.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        label16MouseClicked(e);
                    }
                });
                panel6.add(playstategif);
                playstategif.setBounds(20, 10, 70, 70);

                //---- playtime ----
                playtime.setText("00:00");
                playtime.setHorizontalAlignment(SwingConstants.CENTER);
                playtime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 12));
                playtime.setForeground(new Color(153, 153, 153));
                panel6.add(playtime);
                playtime.setBounds(403, 21, 45, 20);

                //---- playname ----
                playname.setText("Album Store");
                playname.setHorizontalAlignment(SwingConstants.LEFT);
                playname.setForeground(new Color(44, 62, 80));
                playname.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 22));
                panel6.add(playname);
                playname.setBounds(105, 10, 280, 40);

                //---- label20 ----
                label20.setIcon(new ImageIcon("E:\\JavaProject\\untitled\\src\\img\\Download.png"));
                label20.setHorizontalAlignment(SwingConstants.CENTER);
                panel6.add(label20);
                label20.setBounds(410, 45, 30, 30);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel6);
            panel6.setBounds(415, 30, 460, 85);

            //======== scrollPane1 ========
            {
                scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
                scrollPane1.setBackground(Color.white);
                scrollPane1.setAutoscrolls(true);
                scrollPane1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        scrollPane1MouseClicked(e);
                    }
                });

                //---- table1 ----
                table1.setBorder(new LineBorder(Color.white));
                table1.setGridColor(Color.white);
                table1.setBackground(Color.white);
                table1.setModel(new DefaultTableModel());
                table1.setSelectionBackground(new Color(132, 177, 237));
                table1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                table1.setSelectionForeground(Color.white);
                table1.setForeground(new Color(102, 102, 102));
                table1.setFocusable(false);
                table1.setVerifyInputWhenFocusTarget(false);
                table1.setAutoCreateRowSorter(true);
                table1.setOpaque(false);
                table1.setUpdateSelectionOnSort(false);
                table1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        table1MouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(410, 195, 470, 290);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 935, 510);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        panel1.setBorder(BorderFactory.createLineBorder(Color.white, 10, true));


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JPanel jphotobg;
    private JLabel jphoto;
    private JLabel label9;
    private JLabel albumname;
    private JLabel songerLab;
    private JScrollPane scrollPane2;
    private JTable musiclist;
    private JPanel panel5;
    private JLabel label13;
    private JLabel label14;
    private JScrollPane scrollPane3;
    private JTextPane message;
    private JLabel label11;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel title;
    private JLabel close;
    private JLabel label7;
    private JLabel label8;
    private JLabel tablebutton;
    private JPanel panel6;
    private JLabel playsonger;
    private JLabel playstategif;
    private JLabel playtime;
    private JLabel playname;
    private JLabel label20;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void setinit(JSONArray ablums){
        DefaultTableModel t = new DefaultTableModel(0,0){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        table1.setModel(t);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.addColumn("音乐标题");
        tableModel.addColumn("歌手");
        tableModel.addColumn("时间");
        Dimension size = table1.getTableHeader().getPreferredSize();
        size.height = 0;
        table1.getTableHeader().setPreferredSize(size);
        DefaultTableCellRenderer r  =  new  DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        table1.getColumn("歌手").setCellRenderer(r);
        table1.getColumn("时间").setCellRenderer(r);
        table1.getColumn("音乐标题").setCellRenderer(r);
        table1.setRowHeight(25);
        JSONObject object1 = (JSONObject) ablums.get(0);
        setalbum(object1);
        setlabel(title,"./src/img/title.jpg",414,80);
        for(int i=0;i<ablums.length();i++){
            JSONObject object = (JSONObject) ablums.get(i);
            String[] arr=new String[3];
            arr[0]=object.getString("name");
            arr[1]=object.getString("songer");
            arr[2]=object.getString("time");
            tableModel.addRow(arr);
            System.out.println(object);
        }


    }
    public void setalbum(JSONObject album){
        if(Runer.isBuy(this_ablum)){
            setlabel(label11,"./src/img/oks.png",85,85);
        }
        else{
            setlabel(label11,"./src/img/buys.png",85,85);
        }

        DefaultTableModel t = new DefaultTableModel(0,0){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        if(Runer.isBuy(this_ablum))setlabel(label11,"./src/img/oks.png",85,85);
        musiclist.setModel(t);
        message.setText(album.getString("meg"));
        setlabel(jphoto,album.getString("img"),160,160);
        albumname.setText(album.getString("name"));
        songerLab.setText(album.getString("songer"));
        JSONArray musiclists = Runer.ablumdetail(album.getString("id"));
        DefaultTableModel tableModel = (DefaultTableModel) musiclist.getModel();
        tableModel.addColumn("歌曲名称");
        tableModel.addColumn("时长");
        Dimension size = musiclist.getTableHeader().getPreferredSize();
        size.height = 0;
        musiclist.getTableHeader().setPreferredSize(size);
        DefaultTableCellRenderer r  =  new  DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        musiclist.setRowHeight(20);
        musiclist.getColumn("歌曲名称").setCellRenderer(r);
        musiclist.getColumn("时长").setCellRenderer(r);
        for(int i=0;i<musiclists.length();i++){
            JSONObject item =(JSONObject) musiclists.get(i);
            String[] arr = new String[2];
            arr[0] = item.getString("name");
            arr[1] = item.getString("time");
            tableModel.addRow(arr);


        }


    }
    public void setlabel(JLabel label,String img,int width, int height) {
        ImageIcon icon = new ImageIcon(img);
        icon.setImage(icon.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));//80 和 100 为大小 可以自由设置
        label.setIcon(icon);

    }
    public void setStore(){
        DefaultTableModel t = new DefaultTableModel(0,0){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        table1.setModel(t);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.addColumn("音乐标题");
        tableModel.addColumn("歌手");
        tableModel.addColumn("时间");
        Dimension size = table1.getTableHeader().getPreferredSize();
        size.height = 0;
        table1.getTableHeader().setPreferredSize(size);
        DefaultTableCellRenderer r  =  new  DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        table1.getColumn("歌手").setCellRenderer(r);
        table1.getColumn("时间").setCellRenderer(r);
        table1.getColumn("音乐标题").setCellRenderer(r);
        table1.setRowHeight(25);
        for(int i=0;i<Runer.ablumlists.length();i++){
            JSONObject object = (JSONObject) Runer.ablumlists.get(i);
            String[] arr=new String[3];
            arr[0]=object.getString("name");
            arr[1]=object.getString("songer");
            arr[2]=object.getString("time");
            tableModel.addRow(arr);
            System.out.println(object);
        }
    }
    public void setMymusic(){
        DefaultTableModel t = new DefaultTableModel(0,0){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        table1.setModel(t);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.addColumn("音乐标题");
        tableModel.addColumn("歌手");
        tableModel.addColumn("时间");
        Dimension size = table1.getTableHeader().getPreferredSize();
        size.height = 0;
        table1.getTableHeader().setPreferredSize(size);
        DefaultTableCellRenderer r  =  new  DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        table1.getColumn("歌手").setCellRenderer(r);
        table1.getColumn("时间").setCellRenderer(r);
        table1.getColumn("音乐标题").setCellRenderer(r);
        table1.setRowHeight(25);
        for(int i=0;i<Runer.ownmusics.length();i++){
            JSONObject object = (JSONObject) Runer.ownmusics.get(i);
            String[] arr=new String[3];
            arr[0]=object.getString("name");
            arr[1]=object.getString("songer");
            arr[2]=object.getString("time");
            tableModel.addRow(arr);
            System.out.println(object);
        }
    }
    public void setMusicPlay(String name,String songer,String time){
        playname.setText(name);
        playsonger.setText(songer);
        playtime.setText(time);
        setlabel(playstategif,"./src/img/play.gif",64,64);
    }
    public void setMusicStop(String name,String songer,String time){
        playname.setText(name);
        playsonger.setText(songer);
        playtime.setText(time);
        setlabel(playstategif,"./src/img/stop.png",64,64);
    }
}
