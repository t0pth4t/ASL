/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n1ck
 */
public class ViewController {
    private GameFrame gameFrame;
    private TitleFrame titleFrame;
    private boolean inGame = false;
    /**
     * If in game mode go to title mode vice versa
     */
    public void switchStates(){
        if(inGame){
            
            gameFrame.setVisible(false);
            titleFrame.setVisible(true);
        }
        else{
            titleFrame.setVisible(false);
            gameFrame = new GameFrame(titleFrame.getUnits(), this);
           
            
        }
        inGame = !inGame;
    }
    /**
     * set game frame
     * @param g
     * @return false if game frame is already set
     */
    public boolean setGameFrame(GameFrame g){
        if(gameFrame == null){
            gameFrame = g;
            return true;
        }
        return false;
    }
    /**
     * sets titleFrame
     * @param t
     * @return false if title frame is already set
     */
    public boolean setTitleFrame(TitleFrame t){
        if(titleFrame == null){
            titleFrame = t;
            return true;
        }
        return false;
    }
}
