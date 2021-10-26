/*
 * Twitch Helix
 *
 * The new Twitch API provides the tools and data used to develop integrations with Twitch.
 * The data models and systems are designed to provide relevant data in an easy, consistent, and reliable way.
 *
 * Further information:
 * - [Authorization](https://dev.twitch.tv/docs/authentication)
 * - [Pagination](https://dev.twitch.tv/docs/api/guide#pagination)
 * - [Rate Limits](https://dev.twitch.tv/docs/api/guide#rate-limits)
 * - [Methods](https://dev.twitch.tv/docs/api/reference)
 *
 * The version of the OpenAPI document: 1.0.0
 *
 * License: [https://github.com/twitch4j/twitch4j/blob/master/LICENSE](MIT)
 *
 * NOTE: This class is auto generated.
 * Generator: com.github.twitch4j.codegen.java.feign.JavaFeignGenerator - unset
 * Do not edit the class manually.
 */
package com.github.twitch4j.helix.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.annotation.processing.Generated;

/**
 * StartCommercialRequest
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
@JsonPropertyOrder({
        "broadcaster_id",
        "length"
})
@JsonTypeName("StartCommercialRequest")
@Data
public class StartCommercialRequest {

    // ID of the channel requesting a commercial. Minimum: 1 Maximum: 1
    @JsonProperty("broadcaster_id")
    private String broadcasterId;

    // Desired length of the commercial in seconds. Valid options are 30, 60, 90, 120, 150, 180.
    @JsonProperty("length")
    private Integer length;


}
