/*
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 */
package org.apache.rat.analysis.matchers;

import static org.junit.Assert.assertEquals;

import org.apache.rat.analysis.IHeaderMatcher;
import org.apache.rat.analysis.IHeaderMatcher.State;
import org.junit.Before;
import org.junit.Test;

public class SPDXMatcherTest {

    IHeaderMatcher target = SPDXMatcherFactory.INSTANCE.create("hello");

    @Before
    public void setup() {
        target.reset();
    }

    @Test
    public void testMatch() {
        assertEquals(State.i, target.currentState());
        assertEquals(State.i, target.matches("SPDX-License-Identifier: Apache-2"));
        assertEquals(State.i, target.currentState());
        assertEquals(State.t, target.matches("SPDX-License-Identifier: hello"));
        assertEquals(State.t, target.currentState());
        assertEquals(State.t, target.finalizeState());
        assertEquals(State.t, target.currentState());
        target.reset();
        assertEquals(State.i, target.currentState());
    }

    @Test
    public void testNoMatch() {
        assertEquals(State.i, target.currentState());
        assertEquals(State.i, target.matches("SPDX-License-Identifier: Apache-2"));
        assertEquals(State.i, target.currentState());
        assertEquals(State.i, target.matches("SPDX-License-Identifier: MIT"));
        assertEquals(State.i, target.currentState());
        assertEquals(State.f, target.finalizeState());
        assertEquals(State.f, target.currentState());
        target.reset();
        assertEquals(State.i, target.currentState());
    }

    @Test
    public void testTrueIsAlwaysTrue() {
        assertEquals(State.i, target.currentState());
        assertEquals(State.t, target.matches("SPDX-License-Identifier: hello"));
        assertEquals(State.t, target.currentState());
        assertEquals(State.t, target.matches("SPDX-License-Identifier: Apache-2"));
        assertEquals(State.t, target.currentState());
        assertEquals(State.t, target.finalizeState());
        assertEquals(State.t, target.currentState());
        target.reset();
        assertEquals(State.i, target.currentState());
    }
}
