/*
 * Copyright 2012-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.isis.viewer.graphql.viewer.spring;

import org.springframework.graphql.execution.GraphQlSource;

/**
 * Callback interface that can be implemented by beans wishing to customize properties of
 * {@link org.springframework.graphql.execution.GraphQlSource.Builder} whilst retaining
 * default auto-configuration.
 *
 * This has been copied in from Spring Boot 2.7 (not yet released - will remove once bump up).
 *
 * @author Rossen Stoyanchev
 * @since 2.7.0
 */
@FunctionalInterface
public interface GraphQlSourceBuilderCustomizer {

	/**
	 * Customize the {@link GraphQlSource.Builder} instance.
	 * @param builder builder the builder to customize
	 */
	void customize(GraphQlSource.Builder builder);

}