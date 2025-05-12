import java.util.Scanner; // user input

public class Main {
    
    
    private static String error;
    
    
    public static void error( String message ) {
        
        //System.out.println( message );
        error = message + "\n";
    }
    
    
    
    
    
    
    private static boolean check_symbol( String source ) {
        
        if( source.length() == 0 ) { error("Empty."); return false; }
        
        if( source.length() > 1 ) { error("Invalid input length."); return false; }
        
        if( source.charAt(0) != 'X' && source.charAt(0) != 'O' ) { error("Invalid symbol."); return false; }
        
        return true;
    }
    
    
    
    
    
    
    private static boolean check_coord( String source ) {
        
        int i = source.length();
        
        if( i == 0 ) { error( "Empty."); return false; }
        
        if( i != 3 ) { error("Invalid input length."); return false; }
        
        if( source.charAt(1) != ' ' ) { error("Invalid input."); return false; }
        
        if( source.charAt(0) < '0' || source.charAt(0) > '2' || source.charAt(2) < '0' || source.charAt(2) > '2' ) { error("Invalid coordinates."); return false; }
        
        return true;
    }
    
    
    
    
    
    
    
    
    public static void main( String args[] ) {
        
        //init
        error("");
        /*cls*/
        
        //vars
        String input = "";
        char letter[] = new char[2];
        letter[0] = '-';
        letter[1] = '-';
        short turn = 0;
        
        TicTacToe game = new TicTacToe();
        Scanner cin = new Scanner( System.in );
        
        
        
        //get symbol
        while( true ) {
            
            //print game
            game.print();
            
            //instructions
            System.out.print( error + "PLAYER " + (turn+1)  +  ", which symbol do you want to use?\nChoose between 'O', 'o', 'X', 'x': "  ); 
            
            //user input to uppercase
            input = cin.nextLine();
            input = input.toUpperCase();
            
            //check user input
            if( check_symbol( input ) ) {
                
                if( input.charAt(0) == 'X' ) {
                    
                    letter[0] = 'X';
                    letter[1] = 'O';
                }
                else {
                    
                    letter[0] = 'O';
                    letter[1] = 'X';
                }
                
                break;
            }
            
            /*cls*/
        }
        
        
        
        
        // gameplay
        
        /*cls*/
        error("");
        
        while( true ) {
            
            //show game
            game.print();
            
            //instructions
            System.out.print( error + "PLAYER " + (turn+1) + ", your symbol is " + letter[turn] + ".\nChoose x and y coords between 0 and 2 seperated with space: " );
        
            //user input
            input = cin.nextLine();
            
            //check given coordinates
            if( check_coord( input ) ) {
                
                //create a new point info
                Point temp = new Point();
                
                //set new info
                temp.setX( input.charAt(0) - '0'  );
                temp.setY( input.charAt(2) - '0'  );
                temp.setLetter( letter[turn] );
              
                
                //re-check info
                if( game.checkPoint( temp ) ) {
                    
                    //send the info to actual game Point
                    game.setPointsElement( temp );
                    
                    //check if someone won this round
                    if( game.checkWon() ) {
                        
                        game.setWon(true);
                        break;
                        
                    }
                    
                    //check if there are remaining empty Points or if the game finished draw
                    int i = 0;
                    //create a new check Point
                    Point temp2 = new Point();
                    //assign letter '-' to check Point, because it checks both X and O without warning message
                    temp2.setLetter('-');
                    
                    while( i<9 ) {
                        
                        //move to next point
                        temp2.setX( i%3 );
                        temp2.setY( i/3 );
                        
                        //check
                        if( game.checkPoint( temp2 ) ) break;
                        
                        i++;
                    }
                    
                    // if no more points left
                    if( i == 9 ) break;
                    
                    // flush error mesage
                    error("");
                    
                    // switch to other player
                    if( turn == 0 ) turn = 1;
                    else turn = 0;
                }
            }
            
            /*cls*/
            
        }
        
        /*cls*/
        game.print();
        
        if( game.getWon() ) System.out.println( "PLAYER " + (turn+1) + " won the game." );
        else System.out.println("Draw.");
        
        cin.nextLine();
        return;

    }
    
    
    }
        
        