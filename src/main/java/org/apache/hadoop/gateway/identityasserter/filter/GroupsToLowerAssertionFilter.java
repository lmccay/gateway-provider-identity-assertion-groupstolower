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
package org.apache.hadoop.gateway.identityasserter.filter;

import java.security.Principal;
import java.util.Set;
import java.util.ArrayList;
import javax.security.auth.Subject;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.hadoop.gateway.security.GroupPrincipal;
import org.apache.hadoop.gateway.identityasserter.common.filter.CommonIdentityAssertionFilter;

public class GroupsToLowerAssertionFilter extends CommonIdentityAssertionFilter {
  
  /* (non-Javadoc)
   * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  /* (non-Javadoc)
   * @see org.apache.hadoop.gateway.identityasserter.common.filter.AbstractIdentityAssertionFilter#mapGroupPrincipals(java.lang.String, javax.security.auth.Subject)
   */
  @Override
  public String[] mapGroupPrincipals(String mappedPrincipalName, Subject subject) {
    ArrayList<String> groups = new ArrayList<String>();
    Set<?> currentGroups = subject.getPrincipals(GroupPrincipal.class);
    for (Object obj : currentGroups) {
      groups.add(((Principal)obj).getName().toLowerCase());
    }
    
    return groups.toArray(new String[groups.size()]);
  }
}
