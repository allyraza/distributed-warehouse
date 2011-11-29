package br.furb.diswah.resource;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MessageBundle {
	
	private static ResourceBundle resource = ResourceBundle.getBundle("messages");
	
	/**
	 * @return
	 */
	private static ResourceBundle getResourceBundle() {
		return resource;
	}

    /**
     * @param key
     * @param arguments
     * @return
     */
    public static String getMessage(String key, Object... arguments) {
        try{
            if (arguments != null) {
                return MessageFormat.format(getResourceBundle().getString(key), arguments);
            } else {
                return getResourceBundle().getString(key);
            }
        } catch (Exception e) {
            return "##"+key+"##";
        }
    }

    /**
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return getMessage(key, new Object[]{});
    }
    
    /**
     * @param key
     * @return
     */
    public static boolean containsKey(String key) {
    	try {
    		getResourceBundle().getString(key);
    	} catch (Exception e) {
			return false;
		}
    	return true;
    }

}