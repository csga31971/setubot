package xyz.csga.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventHandler {

    private Method method;

    public EventHandler(Method method) {
        this.method = method;
    }

    public Object handle(AbstractEvent event) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        return method.invoke(method.getDeclaringClass().newInstance(), event);
    }
}
