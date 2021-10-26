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

import com.github.twitch4j.helix.domain.GameList;
import com.github.twitch4j.helix.domain.GetGamesSpec;
import com.github.twitch4j.helix.domain.GetTopGamesSpec;
import com.github.twitch4j.helix.domain.TopGameList;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.function.Consumer;

@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public interface GamesApi {

    /**
     * Gets game information by game ID or name.
     * <p>
     * Gets game information by game ID or name. The response has a JSON payload with a data field containing an array of games elements.
     *
     * @param authorization User Auth Token (required)
     * @param id            Game ID. At most 100 id values can be specified. (optional)
     * @param name          Game name. The name must be an exact match. For instance, \"Pokemon\" will not return a list of Pokemon games; instead, query the specific Pokemon game(s) in which you are interested. At most 100 name values can be specified. (optional)
     * @return GameList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-games">Find more information on the Twitch Developer Documentation</a>
     */
    @RequestLine("GET /games?id={id}&name={name}")
    @Headers(
            "Authorization: Bearer {authorization}"
    )
    GameList getGames(@Param("authorization") String authorization, @Param("id") List<Integer> id, @Param("name") List<String> name);


    /**
     * Gets game information by game ID or name.
     * <p>
     * Gets game information by game ID or name. The response has a JSON payload with a data field containing an array of games elements.
     *
     * @param spec a consumer that takes a spec to prepare the request for execution
     * @return GameList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-games">Find more information on the Twitch Developer Documentation</a>
     */
    default GameList getGames(Consumer<GetGamesSpec> spec) {
        GetGamesSpec finalSpec = GetGamesSpec.process(spec);
        return getGames(finalSpec.authorization(), finalSpec.id(), finalSpec.name());
    }

    /**
     * Gets games sorted by number of current viewers on Twitch, most popular first.
     * <p>
     * Gets games sorted by number of current viewers on Twitch, most popular first. The response has a JSON payload with a data field containing an array of games information elements and a pagination field containing information required to query for more streams.
     *
     * @param authorization User Auth Token (required)
     * @param after         Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @param before        Cursor for backward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @param first         Maximum number of objects to return. Maximum: 100. Default: 20. (optional, defaults to 20)
     * @return TopGameList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-top-games">Find more information on the Twitch Developer Documentation</a>
     */
    @RequestLine("GET /games/top?after={after}&before={before}&first={first}")
    @Headers(
            "Authorization: Bearer {authorization}"
    )
    TopGameList getTopGames(@Param("authorization") String authorization, @Param("after") String after, @Param("before") String before, @Param("first") Integer first);


    /**
     * Gets games sorted by number of current viewers on Twitch, most popular first.
     * <p>
     * Gets games sorted by number of current viewers on Twitch, most popular first. The response has a JSON payload with a data field containing an array of games information elements and a pagination field containing information required to query for more streams.
     *
     * @param spec a consumer that takes a spec to prepare the request for execution
     * @return TopGameList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-top-games">Find more information on the Twitch Developer Documentation</a>
     */
    default TopGameList getTopGames(Consumer<GetTopGamesSpec> spec) {
        GetTopGamesSpec finalSpec = GetTopGamesSpec.process(spec);
        return getTopGames(finalSpec.authorization(), finalSpec.after(), finalSpec.before(), finalSpec.first());
    }

}
