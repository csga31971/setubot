package xyz.csga.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.dongliu.requests.Requests;
import xyz.csga.annotation.EventHandler;
import xyz.csga.entity.Message;
import xyz.csga.entity.Update;
import xyz.csga.entity.UpdateResponse;
import xyz.csga.entity.User;
import xyz.csga.event.MessageReceiveEvent;
import xyz.csga.util.BotUtil;
import xyz.csga.util.Constant;
import xyz.csga.util.NeteaseUtil;
import xyz.csga.util.RandomString;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Random;

public class MyHandler {

    @EventHandler
    public void log(MessageReceiveEvent event){
        UpdateResponse updateResponse = event.getResponseAsJson().toJavaObject(UpdateResponse.class);
        Update[] result = updateResponse.getResult();
        for(int i = 0;i < result.length;i++){
            Message message = result[i].getMessage();
            User from = message.getFrom();
            if(from.getUsername() == null){
                System.out.println("[" + from.getFirst_name() + " " + from.getLast_name() + "]: " + message.getText());
            }else{
                System.out.println("[" + from.getUsername() + "]: " + message.getText());
            }
        }
    }

    @EventHandler
    public void test(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText();
        if(text.trim().equalsIgnoreCase("/test")){
            BotUtil.sendMessage("lyfdsb", event.getLatestChatId());
        }
    }

    @EventHandler
    public void lyf(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText();
        if(text.trim().equalsIgnoreCase("/lyf")){
            BotUtil.sendMessage("撸一发！啊！！！社保了！！我社保了！！！！oqiehjnjkfbkjspoawiefp", event.getLatestChatId());
        }
        String[] splits = text.replace("\\s+", " ").split(" ");
        if(text.startsWith("/lyf ") && splits.length > 1){
            try {
                Random random = new Random(System.currentTimeMillis());
                int times = Integer.valueOf(splits[1]);
                StringBuilder sb = new StringBuilder();
                sb.append("撸一发");
                for(int i=0;i<times+random.nextInt(times)+1;i++){
                    sb.append("！");
                }
                sb.append("啊");
                for(int i=0;i<times+random.nextInt(times)+3;i++){
                    sb.append("！");
                }
                sb.append("社保了");
                for(int i=0;i<times+random.nextInt(times)+2;i++){
                    sb.append("！");
                }
                sb.append("我社保了");
                for(int i=0;i<times+random.nextInt(times)+4;i++){
                    sb.append("！");
                }
                sb.append(RandomString.create(times+15));
                BotUtil.sendMessage(sb.toString(), event.getLatestChatId());
            } catch (NumberFormatException e){
                BotUtil.sendMessage("?", event.getLatestChatId());
            }
        }
    }

    @EventHandler
    public void say(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText();
        if(text.trim().equalsIgnoreCase("/say")){
            BotUtil.sendMessage("?", event.getLatestChatId());
            return;
        }
        if(text.toLowerCase().startsWith("/say ")){
            String[] splits = text.trim().split(" ");
            if(splits.length > 1){
                String param = "";
                String after = text.trim().replaceFirst("\\s+", " ").substring(text.indexOf(" ")+1);
                if(after.startsWith("\"")){
                    int firstSpaceIndex = 0;
                    boolean space = false;
                    int lastQuote = 0;
                    boolean quote = false;
                    for(int i=0;i<after.length();i++){
                        if(after.charAt(i) == ' '){
                            if(!space){
                                firstSpaceIndex = i;
                                space = true;
                            }
                        }
                        if(after.charAt(i) == '"' &&
                                ((i < after.length()-1 && after.charAt(i+1) == ' ') || i == after.length()-1)){
                            if(!quote){
                                lastQuote = i;
                                quote = true;
                            }
                        }
                    }
                    if(!space){
                        firstSpaceIndex = after.length();
                    }
                    if(!quote){
                        param = after.substring(0, firstSpaceIndex);
                    } else {
                        param = after.substring(1, lastQuote);
                    }
                } else {
                    param = splits[1];
                }
                BotUtil.sendMessage(param, event.getLatestChatId());
            }
        }
    }

    @EventHandler
    public void setu(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText();
        if(text.trim().equalsIgnoreCase("/setu")){
            BotUtil.sendPhoto("http://shapimai.com/setu?_=" + new Timestamp(System.currentTimeMillis()).getNanos(), event.getLatestChatId());
        }
    }

    @EventHandler
    public void yandere(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText().trim().toLowerCase();
        if(text.equals("/yandere")){
            Random random = new Random(System.currentTimeMillis());
            int page = random.nextInt(BotUtil.getPostCountFromUrl(Constant.YANDEREURL));
            String XMLUrl = Constant.YANDEREURL + "&page=" + page;
            String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
            BotUtil.sendPhoto(file_url, event.getLatestChatId());
        }
        String[] splits = text.replace("\\s+", " ").split(" ");
        if(text.startsWith("/yandere ") && splits.length > 1){
            Random random = new Random(System.currentTimeMillis());
            String tags = text.substring(text.indexOf(' ')+1);
            try {
                int pageCount = random.nextInt(BotUtil.getPostCountFromUrl(Constant.YANDEREURL + "&tags=" + URLEncoder.encode(tags, "utf8")));
                int page = random.nextInt(pageCount);
                String XMLUrl = Constant.YANDEREURL + "&page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8");;
                String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
                BotUtil.sendPhoto(file_url, event.getLatestChatId());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void konachan(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText().trim().toLowerCase();
        if(text.equals("/konachan")){
            Random random = new Random(System.currentTimeMillis());
            int page = random.nextInt(BotUtil.getPostCountFromUrl(Constant.KONACHANURL));
            String XMLUrl = Constant.KONACHANURL + "&page=" + page;
            String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
            BotUtil.sendPhoto(file_url, event.getLatestChatId());
        }
        String[] splits = text.replace("\\s+", " ").split(" ");
        if(text.startsWith("/konachan ") && splits.length > 1){
            Random random = new Random(System.currentTimeMillis());
            String tags = text.substring(text.indexOf(' ')+1);
            try {
                int pageCount = random.nextInt(BotUtil.getPostCountFromUrl(Constant.KONACHANURL + "&tags=" + URLEncoder.encode(tags, "utf8")));
                int page = random.nextInt(pageCount);
                String XMLUrl = Constant.KONACHANURL + "&page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8");;
                String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
                BotUtil.sendPhoto(file_url, event.getLatestChatId());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void danbooru(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText().trim().toLowerCase();
        if(text.equals("/danbooru")){
            Random random = new Random(System.currentTimeMillis());
            int page = random.nextInt(3450000);
            String jsonString = Requests.get(Constant.DANBOORUURL + "/" + page + ".json").send().readToText();
            JSONObject jsonObject = JSON.parseObject(jsonString);
            String file_url = jsonObject.getString("file_url");
            BotUtil.sendPhoto(file_url, event.getLatestChatId());
        }
        String[] splits = text.replace("\\s+", " ").split(" ");
        if(text.startsWith("/danbooru ") && splits.length > 1){
            Random random = new Random(System.currentTimeMillis());
            int page = random.nextInt(10);
//            int page = 0;
            String tags = text.substring(text.indexOf(' ')+1);
            try {
                String jsonString = Requests.get(Constant.DANBOORUURL + ".json?page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8") + "&limit=1").send().readToText();;
                JSONObject jsonObject = JSON.parseArray(jsonString).getJSONObject(0);
                String file_url = jsonObject.getString("file_url");
                BotUtil.sendPhoto(file_url, event.getLatestChatId());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void sp(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText().trim().toLowerCase();
        if(text.equals("/sp")){
            BotUtil.sendPhoto(".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n", event.getLatestChatId());
        }

    }

    @EventHandler
    public void naizi(MessageReceiveEvent event){
        String text = event.getLatestMessage().getText().trim().toLowerCase();
        if(text.equals("/naizi")){
            Random random = new Random(System.currentTimeMillis());
            int randomNum = random.nextInt(3);
            String tags = "breast";
            switch (randomNum){
                case 0:
                    try {
                        int pageCount = random.nextInt(BotUtil.getPostCountFromUrl(Constant.YANDEREURL + "&tags=" + URLEncoder.encode(tags, "utf8")));
                        int page = random.nextInt(pageCount);
                        String XMLUrl = Constant.YANDEREURL + "&page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8");;
                        String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
                        BotUtil.sendPhoto(file_url, event.getLatestChatId());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        int pageCount = random.nextInt(BotUtil.getPostCountFromUrl(Constant.KONACHANURL + "&tags=" + URLEncoder.encode(tags, "utf8")));
                        int page = random.nextInt(pageCount);
                        String XMLUrl = Constant.KONACHANURL + "&page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8");;
                        String file_url = BotUtil.getFileUrlFromXML(XMLUrl);
                        BotUtil.sendPhoto(file_url, event.getLatestChatId());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    int page = random.nextInt(10);
                    try {
                        String jsonString = Requests.get(Constant.DANBOORUURL + ".json?page=" + page + "&tags=" + URLEncoder.encode(tags, "utf8") + "&limit=1").send().readToText();;
                        JSONObject jsonObject = JSON.parseArray(jsonString).getJSONObject(0);
                        String file_url = jsonObject.getString("file_url");
                        BotUtil.sendPhoto(file_url, event.getLatestChatId());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

    }

//    @EventHandler
//    public void netease(MessageReceiveEvent event){
//        String text = event.getLatestMessage().getText();
//        String[] splits = text.replace("\\s+", " ").split(" ");
//        if(text.startsWith("/163 ") && splits.length > 1){
//            String name = text.substring(text.indexOf(' ')+1);
//            String songUrl = NeteaseUtil.getFirstMp3LinkByName(name);
//            BotUtil.sendAudio(songUrl, event.getLatestChatId());
//        }
//    }
}
