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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.Generated;

/**
 * API tests for AnalyticsApi
 */
@Generated(value = "")
class AnalyticsApiTest {

    private AnalyticsApi api;

    @BeforeEach
    public void setup() {
        // todo: setup ...
    }

    /**
     * Get Extension Analytics
     * <p>
     * Gets a URL that Extension developers can use to download analytics reports (CSV files) for their Extensions. The URL is valid for 5 minutes.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     */
    @Test
    void getExtensionAnalyticsTest() {
        String authorization = null;
        String startedAt = null;
        String endedAt = null;
        String extensionId = null;
        String type = null;
        String after = null;
        Integer first = null;
        // ExtensionAnalyticsList response = api.getExtensionAnalytics("08152caf938e37c","startedAt_example","endedAt_example","extensionId_example","overview_v2","",20)
        // TODO: test validations
    }

    /**
     * Get Game Analytics
     * <p>
     * Gets a URL that game developers can use to download analytics reports (CSV files) for their games. The URL is valid for 5 minutes. For detail about analytics and the fields returned, see the Insights & Analytics guide.  The response has a JSON payload with a data field containing an array of games information elements and can contain a pagination field containing information required to query for more streams.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     */
    @Test
    void getGameAnalyticsTest() {
        String authorization = null;
        String startedAt = null;
        String endedAt = null;
        String gameId = null;
        String type = null;
        String after = null;
        Integer first = null;
        // GameAnalyticsList response = api.getGameAnalytics("08152caf938e37c","startedAt_example","endedAt_example","gameId_example","overview_v2","",20)
        // TODO: test validations
    }
}
