import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class FinalProject extends JFrame implements ItemListener  {
	//name
	JLabel namelbl = new JLabel("Name :");
	JTextField nametxt = new JTextField(10);
	
	//age
	JLabel agelbl = new JLabel("Age  : ");
	JTextField agetxt = new JTextField(10);
	//radiobutton
	JLabel nationalitylbl = new JLabel("Nationality :");
	JRadioButton rbMalaysian = new JRadioButton("Malaysian");
	JRadioButton rbNMalaysian = new JRadioButton("Non-Malaysian");
	//JRadioButton group
	ButtonGroup button_group = new ButtonGroup();
	ButtonGroup button_group_rate = new ButtonGroup();
	//rate
	JLabel tatelbl = new JLabel("Rate :");
	JRadioButton rb_3 = new JRadioButton("3%");
	JRadioButton rb_6 = new JRadioButton("6%");
	JRadioButton rb_9 = new JRadioButton("9%");
	//house add
	JLabel houseaddlbl = new JLabel("House Address :");
	JTextArea houseaddtxt = new JTextArea(2,10);
	//house price
	JLabel housepricelbl = new JLabel("House Price :");
	JTextField housepricetxt = new JTextField(10);
	//downpayment
	JLabel downpaynentlbl = new JLabel("DownPayment :");
	JTextField downpaynenttxt = new JTextField(10);
	//loanduration
	JLabel loandurationlbl = new JLabel("Loan Duration :");
	String years[] = {"6 years","5 years","4 years"};
	JComboBox combobox = new JComboBox(years);	
	//JButton
	JButton btnclac = new JButton("Calculate");
	JButton btnclear = new JButton("Clear");
	//monthly payment
	JLabel paymentlbl = new JLabel("Monthly Payment :");
	JTextField paymenttxt = new JTextField(10);
	
	String strname;
	double num1,Radio_Btn_nationality,Radio_Btn_rate;
	double house_price = 0.000;
	double downpayment_amount;
	double answer ;
	int List_Btn_num;
	public FinalProject(){
		Frame test = new Frame("HOME LOAN CALCULATOR");
		test.setSize(300,600);
		test.setVisible(true);
		
		button_group.add(rbMalaysian);
		button_group.add(rbNMalaysian);
		
		button_group_rate.add(rb_3);
		button_group_rate.add(rb_6);
		button_group_rate.add(rb_9);
		
		JPanel p = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = new Insets(0,0,0,0);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(0,0,0,0);
		//name
		c.gridx = 0;
		c.gridy = 1;
		p.add(namelbl,c);
		c.gridx = 1;
		c.gridy = 1;
		p.add(nametxt,c);
		nametxt.setToolTipText("Enter your Name here");  
		//age
		c.gridx = 0;
		c.gridy = 2;
		p.add(agelbl,c);
		c.gridx = 1;
		c.gridy = 2;
		p.add(agetxt,c);
		agetxt.setToolTipText("Enter your age here");  
		//radiobutton
		c.gridx = 0;
		c.gridy = 3;
		p.add(nationalitylbl,c);
		c1.gridx = 1;
		c1.gridy = 3;
		p.add(rbMalaysian,c1);
		c1.gridx = 1;
		c1.gridy= 4;
		p.add(rbNMalaysian,c1);
		//rate
		c.gridx = 0;
		c.gridy= 5;
		p.add(tatelbl,c);
		c2.gridx= 1;
		c2.gridy= 5;
		p.add(rb_3,c2);
		c2.gridx = 1;
		c2.gridy= 6;
		p.add(rb_6,c2);
		c2.gridx = 1;
		c2.gridy= 7;
		p.add(rb_9,c2);
		//house add
		c.gridx = 0;
		c.gridy= 8;
		p.add(houseaddlbl,c);
		c.gridx = 1;
		c.gridy= 8;
		houseaddtxt.setToolTipText("Enter your house address here"); 
		p.add(houseaddtxt,c);
		//houseprice
		c.gridx = 0;
		c.gridy= 9;
		p.add(housepricelbl,c);
		c.gridx = 1;
		c.gridy= 9;
		housepricetxt.setToolTipText("Enter your house value here");
		p.add(housepricetxt,c);
		//downpayment
		c.gridx = 0;
		c.gridy= 10;
		p.add(downpaynentlbl,c);
		c.gridx = 1;
		c.gridy= 10;
		downpaynenttxt.setToolTipText("Enter your house downpayment here");
		p.add(downpaynenttxt,c);	
		//loanduration
		c.gridx = 0;
		c.gridy= 11;
		p.add(loandurationlbl,c);
		c.gridx = 1;
		c.gridy= 11;
		p.add(combobox,c);
		//btnclac
		c.gridx = 0;
		c.gridy= 12;
		p.add(btnclac,c);
		//btnclear
		c.gridx = 1;
		c.gridy= 12;
		p.add(btnclear,c);
		//monthly payment
		c.gridx = 0;
		c.gridy= 13;
		p.add(paymentlbl,c);
		c.gridx = 1;
		c.gridy= 13;
		p.add(paymenttxt,c);
		test.add(p);
		
		//itemlistener(nationalty)
		rbMalaysian.addItemListener(this);
		rbNMalaysian.addItemListener(this);
		//itemlistener(rate)
		rb_3.addItemListener(this);
		rb_6.addItemListener(this);
		rb_9.addItemListener(this);
		
		test.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		
		combobox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	int selectedIndex = combobox.getSelectedIndex();
            	if(selectedIndex==0)
            		List_Btn_num=6;
            	if(selectedIndex==1)
            		List_Btn_num=5;
            	if(selectedIndex==2)
            		List_Btn_num=4;
            	
            }
        });
		
		nametxt.addActionListener(new ActionListener()  {
	            public void actionPerformed(ActionEvent e)   {
	            	if(e.getSource()==nametxt)
	            		strname = nametxt.getText();
	            	agetxt.requestFocus();
	            }
	        });
		
		agetxt.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e)   {
            	if(e.getSource()==agetxt)
            		num1=Double.parseDouble(agetxt.getText());
            			if(num1<21){
            				JOptionPane.showMessageDialog(null,"You are underage to buy property");
            			}
            	agetxt.requestFocus();
            }
        });
		
		housepricetxt.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e)   {
            	if(e.getSource()==housepricetxt)
            		house_price=Double.parseDouble(housepricetxt.getText());
            
            	downpaynenttxt.requestFocus();
            }
        });
		
		downpaynenttxt.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e)   {
            	if(e.getSource()==downpaynenttxt)
            		downpayment_amount=Double.parseDouble(downpaynenttxt.getText());

            }
        });
		
		//Radiobutton
		   rbMalaysian.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	Radio_Btn_nationality =0;
	            	
	            	
	            }
	        });
	        
	        rbNMalaysian.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	Radio_Btn_nationality =0.0025;
	            	
	            	
	            }
	        }); 
		
	      //clear button1
	        btnclear.addMouseListener(new MouseListener()  {
	                    public void mouseClicked(MouseEvent event)   {
	                    	nametxt.setText(null);
	           				agetxt.setText(null);
	           				houseaddtxt.setText(null);
	           				housepricetxt.setText(null);
	           				downpaynenttxt.setText(null);
	           				paymenttxt.setText(null);
	           				button_group.clearSelection();
	           				button_group_rate.clearSelection();
	           				btnclear.setBackground(Color.RED);	
	                    }
	                    public void mousePressed(MouseEvent event){
	            			btnclear.setBackground(Color.YELLOW);
	            		}
	            		public void mouseReleased(MouseEvent event){
	            			btnclear.setBackground(Color.BLUE);
	            		}
	            		public void mouseEntered(MouseEvent event){
	            			btnclear.setBackground(Color.MAGENTA);
	            		}
	            		public void mouseExited(MouseEvent event){
	            			btnclear.setBackground(Color.GREEN);
	            		}
	                });
		
    	//clac button
        btnclac.addMouseListener(new MouseListener()  {
                    public void mouseClicked(MouseEvent event)   {
                    	//formula
                    	
                    	answer  = (Radio_Btn_rate)*(house_price-downpayment_amount);
                    	double num4=(answer)*(List_Btn_num);
                    	 double num5 = (num4+(house_price-downpayment_amount));
                    	 double num6 = (num5)/(List_Btn_num*12);
                    	 
                    	 double num7 = (house_price)*Radio_Btn_nationality;
                    	 double num8 =num7+num6;
                    	 paymenttxt.setText(String.valueOf("RM "+num8));
                    	
                    	btnclac.setBackground(Color.RED);
                    	
                    }
                    public void mousePressed(MouseEvent event){
                    	btnclac.setBackground(Color.yellow);
            		}
            		public void mouseReleased(MouseEvent event){
            			btnclac.setBackground(Color.BLUE);
            		}
            		public void mouseEntered(MouseEvent event){
            			btnclac.setBackground(Color.MAGENTA);
            		}
            		public void mouseExited(MouseEvent event){
            			btnclac.setBackground(Color.GREEN);
            		}
                });
 
	}

	
	 //radiobutton
	public void itemStateChanged(ItemEvent e){
		if(rb_3.isSelected())
			Radio_Btn_rate=0.03;
		if(rb_6.isSelected())
			Radio_Btn_rate=0.06;
		if(rb_9.isSelected())
			Radio_Btn_rate=0.09;

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalProject test = new FinalProject();
	}

}