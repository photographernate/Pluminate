package bandcontrols;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.models.XBee64BitAddress;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author ECE 590 Team 2
 */
public class GUIController {

    private File _script;
    private String _workingScript;
    private File _memberInfo;
    private List<BandMember> _memberList;  // 450 members
    private XBeeDevice _transmitter;
    private int _baud = 9600;
    private String _portNumber = "/dev/ttyUSB0"; // Change this when we get the actual Laptop
    private List<RemoteXBeeDevice> _receivers;
    private List<String> _receiverMAC; //= "0013A20040F8E9DC";

    /**
     * Constructs a new GUI controller with the script, list of band members, and XBee information.
     */
    public GUIController()
    {
        _memberList = readRoster();
        _transmitter = new XBeeDevice(_portNumber, _baud);
        _receivers = new ArrayList<RemoteXBeeDevice>();
        
        int length = _receivers.size();
        
        for (int i = 0; i < length; i++)
        {
            _receivers.add(new RemoteXBeeDevice(_transmitter, new XBee64BitAddress(_receiverMAC.get(i))));
        }
    }

    /**
     * Reads in a file describing each band member (instrument, number,
     * ZigBee ID).
     * @return List of all band members' information.
     */
    public List<BandMember> readRoster()
    {
        _memberInfo = new File("members.txt"); // Check for blank lines
        List<BandMember> list = new ArrayList<BandMember>();
        
        try {
            for (String line : Files.readAllLines(Paths.get(_memberInfo.getAbsolutePath())))
            {
                String[] parts = line.split(",");
                BandMember temp = new BandMember(parts[0], Integer.parseInt(parts[1]), parts[2]);
                list.add(temp);
            }

        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Retrieves the band member list.
     * @return List of current band members.
     */
    public List<BandMember> getMembers()
    {
        return _memberList;
    }

    /**
     * Saves any modifications to the script.
     * @param changes 
     */
    public void saveScript(String changes)
    {
        _workingScript = changes;
    }
    /**
     * Adds band members to the list of band members.
     * @param type Band instrument type
     * @param num Number of band member
     * @param xbeeMac MAC address of XBee
     */
    public void addMembers(String type, int num, String xbeeMac)
    {
        _memberList.add(new BandMember(type, num, xbeeMac));
    }
    
    /**
     * Transmits data from the GUI to the XBee transmitter.
     * @return Whether the data was successfully transmitted or not.
     */
    public boolean transmitData()
    {
        byte[] data = "HELLO WORLD!".getBytes();
        try 
        {
            _transmitter.open();
            _transmitter.sendBroadcastData(data);
            return true;
        }
        catch (XBeeException e)
        {
            System.out.println(e.toString());
            return false;
        }
        finally
        {
            _transmitter.close();
        }

    }
}
