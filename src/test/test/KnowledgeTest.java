package test;

import org.junit.Test;

public class KnowledgeTest {

    static Object strongRef = new Object();
    @Test
    public void testStrongRef(){
        Object object = strongRef;
        strongRef=null;
        object=null;
        System.gc();
        System.out.println("GC之后:"+object);
    }
}
