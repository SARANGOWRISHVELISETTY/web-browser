import java.awt.*;
import java.awtevent.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends Jframe {

    private JTextField addressBar;
    private JEditorPane display;

    //construtor
    public ReadFile(){
        super ("Syumb")

        addressBar =new JtextField("enter a url");
        addressBar.addActionListener(
         new ActionListener(){
             public void ActionPerformed(ActionEvent event){
               LoadCrap(event.getActionCommand());
             }
         }
        );
         add(addressBar, BorderLayout.NORTH );

         display = new JEditorPane();
         display.SetEditable(false);
         display.addHyperLinkListener(
                 new HypeerlinkListener(){
                     public void hyperLinkUpdate(HyperLink event){

                         if (event.getEventType()==HyperLinkEvent.EventType.ACTIVATED){

                             LoadCrap(event.getURL().toString());
                         }
                     }
                 }
         );
       add (new ScrollPane(display).BorderLayout.CENTER);
       setSize(1000,800);
       setVisible(true);
    }
    //LoadCrap to display on the screen
    private void LoadCrap(String usertext){

        try {

            display.setPage(usertext);
            addressBar.setText(usertext);
        }catch (Exeption e){

            System.out.println(" Ah crap!");
        }
    }
}