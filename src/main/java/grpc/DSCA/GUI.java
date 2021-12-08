package grpc.DSCA;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
	private static airQualityServiceStub asyncStub;

	private static transportPollutionServiceBlockingStub blockingStub1;
	private static transportPollutionServiceStub asyncStub2;

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

		int port = 50051;
		int port2 = 50052;
		String host = "localhost";

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();

		blockingStub = airQualityServiceGrpc.newBlockingStub(channel);
		asyncStub = airQualityServiceGrpc.newStub(channel);

		//Stubs for TransportPollution Server
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

		JLabel lblNewLabel_2 = new JLabel(" Please enter a pollutant and then a concntration level ");
		panel_service_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" Rail response ");
		panel_service_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Enter Distacne travelled ");
		panel_service_4.add(lblNewLabel_4);
		
		// Input textbox -
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);

		textNumber2 = new JTextField();
		panel_service_2.add(textNumber2);

		textNumber3 = new JTextField();
		panel_service_3.add(textNumber3);
		
		textNumber4 = new JTextField();
		panel_service_4.add(textNumber4);

		// width of input box
		textNumber1.setColumns(10);
		textNumber2.setColumns(10);
		textNumber3.setColumns(10);
		textNumber4.setColumns(10);
		
		JButton btnSend = new JButton("Send Air Quality index to Server");

		JButton btnSend2 = new JButton("Send pollutant and concentration level to Server");

		JButton btnSend3 = new JButton("Send the distance travelled to the server");
		
		JButton btnSend4 = new JButton("Send the distance travelled ");
		
		
		// add action listener to button
		btnSend.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {

				// retrieve data from gui
				int num1 = Integer.parseInt(textNumber1.getText());

				// String name2 = textName2.getText();

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
			public void actionPerformed(ActionEvent e) {
				
				
				

				


			}
		}

		);
		
		btnSend3.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {

				int num2 = Integer.parseInt(textNumber3.getText());

				railMessage request = railMessage.newBuilder().setDistanceRail(num2).build();

				Iterator<railResponse> responses = blockingStub1.railPollution(request);

				while (responses.hasNext()) {

					railResponse response = responses.next();
					
					textResponse3.append(response.getMessage()+"\n");

				}

			}
		}

		);
		
		btnSend4.addActionListener(new ActionListener() {

			// action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {

				int number1 = Integer.parseInt(textNumber4.getText());	
				
			carMessage request = carMessage.newBuilder().setNumber(number1).build();
			
		StreamObserver<carResponse> responseObserver = new StreamObserver<carResponse>(){

				@Override
				public void onNext(carResponse value) {
			
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub	
				}
		};
		
		StreamObserver<carMessage> requestObserver = asyncStub2.carPollution(responseObserver);
		
		//requestObserver.onNext(request.newBuilder().setNumber(number1).build());
		
		requestObserver.onCompleted();
		
		//carResponse response = asyncStub2.carPollution(responseObserver);

		textResponse4.append(responseObserver.g

			}}
			);

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
