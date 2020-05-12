package xyz.csga.test;

import net.dongliu.requests.Requests;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import xyz.csga.util.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class TestXML {
    public static void main(String[] args){
        Random random = new Random(System.currentTimeMillis());
        int page = random.nextInt(400000);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(Requests.get(Constant.YANDEREURL + "&page=" + page).send().body());
            Element root = document.getRootElement();
            Iterator<Element> iterator = root.elementIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next().attribute("file_url"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
