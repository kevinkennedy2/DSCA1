package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import grpc.DSCA1.*;
import grpc.DSCA1.airQualityServiceGrpc.airQualityServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GUI {
	
		//instancee variables - been used in different methods
		private airQualityServiceBlockingStub blockingStub;
		
		private JFrame frame;
		private JTextField textName1;
		private JTextField textName2;
		private JTextArea textResponse;
		
	// Standard method for launching JFrame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			
			public void run(){
				try {
					//create new GUI application object - create instance of class
					GUI window = new GUI();
					window.frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
}
 //The application
	
	public GUI() {
		
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		blockingStub = airQualityServiceGrpc.newBlockingStub(channel);
		//Combine the code from JFrame and GRPC - two frameworks
		initialize();
	}
	
	private void initialize() {
		//build up GUI
		frame = new JFrame();
		//Title
		frame.setTitle("Client - Service Controller");
		//Set Bounds
		frame.setBounds(100, 100, 500, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Box layout determines how components are lais out in panel
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		
		//flow layout
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));
		
		//create new label and add it to the panel
		JLabel lblNewLabel_1 = new JLabel(" Name 1 ");
		panel_service_1.add(lblNewLabel_1);
		
		//Input textox
		textName1 = new JTextField();
		panel_service_1.add(textName1);
		
		//width of input box
		textName1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" Name 2 ");
		panel_service_1.add(lblNewLabel_2);
		
		JButton btnSend = new JButton("Send our message to Server");
		
		//add action listener to button
		btnSend.addActionListener(new ActionListener(){
			
			//action for action method - will happen when button clicked
			public void actionPerformed(ActionEvent e) {
				
				//retrieve data from gui
			//	String name1 = textName1.getText();
			//	String name2 = textName2.getText();
				
				//Grpc code
				IndexRankNumber iRNumber = IndexRankNumber.newBuilder().setIndex(200).build();
				IndexRankRating response = blockingStub.getAirQualityIndex(iRNumber);
				//print out response
				System.out.println(response);
				//add response into GUI
				textResponse.append("reply: "+response);
			}
		});
		panel_service_1.add(btnSend);
		
		textResponse = new JTextArea (3, 10);
		textResponse .setLineWrap(true);
		textResponse .setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(scrollPane);
		
	}
}