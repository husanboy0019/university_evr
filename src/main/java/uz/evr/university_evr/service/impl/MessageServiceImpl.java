package uz.evr.university_evr.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import uz.evr.university_evr.service.MessageService;
import uz.evr.university_evr.utils.OtpUtils;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private OtpUtils otpUtils;

    @Value(value = "${service.sms.url}")
    private String URL;
    @Value(value = "${service.sms.originator}")
    private String ORIGINATOR;
    @Value(value = "${service.sms.login}")
    private String LOGIN;
    @Value(value = "${service.sms.password}")
    private String PASSWORD;

    @Override
    public void sendSms(String phoneNumber, String otp) {
        Map<String, Object> messages = otpUtils.smsServiceSendSms(phoneNumber, ORIGINATOR, otp);
        String basic = new String(Base64.encodeBase64((LOGIN + ":" + PASSWORD).getBytes()));

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Basic " + basic);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(messages, headers);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        System.out.println("entity: " + entity);
        String object = restTemplate.postForObject(URL, entity, String.class); // via tunnel
        System.out.println("object " + object);
    }


}
