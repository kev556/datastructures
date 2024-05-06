/***********************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.*;

/**
* <b>Title:</b> Project 1<br>
* <b>Filename:</b> Sudoku.java<br>
* <b>Date Written:</b> October 6, 2023<br>
* <b>Due Date:</b> October 6, 2023<br>
* <p>
* <b>Description:</b><br>
* Created methods fillGrid and evaluate, to fill a Sudoku grid given a text file from a URL,
* 	and to evaluate whether the grid represents a Sudoku.
* </p>
* <br>
* Fills the Sudoku grid with numbers from a random file contained in a URL, 
  Sudoku.txt and Sudoku1 - 11.txt.
  <br>
* <p>
* A grid represents a Sudoku if all three conditions are met:
* 
* 		Each row of the 9 x 9 grid must contain each of digits from 1 to 9.
* 		Each column of the 9 x 9 grid must contain each of digits from 1 to 9
* 		Each of the nine 3 x 3 sub-boxes of the 9 x 9 grid must contain each of digits from 1 to 9.
* </p>
* 
*@author Kevin Li
*/

/***********************************************************************/
public class Sudoku extends JFrame implements ActionListener  {
	
	private JButton[][] gridButton = new JButton[9][9];		// buttons that make up the Sudoku grid
	private JButton[] numberButton = new JButton[11];		// numbers and other command buttons
	
	int number = 1;
	
	// background colors of the grid
	public static final Color BEIGE = new Color(0xF5F5DC);
	public static final Color GAINSBORO = new Color(0xDCDCDC); 
	
	// menu bar and menu options
	private MenuBar menuBar = new MenuBar();
	private Menu menuFile = new Menu("File");
	private Menu menuHelp = new Menu("Help");
	private MenuItem menuNew = new MenuItem("New Puzzle");
	private MenuItem menuFill = new MenuItem("Fill Grid");
	private MenuItem menuFileExit = new MenuItem("Exit");     
    
	private MenuItem menuAbout = new MenuItem("About");
	private MenuItem menuSudokuHelp = new MenuItem("Sudoku Help");
    
    /**
     * Sudoku constructor
     */
     public Sudoku()  {
        // Add action listener for the new menu option
        menuNew.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
					resetGrid();			
                }	            
            }
        );

     // Add action listener for the fill grid option
        menuFill.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
					fillGrid();			
                }	            
            }
        );
        
        // Add action listener for the about menu option
        menuAbout.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                	ImageIcon icon = new ImageIcon("logo.jpg");
                	String message = "Sudoku version 0.99\nCopyright \u00A9 2006\nFranklin Graham";
                	JOptionPane.showMessageDialog(null,message,"Sudoku",JOptionPane.INFORMATION_MESSAGE,icon);
                }
            }
     	);
        
     	// Add action listener for the help menu option
        menuSudokuHelp.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	ImageIcon icon = new ImageIcon("sudoku.jpg");
                	String message = "Complete the grid so that every row, column" +
                		"\nand 3x3 box contains every digit from 1 to 9 inclusive." +
                		"\n\nClick the button, at the bottom of the window, with the"+
                		"\nnumber you wish to enter, then click the button in the grid."+
                		"\n\nClick the pen to evaluate, and the pencil does nothing.";
                	JOptionPane.showMessageDialog(null,message,"Sudoku Help",JOptionPane.INFORMATION_MESSAGE,icon);
                }
            }
     	);     
        
        // Add action listener for the exit menu option
        menuFileExit.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Sudoku.this.windowClosed();
                }
            }
        );
        
        // add new, fill, and exit to the file menu
        menuFile.add(menuNew);
        menuFile.add(menuFill);
        menuFile.addSeparator();       
        menuFile.add(menuFileExit);
        
        // add about and help to the help menu
        menuHelp.add(menuAbout);
        menuHelp.add(menuSudokuHelp);
        
        // add menu options to menu bar
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        
		// add the menubar to the frame
		setMenuBar(menuBar);
		
        // create a panel with a grid layout  for the grid
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(9,9));

		for(int i=0;i<9;i++) {
			gridButton[i] = new JButton[9];
			for(int j=0;j<9;j++) {
				gridButton[i][j] = new JButton();
				//gridButton[i][j].setSize(51,42);
				gridButton[i][j].setFont(new Font("Courier New",Font.BOLD,16));
	   			gridButton[i][j].setForeground(Color.blue);
	   			gridButton[i][j].setText("");		   			
	   			gridButton[i][j].setFocusable(false);		   			
	   			gridButton[i][j].addActionListener(this);
	   			gridButton[i][j].setBackground(GAINSBORO);
				switch(i)
				{
					case 0:
					case 1:
					case 2:
					case 6:
					case 7:
					case 8:if(j<3 || j>5)
							gridButton[i][j].setBackground(BEIGE);
							break;
					case 3:
					case 4:
					case 5:if(j>2 && j<6)
							gridButton[i][j].setBackground(BEIGE);
				}
				// add buttons to the panel
				panel1.add(gridButton[i][j]); 
			}
		}
		
		// create another panel with a grid layout for the numbers 
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,11));	
		
		for(int i=0;i<11;i++) {
			if(i < 9) {		
				numberButton[i] = new JButton(""+(i+1));
				numberButton[i].setBackground(Color.blue);
				
			}
			else {
				numberButton[i] = new JButton(new ImageIcon(i+".jpg"));
				numberButton[i].setBackground(Color.white);
			}
			numberButton[i].addActionListener(this);
   			numberButton[i].setForeground(Color.white);
   			numberButton[i].setFocusable(false);
			panel2.add(numberButton[i]);
		}
		
		// set default number to 1 by giving that button the focus
		numberButton[0].requestFocus();
		
		// set the frame's layout to a Border Layout and add the panels
        setLayout(new BorderLayout());
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
        // Add a window listener to the frame
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Sudoku.this.windowClosed();
                }
            }
        );        
    }
	/***********************************************************************/
    public void resetGrid()    {
		for(int i=0;i<9;i++)
		   	for(int j=0;j<9;j++)
		   	{
		   		gridButton[i][j].removeActionListener(this);
	   			gridButton[i][j].setForeground(Color.red);
	   			gridButton[i][j].setText("");		   			
	   			gridButton[i][j].setFocusable(false);		   			
	   			gridButton[i][j].addActionListener(this);
		   	}	
    }    
	
    /**
     * 	Fills the Sudoku grid with numbers from a random file contained in a URL, 
     * 	Sudoku.txt and Sudoku1 - 11.txt.
     */
    public void fillGrid()    {
		Scanner scan;
		URL url;
		BufferedReader in = null;
		try {
			//selects a random number from 0 to 11, 
			int rand = (int)Math.floor((Math.random() * 12));
			
			/** 
			 *	Sudoku.txt exists but does not have a number. If rand becomes 0, 
			 * 	Sudoku.txt will be selected, preventing a MalformedURLException.
			 * 
			 * 	Based on the random number selected by Math.floor(Math.random() * 12), 
			 * 	A Sudoku(rand).txt will be selected to populate the grid.
			 */
			if (rand == 0) {
				url = new URL("https://matcmp.ncc.edu/grahamf/csc130/Sudoku.txt");
			}
			else {
				url = new URL("https://matcmp.ncc.edu/grahamf/csc130/Sudoku" + rand + ".txt");
			}
			// opens the stream and allows the program to process input through a text file.
			scan = new Scanner(url.openStream());
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// creates a string array large enough to fit a row of numbers in a sudoku text file
			String[] strArr = new String[9];
			
			/**
			 *  since a string with 9 characters is fed from the file at a time, 2 loops are created,
			 *  one to split each String filled with 9 numbers fed into the program into an array of Strings, and the other to 
			 *  fill in every row of the Sudoku grid with said 9 numbers within said String array.
			 */
			for (int r = 0; r < gridButton.length; r++) {
				strArr = in.readLine().split(" ");
				
				for (int c = 0; c < strArr.length; c++) {
					
					gridButton[r][c].setText(strArr[c]);
				}
			}
			
		/**
		 * 	handles exceptions that may arise from the input sequence.
		 */
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				// closes the input stream.
				in.close(); 
			} 
			catch (IOException e) {
				System.out.println("Problem closing the stream");
			}
		}
    }        
    /***********************************************************************/
    public void actionPerformed(ActionEvent e)  {
    	boolean commandButtonClicked = false;    	
    	
		// check to see if user pressed 1 of the buttons - 1 thru 9
    	for(int i=0; i < 11 && !commandButtonClicked; i++) 	{
    		if(((JButton)e.getSource()) == numberButton[i])	{
    			commandButtonClicked = true;
    			
    			// if a number was pressed, convert the text to a number
    			//    and store it in the variable 'number'
    			if(i < 9) {
	    			number = Integer.parseInt(((JButton)e.getSource()).getText());	    			
    			}
    			else if(i == 9) {    				
    				if(evaluate())
    					JOptionPane.showMessageDialog(this, "Sudoku");
    				else
    					JOptionPane.showMessageDialog(this,"Not Sudoku");
    			}
    			else if(i == 10)
    				JOptionPane.showMessageDialog(this, "CSC130 - Program #1\nWritten by Kevin Li");
    		}
		}
    	
		// check to see if user pressed 1 of the buttons in the grid
    	// otherwise erase it
		if(!commandButtonClicked )	{
			JButton temp = (JButton)e.getSource();
			
			// replace the text of the grid button with the number clicked
			if(!String.valueOf(number).equals(temp.getText()))	{				
	    		temp.setText("" + number);
	    	}
	    	else 
	    		temp.setText("");
		}		
    }
    
	/**
	 * 	Checks to see if the grid represents a Sudoku
	 * 	A grid represents a Sudoku if all three conditions are met:
	 * 
	 * 	Each row of the 9 x 9 grid must contain each of digits from 1 to 9.
	 * 	Each column of the 9 x 9 grid must contain each of digits from 1 to 9
	 * 	Each of the nine 3 x 3 sub-boxes of the 9 x 9 grid must contain each of digits from 1 to 9.
	 * 
	 * @return True or False, depending on whether the grid represents a valid Sudoku solution
	 */
	public boolean evaluate() {
		
		/**
		 * 	Evaluates the following: Each row of the 9 x 9 grid must contain each of digits from 1 to 9.
		 * 	Returns false if not.
		 * 	Loops through every index of the 2d array adding up values of each row
		 */
		int arrSum = 0;
		for (int r = 0; r < gridButton.length; r++) {
			for (int c = 0; c < gridButton[0].length; c++) {
				
				// using [r][c] will add up the 2s raised to the powers of each number in a row
				arrSum += Math.pow(2, Integer.parseInt(gridButton[r][c].getText()));
			}
			/**
			 *  The sum of 2^1 + 2^2 ... + 2^9 is 1022. Being divisible by 1022 means the first and subsequent 
			 *  rows contain the numbers 1-9 inclusive . If at any point arrSum % 1022 is not 0, that means the previous
			 *  sum of each row added to arrSum is not 1022, and the row does not contain 1-9 inclusive, violating the condition,
			 *  and returning false.
			 */
			if (arrSum % 1022 != 0) {
				return false;
			}
		}
		
		/**
		 * 	Evaluates the following: Each column of the 9 x 9 grid must contain each of digits from 1 to 9.
		 * 	Returns false if not.
		 * 	Loops through every index of the 2d array adding up values of each column
		 */
		arrSum = 0;
		for (int r = 0; r < gridButton.length; r++) {
			for (int c = 0; c < gridButton[0].length; c++) {
				
				// changing r and c adds up the 2s raised to the power of each number in each column instead of row
				arrSum += Math.pow(2, Integer.parseInt(gridButton[c][r].getText()));
			}
			if (arrSum % 1022 != 0) {
				return false;
			}
		}
		/**
		 * 	Evaluates the following: Each of the nine 3 x 3 sub-boxes of the 9 x 9 grid contains each of digits from 1 to 9.
		 * 	Returns false if not.
		 * 	Loops through every 3x3 box within the 9x9 grid counting up every value 
		 * 	in the box to ensure all numbers from 1 to 9 are present.
		 * 
		 *  adding 3 within the loop for i and j moves to the next 3x3 grid locations.
		 *  setting r and c to i and j respectively sets the initial coordinates. The end points for r and c are 
		 *  i + 2 and j + 2 respectively, as this makes 3 rows and 3 columns, to count up every value in a 3x3 box.
		 */
		for (int i = 0; i + 3 < gridButton.length; i += 3) {
			for (int j = 0; j + 3 < gridButton[0].length; j += 3) {
				arrSum = 0;
				for (int r = i; r < i + 3; r++) {
					for (int c = j; c < j + 3; c++) {
						
						arrSum += Math.pow(2, Integer.parseInt(gridButton[r][c].getText()));
					}
				}
				if (arrSum % 1022 != 0) {
					return false;
				}
			}
		}
		
		// Returns true after passing all other conditions 
		return true;
		
	}
	/***********************************************************************
     *  Close window and exit application
     ***********************************************************************/
    protected void windowClosed() {        
        System.exit(0);
    }
    /***********************************************************************
     main menu and start of program
     ***********************************************************************/
    public static void main(String[] args) {        
        Sudoku frame = new Sudoku();  			// Create application frame.
        frame.setTitle("Sudoku v0.99"); 		// add title to the frame       
        frame.setSize(new Dimension(470, 480));	// set the size of the frame        
        frame.setResizable(false);				// frame's size is fixed        
        frame.setVisible(true);					// Show frame        
    }
}
