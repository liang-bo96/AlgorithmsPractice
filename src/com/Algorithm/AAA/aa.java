package com.Algorithm.AAA;

import java.util.HashMap;
import java.util.HashSet;

public class aa {
    static HashMap<String,LockRecord> lockRecord = new HashMap<>();
    static HashMap<String,String> contractRecord = new HashMap<>();
    static final long lockTime = 1000;
    public static void main(String[] args) {

    }
    //B线程观察A插入的锁是否消失，未消失的话给A的锁续租次数加一并更新锁记录时间，达到五次之后删除A的锁记录，插入B自己的锁记录并进行后续的业务操作。
    public static void B(String shopid,String Contract) throws InterruptedException {

        if(lockRecord.get(shopid) != null){
            if(System.currentTimeMillis() - lockRecord.get(shopid).time < 1000){
                for (int i = 0; i < 5; i++) {
                    if(lockRecord.get(shopid).rentrantime >= 5){
                        break;
                    }
                    LockRecord recordA = lockRecord.get(shopid);
                    recordA.rentrantime++;
                    recordA.time = recordA.time + 1000;
                    lockRecord.put(shopid,recordA);
                    Thread.sleep(lockTime);
                }
            }
            lockRecord.remove(shopid);
        }
        LockRecord lockrecord =  new LockRecord(shopid,0);
        lockrecord.time = System.currentTimeMillis();
        lockRecord.put(shopid,lockrecord);
        //start Transaction
        contractRecord.put(shopid, Contract);
        lockRecord.remove(shopid);
        //close Transaction
    }
}
class LockRecord{
    public String shopid;
    public long time;
    public int rentrantime;

    public LockRecord(String shopid, long time, int rentrantime) {
        this.shopid = shopid;
        this.time = time;
        this.rentrantime = rentrantime;
    }

    public LockRecord(String shopid, int rentrantime) {
        this.shopid = shopid;
        this.rentrantime = rentrantime;
    }
}
