package leejy.myapp.api.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import leejy.myapp.api.common.exception.controller.HomeException;
import leejy.myapp.api.common.exception.model.ExceptionCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Component
@PropertySource(value = "classpath:application.properties")
public class Network {

    private static final Logger logger = LoggerFactory.getLogger(Network.class);

    @Value("${url.connecter}")
    private String CONNECTER_URL;
    @Value("${url.connecterPort}")
    private String CONNECTER_PORT;

    public <T, M> T httpRequestCall(M request, Class<T> resp, String targetUrl) throws HomeException {

        //header 정의
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        //request 생성
        HttpEntity<M> req = new HttpEntity<>(request, header);

        //restTemplate call
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(CONNECTER_URL+":"+CONNECTER_PORT+"/"+targetUrl, HttpMethod.POST, req, resp);
        } catch (HttpServerErrorException e) {


            String responseBody = e.getResponseBodyAsString();
            ExceptionCodeResponse result = new ExceptionCodeResponse();

            try {
                result = new ObjectMapper().readValue(responseBody, ExceptionCodeResponse.class);
            } catch (Exception e1) {
                logger.warn("[httpRequestCall] 응답String을 POJO 변환 중 에러. responseBody:{}, error:{}", responseBody, e1);
                throw new HomeException("ER0006"); // 내부에러
            }

            logger.warn("[httpRequestCall] 연계 실패 to ({}) responseBody:{} e:{}", targetUrl, responseBody, e);
            throw new HomeException(result.getCode()); //연계 실패
        }

        if (response.getStatusCode().value() != 200) {
            logger.warn("[httpRequestCall] 연계 결과 비정상. response.getStatusCode():{}", response.getStatusCode());
            throw new HomeException("ER0004"); //연계 실패
        }

        //return response
        return response.getBody();
    }
}

