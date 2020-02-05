package test;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class KnowledgeTest {

    static Object strongRef = new Object();

    //强引用
    @Test
    public void testStrongRef(){
        Object object = strongRef;
        strongRef=null;
        object=null;
        System.gc();
        System.out.println("GC之后:"+object);
    }

    //软引用
    @Test
    public void testSoftRef(){
        String str ="hello";
        Object softRef = new Object();
        SoftReference softReference = new SoftReference(str);
        softRef = null;
        str=null;
        System.out.println(softReference.get());
    }

    //弱引用
    @Test
    public void testWeakRef(){
        Object weakObject = new Object();
        WeakReference weakReference = new WeakReference(weakObject);
        System.gc();
        System.out.println("After:"+weakReference.get());
    }

    //虚引用
    @Test
    public void testPhantomRef() throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object phantomObj = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObj,referenceQueue);
        System.out.println(phantomReference.get());

        phantomObj = null;
        System.gc();
        System.out.println(phantomReference.get());

        Thread.sleep(2000);
        System.out.println(referenceQueue.poll());
    }
}
