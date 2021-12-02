package grpc.DSCA1;

import java.io.IOException;
import java.util.Scanner;

import grpc.DSCA1.IndexRankRating.Builder;
import grpc.DSCA1.airQualityServiceGrpc.airQualityServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

//Extends generated abstract class
public class AirQualityServer extends airQualityServiceImplBase{
	
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		final AirQualityServer ourServer = new AirQualityServer();
		
		ourServer.start();
	}

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting gRPC Server");
	
		int port = 50051;
		//Create new server object, specify the service and port number it will run on
		server = ServerBuilder.forPort(port).addService(new AirQualityServerImpl()).build().start();
		
		System.out.println("Server running on Port: "+port);
		
		//Wait until told to terminate - continue listening
		server.awaitTermination();
		
		
	}

	//Extend abstract base class
	static class AirQualityServerImpl extends airQualityServiceImplBase{
		
		//Two values IndexrankNumber(the request) StreamObserver(interface for sever to call with a response)
		@Override
		public void getAirQualityIndex(IndexRankNumber request, StreamObserver<IndexRankRating> responseObserver) {
	
		int index = request.getIndex();	
		System.out.println(index);
		//Now build response
		IndexRankRating.Builder response = IndexRankRating.newBuilder();
		
		if(index<=50){
		response.setIRRating("The air quality in your area is good");
		//This corresponds to one message
		responseObserver.onNext(response.build());
		
		responseObserver.onCompleted();
		}
		else if(index>50&&index<=100){
			response.setIRRating("The air in yout area is moderate");
			//This corresponds to one message
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}
	}
}}
		