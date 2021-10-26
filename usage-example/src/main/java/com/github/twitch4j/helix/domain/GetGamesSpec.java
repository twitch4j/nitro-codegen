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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * GetGamesSpec
 * <p>
 * This class is used to set request parameters when using the spec method.
 * <p>
 * Required Parameters:
 * - authorization User Auth Token
 * Optional Parameters:
 * - id Game ID. At most 100 id values can be specified.
 * - name Game name. The name must be an exact match. For instance, \"Pokemon\" will not return a list of Pokemon games; instead, query the specific Pokemon game(s) in which you are interested. At most 100 name values can be specified.
 */
@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public class GetGamesSpec {

    private String authorization;
    private List<Integer> id;
    private List<String> name;

    /**
     * Process Spec
     */
    public static GetGamesSpec process(Consumer<GetGamesSpec> spec) {
        GetGamesSpec data = new GetGamesSpec();
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
     * @return GetGamesSpec
     */
    public GetGamesSpec authorization(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public String authorization() {
        return this.authorization;
    }

    /**
     * Set id
     *
     * @param id Game ID. At most 100 id values can be specified. (optional)
     * @return GetGamesSpec
     */
    public GetGamesSpec id(List<Integer> id) {
        this.id = Collections.unmodifiableList(id);
        return this;
    }

    public List<Integer> id() {
        return this.id;
    }

    /**
     * Set name
     *
     * @param name Game name. The name must be an exact match. For instance, \"Pokemon\" will not return a list of Pokemon games; instead, query the specific Pokemon game(s) in which you are interested. At most 100 name values can be specified. (optional)
     * @return GetGamesSpec
     */
    public GetGamesSpec name(List<String> name) {
        this.name = Collections.unmodifiableList(name);
        return this;
    }

    public List<String> name() {
        return this.name;
    }

}