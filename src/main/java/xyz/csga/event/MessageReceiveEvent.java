package xyz.csga.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import xyz.csga.entity.Message;
import xyz.csga.entity.Update;
import xyz.csga.entity.UpdateResponse;

public class MessageReceiveEvent extends AbstractEvent{

    private String rawMessage;

    private String getRawMessage() {
        return rawMessage;
    }

    private UpdateResponse getUpdateResponse(){
        return JSON.parseObject(getRawMessage(), UpdateResponse.class);
    }

    public MessageReceiveEvent(){
        this.rawMessage = "{\"ok\": true, \"result\": []}";
    }

    public MessageReceiveEvent(String rawMessage){
        this.rawMessage = rawMessage;
    }

    public JSONObject getResponseAsJson(){
        return JSON.parseObject(this.rawMessage);
    }

    public Message[] getMessages(){
        Update[] updates = getUpdateResponse().getResult();
        if(updates == null || updates.length < 1) {
            return null;
        }
        Message[] messages = new Message[updates.length];
        for(int i = 0;i < updates.length;i++){
            messages[i] = updates[i].getMessage();
        }
        return messages;
    }

    public Update getLatestUpdate(){
        Update[] updates = getUpdateResponse().getResult();
        if(updates == null || updates.length < 1){
            return null;
        }
        return updates[updates.length-1];
    }

    public Message getLatestMessage(){
        Message[] messages = getMessages();
        if(messages == null || messages.length < 1){
            return null;
        }
        return messages[messages.length-1];
    }

    public Integer getLatestChatId(){
        return getLatestMessage().getChat().getId();
    }

}
