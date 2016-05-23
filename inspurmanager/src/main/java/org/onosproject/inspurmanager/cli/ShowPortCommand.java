package org.onosproject.inspurmanager.cli;

import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;

/**
 * Created by Administrator on 2016/5/23.
 */
@Command(scope = "onos", name = "show-port",
        description = "list ports of specific OVS")
public class ShowPortCommand extends AbstractShellCommand {
    @Override
    protected void execute() {
        print("\n--------------a test---------------\n");
    }
}
