package grpc.DSCA;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class jmDNSServiceDiscovery {
	
	private int port;
	private String host;
	
	
	private static class MyServiceListener implements ServiceListener{
		
		private int port;
		private String host;
		private ServiceInfo serviceInfo1;
		
		//Add service and listen for event
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added "+event.getInfo());
		}
		
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed "+event.getInfo());
		}
		
		public void serviceResolved1(ServiceEvent event) {
			System.out.println("Service Resolved"+event.getInfo());
		}
		
			
		public void serviceResolved(ServiceEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Service Resolved " + event.getInfo());
			
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			System.out.println("host " + serviceInfo.getHostAddress());
			//this.setHost(serviceInfo.getHostAddress());
			System.out.println("port " + serviceInfo.getPort());
			this.setPort(serviceInfo.getPort());
			System.out.println("type " + serviceInfo.getType());
			System.out.println("name " + serviceInfo.getName());
			System.out.println("Computername " + serviceInfo.getServer());
			System.out.println("desc/properties " + serviceInfo.getNiceTextString());
			//System.out.println("desc/properties " + serviceInfo.);
		}
			public int getPort() {
				return port;
			}

			public void setPort(int port) {
				this.port = port;
			}


			public ServiceInfo getServiceInfo() {
				return serviceInfo1;
			}

			public void setServiceInfo(ServiceInfo serviceInfo) {
				this.serviceInfo1 = serviceInfo;
			}
			
		}

		//public static void main(String[] args) {
		public static ServiceInfo run(String service_type) {
			
			int port = 0;
			ServiceInfo serviceInfo = null;
			// get an instance of jmDNS
					
			
			try {
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				
				//will discover the service based on service type
				//String service_type = "_grpc._tcp.local";				
				
				//need to listen for services added/removed etc.
				
				//Listener for client, sits waiting
				MyServiceListener msl = new MyServiceListener();	
				
				jmdns.addServiceListener(service_type, msl);

				
				//sleep for 10 seconds
				Thread.sleep(10000);
				
				serviceInfo = msl.getServiceInfo();
				port = msl.getPort();
				System.out.println("This is the port retreived from jmDNS: " + port);
				
				jmdns.close();
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return serviceInfo;
		}
	}


