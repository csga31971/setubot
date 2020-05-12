package xyz.csga;

import xyz.csga.event.AbstractEvent;
import xyz.csga.event.EventHandler;

import java.io.File;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Registry {

    public static Map<Class, List<EventHandler>> handlerMap = new HashMap<>();

    public static void scanPackage(String iPackage) {
        String path = iPackage.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(path);
        System.out.println(url.toString());
        if (url != null && url.toString().startsWith("file")) {
            try {
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                File dir = new File(filePath);
                List<File> fileList = new ArrayList<>();
                fetchFileList(dir, fileList);
                for (File f : fileList) {
                    String fileName = f.getAbsolutePath();
                    if (fileName.endsWith(".class")) {
                        String nosuffixFileName = fileName.substring(8 + fileName.lastIndexOf("classes"), fileName.indexOf(".class"));
                        String filePackage = nosuffixFileName.replaceAll("\\\\", ".");
                        Class<?> clazz = Class.forName(filePackage);
                        Method[] methods = clazz.getDeclaredMethods();
                        for(Method method : methods){
                            if(method.isAnnotationPresent(xyz.csga.annotation.EventHandler.class)){
                                Class parameterType = method.getParameterTypes()[0];
                                if(method.getParameterCount() == 1 && parameterType.getSuperclass() == AbstractEvent.class){
                                    EventHandler eventHandler = new EventHandler(method);
                                    handlerMap.computeIfAbsent(parameterType, k -> new ArrayList<>()).add(eventHandler);
                                    System.out.println("Registered from .class: " + method.getName());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (url != null && url.toString().startsWith("jar:file")) {
            findJarClass(iPackage);
        }
    }

    private static void fetchFileList(File dir,List<File> fileList){
        if(dir.isDirectory()){
            for(File f:dir.listFiles()){
                fetchFileList(f,fileList);
            }
        }else{
            fileList.add(dir);
        }
    }

    private static void findClass(String iPackage){
        try {
            String filePath = iPackage.replace(".", "/");
            File dir = new File(filePath);
            List<File> fileList = new ArrayList<>();
            fetchFileList(dir, fileList);
            for (File f : fileList) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    String nosuffixFileName = fileName.substring(8 + fileName.lastIndexOf("classes"), fileName.indexOf(".class"));
                    String filePackage = nosuffixFileName.replaceAll("\\\\", ".");
                    Class<?> clazz = Class.forName(filePackage);
                    Method[] methods = clazz.getDeclaredMethods();
                    for(Method method : methods){
                        if(method.isAnnotationPresent(xyz.csga.annotation.EventHandler.class)){
                            Class parameterType = method.getParameterTypes()[0];
                            if(method.getParameterCount() == 1 && parameterType.getSuperclass() == AbstractEvent.class){
                                EventHandler eventHandler = new EventHandler(method);
                                handlerMap.computeIfAbsent(parameterType, k -> new ArrayList<>()).add(eventHandler);
                                System.out.println("Registered from .class: " + method.getName());
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void findJarClass(String iPackage) {
        try {
            String path = iPackage.replace(".", "/");
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource(path);
            JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
            JarFile jarFile = jarURLConnection.getJarFile();
            Enumeration<JarEntry> jarEntries = jarFile.entries();
            while (jarEntries.hasMoreElements()) {
                JarEntry jarEntry = jarEntries.nextElement();
                String jarEntryName = jarEntry.getName();
                if (jarEntryName.contains(path) && !jarEntryName.equals(path + "/")) {
                    if (jarEntryName.endsWith(".class")) {
                        Class<?> clazz = null;
                        try {
                            clazz = classLoader.loadClass(jarEntryName.replace("/", ".").replace(".class", ""));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        Method[] methods = clazz.getDeclaredMethods();
                        for(Method method : methods){
                            if(method.isAnnotationPresent(xyz.csga.annotation.EventHandler.class)){
                                Class parameterType = method.getParameterTypes()[0];
                                if(method.getParameterCount() == 1 && parameterType.getSuperclass() == AbstractEvent.class){
                                    EventHandler eventHandler = new EventHandler(method);
                                    handlerMap.computeIfAbsent(parameterType, k -> new ArrayList<>()).add(eventHandler);
                                    System.out.println("Registered from .class: " + method.getName());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
