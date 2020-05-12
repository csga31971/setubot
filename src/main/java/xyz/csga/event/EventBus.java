package xyz.csga.event;

import xyz.csga.Registry;

import java.lang.reflect.InvocationTargetException;

public class EventBus {
    public static void fire(AbstractEvent event) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for(EventHandler handler : Registry.handlerMap.get(event.getClass())){
            handler.handle(event);
        }
    }
}
