
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * control.java
 *
 * Created on Jul 25, 2011, 4:30:41 PM
 */



/**
 *
 * @author n1ck
 */
public class control extends javax.swing.JPanel {
    private String guess;
    private int score = 0;
    private int replays = 3;
    private MediaPanel mediaPlayer;
    private labels labels;
    private ViewController vc;
    /** Creates new form control */
    public control(MediaPanel m, labels l, ViewController v) {
        vc = v;
        labels = l;
        mediaPlayer = m;
        initComponents();
        labels.setReplaysNumberLabel(""+replays);
    }
    private void guessEntered(){
        if(guess.equals("cheat")){
            labels.enableCheatMode();
            guessText.setText("");
            guessText.setBackground(Color.BLUE);
        }
        else if(guess.equals("no cheat")){
            labels.disableCheatMode();
            guessText.setText("");
            guessText.setBackground(Color.BLUE);
        }
        else if(mediaPlayer.getCurrentVocab().equalsParsedName(guess)) {
                    
               
                mediaPlayer.stop();
                ++score;
                labels.setScoreText(""+score);
                guessText.setBackground(Color.GREEN);
                guessText.setEnabled(false);
            }
         else{
             guessText.setText("");
             guessText.setBackground(Color.red);
             --score;
             labels.setScoreText(""+score);
         }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUnitsButton = new javax.swing.JButton();
        guessButton = new javax.swing.JButton();
        replayButton = new javax.swing.JButton();
        guessText = new javax.swing.JTextField();
        newVocabButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        newUnitsButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        newUnitsButton.setText("Select New Units");
        newUnitsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newUnitsButtonMouseClicked(evt);
            }
        });

        guessButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        guessButton.setText("Guess");
        guessButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guessButtonMouseClicked(evt);
            }
        });

        replayButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        replayButton.setText("Replay");
        replayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replayButtonMouseClicked(evt);
            }
        });

        guessText.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        guessText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guessTextKeyPressed(evt);
            }
        });

        newVocabButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        newVocabButton.setText("New Word");
        newVocabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newVocabButtonMouseClicked(evt);
            }
        });

        quitButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12));
        quitButton.setText("Quit");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quitButton)
                .addGap(18, 18, 18)
                .addComponent(replayButton)
                .addGap(19, 19, 19)
                .addComponent(newUnitsButton)
                .addGap(18, 18, 18)
                .addComponent(guessText, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessButton)
                .addGap(18, 18, 18)
                .addComponent(newVocabButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton)
                    .addComponent(guessText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessButton)
                    .addComponent(newVocabButton)
                    .addComponent(replayButton)
                    .addComponent(newUnitsButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newUnitsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUnitsButtonMouseClicked
        vc.switchStates();
    }//GEN-LAST:event_newUnitsButtonMouseClicked

    private void guessButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guessButtonMouseClicked
            guess = guessText.getText();
            guessEntered();
    }//GEN-LAST:event_guessButtonMouseClicked
    /**
     * keyCode 10 = enter key
     * @param evt 
     */
    private void guessTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guessTextKeyPressed
            if(evt.getKeyCode() == 10){
                guess = guessText.getText();
               
                guessEntered();
            }
    }//GEN-LAST:event_guessTextKeyPressed

    private void replayButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replayButtonMouseClicked
      if(replayButton.isEnabled()==true){
        --replays;
        labels.setReplaysNumberLabel(""+replays);
        if(replays > 0){
           
            mediaPlayer.replay();
        }
        else{
            if(replayButton.isEnabled() == true)
            replayButton.setEnabled(false);
        }
      } 
    }//GEN-LAST:event_replayButtonMouseClicked

    private void newVocabButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newVocabButtonMouseClicked
        replayButton.setEnabled(true);
        guessText.setEnabled(true);
        replays = 3;
        labels.setReplaysNumberLabel(""+replays);
        guessText.setText(null);
        guessText.setBackground(Color.WHITE);
        mediaPlayer.generateNewCurrentVocab();
        
    }//GEN-LAST:event_newVocabButtonMouseClicked

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed

    }//GEN-LAST:event_quitButtonActionPerformed
    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_quitButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessText;
    private javax.swing.JButton newUnitsButton;
    private javax.swing.JButton newVocabButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton replayButton;
    // End of variables declaration//GEN-END:variables
}
