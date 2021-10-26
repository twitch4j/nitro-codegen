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
package com.github.twitch4j.helix.api;

import com.github.twitch4j.helix.domain.StartCommercialRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.Generated;

/**
 * API tests for AdsApi
 */
@Generated(value = "")
class AdsApiTest {

    private AdsApi api;

    @BeforeEach
    public void setup() {
        // todo: setup ...
    }

    /**
     * Start Commercial
     * <p>
     * Starts a commercial on a specified channel.
     */
    @Test
    void startCommercialTest() {
        String authorization = null;
        StartCommercialRequest startCommercialRequest = null;
        // CommercialList response = api.startCommercial("08152caf938e37c",new StartCommercialRequest())
        // TODO: test validations
    }
}
