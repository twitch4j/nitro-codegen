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

import com.github.twitch4j.helix.domain.ExtensionAnalyticsList;
import com.github.twitch4j.helix.domain.GameAnalyticsList;
import com.github.twitch4j.helix.domain.GetExtensionAnalyticsSpec;
import com.github.twitch4j.helix.domain.GetGameAnalyticsSpec;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public interface AnalyticsApi {

    /**
     * Get Extension Analytics
     * <p>
     * Gets a URL that Extension developers can use to download analytics reports (CSV files) for their Extensions. The URL is valid for 5 minutes.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     * <p>
     * Authentication - Required Scopes: [analytics:read:extensions]
     *
     * @param authorization User Auth Token (required)
     * @param startedAt     Starting date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. This must be on or after January 31, 2018.  If this is provided, ended_at also must be specified. If started_at is earlier than the default start date, the default date is used.  The file contains one row of data per day. (required)
     * @param endedAt       Ending date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. The report covers the entire ending date; e.g., if 2018-05-01T00:00:00Z is specified, the report covers up to 2018-05-01T23:59:59Z.  If this is provided, started_at also must be specified. If ended_at is later than the default end date, the default date is used. Default: 1-2 days before the request was issued (depending on report availability). (required)
     * @param extensionId   Client ID value assigned to the extension when it is created. If this is specified, the returned URL points to an analytics report for just the specified extension. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s Extensions. (required)
     * @param type          Type of analytics report that is returned. Currently, this field has no affect on the response as there is only one report type. If additional types were added, using this field would return only the URL for the specified report. Limit: 1. Valid values: overview_v2. (required)
     * @param after         Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @param first         Maximum number of objects to return. Maximum: 100. Default: 20. (optional, defaults to 20)
     * @return ExtensionAnalyticsList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-extension-analytics">Find more information on the Twitch Developer Documentation</a>
     */
    @RequestLine("GET /analytics/extensions?started_at={startedAt}&ended_at={endedAt}&extension_id={extensionId}&type={type}&after={after}&first={first}")
    @Headers(
            "Authorization: Bearer {authorization}"
    )
    ExtensionAnalyticsList getExtensionAnalytics(@Param("authorization") String authorization, @Param("startedAt") String startedAt, @Param("endedAt") String endedAt, @Param("extensionId") String extensionId, @Param("type") String type, @Param("after") String after, @Param("first") Integer first);


    /**
     * Get Extension Analytics
     * <p>
     * Gets a URL that Extension developers can use to download analytics reports (CSV files) for their Extensions. The URL is valid for 5 minutes.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     * <p>
     * Authentication - Required Scopes: [analytics:read:extensions]
     *
     * @param spec a consumer that takes a spec to prepare the request for execution
     * @return ExtensionAnalyticsList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-extension-analytics">Find more information on the Twitch Developer Documentation</a>
     */
    default ExtensionAnalyticsList getExtensionAnalytics(Consumer<GetExtensionAnalyticsSpec> spec) {
        GetExtensionAnalyticsSpec finalSpec = GetExtensionAnalyticsSpec.process(spec);
        return getExtensionAnalytics(finalSpec.authorization(), finalSpec.startedAt(), finalSpec.endedAt(), finalSpec.extensionId(), finalSpec.type(), finalSpec.after(), finalSpec.first());
    }

    /**
     * Get Game Analytics
     * <p>
     * Gets a URL that game developers can use to download analytics reports (CSV files) for their games. The URL is valid for 5 minutes. For detail about analytics and the fields returned, see the Insights & Analytics guide.  The response has a JSON payload with a data field containing an array of games information elements and can contain a pagination field containing information required to query for more streams.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     * <p>
     * Authentication - Required Scopes: [analytics:read:games]
     *
     * @param authorization User Auth Token (required)
     * @param startedAt     Starting date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. This must be on or after January 31, 2018.  If this is provided, ended_at also must be specified. If started_at is earlier than the default start date, the default date is used. The file contains one row of data per day. (required)
     * @param endedAt       Ending date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. The report covers the entire ending date; e.g., if 2018-05-01T00:00:00Z is specified, the report covers up to 2018-05-01T23:59:59Z.  If this is provided, started_at also must be specified. If ended_at is later than the default end date, the default date is used. Default: 1-2 days before the request was issued (depending on report availability). (required)
     * @param gameId        Game ID. If this is specified, the returned URL points to an analytics report for just the specified game. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s games. (required)
     * @param type          Type of analytics report that is returned. Currently, this field has no affect on the response as there is only one report type. If additional types were added, using this field would return only the URL for the specified report. Limit: 1. Valid values: overview_v2. (required)
     * @param after         Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @param first         Maximum number of objects to return. Maximum: 100. Default: 20. (optional, defaults to 20)
     * @return GameAnalyticsList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-game-analytics">Find more information on the Twitch Developer Documentation</a>
     */
    @RequestLine("GET /analytics/games?started_at={startedAt}&ended_at={endedAt}&game_id={gameId}&type={type}&after={after}&first={first}")
    @Headers(
            "Authorization: Bearer {authorization}"
    )
    GameAnalyticsList getGameAnalytics(@Param("authorization") String authorization, @Param("startedAt") String startedAt, @Param("endedAt") String endedAt, @Param("gameId") String gameId, @Param("type") String type, @Param("after") String after, @Param("first") Integer first);


    /**
     * Get Game Analytics
     * <p>
     * Gets a URL that game developers can use to download analytics reports (CSV files) for their games. The URL is valid for 5 minutes. For detail about analytics and the fields returned, see the Insights & Analytics guide.  The response has a JSON payload with a data field containing an array of games information elements and can contain a pagination field containing information required to query for more streams.  If you specify a future date, the response will be “Report Not Found For Date Range.” If you leave both started_at and ended_at blank, the API returns the most recent date of data.
     * <p>
     * Authentication - Required Scopes: [analytics:read:games]
     *
     * @param spec a consumer that takes a spec to prepare the request for execution
     * @return GameAnalyticsList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-game-analytics">Find more information on the Twitch Developer Documentation</a>
     */
    default GameAnalyticsList getGameAnalytics(Consumer<GetGameAnalyticsSpec> spec) {
        GetGameAnalyticsSpec finalSpec = GetGameAnalyticsSpec.process(spec);
        return getGameAnalytics(finalSpec.authorization(), finalSpec.startedAt(), finalSpec.endedAt(), finalSpec.gameId(), finalSpec.type(), finalSpec.after(), finalSpec.first());
    }

}
