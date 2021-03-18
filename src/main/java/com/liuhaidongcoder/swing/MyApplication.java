package com.liuhaidongcoder.swing;

import com.sun.deploy.panel.JavaPanel;
import jdk.nashorn.api.scripting.URLReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Liu Haidong
 * @date 21/2/2
 */
public class MyApplication {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Demo");
        //设置窗体大小 参照马克飞象大小设置
        jFrame.setSize(800, 600);
        //设置位置
        jFrame.setLocation(240, 57);

        //设置菜单工具栏
        jFrame.setJMenuBar(JMenuBarFactory.createJMenuBar());

        //设置布局管理器
        LayoutManager borderLayout = new BorderLayout();
        jFrame.setLayout(borderLayout);

       /* JTabbedPane jp=new JTabbedPane(JTabbedPane.LEFT) ;
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        jp.add("Main", p1);
        jp.add("Setting", p2);
        jp.add("E-mail", p3);
        jp.add("Security", p4);
        jFrame.add(jp,BorderLayout.WEST);*/


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入URL");
        JTextField jTextField = new JTextField();
        JButton jButton = new JButton("点击");

        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(jTextField, BorderLayout.CENTER);
        jPanel.add(jButton, BorderLayout.EAST);
        jPanel.add(jTextField);

        jFrame.add(jPanel, BorderLayout.NORTH);


        JPanel jPanel1 = new JavaPanel();
        JTextArea jTextArea = new JTextArea();
        jPanel1.add(jTextArea);

        JScrollPane jScrollPane = new JScrollPane(jPanel1);


        jFrame.add(jScrollPane,BorderLayout.CENTER);



        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String urlStr = jTextField.getText();
                try {
                    URL url = new URL(urlStr);
                    BufferedReader inputStream = new BufferedReader(new URLReader(url));
                    StringBuffer stringBuffer = new StringBuffer();
                    String line = null;
                    while ((line = inputStream.readLine()) != null) {
                        stringBuffer.append(line + "\n");
                    }

                    jTextArea.setText(stringBuffer.toString());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
