/*
 * Copyright (c) 2012, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */
package com.sun.ts.tests.servlet.api.common.sharedfiles;

import com.sun.ts.tests.servlet.common.util.StaticLog;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public final class SRListener implements ServletRequestListener {

  public void requestDestroyed(ServletRequestEvent event) {
    StaticLog.add("SRListenerDestroyed.");
  }

  public void requestInitialized(ServletRequestEvent event) {
    StaticLog.add("SRListenerInitialized.");
  }
}
