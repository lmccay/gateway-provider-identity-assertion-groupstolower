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

import org.apache.hadoop.gateway.deploy.DeploymentContext;
import org.apache.hadoop.gateway.deploy.ProviderDeploymentContributorBase;
import org.apache.hadoop.gateway.descriptor.FilterParamDescriptor;
import org.apache.hadoop.gateway.descriptor.ResourceDescriptor;
import org.apache.hadoop.gateway.topology.Provider;
import org.apache.hadoop.gateway.topology.Service;

import java.util.List;

public class GroupsToLowerAssertionContributor extends ProviderDeploymentContributorBase {

  private static final String ROLE = "identity-assertion";
  private static final String NAME = "GroupsToLower";
  private static final String FILTER = GroupsToLowerAssertionFilter.class.getName();

  public String getRole() {
    return ROLE;
  }

  public String getName() {
    return NAME;
  }

  public void contributeFilter(
      DeploymentContext context, Provider provider, Service service,
      ResourceDescriptor resource, List<FilterParamDescriptor> params ) {

    resource.addFilter().name( getName() ).role( getRole() ).impl( FILTER ).params( params );

  }

}
