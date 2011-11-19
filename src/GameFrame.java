
import java.awt.BorderLayout;
import javax.swing.JFrame;



/**
 *
 * @author n1ck
 */
public class GameFrame extends JFrame{
    private MediaPanel mediaPanel;
    private rightPanel right;
    private control c;
    public GameFrame(boolean[] u, ViewController v){
        v.setGameFrame(this);
        this.setTitle("ASL GAME");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout(new BorderLayout());
        labels l = new labels();
        right = new rightPanel();
        mediaPanel = new MediaPanel(u, right, l);
        c = new control(mediaPanel, l, v);
        this.add(l, BorderLayout.NORTH);
        add(mediaPanel, BorderLayout.CENTER);
        add(c, BorderLayout.SOUTH);
        this.add(right, BorderLayout.EAST);
        setSize( 800, 600 );
        
        setVisible(true);
    }
}
