package uz.evr.university_evr.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    public Sms sms;
    private String recipient;
    @JsonProperty(value = "message-id")
    private String messageId;

    public Message(String recipient, String messageId, String originator, String text) {
        this.recipient = recipient;
        this.messageId = messageId;
        sms = new Sms(originator, text);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Sms{
        private String originator;
        private Content content;

        public Sms(String originator, String sms) {
            this.originator = originator;
            this.content = new Content(sms);
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Content{
        private String text;
    }
}
