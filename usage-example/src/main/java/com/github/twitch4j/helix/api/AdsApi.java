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

import com.github.twitch4j.helix.domain.CommercialList;
import com.github.twitch4j.helix.domain.StartCommercialRequest;
import com.github.twitch4j.helix.domain.StartCommercialSpec;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "com.github.twitch4j.codegen.java.feign.JavaFeignGenerator")
public interface AdsApi {

    /**
     * Start Commercial
     * <p>
     * Starts a commercial on a specified channel.
     * <p>
     * Authentication - Required Scopes: [channel:edit:commercial]
     *
     * @param authorization          User Auth Token (required)
     * @param startCommercialRequest (required)
     * @return CommercialList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#start-commercial">Find more information on the Twitch Developer Documentation</a>
     */
    @RequestLine("POST /channels/commercial")
    @Headers(
            "Authorization: Bearer {authorization}"
    )
    CommercialList startCommercial(@Param("authorization") String authorization, StartCommercialRequest startCommercialRequest);


    /**
     * Start Commercial
     * <p>
     * Starts a commercial on a specified channel.
     * <p>
     * Authentication - Required Scopes: [channel:edit:commercial]
     *
     * @param spec a consumer that takes a spec to prepare the request for execution
     * @return CommercialList
     * @see <a href="https://dev.twitch.tv/docs/api/reference#start-commercial">Find more information on the Twitch Developer Documentation</a>
     */
    default CommercialList startCommercial(Consumer<StartCommercialSpec> spec) {
        StartCommercialSpec finalSpec = StartCommercialSpec.process(spec);
        return startCommercial(finalSpec.authorization(), finalSpec.startCommercialRequest());
    }

}
