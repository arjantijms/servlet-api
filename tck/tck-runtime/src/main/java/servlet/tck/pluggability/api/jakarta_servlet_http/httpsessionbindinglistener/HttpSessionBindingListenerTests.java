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
 * $Id:$
 */
package servlet.tck.pluggability.api.jakarta_servlet_http.httpsessionbindinglistener;

import servlet.tck.api.jakarta_servlet_http.httpsessionbindinglistener.HSBindingListener;
import servlet.tck.api.jakarta_servlet_http.httpsessionbindinglistener.TestServlet;
import servlet.tck.common.client.AbstractTckTest;
import servlet.tck.common.servlets.CommonServlets;
import servlet.tck.pluggability.common.RequestListener1;
import servlet.tck.pluggability.common.TestServlet1;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HttpSessionBindingListenerTests extends AbstractTckTest {

  @BeforeEach
  public void setupServletName() throws Exception {
    setServletName("TestServlet");
  }

  /**
   * Deployment for the test
   */
  @Deployment(testable = false)
  public static WebArchive getTestArchive() throws Exception {
    JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class, "fragment-1.jar")
            .addClasses(TestServlet1.class, RequestListener1.class)
            .addAsResource(HttpSessionBindingListenerTests.class.getResource("servlet_pluh_httpsessionbindinglistener_web-fragment.xml"),
                    "META-INF/web-fragment.xml");
    return ShrinkWrap.create(WebArchive.class, "servlet_pluh_httpsessionbindinglistener_web.war")
            .addAsLibraries(CommonServlets.getCommonServletsArchive())
            .addClasses(HSBindingListener.class, TestServlet.class)
            .addAsLibraries(javaArchive);
  }


  /*
   * @class.setup_props: webServerHost; webServerPort; ts_home;
   *
   */

  /* Run test */

  /*
   * @testName: unBoundTest
   * 
   * @assertion_ids:
   * Servlet:JAVADOC:459;Servlet:JAVADOC:485;Servlet:JAVADOC:486;Servlet:JAVADOC
   * :491
   * 
   * @test_Strategy: Client calls a servlet that sets/sets/removes an attribute
   * from the session. That attribute happens to be a Binding listener. The
   * Listeners valueBound/valueUnbound methods should be called and messages
   * written to a static log. The servlet then reads the log and verifies the
   * result.
   */
  @Test
  public void unBoundTest() throws Exception {
    TEST_PROPS.setProperty(APITEST, "unBoundTest");
    invoke();
  }

  /*
   * @testName: boundTest
   * 
   * @assertion_ids: Servlet:JAVADOC:458;Servlet:JAVADOC:485;Servlet:JAVADOC:486
   * 
   * @test_Strategy: Client calls a servlet that sets an attribute to the
   * session. That attribute happens to be a Binding listener. The Listeners
   * valueBound/valueUnbound methods should be called and messages written to a
   * static log. The servlet then reads the log and verifies the result.
   */
  @Test
  public void boundTest() throws Exception {
    TEST_PROPS.setProperty(APITEST, "boundTest");
    invoke();
  }
}
