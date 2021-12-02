package grpc.DSCA1;

import java.util.concurrent.TimeUnit;

import grpc.DSCA1.airQualityServiceGrpc.airQualityServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

	public static void main(String[] args) {
		// build a channel as network to connect client and server

		// We need two variables to specify where server is running (port and server
		// name)

		int port = 50051;
		// Hose = server name
		// Is local becasue running on same PC (otherwise would be IP or DNS name)
		String host = "localhost";

		// Plain text is not secure - this is building the channel for connection
		// this is generic
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// build a message - this is specify for our service
		// this message goes from client to server
		// Builder has a method that allows us to set contents
		IndexRankNumber iRNumber = IndexRankNumber.newBuilder().setIndex(100).build();

		// create a stub - this isa local object client has that represents service
		// Async for bio-directional and client streaming
		// two types of stub blocking and sync
		airQualityServiceBlockingStub bstub = airQualityServiceGrpc.newBlockingStub(newChannel);

		// we can now use stub to call rpc with getter method
		// message of type Indexrankrating (content is string)
		IndexRankRating response = bstub.getAirQualityIndex(iRNumber);

		System.out.println(response);

		// Shutdown channel -
		try {
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("error closig channel");
			e.printStackTrace();
		}
	}

}
