package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String LogTest() {
        String name = "Spring";

        //log level
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name); // 운영 시스템에서 봐야할 정보
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        //RestController 를 사용하면 String 그자체로 반환된다.
        //Controller > view name으로 찾음
        return "ok";
    }
}
