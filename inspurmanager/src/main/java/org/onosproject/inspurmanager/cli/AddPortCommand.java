package org.onosproject.inspurmanager.cli;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.inspurmanager.intf.InspurOvsManageService;

/**
 * Created by Administrator on 2016/5/23.
 */
@Command(scope = "onos", name = "add-port",
        description = "add a port on specific bridge")
public class AddPortCommand extends AbstractShellCommand {

    private static final String ADD_PORT_FORMAT = "add port %s to Bridge: %s";
    private static final String ADD_PORT_FAIL_FORMAT = "add port fail";

    @Argument(index = 0, name = "bridge-name", description = "name of Bridge",
            required = true, multiValued = false)
    private String bridgeName;

    @Argument(index = 0, name = "port-name", description = "name of Port",
            required = true, multiValued = false)
    private String portName;

    @Override
    protected void execute() {

        if (bridgeName == null || portName == null) {
            return;
        }

        InspurOvsManageService ovsService = AbstractShellCommand.get(InspurOvsManageService.class);

        if (ovsService.addPort(bridgeName, portName)) {
            print(ADD_PORT_FORMAT, portName, bridgeName);
        } else {
            print(ADD_PORT_FAIL_FORMAT);
        }
    }
}
