package grpc.DSCA;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class jmDNSServiceDiscoveryTransport {
	
	private int port;
	private String host;
	
	
	private static class MyServiceListener implements ServiceListener{
		
		private int port;
		private String host;
		private ServiceInfo serviceInfo;
		
		@Override
		public void serviceAdded(ServiceEvent event) {
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			System.out.println("port " + serviceInfo.getPort());
			this.setPort(serviceInfo.getPort());;
			System.out.println("Service added "+event.getInfo());
		}
		
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed "+event.getInfo());
		}
		
		@Override
		public void serviceResolved(ServiceEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Service Resolved " + event.getInfo());
			
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			System.out.println("port " + serviceInfo.getPort());
			this.setPort(serviceInfo.getPort());;
		}
			

			public void setPort(int port) {
				this.port = port;
			}

			public int getPort() {
				return port;
			}
			public ServiceInfo getServiceInfo() {
				return serviceInfo;
			}

			public void setServiceInfo(ServiceInfo serviceInfo) {
				this.serviceInfo = serviceInfo;
			}
			
		}

		//public static void main(String[] args) {
		public static ServiceInfo run(String service_type) {
			
			int port = 0;
			ServiceInfo serviceInfo = null;
			

			try {
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				
				//will discover the service based on service type
				service_type = "_transport._tcp.local";				
				
				//need to listen for services added/removed etc.
				MyServiceListener msl = new MyServiceListener();
				        
				serviceInfo = msl.getServiceInfo();
				System.out.println("Service is "+msl.getServiceInfo());
				port = msl.getPort();
				System.out.println("This is the port retreived from jmDNS: " + port);	
				
				//jmdns.addServiceListener("_grpc._tcp.local", msl);
			
				//jmdns.registerService(serviceInfo);
				
				//sleep for 10 seconds
				Thread.sleep(10000);
				
				
				
				jmdns.close();
				
				
				
			} catch (UnknownHostException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			return serviceInfo;
		}
	}


