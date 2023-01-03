package com.irostub.webhook.whatap.mediator;

import com.irostub.webhook.config.AppConfig;
import com.irostub.webhook.discord.dto.embed_message.DiscordWebhookRequest;
import com.irostub.webhook.utils.WhatapToDiscordWebhookConvertor;
import com.irostub.webhook.whatap.dto.WhatapWebhookReceiveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/whatap-json")
public class WhatapHookReceiveController {
    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    @PostMapping("/discord/mediator")
    public String whatapToDiscordHook(@RequestBody WhatapWebhookReceiveDto whatapDto){
        DiscordWebhookRequest discordWebhookRequest = WhatapToDiscordWebhookConvertor.toDiscordRequest(whatapDto);
        return restTemplate.postForObject(appConfig.getDiscord().getUrl(), discordWebhookRequest, String.class);
    }

}
