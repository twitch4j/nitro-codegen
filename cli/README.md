# OpenAPI Generator CLI (Nitro)

A custom build of the OpenAPI generator that contains all generators of this project.

## cli usage example

`java -jar cli/build/libs/openapi-generator.jar generate --input-spec usage-example/src/main/resources/openapi.yaml --generator-name nitro-java-feign --engine auto --output usage-example --package-name com.github.twitch4j.helix --api-package com.github.twitch4j.helix.api --model-package com.github.twitch4j.helix.domain`
