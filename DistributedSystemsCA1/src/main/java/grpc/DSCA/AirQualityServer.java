package grpc.DSCA;

import java.io.IOException;
import grpc.DSCA.airQualityServiceGrpc.airQualityServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

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
		public void getAirQualityIndex(IndexRankNumber request, StreamObserver<IndexRankRating> responseObserver) {

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
				System.out.println(" Index must be greater than 0 and less than 500");
			}

			// This corresponds to one message
			responseObserver.onNext(response.build());

			responseObserver.onCompleted();
		}
	
		public StreamObserver<GasType> pollutantCalculation(StreamObserver<PollutionResult> responseObserver) {
		
			return new StreamObserver<GasType> () {
				
				int index;
				String gas;
				@Override
				public void onNext(GasType value) {
				
				gas = value.getGas();
				index = value.getIndex2();
					
				GasType.Builder response = GasType.newBuilder().setGas(gas).setIndex2(index);
					
				
				}
				
				
				
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					PollutionResult.Builder response = PollutionResult.newBuilder();
					
					if (gas== "Carbon Monoxide") {
						response.setConcentrateLevel(11);
					}
					else if(gas=="Sulphur Dioxide") {
						response.setConcentrateLevel(2);
					}
					
					responseObserver.onNext(response.build());
					
					int cLevel = response.getConcentrateLevel();
					
					int result = (index*cLevel);
					
					response.setResult(result);
		
					
					System.out.println(index+gas+result+cLevel);
					
					responseObserver.onNext(response.build());
					
					responseObserver.onCompleted();
					
				}

			};
		}
	}

}
