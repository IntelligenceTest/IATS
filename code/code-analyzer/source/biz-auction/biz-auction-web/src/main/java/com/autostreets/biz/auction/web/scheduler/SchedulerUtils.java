package com.autostreets.biz.auction.web.scheduler;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerUtils {

    private final static String DEFAULT_LOCALHOST_NAME = "localhost";
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerUtils.class);

    public static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException("Unknown Host", e);
        }
    }

    public static String[] getLocalHostIps() {
        List<String> ips = new ArrayList<String>();
        Enumeration<NetworkInterface> allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress inetAddress = addresses.nextElement();
                if (inetAddress != null && inetAddress instanceof Inet4Address) {
                    String ip = inetAddress.getHostAddress();
                    if (ip != null && !ip.equals("127.0.0.1")) {
                        ips.add(ip);
                    }
                }
            }
        }
        return ips.toArray(new String[ips.size()]);
    }

    public static boolean isLocalHostName(String computerName) {
        return computerName.toLowerCase().indexOf(DEFAULT_LOCALHOST_NAME) != -1;
    }
}
