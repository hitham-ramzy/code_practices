package designPatterns.structure;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ProxyPatternTest {

    @Test
    public void proxyPatternTest() {
        IFile fileProxyCache = new FileProxyCache();
        IFile file1 = fileProxyCache.getFile("URL");
        IFile file2 = fileProxyCache.getFile("URL2");
        IFile file3 = fileProxyCache.getFile("URL");

        assertEquals(file1, file3);
        assertNotSame(file1, file2);
    }
}
