/*
 * Copyright 2015-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.inspurmanager.cli;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
//import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.inspurmanager.intf.InspurOvsManageService;

/**
 * CLI to create an OVS switch.
 */
@Command(scope = "onos", name = "create-bridge",
        description = "Create a bridge on specific OVS")
public class CreateBridgeCommand extends AbstractShellCommand {

    private static final String CREATE_BRIDGE_FORMAT = "Create Bridge: %s";

    @Argument(index = 0, name = "bridge-name", description = "name of Bridge",
            required = true, multiValued = false)
    private String bridgeName;

    @Argument(index = 1, name = "bridge-type", description = "type of Bridge",
            required = true, multiValued = false)
    private String bridgeType;

    @Override
    protected void execute() {

        if (bridgeName == null || bridgeType == null) {
            return;
        }

        InspurOvsManageService.OvsDeviceType deviceType;
        if (bridgeType.toLowerCase().equals("core")) {
            deviceType = InspurOvsManageService.OvsDeviceType.CORE;
        } else if (bridgeType.toLowerCase().equals("access")) {
            deviceType = InspurOvsManageService.OvsDeviceType.ACCESS;
        } else {
            print("usage:  create-bridge bridgename 'core'/'access'");
            return;
        }

        InspurOvsManageService ovsService = AbstractShellCommand.get(InspurOvsManageService.class);

        if (ovsService.createOvs(bridgeName, deviceType)) {
            print(CREATE_BRIDGE_FORMAT, bridgeName);
        } else {
            print(CREATE_BRIDGE_FORMAT, "fail");
        }
    }
}
