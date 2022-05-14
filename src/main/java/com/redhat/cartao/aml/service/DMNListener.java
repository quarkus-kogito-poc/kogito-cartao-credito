package com.redhat.cartao.aml.service;

/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.kie.dmn.api.core.event.BeforeEvaluateAllEvent;
import org.kie.dmn.api.core.event.AfterEvaluateDecisionEvent;
import org.kie.dmn.api.core.event.DMNRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
class DMNListener implements DMNRuntimeEventListener{

  private static final Logger LOG = LoggerFactory.getLogger(DMNListener.class);
  
  @Override
    public void beforeEvaluateAll(BeforeEvaluateAllEvent event) {
        BeforeEvaluateAllEvent castedEvent = (BeforeEvaluateAllEvent)event;
        
        Map<String, Object> contextObjects = castedEvent.getResult().getContext().getAll();
        LOG.info("---------- New Input ----------");
        LOG.info("DMN Input Event Input Result: " + contextObjects.toString());

    }

  @Override
  public void afterEvaluateDecision(AfterEvaluateDecisionEvent dmnEvent){
    
    LOG.info("DMN Event Decision node name: " + dmnEvent.getDecision().getName());
    LOG.info("DMN Event Decision node id: " + dmnEvent.getDecision().getId());
    LOG.info("DMN Event Decision ResultType Name: " + dmnEvent.getDecision().getResultType().getName());
    LOG.info("DMN Event Decision Status: " + dmnEvent.getResult().getDecisionResultById(dmnEvent.getDecision().getId()).getEvaluationStatus().name());
    LOG.info("DMN Event Decision Result: " + dmnEvent.getResult().getDecisionResultById(dmnEvent.getDecision().getId()).getResult());	

    // LOG.info("Decision {} evaluated to: {}", event.getDecision().getName(), event.getResult().getDecisionResultByName(event.getDecision().getName()).getResult());
  }
  
}