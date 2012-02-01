/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.commandhandling.callbacks;

import org.axonframework.commandhandling.CommandCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Callback that does absolutely nothing when invoked. For performance reasons, an instance of this callback can be
 * obtained using <code>NoOpCallback.INSTANCE</code>. A generics-compatible alternative is provided by
 * <code>NoOpCallback.&lt;C&gt;instance()</code>.
 *
 * @author Allard Buijze
 * @since 0.6
 * @deprecated Use the {@link org.axonframework.commandhandling.CommandBus#dispatch(Object)} method instead to indicate
 *             that no callback action is required..
 */
@Deprecated
public final class NoOpCallback implements CommandCallback<Object> {

    private static final Logger logger = LoggerFactory.getLogger(NoOpCallback.class);

    /**
     * A statically available instance of the NoOpCallback. Provided for performance reasons.
     */
    public static final NoOpCallback INSTANCE = new NoOpCallback();

    /**
     * {@inheritDoc}
     * <p/>
     * This implementation does nothing.
     */
    @Override
    public void onSuccess(Object result) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * This implementation does nothing.
     */
    @Override
    public void onFailure(Throwable cause) {
        logger.warn("Command processing resulted in an exception.", cause);
    }
}
