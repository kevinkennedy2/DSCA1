package grpc.DSCA;

import java.io.IOException;
import java.util.ArrayList;

import grpc.DSCA.transportPollutionServiceGrpc.transportPollutionServiceImplBase;
import grpc.DSCA.carMessage;
import grpc.DSCA.carResponse;
import grpc.DSCA.TransportPollutionServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TransportPollutionServer {

	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {

		final TransportPollutionServer transportServer = new TransportPollutionServer();

		transportServer.start();

	}

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting Transport Server");

		int port = 50052;
		// Create new server object, specify the service and port number it will run on
		server = ServerBuilder.forPort(port).addService(new TransportPollutionServerImpl()).build().start();
		
		//JmDns intergration
		String service_type = "grpc.tvp.local.";
		String service_name = "TransportPollutionServer";
		
		System.out.println("Transport server running on Port: " + port);

		// Wait until told to terminate - continue listening
		server.awaitTermination();

	}

	// Extend abstract base class
	static class TransportPollutionServerImpl extends transportPollutionServiceImplBase {

		// Method for Server-side Streaming RPC
		@Override
		public void railPollution(railMessage request, StreamObserver<railResponse> responseObserver) {

			// Find out what was sent by client
			double distanceRail = request.getDistanceRail();
			System.out.println("The distance travelled is : " + distanceRail);

			// Now build our responses (message of type railMessage) - Response Observer is
			// used to send out message
			railResponse.Builder response = railResponse.newBuilder();

			// Response 1
			response.setEmissions(distanceRail * 0.04);
			response.setMessage("Travelling " + distanceRail + "KM by Commuter Train will emit "+ response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());

			// Response 2
			response.setEmissions(distanceRail * 0.07);
			response.setMessage("Travelling " + distanceRail + "KM by Light rail Tram will emit "+ response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());

			// Response 3
			response.setEmissions(distanceRail * 0.03);
			response.setMessage("Travelling " + distanceRail + "KM by Subway will emit " + response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}

		// We are not returning void like ServerStreaming but now returning
		// StreamObserver of type Car message

		@Override
		public StreamObserver<carMessage> carPollution(StreamObserver<carResponse> responseObserver) {
			
			//we create an array list of type double to store the numbers during the client stream
			ArrayList<Double> list = new ArrayList();
			
			System.out.println("Client Streaming");
			
			//return streamObserver back to library
			return new StreamObserver<carMessage>() {
				
				@Override
				public void onNext(carMessage value) {
					
					System.out.println(value.getNumber());

					carMessage.Builder message = carMessage.newBuilder();
					//add the number entered by user into the Array
					list.add(value.getNumber());
					
				}

				@Override
				public void onError(Throwable t) {

				}

				// When client has sent all his messages and is finished streaming, below method sends message back from Server
				@Override
				public void onCompleted() {
				
					carResponse.Builder response = carResponse.newBuilder();
					
					double emissions = 0;
					//Access the two elements in the array
					double number1 = list.get(0);
					double number2 = list.get(1);
					
					//Calculation for working out CO2 emissions based on Distance and Consumption
					emissions= number1/100*number2*2.62;
					
					response.setEmissions(emissions);
					
					responseObserver.onNext(response.build());
					responseObserver.onCompleted();
				}

			};

		}
	}
}