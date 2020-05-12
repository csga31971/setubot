package xyz.csga.util;

import net.dongliu.requests.Requests;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import xyz.csga.config.BotConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BotUtil {
    public static String sendMessage(String message, int chat_id){
        Map<String, Object> params = new HashMap<>();
        params.put("chat_id", chat_id);
        params.put("text", message);
        return Requests.post(BotConfig.APIURL + "sendMessage").params(params).send().readToText();
    }

    public static String sendPhoto(String url, int chat_id){
        Map<String, Object> params = new HashMap<>();
        params.put("chat_id", chat_id);
        params.put("photo", url);
        return Requests.post(BotConfig.APIURL + "sendPhoto").params(params).send().readToText();
    }

    public static String sendAudio(String url, int chat_id){

        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "multipart/form-data");
        byte[] audioBytes = Requests.get(url).send().readToBytes();
        Map<String, Object> params = new HashMap<>();
        params.put("chat_id", chat_id);
        return Requests.post(BotConfig.APIURL + "sendAudio").headers(headers).body(audioBytes).params(params).send().readToText();
    }

    public static Document getXMLDocumentFromUrl(String url){
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(Requests.get(url).send().body());
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getPostCountFromUrl(String url){
        Element root = getXMLDocumentFromUrl(url).getRootElement();
        return Integer.valueOf(root.attribute("count").getValue());
    }

    public static String getFileUrlFromXML(String XMLUrl){
        Document document = getXMLDocumentFromUrl(XMLUrl);
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();
        String file_url = "";
        while(iterator.hasNext()){
            file_url = iterator.next().attribute("file_url").getValue();
        }
        return file_url;
    }
}
