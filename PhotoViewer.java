import javax.swing.*;
import java.awt.event.*;
public class PhotoViewer extends JFrame implements ActionListener
{
    public PhotoViewer()
    {
        super();
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        
    }
    public static void main(String[] args)
    {
        PhotoViewer main = new PhotoViewer();
        System.out.println(main);
    }
}