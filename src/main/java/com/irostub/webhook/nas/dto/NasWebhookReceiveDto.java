package com.irostub.webhook.nas.dto;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class NasWebhookReceiveDto {
    public static String SEPARATOR = ";";
    private ParsedMessage parsedMessage;
    private String message;

    public ParsedMessage getParsedMessage(){
        if (StringUtils.hasText(message)) {
            return null;
        }
        String[] split = this.message.split(SEPARATOR);
        if (split.length < 4) {
            throw new RuntimeException("nas webhook 메세지 규격이 아닙니다. message : " + this.message);
        }

        ParsedMessage parsedMessage = new ParsedMessage();
        parsedMessage.setTime(split[0]);
        parsedMessage.setHostName(split[1]);
        parsedMessage.setTitle(split[2]);
        parsedMessage.setContent(split[3]);
        return parsedMessage;
    }

    @Data
    public static class ParsedMessage{
        private String time;
        private String hostName;
        private String title;
        private String content;
    }
}
