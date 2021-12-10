package grpc.DSCA;

import java.io.IOException;
import grpc.DSCA.airQualityServiceGrpc.airQualityServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;



public class AirQualityServer {

	// GRPC server
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {

		// Create Server Object - instantiate the class
		final AirQualityServer ourServer = new AirQualityServer();

		// Start our server
		ourServer.start();

	}

	// Method on server starting
	private void start() throws IOException, InterruptedException {
		System.out.println("Air Quality Server is Starting");

		// The port our AirQualityServer services will run on.
		int port = 50051;
		//Give JmDns the information it needs to discover the Service 
		String service_type = "_grpc.tcp.local.";
		String service_name = "AirQualityServer";
		//Create service registration object
		jmDNSServiceRegistration ssr = new jmDNSServiceRegistration();
		//pass three variables to service 
		ssr.run(port, service_type, service_name);
		
		/*
		 * Build an instance of the server, this will dispatch and listen for calls.
		 * Specify port service will run on and which service it will be
		 */
		
		server = ServerBuilder.forPort(port).addService(new NewAirQualityServerImpl()).build().start();
		System.out.println("Server running on port " + port);
		
		//keep server running
		server.awaitTermination();
	}

	// Extends abstract base generated class for our implementation, functionality
	// will go here

	static class NewAirQualityServerImpl extends airQualityServiceImplBase {

		/*
		  Stream observer watches for messages coming in and going out 
		 */
		@Override
		public  void getAirQualityIndex(IndexRankNumber request, StreamObserver<IndexRankRating> responseObserver) {

			//Find out index that has been sent - get method is created from generated classes
			int index = request.getIndex();
			System.out.println(index);
		
			// Now build response - based on index received we s it is ready to send back. 
			IndexRankRating.Builder response = IndexRankRating.newBuilder();

			if (index <= 50) {
				response.setIRRating("The air quality in your area is good");

			} else if (index > 50 && index <= 100) {
				response.setIRRating("The air in your area is moderate");
			}

			else if (index > 101 && index <= 150) {
				response.setIRRating("The air in your area is unhealthy for sensitive groups");
			}

			else if (index > 151 & index <= 200) {
				response.setIRRating("The air in your area is unhealthy");
			}

			else if (index > 200 & index <= 300) {
				response.setIRRating("The air in your area is hazardous");
			} else {
				response.setIRRating(" Index must be greater than 0 and less than 500");
			}

			// This corresponds to one message
			responseObserver.onNext(response.build());

			responseObserver.onCompleted();
		}
	
		}
	}


