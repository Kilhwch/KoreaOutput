
package Files;

import java.io.File;


public class FileNames {
    
    protected static final String ITEMPATH = "./Files/Items/";
    
    public File[] getAll() {
        File folder = new File(ITEMPATH);
        File[] list = folder.listFiles();
        return list;
    }
}
