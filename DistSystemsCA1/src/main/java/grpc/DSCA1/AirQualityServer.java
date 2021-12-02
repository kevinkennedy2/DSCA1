package grpc.DSCA1;

import java.io.IOException;
import grpc.DSCA1.IndexRankRating.Builder;
import grpc.DSCA1.airQualityServiceGrpc.airQualityServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

//Extends generated abstract class
public class AirQualityServer extends airQualityServiceImplBase {

	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		final AirQualityServer ourServer = new AirQualityServer();

		ourServer.start();
	}

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting gRPC Server");

		int port = 50051;
		// Create new server object, specify the service and port number it will run on
		server = ServerBuilder.forPort(port).addService(new AirQualityServerImpl()).build().start();

		System.out.println("Server running on Port: " + port);

		// Wait until told to terminate - continue listening
		server.awaitTermination();

	}

	// Extend abstract base class
	static class AirQualityServerImpl extends airQualityServiceImplBase {

		// Two values IndexrankNumber(the request) StreamObserver(interface for sever to
		// call with a response)
		@Override
		public void getAirQualityIndex(IndexRankNumber request, StreamObserver<IndexRankRating> responseObserver) {

			int index = request.getIndex();
			System.out.println(index);
			// Now build response
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
		
		//We are returning a stream observer of type GasType
		@Override
		public StreamObserver<GasType> pollutantCalculation(StreamObserver<PollutionResult> responseObserver2) {
			
			return new StreamObserver<GasType>() {
				
				
				//Every client message hits on next - logic goes in here
				@Override
				public void onNext(GasType value) {
					System.out.println("Client streaming started"+value.getGas());
					
					responseObserver2.setResult("The air quality in your area is good");
				}
			
				@Override
				public void onError(Throwable t) {

					t.printStackTrace();

				}
				//When client has finished streaming
				@Override
				public void onCompleted() {
					PollutionResult.Builder response = PollutionResult.newBuilder();
					
					responseObserver2.onNext(response.build());

					// completed too
					responseObserver2.onCompleted();
				}

			};

		}
	}
}
