/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2025 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.maven.skins.reflow.velocity;

import java.util.Properties;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.velocity.VelocityComponentConfigurator;

/**
 * Velocity configurator. Used by {@link org.codehaus.plexus.velocity.VelocityComponent}.
 *
 * <p>
 * Preserve compatibility of Velocity 2.x with Velocity 1.x.
 * </p>
 */
@Component(role = VelocityComponentConfigurator.class, hint = "wcmio-reflow")
public class VelocityConfigurator implements VelocityComponentConfigurator {

  @Override
  public void configure(Properties properties) {

    // No automatic conversion of methods arguments
    properties.put("introspector.conversion_handler.class", "none");

    // Use backward compatible space gobbling
    properties.put("parser.space_gobbling", "bc");

    // Have #if($foo) only returns false if $foo is false or null
    properties.put("directive.if.empty_check", "false");

    // Allow '-' in identifiers (since 2.1)
    properties.put("parser.allow_hyphen_in_identifiers", "true");

    // Enable backward compatibility mode for Velocimacros
    properties.put("velocimacro.enable_bc_mode", "true");

    // When using an invalid reference handler, also include quiet references (since 2.2)
    properties.put("event_handler.invalid_references.quiet", "true");

    // When using an invalid reference handler, also include null references (since 2.2)
    properties.put("event_handler.invalid_references.null", "true");

    // When using an invalid reference handler, also include tested references (since 2.2)
    properties.put("event_handler.invalid_references.tested", "true");

    // Let the range operator expressions '[ x..y ]' return mutable lists (since 2.4)
    properties.put("runtime.immutable_range", "false");

  }

}
