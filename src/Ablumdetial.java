import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;
/*
 * Created by JFormDesigner on Mon Oct 22 17:19:48 CST 2018
 */



/**
 * @author jframe
 */
public class Ablumdetial extends JFrame {
    public Ablumdetial() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        jphoto = new JLabel();
        jablumname = new JLabel();
        jsonger = new JLabel();
        scrollPane2 = new JScrollPane();
        jintroduce = new JTextPane();
        textArea1 = new JTextArea();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setFont(new Font("Dialog", Font.PLAIN, 20));
        setBackground(Color.white);
        setForeground(Color.white);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- jphoto ----
            jphoto.setForeground(Color.white);
            jphoto.setBackground(Color.cyan);
            panel1.add(jphoto);
            jphoto.setBounds(25, 5, 181, 190);

            //---- jablumname ----
            jablumname.setText("\u4e13\u8f91\u540d");
            jablumname.setBackground(Color.white);
            panel1.add(jablumname);
            jablumname.setBounds(235, 5, 280, 40);

            //---- jsonger ----
            jsonger.setText("\u6b4c\u624b");
            panel1.add(jsonger);
            jsonger.setBounds(235, 50, 131, 25);

            //======== scrollPane2 ========
            {
                scrollPane2.setBackground(Color.white);

                //---- jintroduce ----
                jintroduce.setBackground(Color.white);
                jintroduce.setForeground(Color.darkGray);
                jintroduce.setEditable(false);
                scrollPane2.setViewportView(jintroduce);
            }
            panel1.add(scrollPane2);
            scrollPane2.setBounds(235, 105, 295, 80);
            panel1.add(textArea1);
            textArea1.setBounds(780, 171, 20, 20);

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //---- table1 ----
                table1.setBackground(Color.white);
                table1.setShowHorizontalLines(false);
                table1.setShowVerticalLines(false);
                table1.setGridColor(Color.white);
                table1.setBorder(new LineBorder(Color.white));
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(15, 220, 525, 100);

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
        panel1.setBounds(0, 0, 560, 370);

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel jphoto;
    private JLabel jablumname;
    private JLabel jsonger;
    private JScrollPane scrollPane2;
    private JTextPane jintroduce;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void setinit(JSONArray ablumdetial,String name,String songer,String imgdir,String message){
        Font f = new Font("微软雅黑",Font.BOLD,20);
        table1.setShowGrid(false);
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        table1.getTableHeader().setBackground(new Color(246, 255, 252));
        Dimension size = table1.getTableHeader().getPreferredSize();
        size.height = 0;//设置新的表头高度32
        table1.getTableHeader().setPreferredSize(size);

        jablumname.setText("专辑："+name);
        jablumname.setFont(f);
        jintroduce.setText("    "+message);
        jintroduce.setEditable(false);
        jsonger.setText("歌手： "+songer);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.addColumn("音乐标题");
        tableModel.addColumn("歌手");
        tableModel.addColumn("时长");
        setlabel(imgdir);
        DefaultTableCellRenderer r  =  new  DefaultTableCellRenderer();
        r.setHorizontalAlignment(JTextField.CENTER);
        table1.getColumn("歌手").setCellRenderer(r);
        table1.getColumn("时长").setCellRenderer(r);
        for(int i=0;i<ablumdetial.length();i++){
            JSONObject object = (JSONObject) ablumdetial.get(i);
            String[] arr=new String[3];
            arr[0]=object.getString("name");
            arr[1]=object.getString("songer");
            arr[2]=object.getString("time");
            tableModel.addRow(arr);
        }
        table1.setPreferredSize(new Dimension(450,(6*table1.getRowHeight())));
        scrollPane1.setPreferredSize(new Dimension(450,(6*table1.getRowHeight())));

    }
    public void setlabel(String img) {
        System.out.println(img);
        ImageIcon icon = new ImageIcon(img);
        icon.setImage(icon.getImage().getScaledInstance(181,185,Image.SCALE_DEFAULT));//80 和 100 为大小 可以自由设置
        jphoto.setIcon(icon);
    }
}
