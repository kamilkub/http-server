package org.http.controllers;

import java.util.HashMap;
import java.util.Map;

public class ControllerContext {

    private static final ControllerContext context = new ControllerContext();
    private static final Map<String, Controller> controllers = new HashMap<>();

    public synchronized ControllerContext getContext() {
        return context;
    }

    public synchronized void addDependency(Controller controller) {
        String controllerClassName = controller.getClass().getName();
        String controllerName = controllerClassName
                .substring(0, 1)
                .concat(controllerClassName.substring(1));

        controllers.put(controllerName, controller);
    }

    public synchronized Map<String, Controller> getControllers() {
        return controllers;
    }
}
