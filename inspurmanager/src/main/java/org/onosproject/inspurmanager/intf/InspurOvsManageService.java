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
package org.onosproject.inspurmanager.intf;

import org.onosproject.net.behaviour.BridgeDescription;
import org.onosproject.net.device.PortDescription;

import java.util.List;

/**
 * OVS Switch Manage Service.
 */
public interface InspurOvsManageService {

    /**
     * Create an OVS switch.
     * @param deviceName : Switch name.
     * @param deviceType : Switch type, use enum OvsDeviceType below.
     * @return : if create successfully.
     */
    boolean createOvs(String deviceName, OvsDeviceType deviceType);

    /**
     * Delete an OVS switch.
     * @param deviceName : Switch name.
     * @return : if delete successfully.
     */
    boolean deleteOvs(String deviceName);

    /**
     * Get a List of the BridgeDescription of OVS switches connecting to ONOS.
     * @param type : Switch type, use enum OvsDeviceType below.
     * @return : List of the BridgeDescription, if fail or have no switch, it is emptyList.
     */
    List<BridgeDescription> getOvs(OvsDeviceType type);

    /**
     * add an OVS port .
     * @param bridgeName : Switch name.
     * @param portName   : port name
     * @return : if delete successfully.
     */
    boolean addPort(String bridgeName, String portName);

    /**
     * del an OVS port .
     * @param bridgeName : Switch name.
     * @param portName   : port name
     * @return : if delete successfully.
     */
    boolean delPort(String bridgeName, String portName);

    /**
     * Get a List of the PortDescription of OVS switches connecting to ONOS.
     * @return : List of the BridgeDescription, if fail or have no switch, it is emptyList.
     */
    List<PortDescription> getPorts(String bridgeName);

    /**
     * Switch type, include CORE and ACCESS.
     */
    enum OvsDeviceType {
        CORE,
        ACCESS
    }

}
