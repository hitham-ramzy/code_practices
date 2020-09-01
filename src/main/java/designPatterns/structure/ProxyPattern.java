package designPatterns.structure;

import java.util.HashMap;
import java.util.Map;

public class ProxyPattern {

}

interface IFile {
    IFile getFile(String path);
}

class File implements IFile {

    String path;

    public File(String path) {
        this.path = path;
    }

    @Override
    public IFile getFile(String path) {
        return new File(path);
    }
}

class FileProxyCache implements IFile {

    private Map<String, File> map = new HashMap<>();

    @Override
    public File getFile(String path) {
        File file = map.get(path);
        if (file == null) {
            file = new File(path);
            map.put(path, file);
        }
        return file;
    }
}
