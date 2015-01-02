import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PhotoViewer extends JFrame implements ActionListener
{
    JMenuItem about, openPhoto;
    public final String sep = File.separator;
    JLabel ImageHolder;
    public PhotoViewer()
    {
        super("Photo Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setJMenuBar(menu());
        add(photoContainer());
        setVisible(true);
    }
    private JLabel photoContainer()
    {
        ImageHolder = new JLabel("Open a photo to view it.");
        return ImageHolder;
    }
    private JMenuBar menu()
    {
        JMenuBar res = new JMenuBar();
        
        JMenu file = new JMenu("File", true);
        openPhoto = new JMenuItem("Open Photo");
        openPhoto.addActionListener(this);
        file.add(openPhoto);
        res.add(file);
        
        JMenu help = new JMenu("Help", true);
        about = new JMenuItem("About");
        about.addActionListener(this);
        help.add(about);
        res.add(help);
        
        return res;
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        if(source == about)
            JOptionPane.showMessageDialog(this,"Created by Jordan Waughtal \n(c)2014");
        if(source == openPhoto)
            openPhoto();
    }

    
    public void openPhoto()
    {
        JFileChooser fileChoose = new JFileChooser();
        fileChoose.showDialog(this, "Open Photo");
        File chosen = fileChoose.getSelectedFile();
        ImageIcon res = new ImageIcon(chosen.toString());
        System.out.println("DEBUG \n"+chosen.toString());
        ImageHolder.setIcon(res);
    }
    
    public static void main(String[] args)
    {
        PhotoViewer main = new PhotoViewer();
        System.out.println(main);
    }
}