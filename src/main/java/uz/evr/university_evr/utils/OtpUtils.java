package uz.evr.university_evr.utils;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OtpUtils {

    /**
     * PlayMobile "send.sms" request body
     *
     * @param phoneNumber recipient phone number
     * @param originator  middleware originator
     * @param otp         generated one time password
     * @return ObjectNode
     */
    public Map<String, Object> smsServiceSendSms(String phoneNumber, String originator, String otp) {
        Map<String, Object> messages = new LinkedHashMap<>();
        List<Map<String, Object>> messageList = new ArrayList<>();

        Map<String, Object> content = new HashMap<>();
        content.put("text", otp);

        Map<String, Object> SMS = new HashMap<>();
        SMS.put("originator", originator);
        SMS.put("content", content);

        Map<String, Object> message = new HashMap<>();
        message.put("recipient", phoneNumber);
        message.put("priority", "");
        message.put("sms", SMS);

        Date messageDate = new Date();
        message.put("message-id", messageDate.getTime());
        messageList.add(message);
        messages.put("messages", messageList);

        return messages;
    }


}
