/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.isis.core.metamodel.facets.param.choices.methodnum;

import java.util.EnumSet;

import javax.inject.Inject;

import org.apache.isis.core.config.progmodel.ProgrammingModelConstants.MemberSupportPrefix;
import org.apache.isis.core.metamodel.context.MetaModelContext;
import org.apache.isis.core.metamodel.facetapi.FeatureType;
import org.apache.isis.core.metamodel.facets.ParameterSupport;
import org.apache.isis.core.metamodel.facets.ParameterSupport.ParamSupportingMethodSearchRequest.ReturnType;
import org.apache.isis.core.metamodel.facets.ParameterSupport.SearchAlgorithm;
import org.apache.isis.core.metamodel.facets.members.support.MemberSupportFacetFactoryAbstract;

import lombok.val;

public class ActionParameterChoicesFacetViaMethodFactory
extends MemberSupportFacetFactoryAbstract {

    @Inject
    public ActionParameterChoicesFacetViaMethodFactory(final MetaModelContext mmc) {
        super(mmc, FeatureType.ACTIONS_ONLY, MemberSupportPrefix.CHOICES);
    }

    // ///////////////////////////////////////////////////////
    // Actions
    // ///////////////////////////////////////////////////////

    @Override
    public void process(final ProcessMethodContext processMethodContext) {

        val facetedMethod = processMethodContext.getFacetHolder();
        val parameters = facetedMethod.getParameters();

        if (parameters.isEmpty()) {
            return;
        }

        // attach ActionChoicesFacet if choicesNumMethod is found ...

        val methodNameCandidates = memberSupportPrefix.getMethodNamePrefixes()
                .flatMap(processMethodContext::parameterSupportCandidates);

        val searchRequest = ParameterSupport.ParamSupportingMethodSearchRequest.builder()
                .processMethodContext(processMethodContext)
                .returnType(ReturnType.NON_SCALAR)
                .paramIndexToMethodNameProviders(methodNameCandidates)
                .searchAlgorithms(EnumSet.of(SearchAlgorithm.PPM, SearchAlgorithm.SWEEP))
                .build();

        ParameterSupport.findParamSupportingMethods(searchRequest, searchResult -> {

            val choicesMethod = searchResult.getSupportingMethod();
            val paramIndex = searchResult.getParamIndex();
            val returnType = searchResult.getReturnType();

            processMethodContext.removeMethod(choicesMethod);

            // add facets directly to parameters, not to actions
            val paramAsHolder = parameters.get(paramIndex);
            val ppmFactory = searchResult.getPpmFactory();
            addFacet(
                    new ActionParameterChoicesFacetViaMethod(
                            choicesMethod, returnType, ppmFactory, paramAsHolder));
        });

    }



}
