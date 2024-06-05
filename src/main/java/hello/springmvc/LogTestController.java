package hello.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace("trace log={}, {}", name);
        log.debug("debug log={}, {}", name); // 개발
        log.info("info log={}", name); // 운영 시스템
        log.warn("warn log={}, {}", name); // 경고
        log.error("error log={}", name); // 에러

        return "ok";
    }
}
