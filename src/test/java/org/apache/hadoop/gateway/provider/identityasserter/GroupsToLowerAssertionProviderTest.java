/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway.provider.identityasserter;

import junit.framework.TestCase;
import org.apache.hadoop.gateway.identityasserter.GroupsToLowerAssertionFilter;
import org.apache.hadoop.gateway.security.GroupPrincipal;
import org.apache.hadoop.gateway.security.PrimaryPrincipal;
import org.junit.Ignore;
import org.junit.Test;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Set;

public class GroupsToLowerAssertionProviderTest extends TestCase {

  @Test
  public void testGroupsMapping() throws Exception {
    GroupsToLowerAssertionFilter filter = new GroupsToLowerAssertionFilter();
    
    Subject subject = new Subject();
    Set<Principal> principals = subject.getPrincipals();
    principals.add(new PrimaryPrincipal("guest"));
    //principals.add(new GroupPrincipal("ADMIN"));
    principals.add(new GroupPrincipal("admin"));

    String[] groups = filter.mapGroupPrincipals("guest", subject);
    //assertTrue("Expected group not found.", groups[0].equals("admin"));
    assertTrue("Expected group not found.", groups[0].equals("ADMIN"));
    
  }
}
