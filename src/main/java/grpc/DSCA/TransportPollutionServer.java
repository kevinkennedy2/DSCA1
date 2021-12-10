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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

		// JmDns intergration
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
			response.setMessage("Travelling " + distanceRail + "KM by Commuter Train will emit "
					+ response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());

			// Response 2
			response.setEmissions(distanceRail * 0.07);
			response.setMessage("Travelling " + distanceRail + "KM by Light rail Tram will emit "
					+ response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());

			// Response 3
			response.setEmissions(distanceRail * 0.03);
			response.setMessage(
					"Travelling " + distanceRail + "KM by Subway will emit " + response.getEmissions() + "KG of CO2");
			responseObserver.onNext(response.build());

			responseObserver.onCompleted();
		}

		// We are not returning void like ServerStreaming but now returning
		// StreamObserver of type Car message

		public StreamObserver<carMessage> carPollution(StreamObserver<carResponse> responseObserver) {

			System.out.println("inside streaming implementation");
			// return streamObserver back to library
			return new StreamObserver<carMessage>() {

				// we create an array list of type double to store the numbers during the client
				// stream
				ArrayList<Double> list = new ArrayList<Double>();

				@Override
				public void onNext(carMessage value) {

					// add the number entered by user into the Array
					list.add(value.getDistanceTravelled());
					

				}

				@Override
				public void onError(Throwable t) {

				}

				// When client has sent all his messages and is finished streaming, below method
				// sends message back from Server
				@Override
				public void onCompleted() {

					double emissions = 0;
					// Access the two elements in the array
					double number1 = list.get(0);

					double number2 = list.get(1);

					// Calculation for working out CO2 emission's based on Distance and Consumption
					emissions = ((number1 / 100) * (number2 * 2.62));
					
					carResponse response = carResponse.newBuilder().setEmissions(emissions).build();
			
					responseObserver.onNext(response);
					responseObserver.onCompleted();
					System.out.println(emissions);
				}

			};

		}

		public StreamObserver<busMessage> busPollution(StreamObserver<busResponse> responseObserver) {

			return new StreamObserver<busMessage>() {
				
				ArrayList<Double> list = new ArrayList<Double>();
				

				@Override
				public void onNext(busMessage value) {
					// add the number entered by user into the Array
					list.add(value.getDistance());
					

				}
				
				@Override
				public void onError(Throwable t) {

					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					
					double number1 = list.get(0);
					
					busResponse response = busResponse.newBuilder().setEmissions(number1*.882).setMessage("City Bus").build();
					responseObserver.onNext(response);
					
					busResponse response2 = busResponse.newBuilder().setEmissions(number1*1.3).setMessage("Coach").build();
					responseObserver.onNext(response2);
					
					double number2 = list.get(1);
					
					busResponse response3 = busResponse.newBuilder().setEmissions(number2*.882).setMessage("City Bus").build();
					responseObserver.onNext(response3);
					
					busResponse response4 = busResponse.newBuilder().setEmissions(number2*1.3).setMessage("Coach").build();
					responseObserver.onNext(response4);
					
					// completed too
					responseObserver.onCompleted();
				}

			};

		}
	}
}