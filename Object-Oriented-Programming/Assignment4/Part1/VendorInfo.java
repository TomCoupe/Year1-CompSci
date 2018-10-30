import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
//extending the JFrame and implimenting the ActionListener
public class VendorInfo extends JFrame implements ActionListener {
	//creating an object in the class so i can call it in other classes
	Vending f;
	//creating a JLabel for total sales
	JLabel totSales = new JLabel("Total Sales = \u00a3"+String.format("%.2f", f.sales, JLabel.CENTER));
	//creating a JButton to reset stock values
	JButton stockReset = new JButton("Reset stock");
	//calling the Vending in the parameters so that its reffering to my main frame.
	public VendorInfo(Vending f) {
		super("Vendor information"); //calling the super
		this.f = f;
		//adding panels with GridBagLayout
		JPanel northp = new JPanel(new GridBagLayout());
		JPanel southp = new JPanel(new GridBagLayout());
		//size of frame
		setSize(250, 150);
		setResizable(false); //user cannot change size of window
		//adding the JLabel to the top panel and the button to the bottom panel
		northp.add(totSales);
		southp.add(stockReset);
		//setting visible to true
		setVisible(true);
		stockReset.addActionListener(this); //calling the action listener
		//choosing the positions of the panels
		add(northp, BorderLayout.NORTH);
		add(southp, BorderLayout.SOUTH);
		pack(); 
	}
	//acion listener method
	public void actionPerformed(ActionEvent e) {
		/*if reset stock button is pressed it will iterate through the whole
		of the sweetslist array and will update the JLabels underneath each button
		with the new stock value. it will also reset the total sales value back to
		£0.00 when the reset stock button is pressed. also setting the colours back to orginial colour*/
		if (e.getSource() == stockReset) {
			for (int i = 0; i < f.sweetslist.length; i++) {
				f.sweetslist[i].setStock(4);
				f.labels[i].setText(f.sweetslist[i].getStock()+" left");
				f.sales = 0.00;
				if(i == 0 || i == 1 || i == 2) {
                	f.buttons[i].setBackground(new Color(150, 250, 75));
                }
                if(i == 3 || i == 4|| i == 5) {
                	f.buttons[i].setBackground(new Color(255, 255, 100));
                }
                if(i == 6 || i == 7|| i == 8) {
                	f.buttons[i].setBackground(new Color(200, 150, 100));
                }
				totSales.setText("Total Sales = \u00a3"+String.format("%.2f", f.sales));
			}
		}
	}
}