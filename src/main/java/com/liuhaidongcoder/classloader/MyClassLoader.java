package com.liuhaidongcoder.classloader;

import com.google.common.collect.Maps;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Liu Haidong
 * @date 20/7/15
 */
public class MyClassLoader extends ClassLoader {
    public String path;
    public String classLoaderName;
    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String file) throws ClassNotFoundException {

        /*String FilePath = this.path + name.replaceAll("\\.", "/") + ".class";
        File file = new File(FilePath);
        System.out.println(file);
        if(!file.exists()) {
            System.out.println("找不到文件！");
            return null;
        }
        byte[] b = loadClassByteCodeByFile(file);
        if(b == null) {
            return null;
        }*/
        byte[] b = loadClassByteCodeByJarFile(file);
        return defineClass("com.bj58.norman.common.tuple.Tuple2",b,0,b.length);
    }

    private byte[] loadClassByteCodeByFile(File file) {
            InputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                int i = 0;
                while ((i = in.read()) != -1) {
                    out.write(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return out.toByteArray();

    }

    public byte[] loadClassByteCodeByJarFile(String path){
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Enumeration<JarEntry> ee = jarFile.entries();

            List<JarEntry> jarEntryList = new ArrayList<JarEntry>();
            while (ee.hasMoreElements()) {
                JarEntry entry = (JarEntry) ee.nextElement();
                // 过滤我们出满足我们需求的东西，这里的fileName是指向一个具体的文件的对象的完整包路径，比如com/mypackage/test.txt
                if (entry.getName().endsWith("Tuple2.class")) {
                    System.out.println(entry);
                    jarEntryList.add(entry);
                }

            }
            try {
                InputStream in = jarFile.getInputStream(jarEntryList.get(0));
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                String s;
                int i = 0;
                while ((i = in.read()) != -1) {
                    out.write(i);
                }
                return out.toByteArray();
            } catch (IOException e) {
                throw new  NullPointerException();
            }

    }
}
