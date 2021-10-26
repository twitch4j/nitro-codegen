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
 * GetTopGamesSpec
 * <p>
 * This class is used to set request parameters when using the spec method.
 * <p>
 * Required Parameters:
 * - authorization User Auth Token
 * Optional Parameters:
 * - after Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query.
 * - before Cursor for backward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query.
 * - first Maximum number of objects to return. Maximum: 100. Default: 20.
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public class GetTopGamesSpec {

    private String authorization;
    private String after;
    private String before;
    private Integer first;

    /**
     * Process Spec
     */
    public static GetTopGamesSpec process(Consumer<GetTopGamesSpec> spec) {
        GetTopGamesSpec data = new GetTopGamesSpec();
        spec.accept(data);
        data.validate();
        return data;
    }

    /**
     * Validates the Spec, will throw a exception if required parameters are missing
     */
    public void validate() {
        Objects.requireNonNull(authorization, "authorization is a required parameter!");
    }

    /**
     * Set authorization
     *
     * @param authorization User Auth Token (required)
     * @return GetTopGamesSpec
     */
    public GetTopGamesSpec authorization(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public String authorization() {
        return this.authorization;
    }

    /**
     * Set after
     *
     * @param after Cursor for forward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @return GetTopGamesSpec
     */
    public GetTopGamesSpec after(String after) {
        this.after = after;
        return this;
    }

    public String after() {
        return this.after;
    }

    /**
     * Set before
     *
     * @param before Cursor for backward pagination: tells the server where to start fetching the next set of results, in a multi-page response. The cursor value specified here is from the pagination response field of a prior query. (optional)
     * @return GetTopGamesSpec
     */
    public GetTopGamesSpec before(String before) {
        this.before = before;
        return this;
    }

    public String before() {
        return this.before;
    }

    /**
     * Set first
     *
     * @param first Maximum number of objects to return. Maximum: 100. Default: 20. (optional, defaults to 20)
     * @return GetTopGamesSpec
     */
    public GetTopGamesSpec first(Integer first) {
        this.first = first;
        return this;
    }

    public Integer first() {
        return this.first;
    }

}