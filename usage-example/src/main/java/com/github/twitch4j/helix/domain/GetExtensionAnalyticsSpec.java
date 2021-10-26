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

import javax.annotation.processing.Generated;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * GetExtensionAnalyticsSpec
 * <p>
 * This class is used to set request parameters when using the spec method.
 * <p>
 * Required Parameters:
 * - authorization User Auth Token
 * - startedAt Starting date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. This must be on or after January 31, 2018.  If this is provided, ended_at also must be specified. If started_at is earlier than the default start date, the default date is used.  The file contains one row of data per day.
 * - endedAt Ending date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. The report covers the entire ending date; e.g., if 2018-05-01T00:00:00Z is specified, the report covers up to 2018-05-01T23:59:59Z.  If this is provided, started_at also must be specified. If ended_at is later than the default end date, the default date is used. Default: 1-2 days before the request was issued (depending on report availability).
 * - extensionId Client ID value assigned to the extension when it is created. If this is specified, the returned URL points to an analytics report for just the specified extension. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s Extensions.
 * - type Type of analytics report that is returned. Currently, this field has no affect on the response as there is only one report type. If additional types were added, using this field would return only the URL for the specified report. Limit: 1. Valid values: overview_v2.
 * Optional Parameters:
 * - after Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query.
 * - first Maximum number of objects to return. Maximum: 100. Default: 20.
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public class GetExtensionAnalyticsSpec {

    private String authorization;
    private String startedAt;
    private String endedAt;
    private String extensionId;
    private String type;
    private String after;
    private Integer first;

    /**
     * Process Spec
     */
    public static GetExtensionAnalyticsSpec process(Consumer<GetExtensionAnalyticsSpec> spec) {
        GetExtensionAnalyticsSpec data = new GetExtensionAnalyticsSpec();
        spec.accept(data);
        data.validate();
        return data;
    }

    /**
     * Validates the Spec, will throw a exception if required parameters are missing
     */
    public void validate() {
        Objects.requireNonNull(authorization, "authorization is a required parameter!");
        Objects.requireNonNull(startedAt, "startedAt is a required parameter!");
        Objects.requireNonNull(endedAt, "endedAt is a required parameter!");
        Objects.requireNonNull(extensionId, "extensionId is a required parameter!");
        Objects.requireNonNull(type, "type is a required parameter!");
    }

    /**
     * Set authorization
     *
     * @param authorization User Auth Token (required)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec authorization(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public String authorization() {
        return this.authorization;
    }

    /**
     * Set startedAt
     *
     * @param startedAt Starting date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. This must be on or after January 31, 2018.  If this is provided, ended_at also must be specified. If started_at is earlier than the default start date, the default date is used.  The file contains one row of data per day. (required)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec startedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String startedAt() {
        return this.startedAt;
    }

    /**
     * Set endedAt
     *
     * @param endedAt Ending date/time for returned reports, in RFC3339 format with the hours, minutes, and seconds zeroed out and the UTC timezone: YYYY-MM-DDT00:00:00Z. The report covers the entire ending date; e.g., if 2018-05-01T00:00:00Z is specified, the report covers up to 2018-05-01T23:59:59Z.  If this is provided, started_at also must be specified. If ended_at is later than the default end date, the default date is used. Default: 1-2 days before the request was issued (depending on report availability). (required)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec endedAt(String endedAt) {
        this.endedAt = endedAt;
        return this;
    }

    public String endedAt() {
        return this.endedAt;
    }

    /**
     * Set extensionId
     *
     * @param extensionId Client ID value assigned to the extension when it is created. If this is specified, the returned URL points to an analytics report for just the specified extension. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s Extensions. (required)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec extensionId(String extensionId) {
        this.extensionId = extensionId;
        return this;
    }

    public String extensionId() {
        return this.extensionId;
    }

    /**
     * Set type
     *
     * @param type Type of analytics report that is returned. Currently, this field has no affect on the response as there is only one report type. If additional types were added, using this field would return only the URL for the specified report. Limit: 1. Valid values: overview_v2. (required)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec type(String type) {
        this.type = type;
        return this;
    }

    public String type() {
        return this.type;
    }

    /**
     * Set after
     *
     * @param after Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec after(String after) {
        this.after = after;
        return this;
    }

    public String after() {
        return this.after;
    }

    /**
     * Set first
     *
     * @param first Maximum number of objects to return. Maximum: 100. Default: 20. (optional, defaults to 20)
     * @return GetExtensionAnalyticsSpec
     */
    public GetExtensionAnalyticsSpec first(Integer first) {
        this.first = first;
        return this;
    }

    public Integer first() {
        return this.first;
    }

}