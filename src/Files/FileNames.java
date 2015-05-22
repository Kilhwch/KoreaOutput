package Files;

import Constants.C;
import java.io.File;

public class FileNames {
    
    public File[] getAll() {
        File folder = new File(C.ITEMSPATH);
        File[] list = folder.listFiles();
        return list;
    }
}
