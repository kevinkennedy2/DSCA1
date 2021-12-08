package grpc.DSCA;

import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GuiSupport {
	
	public static void main(String[] args) {
		
	
		
		int port2 = 50052;
		String host = "localhost";
		
		ManagedChannel channel2 = ManagedChannelBuilder
				.forAddress(host, port2)
				.usePlaintext()
				.build();

		//blockingStub1 = transportPollutionServiceGrpc.newBlockingStub(channel2);
		
		transportPollutionServiceGrpc.transportPollutionServiceBlockingStub stub = transportPollutionServiceGrpc.newBlockingStub(channel2);
		
		double distanceRail;
		
		//railMessage request = railMessage.newBuilder().build();
		
		railMessage request = railMessage.newBuilder().setDistanceRail(5).build();
		
		Iterator<railResponse> responses = stub.railPollution(request);
		
		while(responses.hasNext()) {
		
		railResponse response = responses.next();
		
		System.out.println("Response is "+response.getMessage());
		
		
	}}
	}

