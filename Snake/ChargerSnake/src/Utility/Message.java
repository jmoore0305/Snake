package Utility;

/**
 * 
 * This class is used in the subject/observer pattern
 * to notify the view when to call a particular method within
 * the view. 
 */
public class Message {

    final String messageContent;
    /**
     * 
     * @param m 
     * The message will contain instructions on what method
     * the view will call such as what frame to draw
     */
    public Message(String m) {
        this.messageContent = m;
    }
    /**
     * 
     * @return 
     * Used to return the content for evaluation
     */
    public String getMessageContent() {
        return messageContent;
    }
}
