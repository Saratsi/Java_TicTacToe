public class TicTacToe {
    
    
    
    // variables
    
    private boolean won;
    private Point points[];
    
    
    
    
    // constructor
    
    public TicTacToe() {
        
        this.won = false;
        this.points = new Point[9];
        
        int i = 0;
        
        while( i < 9 ) {
            
            points[i] = new Point();
            
            points[i].setLetter('-');
            points[i].setX( i % 3 );
            points[i].setY( i / 3 );
            
            i+=1;
        }
    }
    
    
    
    
    // set
    
    public void setWon( boolean won ) {
        
        this.won = won;
        return;
    }
    
    public void setPointsElement( Point temp ) {
        
        int i = ( temp.getY() * 3 ) + temp.getX();
        
        this.points[i].setX(  temp.getX()  );
        this.points[i].setY(  temp.getY()  );
        this.points[i].setLetter(  temp.getLetter()  );
    }
    
    
    
    
    // get
    
    public boolean getWon() {
        
        return this.won;
    }
    

    
    
    // functions
    
    public boolean checkPoint( Point temp ) {
        
        // bring an instance of main here to write the errors.
        Main main = new Main();
        
        
        
        if( temp.getX() < 0 || temp.getX() > 2 ) { main.error("Invalid x coordinate passed to Point Object."); return false; }
        if( temp.getY() < 0 || temp.getY() > 2 ) { main.error("Invalid y coordinate passed to Point Object."); return false; }
        
        if( temp.getLetter() != 'X' && temp.getLetter() != 'O' && temp.getLetter() != '-' ) { main.error("Unexpected symbol passed to Point object."); return false; }
        
        
        int i = (temp.getY()*3)+temp.getX();
        if( this.points[i].getLetter() != '-' ) {
            
            // if check point has no symbol, return false with no warning, it just counts free spaces.
            if( temp.getLetter() == '-' ) return false;
            
            // if check point has symbol, it is a user input. inform for unavailable position
            main.error("This position is already taken. Choose another one.");
            return false;
        }

        return true;
    }
    
    
    
    public boolean checkWon() {
        
        
        if( this.points[0].getLetter() != '-' ) {
            
            if( this.points[0].getLetter() == this.points[1].getLetter() && this.points[0].getLetter() == this.points[2].getLetter() ) return true;  //orizontia 1
            if( this.points[0].getLetter() == this.points[3].getLetter() && this.points[0].getLetter() == this.points[6].getLetter() ) return true;  //katheta 1
            if( this.points[0].getLetter() == this.points[4].getLetter() && this.points[0].getLetter() == this.points[8].getLetter() ) return true;  //diagonia 1
        }
        
        
        if( this.points[1].getLetter() != '-' ) {
            
            if( this.points[1].getLetter() == this.points[4].getLetter() && this.points[1].getLetter() == this.points[7].getLetter() ) return true;  //katheta 2
        }
        
        
        if( this.points[2].getLetter() != '-' ) {
            
            if( this.points[2].getLetter() == this.points[4].getLetter() && this.points[2].getLetter() == this.points[6].getLetter() ) return true;  //diagonia 2
            if( this.points[2].getLetter() == this.points[5].getLetter() && this.points[2].getLetter() == this.points[8].getLetter() ) return true;  //katheta 3
        }

        
        if( this.points[3].getLetter() != '-' ) {
            
            if( this.points[3].getLetter() == this.points[4].getLetter() && this.points[3].getLetter() == this.points[5].getLetter() ) return true;  //orizontia 2
        }
        
        
        if( this.points[6].getLetter() != '-' ) {
            
            if( this.points[6].getLetter() == this.points[7].getLetter() && this.points[6].getLetter() == this.points[8].getLetter() ) return true;  //orizontia 3
        }
        
        
        return false;
    }
    
    
    
    
    // print
    
    public void print() {
        
        String space = "                "; //16 spaces
        String content = "";
        String non_cls_space = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        content += non_cls_space + "TIC TAC TOE\n\n---------------------------------------------\n\n" +
        space + " " + this.points[0].getLetter() + " |  " + this.points[1].getLetter()  + "  | " + this.points[2].getLetter() + "\n" +
        space + "---+-----+---\n" +
        space + " " + this.points[3].getLetter() + " |  " + this.points[4].getLetter()  + "  | " + this.points[5].getLetter() + "\n" +
        space + "---+-----+---\n" +
        space + " " + this.points[6].getLetter() + " |  " + this.points[7].getLetter()  + "  | " + this.points[8].getLetter() + 
        "\n\n---------------------------------------------\n\n";
        
        System.out.print( content );
    }
    
    
    
    
    
}