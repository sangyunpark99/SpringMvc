package hello.springmvc.response;

import hello.springmvc.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResponseBodyController {
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(HttpServletResponse response) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    //@ResponseBody
    public String responseBodyV3(HttpServletResponse response) throws IOException {
        return "OK";
    }

    @ResponseStatus(HttpStatus.OK)
    //@ResponseBody // 클래스 레벨에 붙일 수 있다.
    @GetMapping("/responsebody-body-json-v2")
    public HelloData responseBodyJsonV2() {

        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return helloData;
    }
}