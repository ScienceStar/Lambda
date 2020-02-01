package test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

    @AfterClass
    public static void afterClass() throws Exception {

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
        System.out.println("write into data key=" +key+ ">val=" + dataMap.get(key));
        return val;
    }

    /**
     * 二维码生成
     */
    @Test
    public void bitMatrixCreate(){
        int width=300;
        int height=300;
        String format="png";
        String contents="孙子兵法-孙武";
        HashMap map=new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 0);
        try {
            BitMatrix bm = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height);
            Path file=new File("D:/img.png").toPath();
            MatrixToImageWriter.writeToPath(bm, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}