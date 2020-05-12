package xyz.csga.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {

    public static double timerDuration;
    public static String apikey;
    public static String APIURL;

    @Value("${timerDuration}")
    public void setTimerDuration(double timerDuration) {
        BotConfig.timerDuration = timerDuration;
    }

    @Value("${apikey}")
    public void setApikey(String apikey) {
        BotConfig.apikey = apikey;
        BotConfig.APIURL = "https://api.telegram.org/bot<token>/".replace("<token>", apikey);
    }

}
