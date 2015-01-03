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

package org.apache.isis.viewer.wicket.ui.pages.login;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.isis.viewer.wicket.ui.errors.ExceptionModel;
import org.apache.isis.viewer.wicket.ui.pages.accmngt.AccountManagementPageAbstract;

/**
 * Boilerplate, pick up our HTML and CSS.
 */
public class WicketSignInPage extends AccountManagementPageAbstract {
    
    private static final long serialVersionUID = 1L;

    public WicketSignInPage(final PageParameters parameters) {
        this(parameters, getAndClearExceptionModelIfAny());
    }

    public WicketSignInPage(final PageParameters parameters, ExceptionModel exceptionModel) {
        super(parameters, exceptionModel);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addSignInPanel();
    }

    protected SignInPanel addSignInPanel() {
        final boolean suppressRememberMe = getConfiguration().getBoolean("isis.viewer.wicket.suppressRememberMe", false);
        final boolean suppressForgotPassword = getConfiguration().getBoolean("isis.viewer.wicket.suppressForgotPassword", false);
        final boolean clearOriginalDestination = getConfiguration().getBoolean("isis.viewer.wicket.clearOriginalDestination", false);
        final boolean rememberMe = !suppressRememberMe;
        final boolean forgotPassword = !suppressForgotPassword;
        final boolean continueToOriginalDestination = !clearOriginalDestination;
        return addSignInPanel(rememberMe, forgotPassword, continueToOriginalDestination);
    }

    private SignInPanel addSignInPanel(
            final boolean rememberMe,
            final boolean forgotPassword,
            final boolean continueToOriginalDestination) {
        final SignInPanel signInPanel = new IsisSignInPanel("signInPanel", rememberMe, forgotPassword, continueToOriginalDestination);
        add(signInPanel);
        return signInPanel;
    }
}
