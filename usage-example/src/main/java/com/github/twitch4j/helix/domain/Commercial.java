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
 * Commercial
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
@JsonPropertyOrder({
        "length",
        "message",
        "retry_after"
})
@JsonTypeName("Commercial")
@Data
public class Commercial {

    // Length of the triggered commercial
    @JsonProperty("length")
    private Integer length;

    // Provides contextual information on why the request failed
    @JsonProperty("message")
    private String message;

    // Seconds until the next commercial can be served on this channel
    @JsonProperty("retry_after")
    private Integer retryAfter;


}
