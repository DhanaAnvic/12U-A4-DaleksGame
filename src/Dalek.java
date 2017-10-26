
/** This class models a Dalek in the game. A Dalek has
 *  a position and can advance towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        this.col = col;
        this.row = row;
        hasCrashed = false;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
         if (hasCrashed == false) {
            //gets the coordinates of the Doctor
            int docRow = doc.getRow();
            int docCol = doc.getCol();
            
        //if the doctor's row is greater than Dalek
        //it will move forward the same way as the dcctor
        if(doc.getRow() > this.row ){
            this.row++;
    }
        //if the doctor's row is less than Dalek
        //it will move backward the same way as the dcctor
        if(doc.getRow() < this.row){
            this.row--;
        }
        //if the doctor's col is greater than Dalek
        //it will move forward the same way as the dcctor
        if(doc.getCol() > this.col){
            this.col++;
        }
         //if the doctor's col is less than Dalek
        //it will move backward the same way as the dcctor
        if(doc.getCol() < this.col){
            this.col--;
        }
         }
         
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
       return this.row;

    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;

    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
    hasCrashed = true;
        

        }
   
    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        return hasCrashed;
    
    }

}




