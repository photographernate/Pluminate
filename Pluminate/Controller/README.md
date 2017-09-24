Code repository for ECE 590: Senior Design Experience.

This software is a controller for LEDs on band members' helmets and a smartphone application.

The controls interface with a local XBee device to broadcast information to remote XBee devices across a network.

**Patent Status: Pending**

## Installation Requirements
* Install the XCTU client from XBee.
* Connect the XBee device and board to the PC via USB port.
* Mark down the Port Number and Baud Rate for your device.


## Running Requirements -- WIP
* Please see the `Installation Requirements` above first.
* If on Linux, please make sure to run XCTU and Netbeans as root user.
* Inside `GUIControl.java`, change the `_portNumber` and `_baud` to the recorded values.
* If Netbeans throws a reference bug with the libraries, look under `lib/extra-libs/` directory for the binaries.