/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MediaPanel.java
 *
 * Created on Jul 25, 2011, 4:01:52 PM
 */


import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

/**
 *
 * @author n1ck
 */
public class MediaPanel extends javax.swing.JPanel {
    private static final int PLAYER_STARTED = 600;
    private static final int PLAYER_STOPPED = 500;
    private Player mediaPlayer;
    private labels labs;
    private Component video,controls;
    private ArrayList<Vocab> vocab = new ArrayList<Vocab>();
    private ArrayList<String> vocabUsed = new ArrayList<String>();
    private Vocab currentVocab;
    private Random rng;
    private rightPanel right;
    /** Creates new form MediaPanel */
    public MediaPanel( boolean[] units, rightPanel r, labels l) {
        labs = l;
        right = r;
        populateVocab(units);
        rng = new Random();
        currentVocab = vocab.get(rng.nextInt(vocab.size()-1));
        if(labs.cheatModeEnabled()) labs.setCheatText(currentVocab.getParsedName());
        vocabUsed.add(currentVocab.getParsedName());
        initComponents();
        setLayout( new BorderLayout() ); // use a BorderLayout
        try {

            // Create a JMF player to play the media specified in the URL:
            mediaPlayer = Manager.createRealizedPlayer( new MediaLocator(currentVocab.getURL()) );
        

            // Get the components for the video and the playback controls:
            video = mediaPlayer.getVisualComponent();
            controls = mediaPlayer.getControlPanelComponent();

            if ( video != null )
                add( video, BorderLayout.CENTER ); // add video component


            // Start the JMF player:
            mediaPlayer.start(); // start playing the media clip

        } // end try

        catch ( NoPlayerException noPlayerException ) {
            System.err.println( "No media player found" );
        } // end catch
        catch (CannotRealizeException ex) {
            System.err.println(ex.getMessage());
        } // end catch
        catch ( IOException iOException ) {
            System.err.println( "Error reading from the source" );
        } // end catch

} // end MediaPanel constructor
/**
* Populate the vocab arraylist  
* @param u units selected
*/
private void populateVocab(boolean[] u){
           
            
            String path = "C:\\Users\\n1ck\\Documents\\NetBeansProjects\\ASL\\ASL\\src\\ASL\\";
            for(int i= 0; i < 11; ++i){
                int unitNumber = i+13;
                if(u[i]){
                   File file = new File(path+""+unitNumber+"\\"+unitNumber+".txt");
                    try {
                        Scanner filein = new Scanner(file);
                        while(filein.hasNext()){
                            Vocab v = null;
           
                   
                                // Get the file as URL:
                                v = new Vocab(filein.nextLine(), unitNumber);
                   
                                if(v != null)vocab.add(v);
                         
                        }
                    } catch (FileNotFoundException ex) {
                        System.err.println("Couldnt find unit video names file");
                    }
                }
           }
   
        
    
}
    /**
     * 
     */
public void generateNewCurrentVocab(){
    mediaPlayer.stop();
    
    remove(video);
    validate();
    mediaPlayer.deallocate();
    mediaPlayer.close();
    //Save current vocab name
    right.addToList(currentVocab.getParsedName());
    System.err.println(vocabUsed.size()+" "+vocab.size());
    if(vocabUsed.size()+1 != vocab.size()){
    //Prevent Duplicate Words
        do{
            currentVocab = vocab.get(rng.nextInt(vocab.size()-1));
        }while(vocabUsed.contains(currentVocab.getParsedName()));
        vocabUsed.add(currentVocab.getParsedName());
    }
    else{
        vocabUsed.clear();
    }
        try {
            mediaPlayer = Manager.createRealizedPlayer( new MediaLocator(currentVocab.getURL()) );
        } catch (IOException ex) {
            System.err.println(ex.getMessage()+ " Cannot find " + currentVocab.getParsedName());
            generateNewCurrentVocab();
        } catch (NoPlayerException ex) {
            Logger.getLogger(MediaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(MediaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        video = mediaPlayer.getVisualComponent();
        
        if(video!=null){
            add(video, BorderLayout.CENTER);
        }
        if(labs.cheatModeEnabled()) labs.setCheatText(currentVocab.getParsedName());
       //mediaPlayer.realize();
        mediaPlayer.setMediaTime(new Time(0));
       validate();
        mediaPlayer.start();
}
public Vocab getCurrentVocab(){return currentVocab;}
/**
 * Replay the current video
 */
public void replay(){
    if(mediaPlayer.getState()== PLAYER_STARTED){
    mediaPlayer.setMediaTime(new Time(0));
    }
    else {
        mediaPlayer.setMediaTime(new Time(0));
        mediaPlayer.start();
    }
}
public void stop(){ mediaPlayer.stop();}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
