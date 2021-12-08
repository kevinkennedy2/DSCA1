package grpc.DSCA;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import grpc.DSCA.carResponse;
import grpc.DSCA.transportPollutionServiceGrpc;
import grpc.DSCA.transportPollutionServiceGrpc.transportPollutionServiceStub;
import grpc.DSCA.airQualityServiceGrpc.airQualityServiceBlockingStub;
import grpc.DSCA.airQualityServiceGrpc.airQualityServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client {
	
	static airQualityServiceStub asyncStub;
	
	public static void main (String [] args) throws InterruptedException {
		
		
		/* 
		 *  We need two variables to specify where server is running (port and server name)
		 *  We build a channel as network to connect client and server 
		 */

			int port = 50051;
			int port2 = 50052;
			// Host is server name, this is local as running on same PC (otherwise would be IP or DNS name)
			// 
		String host = "localhost";
		

		//Plain text is not secure - this is building the channel for connection
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();	
		
		//Second channel for second port
		ManagedChannel newChannel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();
		
		//Build a message - this is specific for our service and goes from client to server
		//(Builder has a method in it that allows us to set contents also)
	
		//First Service Air Quality
		IndexRankNumber iRNumber = IndexRankNumber.newBuilder().setIndex(port).build();
		GasType gT = GasType.newBuilder().setGas("test").setIndex2(port2).build();
		
		//Second Service Transport Pollution
		railMessage rM = railMessage.newBuilder().setDistanceRail(port2).build();
		carMessage cM = carMessage.newBuilder().setNumber(100).build();
			
		
		//Create a stub - this is a local object client that has represents service
		airQualityServiceBlockingStub bstub = airQualityServiceGrpc.newBlockingStub(newChannel);	
		airQualityServiceStub asyncStub = airQualityServiceGrpc.newStub(newChannel);
	
		
		
		
		//streaming methods require async - no blocking (using same channel also)
		transportPollutionServiceStub asyncStub1 = transportPollutionServiceGrpc.newStub(newChannel2);
		transportPollutionServiceStub asyncStub2 = transportPollutionServiceGrpc.newStub(newChannel2);
		
		//We can now use stub to call rpc with getter method
		
		// message of type Indexrankrating (content is string) being returned
		IndexRankRating response = bstub.getAirQualityIndex(iRNumber);
		
		
	/*
		
		//publish messages to observer while Server waits - Client Streaming	
			requestObserver.onNext(carMessage.newBuilder().setNumber(100).build());
			requestObserver.onNext(carMessage.newBuilder().setNumber(250).build());
			
			
			
		
			// Mark the end of requests
			requestObserver.onCompleted();
*/
						
			Thread.sleep(10000);
	
		// Shutdown channel -
		try {
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("error closig channel");
			e.printStackTrace();
		}
	
	}
	
	public static  void carPollution() {
		
		
		StreamObserver<PollutionResult> responseObserver = new StreamObserver<PollutionResult>() {

			double result = 100;
			
			@Override
			public void onNext(PollutionResult value) {
				System.out.println("receving gastype from user ");
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed "+ result+ " converted numbers");
				
			}
	
		
		};
	
		
		StreamObserver<GasType> requestObserver = asyncStub.pollutantCalculation(responseObserver);

			requestObserver.onNext(GasType.newBuilder().setGas("Carbon Monoxide").setIndex2(100).build());
			
			
			// Mark the end of requests
			requestObserver.onCompleted();
		
	}
	
	
	
}

