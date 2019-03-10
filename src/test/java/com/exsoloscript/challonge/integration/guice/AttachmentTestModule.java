/*
 * Copyright 2017 Stefan Geyer <stefangeyer at outlook.com>
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

package com.exsoloscript.challonge.integration.guice;

import com.google.common.io.Resources;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.File;
import java.net.URISyntaxException;

public class AttachmentTestModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(File.class).annotatedWith(Names.named("attachment")).toInstance(new File(Resources.getResource("testfile1.txt").toURI()));
        } catch (URISyntaxException ignored) {
        }
    }
}