package com.liuhaidongcoder;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Liu Haidong
 * @date 21/1/9
 */
public class awt {
    public static void main(String[] args) {
        Frame frame=new Frame();
        //设置Java窗体组件的名称
        frame.setTitle("JavaGUIComponent");
        //设置窗体的顶点位置及其大小
        frame.setBounds(20,30,300,280);
        //设置窗体是否可见
        frame.setVisible(true);
        //设置窗体背景颜色
        frame.setBackground(Color.gray);
        frame.add(new List());
        /*给窗体添加监听器的方法改变窗体状态,监听器的参数是一个内部类，
         *     内部类定义了窗体关闭的处理方法
         */
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        //创建一个panel面板
      /*  Panel panel=new Panel();
        //给panel面板添加文本框、文本域、列表、单选按钮、复选按钮、画布、标签、字体大小、事件、滚动条
        panel.add(new TextField(20));
        panel.add(new Button("Click me!"));

        frame.add(panel);*/
    }
}
