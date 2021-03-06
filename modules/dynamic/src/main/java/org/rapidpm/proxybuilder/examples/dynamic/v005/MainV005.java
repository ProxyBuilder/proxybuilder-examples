package org.rapidpm.proxybuilder.examples.dynamic.v005;

import org.rapidpm.proxybuilder.examples.dynamic.model.ServiceV001;
import org.rapidpm.proxybuilder.examples.dynamic.model.ServiceV001Impl;
import org.rapidpm.proxybuilder.type.dymamic.DynamicProxyBuilder;

import java.time.LocalDateTime;

/**
 *  Copyright (C) 2012 RapidPM
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * Created by RapidPM - Team on 19.11.15.
 */
public class MainV005 {

  private MainV005() {
  }

  public static void main(String[] args) {
    final ServiceV001 serviceV001 = DynamicProxyBuilder
        .createBuilder(ServiceV001.class, new ServiceV001Impl())
        .addSecurityRule(() -> {
          System.out.println("checkRule = " + LocalDateTime.now());
          return false;
        })
        .build();
    System.out.println("Proxy created " + LocalDateTime.now());

    System.out.println(serviceV001.doWork("invoke") + " " + LocalDateTime.now());

  }
}
