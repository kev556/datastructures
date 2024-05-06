package csc130.KevinLi.project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import java.util.StringTokenizer;

/**
* <b>Title:</b> Project 2:<br>
* <b>Filename:</b> CalculatorFrame.java<br>
* <b>Date Written:</b> October 27, 2023<br>
* <b>Due Date:</b> October 31, 2023<br>
* <p>
* <b>Description:</b><br>
* Convert infix expression input through GUI to postfix expression, then calculate the result by evaluating
* postfix expression, utilizing the first-in-last-out characteristic of Stacks.
* </p>
* <p>
* </p>
* <p><b></b></p>
* <p>
*</p>
*@author Kevin Li
*/

@SuppressWarnings("serial")
class CalculatorFrame extends JFrame implements ActionListener  {
	JTextField jtfInfix = new JTextField(21); // for infix 
	JTextField jtfPostfix = new JTextField();  // for postfix
	JTextField result = new JTextField("0");   // for result
	
	JButton[][] calcButton = new JButton[4][5];
	
	JPanel calcPanel = new JPanel();	
	JPanel topPanel = new JPanel();    

	
	public CalculatorFrame(){
		String[][] buttonText = 
				new String[][]{{"7","8","9","\u00F7","C"},{"4","5","6","\u2217","B"},
				{"1","2","3","-","R"},{"0","(",")","+","="}};
				
		this.setTitle("CSC130 Calculator");
		this.setLayout(new BorderLayout(2,1));

		jtfInfix.setHorizontalAlignment(JTextField.RIGHT);
		jtfPostfix.setHorizontalAlignment(JTextField.RIGHT);
		result.setHorizontalAlignment(JTextField.RIGHT);
		jtfPostfix.setEnabled(false);
		result.setEnabled(false);
		//jtfInfix.setEditable(false); // hide text caret
		
		// set the font size to 34 for the text fields
		Font textFieldFont=new Font(jtfPostfix.getFont().getName(),jtfPostfix.getFont().getStyle(),24);
		jtfInfix.setFont(textFieldFont);
		jtfPostfix.setFont(textFieldFont);
		result.setFont(textFieldFont);
		
		topPanel.setLayout(new GridLayout(3,1));				
		topPanel.add(jtfInfix);		
		topPanel.add(jtfPostfix);
		topPanel.add(result);
		
		calcPanel.setLayout(new GridLayout(4,5,3,3));
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				calcButton[i][j]= new JButton("" + buttonText[i][j]);
				calcButton[i][j].setForeground(Color.blue);
				calcButton[i][j].setFont(new Font("sansserif",Font.BOLD,42));
				calcButton[i][j].addActionListener(this);
				calcButton[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				calcPanel.add(calcButton[i][j]);
			}
		}
		this.add(topPanel,BorderLayout.NORTH);
		this.add(calcPanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {				
				if(e.getSource() == calcButton[i][j]){
					// clear
					if(i==0 && j == 4){
						jtfInfix.setText(null);
						jtfPostfix.setText(null);
						result.setText("0");
					}
					// backspace
					else if(i==1 && j == 4){
						if(jtfInfix.getDocument().getLength()>0)
							try {
								jtfInfix.setText(jtfInfix.getText(0, jtfInfix.getDocument().getLength()-1));
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						
					}
					// number or operator
					else if(j<4){
						jtfInfix.setText(jtfInfix.getText()
							+ calcButton[i][j].getText());
						}
					// = button pressed
					else if(i==3&&j==4){
						// erase contents of the postfix textfield
						jtfPostfix.setText(null);  
						// update the postfix textfield with the String returned
							jtfPostfix.setText(infixToPostfix());
						// update the result textfield with the result of the computation
						result.setText("" + calculate());
					}
				}
			}
		}
    }
	/**
	 * Convert an infix, or mathematical expression, to a postfix expression utilizing the first in last out 
	 * nature of the Stack Abstract Data Type. 
	 * 
	 * @return	The equivalent postfix expression to the infix entered by the user.
	 */
	public String infixToPostfix() {
		
		String postfix = "";
		/* Creates a StringTokenizere object, allowing us to obtain String values one at a time.
		 * Tokens are delimited by operators, including +, -, the unicode expressions for * and the division sign,
		 * parentheses, and spaces.
		 */
		StringTokenizer strToken = new StringTokenizer(jtfInfix.getText(), "+-\u00F7\u2217/() ", true);
		String token;
		
		Stack<String> stack = new ArrayStack<String>();
		
		try {
			// Obtains the next token
			while (strToken.hasMoreTokens()) {
				token = strToken.nextToken();
				/*	Attempts to convert the token to an Integer, and immediately append it to the postfix expression.
				 *  If NumberFormatException is thrown, then the token is not an operand, and the program continues to evaluate operators.
				 */
				try {
					postfix += Integer.parseInt(token) + " ";
				}
				catch (NumberFormatException nfe) {
					// If token is a left bracket, immediately pushes token into the stack.
					if (token.equals("("))
						stack.push(token);
					/* If token is a right bracket, all values within the stack are popped and added to  
					 * the postfix expression until a left bracket is encountered. When it is encountered, pops the left bracket.
					 * If a left bracket is not encountered, the stack will be emptied, and the expression will be invalid since there was no
					 * matching bracket found.
					 */
					else if (token.equals(")")) {
						while (!stack.isEmpty() && !stack.peek().equals("("))
							postfix += stack.pop() + " ";;
						if (stack.isEmpty())
							return "Invalid Expression";
						stack.pop();
					}
					/*	All remaining operators are arithmetic operators, +,-,*, and /. When one of these operators is encountered, 
					 * 	the top value of the stack will be compared to the current operator. 
					 * 	
					 * 	The operator in the stack will be popped and added to the postfix expression if 
					 * 	it has more or equal precedence, until the stack is emptied or if the stack operator no longer has precedence.
					 * 
					 * 	Afterwards/otherwise, the current operator stored in token is added to the stack.
					 */
					else {
						while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token))
							postfix += stack.pop() + " ";;
						stack.push(token);
					}
				}
			}
			// After there are no more tokens, all values within the stack are popped and added to the postfix expression.
			while (!stack.isEmpty()) 
				postfix += stack.pop() + " ";;
		}
		catch (StackException se) {
			System.out.println("Stack Exception");
		}
		
		return postfix;
	}
	/**
	 * 	Calculates the value of a postfix expression.
	 * @return	The numerical value equivalent to the infix expression having been converted to a postfix expression.
	 */
	public String calculate() {
		// Creates a String array delimited by white space, white space having been deliberated placed by infixToPostfix() for ease of use.
		String[] tokens = jtfPostfix.getText().split(" ");
		String temp;
		
		Stack<Integer> stack = new ArrayStack<Integer>();
		
		int left;
		int right;
		
		try {
			//iterates through all tokens stored in String[] tokens
			for (int i = 0; i < tokens.length; i++) {
				temp = tokens[i];
				try {
					// Attempts to push temp converted to an integer. Fails if String is not an integer, but an operator.
					stack.push(Integer.parseInt(temp));
				}
				catch (NumberFormatException nfe) {
					// The first value popped is the expression to the right of an operator during the infix stage. The second is the left.
					right = (int)stack.pop();
					left = (int)stack.pop();
					
					// Performs an operation on the two numbers above based on the operator stored in token.
					switch(temp) {
					case "+":
						stack.push((left + right));
						break;
					case "-": 
						stack.push((left - right));
						break;
					case "\u2217":
						stack.push((left * right));
						break;
					case "\u00F7":
						stack.push((left / right));
						break;
					}
				}
			}
			// returns the final value within the stack after all operations are complete.
			return stack.pop().toString();
		}
		catch (StackException se) {
			return ("Invalid Expression");
		}
	}
	/**
	 * 	Returns an integer representing the precedence of an operator.
	 * @param s	The string to be evaluated
	 * @return	A numerical value representing the precedence of an operator. A higher value indicates a higher precedence.
	 */
	public int precedence(String s) {
		switch(s) {
			case "+":
			case "-":
				return 1;
			case "\u00F7":
			case "\u2217":
				return 2;
		}
		return -1;
	}
	static final int MAX_WIDTH = 398, MAX_HEIGHT = 440;
	
	public static void main(String arg[]){
		JFrame frame = new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MAX_WIDTH,MAX_HEIGHT);	
		frame.setBackground(Color.white);		
		frame.setResizable(false);				
		frame.setVisible(true);
		
	}
}