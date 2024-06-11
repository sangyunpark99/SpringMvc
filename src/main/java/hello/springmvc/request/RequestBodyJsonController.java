package hello.springmvc.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}. age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    // requestBody로 확 줄은것을 확인할 수 있다.
    @PostMapping("/request-body-json-v2")
    @ResponseBody
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}. age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // requestBody로 확 줄은것을 확인할 수 있다.
    @PostMapping("/request-body-json-v3")
    @ResponseBody
    public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {
        log.info("username={}. age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @PostMapping("/request-body-json-v4")
    @ResponseBody
    public HelloData requestBodyJsonV4(@RequestBody HelloData helloData) throws IOException {
        log.info("username={}. age={}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }
}
