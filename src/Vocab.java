
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author n1ck
 */
public class Vocab {
    private static String path = "C:\\Users\\n1ck\\Documents\\NetBeansProjects\\ASL\\ASL\\src\\ASL\\";
    private URL pathToFile;
    private String name;
    private String parsedName;
    private String[] nameArray;
    private boolean correct = false;
    public Vocab(String n, int unitNumber){
        name = n;
        parseName();
        try{
            pathToFile = new URL("file:"+path+unitNumber+"\\"+name);
        }
        catch(MalformedURLException e){
            System.err.print("Error creating url in vocab");
        }
    }
    public URL getURL(){
        return pathToFile;
    }
    public String getParsedName(){
        return parsedName;
    }
    private void parseName(){
        parsedName = name.substring(0, name.length()-4);
        nameArray = parsedName.split("_");
        
    }
    public boolean equalsParsedName(String guess){
        
        for(int i =0; i < nameArray.length; ++i){
            System.out.println(nameArray[i]);
            if(guess.equals(nameArray[i]))correct = true;
        }
        return correct;
    }
    @Override
    public boolean equals(Object o){
        Vocab voc = null;
        try{
            voc = (Vocab) o; 
        }
        catch(ClassCastException e){
            System.err.println("Couldnt cast to a vocab");
            return false;
        }
        return pathToFile.equals(voc.getURL()) && parsedName.equals(voc.getParsedName());
         
        
    }
    public boolean guessedCorrect(){return correct;}
    
}
