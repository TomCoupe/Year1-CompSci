import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
//extending the JFrame and implimenting the ActionListener
public class Vending extends JFrame implements ActionListener{
	JPanel panels = new JPanel(new GridBagLayout()); //creating my GridBagLayout panel
	//creating a list of JButtons, Jlabels and also a Sweets list.
	JButton[] buttons = new JButton[9];
    public JLabel[] labels = new JLabel[9]; 
	public static Sweets[] sweetslist = new Sweets[9];
	//creating anoher GridBagLayout panel for my vendor information button at the bottom of the frame.
	JPanel bottomPanel = new JPanel(new GridBagLayout());
	JButton vendorI = new JButton("Vendor Info"); //vendor information button
    GridBagConstraints c = new GridBagConstraints(); //declaring the GridBagConstraints
	GridBagConstraints cSouth = new GridBagConstraints();
	public static double sales = 0.00;

	public static void main(String[] args) {
		new Vending(); //creating the instance of Vending()
	}

	public Vending() {
        super("TwistyJigglyBomb suprises");
        setSize(800,400);
        setResizable(false);
        /*Declaring characteristics of the sweets by using the Sweets(name, price, stock) method 
        from my Sweets class.*/
		sweetslist[0] = new Sweets("Chocolate Jigglypuffs", 1.30, 4);
		sweetslist[1] = new Sweets("Caramel Jigglypuffs", 1.30, 4);
		sweetslist[2] = new Sweets("French Vanilla Jigglypuffs", 1.30, 4);
		sweetslist[3] = new Sweets("Chocolate Bombs", 1.00, 4);
		sweetslist[4] = new Sweets("Caramel Bombs", 1.00, 4);
		sweetslist[5] = new Sweets("French Vanilla Bombs", 1.00, 4);
		sweetslist[6] = new Sweets("Chocolate Twists", 0.80, 4);
		sweetslist[7] = new Sweets("Caramel Twists", 0.80, 4);
		sweetslist[8] = new Sweets("French Vanilla Twists", 0.80, 4);
		
		int i = 0; //counter
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                c.insets = new Insets(0, 4, 0, 4); //setting the insets for the components on the GridBagLayout
                //creating 9 JButtons
                buttons[i] = new JButton(sweetslist[i].getName()+" ( \u00a3"+String.format("%.2f", sweetslist[i].getPrice())+")");
                /*additional coding, changing the button colours based upon the type of sweet being sold*/
                if(i == 0 || i == 1 || i == 2) {
                	buttons[i].setBackground(new Color(150, 250, 75));
                }
                if(i == 3 || i == 4|| i == 5) {
                	buttons[i].setBackground(new Color(255, 255, 100));
                }
                if(i == 6 || i == 7|| i == 8) {
                	buttons[i].setBackground(new Color(200, 150, 100));
                }
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = row;  //positioning each JButton
                c.gridy = col * 2;
				buttons[i].setPreferredSize(new Dimension(250, 43)); //size of buttons
				buttons[i].addActionListener(this); //calling action listener
                panels.add(buttons[i], c); //adding buttons to the panel

                //creating 9 JLabels
                labels[i] = new JLabel(sweetslist[i].getStock()+" left", JLabel.CENTER);   
                c.gridx = row;//positioning the JLabels under each JButton by adding 1 to the col value.
                c.gridy = col * 2 + 1;
                c.insets = new Insets(0, 0, 2, 0); //insets of JLabels
          
                panels.add(labels[i], c); //adding labels to the panel 
				
				i++; //increase counter by 1
            }
        }
		cSouth.insets = new Insets(0, 5, 0, 0); //setting insets of the new GridBagLayout
		bottomPanel.add(vendorI, cSouth);
		vendorI.setBackground(new Color(100, 150, 250));
		vendorI.addActionListener(this); //calling action listener
		//positioning the elements in the GridBagLayout
		cSouth.fill = GridBagConstraints.HORIZONTAL;
		cSouth.gridx = 3;
		cSouth.gridy = 1;
		cSouth.anchor = GridBagConstraints.EAST;
        add(panels, BorderLayout.NORTH); //adding panels to the frame.
		add(bottomPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); //setting the application to visible
    }
	
	public void actionPerformed(ActionEvent e) { //Action listener method that decides what happens when the buttons are pressed.
		for (int i = 0; i < sweetslist.length; i++) { //iterates the length of the sweetslist
			if (e.getActionCommand().equals(sweetslist[i].getName()+" ( \u00a3"+String.format("%.2f", sweetslist[i].getPrice())+")")) {			
				if (sweetslist[i].getStock() <= 0) { // if the item has no stock alert to the user
					buttons[i].setBackground(new Color(255, 70, 70));
					JOptionPane.showMessageDialog(null,"Oops, there are none left!");
				}
				else
				{
					//decreasing the stock value, then updating the JLabels with the new stock
					//also counting up the sales.
					sweetslist[i].newStock();
					labels[i].setText(sweetslist[i].getStock()+" left");
					sales = sales + sweetslist[i].getPrice();
					repaint();					
				}
			}
			//if vendor information button is pressed it calls the VendorInfo class
			if (e.getSource() == vendorI) {
				VendorInfo VI = new VendorInfo(this);
				break;
			}
		}			
	}
}