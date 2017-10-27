
import java.awt.Color;


/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    private int row, col;
    private boolean hasCrashed;
    
    private Doctor doctor;
    private Dalek dalek1, dalek2, dalek3;
    private Board board;

    
  
    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
      //create the game board
      board = new Board(12,12);
      
      int docRow = (int)(Math.random() *12);
      int docCol = (int) (Math.random() *12);
      //create the doctor
       doctor = new Doctor (docRow, docCol);
      //putting a green peg for the doctor
     board.putPeg(Color.GREEN,doctor.getRow(), doctor.getCol());

     int d1Row = (int)(Math.random() * 12);
     int d1Col= (int)(Math.random() * 12);
     //create the first dalek
      dalek1 = new Dalek(d1Row, d1Col);
       //putting a black peg for the dalek1
     board.putPeg(Color.BLACK,dalek1.getRow(), dalek1.getCol());

     int d2Row = (int)(Math.random() * 12);
     int d2Col= (int)(Math.random() * 12);
     //create the second dalek
     dalek2 = new Dalek (d2Row, d2Col);
     //putting a black peg for the dalek2
     board.putPeg(Color.BLACK, d2Row, d2Col);
 
     int d3Row = (int)(Math.random() * 12);
     int d3Col= (int)(Math.random() * 12);
     //create the third dalek
    dalek3 = new Dalek (d3Row, d3Col);
     //putting a black peg for the dalek3
    board.putPeg(Color.BLACK, d3Col, d3Row);
 
    }
 
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        
        while(true){
        //determine the user's doctor move
        Coordinate click = board.getClick();

         //Remove the old doctor peg
          board.removePeg(doctor.getRow(), doctor.getCol());
          //remove the old three daleks peg
        board.removePeg(dalek1.getRow(), dalek1.getCol());
        board.removePeg(dalek2.getRow(), dalek2.getCol());
        board.removePeg(dalek3.getRow(), dalek3.getCol());
          
          // Move the doctor peg to new location where the player clicked
          doctor.move(click.getRow(), click.getCol());
          //all the dalek will go foward to the doctor
          dalek1.advanceTowards(doctor);
          dalek2.advanceTowards(doctor);
          dalek3.advanceTowards(doctor);
   
          // Place the doctor peg!
          board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
          
          //place the three dalek pegs
          board.putPeg(Color.BLUE, dalek1.getRow(), dalek1.getCol());
          board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
          board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
          
          
          //check if each dalek 1 will crash to the doctor
          if (doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getRow()){
              board.removePeg(dalek1.getRow(), dalek1.getCol());
              board.removePeg(doctor.getRow(), doctor.getCol());
              board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol()); 
              
           //check if dalek 2 will collide to the doctor
          }
         if(doctor.getRow() == dalek2.getRow() && doctor.getCol() == dalek2.getCol()){
              board.removePeg(dalek2.getRow(), dalek2.getCol());
              board.removePeg(doctor.getRow(), doctor.getCol());
              board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
              
          }
       
        if(doctor.getRow() == dalek3.getRow() && doctor.getCol() == dalek3.getCol()){
              board.removePeg(dalek3.getRow(), dalek3.getCol());
              board.removePeg(doctor.getRow(), doctor.getCol());
              board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
              break;
          }
        }
          //check if each dalek crash each other
         if (dalek1.getRow() == dalek2.getRow() && dalek1.getRow() == dalek2.getRow()){
              board.removePeg(dalek1.getRow(), dalek1.getCol());
              board.removePeg(dalek2.getRow(), dalek2.getCol());
              board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
              dalek1.crash();
              dalek2.crash();
              
          }
         if(dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()){
              board.removePeg(dalek1.getRow(), dalek1.getCol());
              board.removePeg(dalek3.getRow(), dalek3.getCol());
              board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
              dalek1.crash();
              dalek3.crash();
              
          }
        if(dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()){
              board.removePeg(dalek2.getRow(), dalek2.getCol());
              board.removePeg(dalek3.getRow(), dalek3.getCol());
              board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
              dalek2.crash();
              dalek3.crash();
    }
    if(dalek1.getRow() == dalek2.getRow() && dalek1.getRow() == dalek3.getRow() 
            && dalek1.getCol() == dalek2.getCol() && dalek1.getCol() == dalek3.getCol() &&
            dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getRow()){
        dalek1.crash();;
        dalek2.crash();
        dalek3.crash();
        board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
        board.displayMessage("You have lost!!");

       
    }
        
        }
    }



