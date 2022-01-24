package Tests;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ScrollTest {

	private static String[] stringInit= {};
	public ScrollTest(){

	}

	public static InetAddress getLocalAddress() throws SocketException
	{
		Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
		while( ifaces.hasMoreElements() )
		{
			NetworkInterface iface = ifaces.nextElement();
			Enumeration<InetAddress> addresses = iface.getInetAddresses();

			while( addresses.hasMoreElements() )
			{
				InetAddress addr = addresses.nextElement();
				if( addr instanceof Inet4Address && !addr.isLoopbackAddress() )
				{
					return addr;
				}
			}
		}

		return null;
	}
}