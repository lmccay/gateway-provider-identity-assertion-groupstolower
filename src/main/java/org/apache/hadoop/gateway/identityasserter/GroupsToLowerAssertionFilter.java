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
package org.apache.hadoop.gateway.identityasserter;

import org.apache.hadoop.gateway.identityasserter.common.filter.CommonIdentityAssertionFilter;
import org.apache.hadoop.gateway.security.GroupPrincipal;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Set;

public class GroupsToLowerAssertionFilter extends CommonIdentityAssertionFilter {
  
  @Override
  public String[] mapGroupPrincipals( String mappedPrincipalName, Subject subject ) {
    ArrayList<String> groups = new ArrayList<String>();
    Set<GroupPrincipal> currentGroups = subject.getPrincipals( GroupPrincipal.class );
    for ( GroupPrincipal group : currentGroups ) {
      groups.add( group.getName().toLowerCase() );
    }
    return groups.toArray( new String[groups.size()] );
  }

}
