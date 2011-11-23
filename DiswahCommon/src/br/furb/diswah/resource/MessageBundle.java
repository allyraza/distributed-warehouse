package br.furb.diswah.resource;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MessageBundle {
	
	private static MessageBundle instance = new MessageBundle();

	/**
	 * @return instance
	 */
	public static MessageBundle getInstance() {
		return instance;
	}
	
	private ResourceBundle resource;

	private MessageBundle() {
		resource = ResourceBundle.getBundle("messages");
	}
	
    /**
     * Retorna o arquivo de referência que possui as mensagens que serão
     * apresentadas pelo sistema.
     * @return o arquivo de referência.
     */
	private ResourceBundle getResourceBundle() {
		return resource;
	}

    /**
     * Recupera mensagem cadastrada no arquivo <code>resource</code> buscando
     * a mensagem pela chave <code>key</code> e caso a mensagem contiver parametros
     * eles serão substituídos pelos valores de <code>arguments</code>.
     * @param key - Chave da mensagem
     * @param arguments - Lista de argumentos passado para mensagem.
     * @return A mensagem do <code>resource</code>.
     */
    public String getMessage(String key, Object... arguments) {
        try{
            if (arguments != null) {
                return MessageFormat.format(getResourceBundle().getString(key), arguments);
            } else {
                return getResourceBundle().getString(key);
            }
        } catch (Exception e) {
            return "??"+key+"??";
        }
    }

    /**
     * Recupera mensagem cadastrada no arquivo <code>resource</code> buscando
     * a mensagem pela chave <code>key</code> e caso a mensagem contiver parametros
     * eles serão substituídos pelos valores de <code>arguments</code>.
     * @param key - Chave da mensagem
     * @return A mensagem do <code>resource</code>.
     */
    public String getMessage(String key) {
        return getMessage(key, new Object[]{});
    }
    
    /**
     * Verifica se existe a chave no arquivo <code>resource</code> buscando
     * a mensagem pela chave <code>key</code>
     * @param key - Chave da mensagem
     * @return <code>true</code> se encontrar, <code>false</code> se não encontrar.
     */
    public boolean containsKey(String key) {
    	try {
    		getResourceBundle().getString(key);
    	} catch (Exception e) {
			return false;
		}
    	return true;
    }

}