package my.training.osgi.listener;

import my.training.osgi.extender.AppContextHolder;
import org.osgi.framework.*;
import org.springframework.context.ApplicationContext;

/**
 * Created by angelo on 9/7/14.
 */
public class JobBundleListener implements BundleActivator, BundleListener {

    private BundleContext context;
    private ApplicationContext springContext;

    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
        this.context.addBundleListener(this);
    }

    @Override
    public void stop(BundleContext context) throws Exception {

    }

    @Override
    public void bundleChanged(BundleEvent event) {
        switch (event.getType()){
            case BundleEvent.STARTED:
                System.out.println("New bundle started ...");
                Bundle target = event.getBundle();
                String className = target.getHeaders().get("Job-Configuration-Class");
                Class clazz = null;
                if(className != null){
                    try {
                        clazz = target.loadClass(className);
                        System.out.println(getSpringContext());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case BundleEvent.STOPPED:
                break;

        }
    }

    private ApplicationContext getSpringContext(){
        if(springContext==null){
            springContext = AppContextHolder.getSpringContext();
        }
        return springContext;
    }
}
