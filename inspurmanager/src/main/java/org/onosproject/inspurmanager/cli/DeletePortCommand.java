package org.onosproject.inspurmanager.cli;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.inspurmanager.intf.InspurOvsManageService;

/**
 * Created by Administrator on 2016/5/23.
 */
@Command(scope = "onos", name = "del-port",
        description = "del a port on specific bridge")
public class DeletePortCommand extends AbstractShellCommand {

    private static final String DEL_PORT_FORMAT = "del port %s from Bridge: %s";
    private static final String DEL_PORT_FAIL_FORMAT = "del port fail";

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

        if (ovsService.delPort(bridgeName, portName)) {
            print(DEL_PORT_FORMAT, portName, bridgeName);
        } else {
            print(DEL_PORT_FAIL_FORMAT);
        }
    }
}