import java.awt.event.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Oct 19 15:28:25 CST 2018
 */



/**
 * @author jframe
 */
public class Index extends JFrame {
    public Index() {
        setUIFont();
        initComponents();
    }
    public static void setUIFont()
    {
        Font f = new Font("微软雅黑",Font.PLAIN,12);
        String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
                "JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField","TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
        };
        for (String item : names) {
            UIManager.put(item+ ".font",f);
        }
    }
    private void list1MouseClicked(MouseEvent e) {
        if (e.getClickCount()==2){

            Runer.ablumdetail(list1.getSelectedValue().toString());
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        panel2 = new JPanel();

        //======== this ========
        setBackground(Color.white);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel3 ========
        {
            panel3.setLayout(null);

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
        contentPane.add(panel3);
        panel3.setBounds(new Rectangle(new Point(195, 90), panel3.getPreferredSize()));

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBackground(Color.white);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- label1 ----
                label1.setText("\u97f3\u4e50\u7c7b\u578b");
                panel1.add(label1);
                label1.setBounds(new Rectangle(new Point(15, 10), label1.getPreferredSize()));

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u5927\u9646",
                    "\u6b27\u7f8e"
                }));
                comboBox1.setBackground(Color.white);
                panel1.add(comboBox1);
                comboBox1.setBounds(new Rectangle(new Point(75, 5), comboBox1.getPreferredSize()));

                //======== scrollPane1 ========
                {

                    //---- list1 ----
                    list1.setBackground(Color.white);
                    list1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            list1MouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(list1);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(15, 55, 370, 185);

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
            tabbedPane1.addTab("\u4e13\u8f91", panel1);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setLayout(null);

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
            tabbedPane1.addTab("\u97f3\u4e50", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 410, 315);

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
    private JPanel panel3;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JComboBox<String> comboBox1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void getlist(JSONArray ablums){
        Vector ablum = new Vector();
        for (int i = 0; i < ablums.length(); i++) {
            JSONObject object = (JSONObject) ablums.get(i);
            String name = object.getString("name")+" - "+object.getString("songer");
            System.out.println(name);
            ablum.add(name);
        }
        list1.setListData(ablum);

    }
}
