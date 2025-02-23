/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rat.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.Test;

public class FormatTest {
    @Test
    public void fromNameTest() throws MalformedURLException {
        assertEquals(Format.XML, Format.fromName("foo/x.xml"));
        assertEquals(Format.XML, Format.fromName("x.xml"));
        assertThrows(IllegalArgumentException.class, () ->Format.fromName("junk"));
        assertEquals(Format.XML, Format.fromFile( new File("foo/y.xml")));
    }

}
