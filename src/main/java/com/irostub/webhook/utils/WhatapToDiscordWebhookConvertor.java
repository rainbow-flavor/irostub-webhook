package com.irostub.webhook.utils;

import com.irostub.webhook.discord.dto.embed_message.DiscordWebhookRequest;
import com.irostub.webhook.discord.dto.embed_message.Embed;
import com.irostub.webhook.discord.dto.embed_message.Field;
import com.irostub.webhook.discord.dto.embed_message.Footer;
import com.irostub.webhook.whatap.dto.WhatapWebhookReceiveDto;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
public class WhatapToDiscordWebhookConvertor {
    private static final int COLOR = Color.ORANGE.getRGB();
    private static final String USERNAME = "상태 알림 봇";
    public static DiscordWebhookRequest toDiscordRequest (WhatapWebhookReceiveDto dto){
        log.info("toDiscordRequest={}", dto);
        Field metricValue = new Field();
        metricValue.setName(dto.getMetricName());
        metricValue.setValue(dto.getMetricValue());

        Field metricThreshold = new Field();
        metricThreshold.setName("임계치");
        metricThreshold.setValue(dto.getMetricThreshold());

        Embed embed = Embed.builder()
                .color(COLOR)
                .title(makeTitle(dto))
                .footer(Footer.create(makeFooterText(dto), null))
                .description(makeDescription(dto))
                .fields(List.of(metricValue, metricThreshold))
                .build();
        return DiscordWebhookRequest.builder()
                .username(USERNAME)
                .embeds(List.of(embed))
                .build();
    }

    private static String makeDescription(WhatapWebhookReceiveDto dto) {
        long time = dto.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(time));

        return "[" + format + "]" + dto.getMessage();
    }

    private static String makeTitle(WhatapWebhookReceiveDto dto) {
        return "[" + dto.getLevel() + "]" + dto.getTitle();
    }

    private static String makeFooterText(WhatapWebhookReceiveDto dto) {
        return "프로젝트 " + dto.getProjectName() + "("+ dto.getPcode() +") 에서 수집된 정보입니다.";
    }
}
