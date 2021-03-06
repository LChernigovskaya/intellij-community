// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

/*
 * Class RemoteConfigurationFactory
 * @author Jeka
 */
package com.intellij.execution.remote;

import com.intellij.execution.ExecutionBundle;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.SimpleConfigurationType;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.util.LazyUtil;
import org.jetbrains.annotations.NotNull;

public final class RemoteConfigurationType extends SimpleConfigurationType {
  public RemoteConfigurationType() {
    super("Remote", ExecutionBundle.message("remote.debug.configuration.display.name"), ExecutionBundle.message("remote.debug.configuration.description"),
          LazyUtil.create(() -> AllIcons.RunConfigurations.Remote));
  }

  @Override
  @NotNull
  public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
    return new RemoteConfiguration(project, this);
  }

  @NotNull
  @Override
  public String getTag() {
    return "jvmRemote";
  }

  @NotNull
  @Deprecated
  public ConfigurationFactory getFactory() {
    return this;
  }

  @NotNull
  public static RemoteConfigurationType getInstance() {
    return ConfigurationTypeUtil.findConfigurationType(RemoteConfigurationType.class);
  }
}
