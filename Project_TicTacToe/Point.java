public class Point {
    
    
    
    
    
    // variables
    
    private int x, y;
    private char letter;
    
    
    
    // constructor
    
    public Point() {
        
        this.x = -1;
        this.y = -1;
        letter = '-';
    }
    
    
    
    // set
    
    public void setX( int x ) {
        
        this.x = x;
        return;
    }
    
    public void setY( int y ) {
        
        this.y = y;
        return;
    }
    
    public void setLetter( char letter ) {
        
        this.letter = letter;
        return;
    }
    
    
    
    
    // get
    
    public int getX() {
        
        return this.x;
    }
    
    public int getY() {
        
        return this.y;
    }
    
    public char getLetter() {
        
        return this.letter;
    }
    
    
    
    
}
    
    