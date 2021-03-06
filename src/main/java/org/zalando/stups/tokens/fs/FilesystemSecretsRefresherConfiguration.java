/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.tokens.fs;

import static java.util.Objects.requireNonNull;

import org.zalando.stups.tokens.AccessTokensBuilder;

public class FilesystemSecretsRefresherConfiguration {

    private final AccessTokensBuilder parent;

    private boolean validateTokensOnStartup = false;

    private TokenContentExtractor tokenContentExtractor = new JwtFileSystemTokenContentExtractor();

    public FilesystemSecretsRefresherConfiguration(AccessTokensBuilder parent) {
        this.parent = requireNonNull(parent, "'accessTokensBuilder' should never be null");
    }

    public FilesystemSecretsRefresherConfiguration validateTokensOnStartup() {
        this.validateTokensOnStartup = true;
        return this;
    }

    public FilesystemSecretsRefresherConfiguration usingTokenContentExtractor(TokenContentExtractor tokenContentExtractor) {
        this.tokenContentExtractor = requireNonNull(tokenContentExtractor, "'tokenContentExtractor' should never be null");
        return this;
    }

    public boolean isValidateTokensOnStartup() {
        return this.validateTokensOnStartup;
    }

    public AccessTokensBuilder done() {
        return this.parent;
    }

    public TokenContentExtractor getTokenContentExtractor() {
        return this.tokenContentExtractor;
    }
}
