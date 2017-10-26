
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
     Board board = new Board(12,12);
   
      //create the doctor
      Doctor doctor = new Doctor ((int)(Math.random() * 12), (int) (Math.random() * 12));

     //create the first dalek
    Dalek  dalek1 = new Dalek((int)(Math.random() * 12), (int) (Math.random() * 12));

     //create the second dalek
     Dalek dalek2 = new Dalek ((int)(Math.random() * 12), (int) (Math.random() * 12));
 
     //create the third dalek
     Dalek dalek3 = new Dalek ((int)(Math.random() * 12), (int) (Math.random() * 12));
     
     board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
     board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
     board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
     board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

     
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
          board.removePeg(dalek1.getRow(), dalek1.getCol());
          board.removePeg(dalek2.getRow(), dalek2.getCol());
          board.removePeg(dalek3.getRow(), dalek3.getCol());
          
          // Move the doctor peg to new location where the player clicked
          doctor.move(click.getRow(), click.getCol());
          dalek1.advanceTowards(doctor);
          dalek2.advanceTowards(doctor);
          dalek3.advanceTowards(doctor);
          
          
          // Place the doctor peg!
          board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
          board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
          board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
          board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());
          
          
          //check if all the daleks crash
          if(doctor.getRow() == dalek1.getRow() && doctor.getCol() == dalek1.getRow()){
              board.removePeg(dalek1.getRow(), dalek1.getCol());
              board.removePeg(doctor.getRow(), doctor.getCol());
              board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());

          }
          


    }
}
}

        





