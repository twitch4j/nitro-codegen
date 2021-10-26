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
 * StartCommercialSpec
 * <p>
 * This class is used to set request parameters when using the spec method.
 * <p>
 * Required Parameters:
 * - authorization User Auth Token
 * - startCommercialRequest
 * Optional Parameters:
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public class StartCommercialSpec {

    private String authorization;
    private StartCommercialRequest startCommercialRequest;

    /**
     * Process Spec
     */
    public static StartCommercialSpec process(Consumer<StartCommercialSpec> spec) {
        StartCommercialSpec data = new StartCommercialSpec();
        spec.accept(data);
        data.validate();
        return data;
    }

    /**
     * Validates the Spec, will throw a exception if required parameters are missing
     */
    public void validate() {
        Objects.requireNonNull(authorization, "authorization is a required parameter!");
        Objects.requireNonNull(startCommercialRequest, "startCommercialRequest is a required parameter!");
    }

    /**
     * Set authorization
     *
     * @param authorization User Auth Token (required)
     * @return StartCommercialSpec
     */
    public StartCommercialSpec authorization(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public String authorization() {
        return this.authorization;
    }

    /**
     * Set startCommercialRequest
     *
     * @param startCommercialRequest (required)
     * @return StartCommercialSpec
     */
    public StartCommercialSpec startCommercialRequest(StartCommercialRequest startCommercialRequest) {
        this.startCommercialRequest = startCommercialRequest;
        return this;
    }

    public StartCommercialRequest startCommercialRequest() {
        return this.startCommercialRequest;
    }

}