package io.magicbank.springboot.limit;

import com.google.common.util.concurrent.RateLimiter;
import io.magicbank.springboot.limit.annotation.AnRateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class TestLimitController {
    Logger log = LoggerFactory.getLogger(TestLimitController.class);
    /**
     * 以1r/s往桶中放入令牌
     */
    private RateLimiter limiter = RateLimiter.create(1.0);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/indexLimiter")
    public String indexLimiter() {
        // 如果用户在500毫秒内没有获取到令牌,就直接放弃获取进行服务降级处理
        boolean tryAcquire = limiter.tryAcquire(1000, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            log.info("Error ---时间:{},获取令牌失败.", sdf.format(new Date()));
            return "系统繁忙,请稍后再试.";
        }
        log.info("Success ---时间:{},获取令牌成功.", sdf.format(new Date()));
        return "success";
    }

    @GetMapping("/index")
    @AnRateLimiter(permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "亲,现在流量过大,请稍后再试.")
    public String index() {
        return System.currentTimeMillis() + "";
    }
}
