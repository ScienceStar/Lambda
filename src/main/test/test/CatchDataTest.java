package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lxc
 * @Title: CatchDataTest
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/22 15:00
 */
public class CatchDataTest {
    static Map<Integer, Object> dataMap = new HashMap<Integer, Object>( );
    static ReadWriteLock lock = new ReentrantReadWriteLock( );//创建读写锁的实例

    static Object getData(Integer key) {
        lock.readLock( ).lock( );//读取前先上锁
        Object val = null;
        try {
            val = dataMap.get(key);
            if (val == null) {
                // Must release read lock before acquiring write lock
                lock.readLock( ).unlock( );
                lock.writeLock( ).lock( );
                try {
                    if (val == null) {
                        //dataMap.put(key, "");//query from db
                        val = queryDataFromDB(key);
                    }
                } finally {
                    //Downgrade by acquiring read lock before releasing write lock
                    lock.readLock( ).lock( );
                    // Unlock write, still hold read
                    lock.writeLock( ).unlock( );
                }
            }
        } finally {
            lock.readLock( ).unlock( );//最后一定不要忘记释放锁 System.out.println("get data key="+key+">val="+val);
            return val;
        }
    }

    public static void main(String[] args) {
        while (true){
            new Thread(() -> {
                getData(new Random( ).nextInt(100));
            }).start( );
        }
    }

    static Object queryDataFromDB(Integer key) {
        Object val = new Random( ).nextInt(1000);
        dataMap.put(key, val);
        System.out.println("write into data key=" + key + ">val=" + val);
        return val;
    }
}