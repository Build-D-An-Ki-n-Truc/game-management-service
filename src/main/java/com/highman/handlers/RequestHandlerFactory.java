package com.highman.handlers;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class RequestHandlerFactory {
    final static String HANDLER_PACAKAGE = "com.highman.handlers";
    final static String EXTRACT_HANDLER_ERROR = "Error while retrieving and instantiating request handler";
    private static final Map<String, RequestHandlerBase> handlers = new HashMap<>();

    static {
        Reflections reflections = new Reflections(HANDLER_PACAKAGE, new SubTypesScanner(false));
        HashSet<Class<? extends RequestHandlerBase>> handlerClasses = new HashSet<>(reflections.getSubTypesOf(RequestHandlerBase.class));
        for (Class<? extends RequestHandlerBase> handlerClass: handlerClasses) {
            try {
                RequestHandlerBase handler = handlerClass.getDeclaredConstructor().newInstance();
                System.out.println(handler.getEndpointName());
                handlers.put(handler.getEndpointName(), handler);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                     InstantiationException e) {
                System.out.println(EXTRACT_HANDLER_ERROR);
            }
        }
    }

    public static RequestHandlerBase getHandler(String endpoint) {
        return handlers.get(endpoint);
    }
}
