package fr.mysite.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * The token saver class
 * @author Jason POQUET
 *
 */
public class TokenSaver {
    public static Map<String, String> tokensByName;

    static {
        tokensByName = new HashMap<String, String>();
    }
}
