package com.irostub.webhook.whatap.dto;

import lombok.Data;

/**
 * whatap webhook json receive format
 * <pre>
 *  {
 *      "pcode":1234,
 *      "projectName":"Sample project",
 *      "time":1577840400000,
 *      "oid":1234567890,
 *      "oname":"WAS-01"  //Optional,
 *      "title":"Alert Title",
 *      "message":"Sample warning message"  //Optional,
 *      "level":"Warning",
 *      "status":"on",
 *      "metricName":"cpu"  //Optional,
 *      "metricValue":"99.99"  //Optional,
 *      "metricThreshold":"90"  //Optional
 *   }
 * </pre>
 */
@Data
public class WhatapWebhookReceiveDto {
    private Integer pcode;
    private String projectName;
    private Long time;
    private Long oid;
    private String oname;
    private String title;
    private String message;
    private String level;
    private String status;
    private String metricName;
    private String metricValue;
    private String metricThreshold;
}