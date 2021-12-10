package grpc.DSCA;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class jmDNSServiceRegistration {

	public void run(int port, String service_type, String service_name) {

		// get an instance of jmDNS
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			int service_port = port;
			String service_desc = "jmDNS intgration for DS CA";

			// Create Service info object
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);

			// Register the service
			jmdns.registerService(serviceInfo);
			
			System.out.println("JmDNS Service Registered");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
