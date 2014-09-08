package my.training.osgi.extender;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by angelo on 9/7/14.
 */
public class AppContextHolder implements ApplicationContextAware {

    private static ApplicationContext springContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springContext = applicationContext;
    }

    public static ApplicationContext getSpringContext(){
        return springContext;
    }


}
