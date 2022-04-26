package Utility;

/**
 * The subject interface is used by the model to be observed by the view.
 * The model sends instructions to the view to tell the view when to execute
 * a particular method.
 */
public interface Subject {
    /**
     * Used for attaching an observer
     * @param o 
     */
    public void attach(Observer o);
    /**
     * Used for detaching an observer
     * @param o 
     */
    public void detach(Observer o);
    /**
     * Used to call update method which will carry a message
     * to the view.
     * @param m 
     */
    public void notifyUpdate(Message m);
}
