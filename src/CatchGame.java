
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
    private Board board;
    private Doctor doctor;
    private Dalek d1, d2, d3;
   
 
  
    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
      //create the game board
      this.board = new Board(12,12);
      
      //find a random place in the boad for the doctor
      int docRow = (int)(Math.random() * 12);
      int docCol = (int) (Math.random() * 12);
      //create the doctor
       doctor = new Doctor (docRow, docCol);

    //find a random place in the boad for dalek1
     int d1Row = (int)(Math.random() * 12);
     int d1Col= (int)(Math.random() * 12);
     //create the first dalek
     d1 = new Dalek(d1Row, d1Col);

     //find a random place in the boad for dalek2
     int d2Row = (int)(Math.random() * 12);
     int d2Col= (int)(Math.random() * 12);
     //create the second dalek
     d2 = new Dalek (d2Row, d2Col);

    //find a random place in the boad for dalek3
    int d3Row = (int)(Math.random() * 12);
    int d3Col= (int)(Math.random() * 12);
    //create the third dalek
    d3 = new Dalek (d3Row, d3Col);
    
    
       //putting a black peg for the dalek1
     board.putPeg(Color.BLACK,d1.getRow(), d1.getCol());     
     //putting a black peg for the dalek2
     board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
     //putting a black peg for the dalek3
    board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
    
    //put a green peg for the doctor
    board.putPeg(Color.GREEN,doctor.getRow(), doctor.getCol());
 
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
          // Move the doctor peg to new location where the player clicked
          doctor.move(click.getRow(), click.getCol());
           // Place the doctor peg
          board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
          
          //remove the old three daleks peg
        board.removePeg(d1.getRow(), d1.getCol());
        board.removePeg(d2.getRow(), d2.getCol());
        board.removePeg(d3.getRow(), d3.getCol());
          
          //all the dalek will go foward to the doctor
          d1.advanceTowards(doctor);
          //place the first dalek peg
          board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
          
          //dalek 2 will go forward to the doctor
          d2.advanceTowards(doctor);
          board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
          
          //dalek3 will go forward to the doctor 
          d3.advanceTowards(doctor);
          board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
          
           //check of dalek 1 has crashed with the doctor
            if (doctor.getRow() == d1.getRow() && doctor.getCol() == d1.getCol()) {
                //remove the peg for the doctor and dalek1
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.removePeg(d1.getRow(),d1.getCol());
                //put a yellow peg if dalek1 and doctor crash
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                
            }
            //check if dalek2 and doctor crash each other
            if(doctor.getRow() == d2.getRow() && doctor.getCol() == d2.getCol()){
                //remove the peg for the doctor and dalek2
               board.removePeg(doctor.getRow(), doctor.getCol());
                board.removePeg(d2.getRow(),d2.getCol());
                //put a yellow peg if dalek2 and doctor crash
                board.putPeg(Color.yellow, doctor.getRow(), doctor.getCol());
                
            }
              //check of dalek 3 has crashed with the doctor
            if(doctor.getRow() == d3.getRow() && doctor.getCol() == d3.getCol()){
                 //remove the peg for the doctor and dalek3
                board.removePeg(doctor.getRow(), doctor.getCol());
                board.removePeg(d3.getRow(), d3.getCol());
                  //put a yellow peg if dalek13 and doctor crash
                board.putPeg(Color.YELLOW,doctor.getRow(), doctor.getCol());
            }
            //check if all the daleks crashed with the doctor
            if(doctor.getRow() == d1.getRow() && doctor.getCol() == d1.getCol()
                    && doctor.getRow() == d2.getRow() && doctor.getCol() == d2.getCol()
                    && doctor.getRow() == d3.getRow() && doctor.getCol() == d3.getCol()){
                //remove the peg for the dalek
                board.removePeg(doctor.getRow(),doctor.getCol());
                //put a yellow peg if all the daleks crashes with the doctor
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                //display on the board you have lost
                board.displayMessage("You have lost!");
                break;
            }
          //check of dalek1 crash with dalek2
          if(d1.hasCrashed(d2)){
              //dalek 1 will crash
              d1.crash();
              //dalek 2 will crash
              d2.crash();
              //take out the pegs for the dalek1 and dalek2
              board.removePeg(d1.getRow(), d1.getCol());
              board.removePeg(d2.getRow(), d2.getCol());
              //put a red peg if dalek1 and dalek 2 crash
              board.putPeg(Color.RED, d1.getRow(), d1.getCol());
          }
          
          //check if dalek1 has crashed with dalek3
          if(d1.hasCrashed(d3)){
              //dalek1 will crash
              d1.crash();
              //dalek3 will crash
              d2.crash();
              //remove the pegs for dalek1 and dalek3
              board.removePeg(d1.getRow(), d1.getCol());
              board.removePeg(d3.getRow(), d3.getCol());
              //put a red peg if dalek1 and dalek3
              board.putPeg(Color.RED, d1.getRow(), d1.getCol());
          
        }
          //check if dalek2 has crashed with dalek3
          if(d2.hasCrashed(d3)){
              //dalek2 will crash
              d2.crash();
              //dalek3 will crash
              d3.crash();
              //removes the pegs for dalek2 and dalek3
              board.removePeg(d2.getRow(), d2.getCol());
              board.removePeg(d3.getRow(), d3.getCol());
              //put a red peg if dalek2 and dalak3
              board.putPeg(Color.RED, d2.getRow(), d2.getCol());
    }
          //check if all the daleks has crashed each other
          if(d1.hasCrashed(d2) && d1.hasCrashed(d3) && d2.hasCrashed(d3)){
              //daleks 1, 2, and 3 will crash
              d1.crash();
              d2.crash();
              d3.crash();
              //remove the pegs for dalek2 and dalek3
              board.removePeg(d2.getRow(), d2.getRow());
              board.removePeg(d3.getRow(), d3.getCol());
              //put a red peg if all the daleks crash each other
              board.putPeg(Color.RED, d1.getRow(), d1.getCol());
              break;
          }

    }
}
}

           
         

  





       
 
    


              
              
          
              
   


