package com.irostub.webhook.whatap.mediator;

import com.irostub.webhook.config.AppConfig;
import com.irostub.webhook.discord.dto.embed_message.DiscordWebhookRequest;
import com.irostub.webhook.utils.WhatapToDiscordWebhookConvertor;
import com.irostub.webhook.whatap.dto.WhatapWebhookReceiveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/whatap-json")
public class WhatapHookReceiveController {
    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    @GetMapping("/discord/mediator")
    public String check(){
        log.info("sdfasdfasdfsadfsadfsadfasdfasdf");
        return "whata";
    }

    @PostMapping("/discord/mediator")
    public String whatapToDiscordHook(@RequestBody WhatapWebhookReceiveDto whatapDto){
        log.info("path=/whatap-json/discord/mediator, message={}", whatapDto);
        DiscordWebhookRequest discordWebhookRequest = WhatapToDiscordWebhookConvertor.toDiscordRequest(whatapDto);
        return restTemplate.postForObject(appConfig.getDiscord().getUrl(), discordWebhookRequest, String.class);
    }

}
