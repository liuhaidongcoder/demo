package com.liuhaidongcoder.swing;

import javax.swing.*;

/**
 * @author Liu Haidong
 * @date 21/2/2
 */
public class JMenuBarFactory {

    /**
     * 创建菜单工具栏
     *
     * @return
     */
    public static JMenuBar createJMenuBar() {
        //菜单工具栏
        JMenuBar jMenuBar = new JMenuBar();

        //文件菜单
        JMenu fileMenu = new JMenu("文件");
        JMenuItem newMenuItem = new JMenu("新建");
        JMenuItem openMenuItem = new JMenu("打开");
        JMenuItem saveMenuItem = new JMenu("保存");
        JMenuItem importMenuItem = new JMenu("导入");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(importMenuItem);
        //编辑菜单
        JMenu editMenu = new JMenu("编辑");
        //帮助菜单
        JMenu helpMenu = new JMenu("帮助");

        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(helpMenu);

        return jMenuBar;
    }
}
