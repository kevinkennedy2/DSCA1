package grpc.DSCA;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.jmdns.ServiceInfo;
import javax.swing.*;


import grpc.DSCA.airQualityServiceGrpc.airQualityServiceBlockingStub;
import grpc.DSCA.airQualityServiceGrpc.airQualityServiceStub;
import grpc.DSCA.transportPollutionServiceGrpc.transportPollutionServiceBlockingStub;
import grpc.DSCA.transportPollutionServiceGrpc.transportPollutionServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;

public class GUI {

	private static airQualityServiceBlockingStub blockingStub;

	private static transportPollutionServiceBlockingStub blockingStub1;
	private static transportPollutionServiceStub asyncStub2;
	private static transportPollutionServiceStub asyncStub;
	
	// instance variables - been used in different methods
	JFrame frame;
	private JTextField textNumber1;
	private JTextArea textResponse;
	private JTextField textNumber2;
	private JTextArea textResponse2;
	private JTextField textNumber3;
	private JTextArea textResponse3;
	private JTextField textNumber4;
	private JTextArea textResponse4;
	private JTextField textNumber5;
	private JTextField textNumber6;
	
	// Standard method for launching JFrame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					// create new GUI application object - create instance of class
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	
	}
	// The application
	public GUI() {
		
		//--------JMDNS---------------
		
		ServiceInfo serviceInfo;
		String service_type = "_grpc.tcp.local.";
		
		//Pass service Info back to client
		serviceInfo = jmDNSServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";

		//----------------------------------------
	
		
		//int port = 50051;
		int port2 = 50052;
		//String host = "localhost";

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();

		blockingStub = airQualityServiceGrpc.newBlockingStub(channel);
		

		// Stubs for TransportPollution Server
		asyncStub = transportPollutionServiceGrpc.newStub(channel2);
		asyncStub2 = transportPollutionServiceGrpc.newStub(channel2);
		blockingStub1 = transportPollutionServiceGrpc.newBlockingStub(channel2);

		// Combine the code from JFrame and GRPC - two frameworks
		initialize();
	}

	// Builds Gui and calls RPC
	private void initialize() {
		// build up GUI - JFrame is outer window
		frame = new JFrame();
		// Title
		frame.setTitle("Client for DS CA1");
		// Set Bounds
		frame.setBounds(100, 100, 800, 600);
		// What happens when you exit - exit on close kills program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Box layout determines how components are laid out in panel
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_1 = new JPanel();
		JPanel panel_service_2 = new JPanel();
		JPanel panel_service_3 = new JPanel();
		JPanel panel_service_4 = new JPanel();

		// add panel to jframe
		frame.getContentPane().add(panel_service_1);
		frame.getContentPane().add(panel_service_2);
		frame.getContentPane().add(panel_service_3);
		frame.getContentPane().add(panel_service_4);

		// flow layout - gaps
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_service_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_service_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// create new label and add it to the panel
		JLabel lblNewLabel_1 = new JLabel(" Please enter the Air Quality Index or your area ");
		panel_service_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(" Please enter a number representing the distance travelled in KM in each box ");
		panel_service_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" Please enter a number representing the distance travelled in KM in the box ");
		panel_service_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(" Enter the distance travelled in the first box and your consumption per liter in the second");
		panel_service_4.add(lblNewLabel_4);

		// Input textbox -
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);

		textNumber2 = new JTextField();
		panel_service_2.add(textNumber2);

		textNumber3 = new JTextField();
		panel_service_2.add(textNumber3);

		textNumber4 = new JTextField();
		panel_service_3.add(textNumber4);
		
		textNumber5 = new JTextField();
		panel_service_4.add(textNumber5);
		
		textNumber6 = new JTextField();
		panel_service_4.add(textNumber6);

		// width of input box
		textNumber1.setColumns(10);
		textNumber2.setColumns(10);
		textNumber3.setColumns(10);
		textNumber4.setColumns(10);
		textNumber5.setColumns(10);
		textNumber6.setColumns(10);
		
		JButton btnSend = new JButton("Send Air Quality Index to Server");

		JButton btnSend2 = new JButton("Send numbers to server");

		JButton btnSend3 = new JButton("Send the distance travelled to the server");

		JButton btnSend4 = new JButton("Send the distance and consumption to the server ");

		// add action listener to button
		btnSend.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {

				// retrieve data from GUI
				int num1 = Integer.parseInt(textNumber1.getText());


				// This is calling mehtod and not server
				IndexRankNumber iRNumber = IndexRankNumber.newBuilder().setIndex(num1).build();

				IndexRankRating response = blockingStub.getAirQualityIndex(iRNumber);

				// add response into GUI
				textResponse.append("reply: " + response);
			}
		}
		);

		btnSend2.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent b) {
							
				double number1= Double.parseDouble(textNumber2.getText());
				double number2= Double.parseDouble(textNumber3.getText());
				
				//Create Stream observer called responseObeserver
				StreamObserver<busResponse> responseObserver = new StreamObserver<busResponse>() {
					
					@Override
					public void onNext(busResponse value) {
						System.out.println("Your Emissions are "+value.getEmissions()+" kg ");
					
						textResponse2.append("Your CO2 Emissions are "+value.getEmissions()+"KG for travelling on a "+value.getMessage()+"\n");
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onCompleted() {
						System.out.println("Stream Completed");
					}
				};
			
				
				StreamObserver<busMessage> requestObserver = asyncStub.busPollution(responseObserver);
				try {
				
					//requestObserver.onNext(busMessage.newBuilder().setDistance(number1).
				//	Thread.sleep(500);
					
					requestObserver.onNext(busMessage.newBuilder().setDistance(number1).build());
					Thread.sleep(500);
					
					requestObserver.onNext(busMessage.newBuilder().setDistance(number2).build());
					Thread.sleep(500);
					
					requestObserver.onNext(busMessage.newBuilder().setDistance(number2).build());
					Thread.sleep(500);
					
					requestObserver.onCompleted();	
					
						
				}catch (InterruptedException e1) {

					e1.printStackTrace();
				}

				
			}
			});
		
		btnSend3.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {

				int num2 = Integer.parseInt(textNumber4.getText());

				railMessage request = railMessage.newBuilder().setDistanceRail(num2).build();
				
				//Iterator puts all response messages into responses object - iterator is of object type railResponse
				Iterator<railResponse> responses = blockingStub1.railPollution(request);
				//this will collect all as long as next exists and then stops
				while (responses.hasNext()) {

					railResponse response = responses.next();

					textResponse3.append(response.getMessage() + "\n");
				}

			}
		}

		);
				
		btnSend4.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent b) {
							
				double number1= Double.parseDouble(textNumber5.getText());
			
				double number2 = Double.parseDouble(textNumber6.getText());

				StreamObserver<carResponse> responseObserver = new StreamObserver<carResponse>() {

					@Override
					public void onNext(carResponse value) {
						System.out.println("Your Emissions are "+value.getEmissions()+" kg ");
						System.out.println(number1);
						System.out.println(number2);
						textResponse4.append("Your Emissions are "+value.getEmissions()+"kg of CO2 for travelling "+number1+"KM in your Car");
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onCompleted() {
						System.out.println("Stream Completed");
					}
				};
				
				StreamObserver<carMessage> requestObserver = asyncStub2.carPollution(responseObserver);
				try {
					
					requestObserver.onNext(carMessage.newBuilder().setDistanceTravelled(number1).build());
					Thread.sleep(500);
					
					requestObserver.onNext(carMessage.newBuilder().setDistanceTravelled(number2).build());
					
					requestObserver.onCompleted();
				 
						
						
				}catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}
			});
		
		panel_service_1.add(btnSend);

		textResponse = new JTextArea(3, 40);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);

		panel_service_1.add(scrollPane);

		panel_service_2.add(btnSend2);

		textResponse2 = new JTextArea(3, 40);
		textResponse2.setLineWrap(true);
		textResponse2.setWrapStyleWord(true);

		JScrollPane scrollPane2 = new JScrollPane(textResponse2);

		panel_service_2.add(scrollPane2);

		panel_service_3.add(btnSend3);

		textResponse3 = new JTextArea(3, 40);
		textResponse3.setLineWrap(true);
		textResponse3.setWrapStyleWord(true);

		JScrollPane scrollPane3 = new JScrollPane(textResponse3);

		panel_service_3.add(scrollPane3);

		panel_service_4.add(btnSend4);

		textResponse4 = new JTextArea(3, 40);
		textResponse4.setLineWrap(true);
		textResponse4.setWrapStyleWord(true);

		JScrollPane scrollPane4 = new JScrollPane(textResponse4);

		panel_service_4.add(scrollPane4);

	}
}
