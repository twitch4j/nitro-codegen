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
import java.util.List;

/**
 * API tests for GamesApi
 */
@Generated(value = "")
class GamesApiTest {

    private GamesApi api;

    @BeforeEach
    public void setup() {
        // todo: setup ...
    }

    /**
     * Gets game information by game ID or name.
     * <p>
     * Gets game information by game ID or name. The response has a JSON payload with a data field containing an array of games elements.
     */
    @Test
    void getGamesTest() {
        String authorization = null;
        List<Integer> id = null;
        List<String> name = null;
        // GameList response = api.getGames("08152caf938e37c",Arrays.asList(),Arrays.asList())
        // TODO: test validations
    }

    /**
     * Gets games sorted by number of current viewers on Twitch, most popular first.
     * <p>
     * Gets games sorted by number of current viewers on Twitch, most popular first. The response has a JSON payload with a data field containing an array of games information elements and a pagination field containing information required to query for more streams.
     */
    @Test
    void getTopGamesTest() {
        String authorization = null;
        String after = null;
        String before = null;
        Integer first = null;
        // TopGameList response = api.getTopGames("08152caf938e37c","","",20)
        // TODO: test validations
    }
}
