package io.magicbank.skill;

import java.util.concurrent.CountDownLatch;

public class SkillOrder {

    private ProductStorage storage = new ProductStorage();
    private static final CountDownLatch latch = new CountDownLatch(1);
    
    public boolean skillWithOrder(){
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 扣减库存
        Boolean r = storage.descStorage();

        if (r){
            // 插入订单
            System.out.println("当前线程："+Thread.currentThread().getName()+"扣减成功");
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        SkillOrder skillOrder = new SkillOrder();
        for (int i =0; i<1000; i++){
            new Thread(new Run(skillOrder)).start();
        }
        latch.countDown();

    }

    public static class Run implements Runnable {

        private SkillOrder skillOrder;

        public Run(SkillOrder skillOrder) {
            this.skillOrder = skillOrder;
        }

        @Override
        public void run() {
            skillOrder.skillWithOrder();
        }
    }
}
