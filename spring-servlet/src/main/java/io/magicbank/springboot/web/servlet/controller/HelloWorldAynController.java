package io.magicbank.springboot.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@RestController
@EnableScheduling
public class HelloWorldAynController {
    private final BlockingQueue<DeferredResult> queue = new ArrayBlockingQueue<DeferredResult>(50);
    private final Random reRandom= new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            int timeOut = reRandom.nextInt(100);
            Thread.sleep(timeOut);
            result.setResult("执行");
            println("执行时间"+timeOut);
        } while (result != null);
    }

    @GetMapping("/helloWorld")
    public DeferredResult<String> helloWorld(){
        DeferredResult<String> deferredResult = new DeferredResult<>(50L);
        //deferredResult.setResult("Hello World");
        queue.offer(deferredResult);
        println("hello world");
        deferredResult.onCompletion(()->{
            println("执行结束");
        });
        deferredResult.onTimeout(()->{
            println("超时");
        });
        return deferredResult;
    }

    public void println(Object object){
        String name = Thread.currentThread().getName();
        System.out.println("当前线程={"+name+"]"+object);

    }
}
