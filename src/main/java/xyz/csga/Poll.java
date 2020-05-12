package xyz.csga;

import net.dongliu.requests.Requests;
import org.springframework.stereotype.Component;
import xyz.csga.config.BotConfig;
import xyz.csga.entity.Update;
import xyz.csga.event.EventBus;
import xyz.csga.event.MessageReceiveEvent;
import xyz.csga.util.Constant;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class Poll{

    public static Integer latest_update_id = -1;

    public static void run(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String updateUrl = BotConfig.APIURL + "getUpdates";
                if(Poll.latest_update_id > 0){
                    updateUrl += "?offset=" + (Poll.latest_update_id+1);
                }
                String response = "{\"ok\": true, \"result\": []}";
                try{
                    response = Requests.get(updateUrl).send().readToText();
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    if(response.length() > 30){
                        MessageReceiveEvent event = new MessageReceiveEvent(response);
                        Update latestUpdate = event.getLatestUpdate();
                        if(latestUpdate != null){
                            Poll.latest_update_id = event.getLatestUpdate().getUpdate_id();
                        }
                        try {
                            EventBus.fire(event);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, (long)(BotConfig.timerDuration*1000));
    }
}
