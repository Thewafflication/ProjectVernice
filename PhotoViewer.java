import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PhotoViewer extends JFrame implements ActionListener
{
    JMenuItem about, openPhoto;
    public final String sep = File.separator;
    JLabel ImageHolder, status;
    public PhotoViewer()
    {
        super("Photo Viewer - ProjectVernice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(new BorderLayout());
        setJMenuBar(menu());
        add(photoContainer());
        add(statusBar(), BorderLayout.SOUTH);
        setVisible(true);
    }
    /**
     * Creates a JLabel to hold the image
     */
    private JLabel photoContainer()
    {
        ImageHolder = new JLabel("");
        return ImageHolder;
    }
    /**
     * Creates a status bar
     */
    private JPanel statusBar()
    {
        JPanel res = new JPanel();
        res.setBorder(new BevelBorder(BevelBorder.LOWERED));
        res.setPreferredSize(new Dimension(this.getWidth(), 16));
        res.setLayout(new BoxLayout(res, BoxLayout.X_AXIS));
        
        status = new JLabel("Open a photo to view it.");
        status.setHorizontalAlignment(SwingConstants.LEFT);
        
        res.add(status);
        
        return res;
    }
    /**
     * Creates a JMenuBar
     */
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
    /**
     * Captures menu actions etc.
     */
    //@override
    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        if(source == about)
            JOptionPane.showMessageDialog(this,"Created by Jordan Waughtal \n(c)2014");
        if(source == openPhoto)
            openPhoto();
    }
    /**
     * Displays a JFileChooser 
     * Updates the JLabel to have the selected file
     * Updates the status bar to have the file path of the image
     */
    public void openPhoto()
    {
        JFileChooser fileChoose = new JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("PNG Images", "png");
        fileChoose.setFileFilter(filter);
        int res = fileChoose.showDialog(this, "Open Photo");
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File chosen = fileChoose.getSelectedFile();
            ImageIcon FCRes = new ImageIcon(chosen.toString());
            ImageHolder.setIcon(FCRes);
            status.setText(chosen.toString());    
        }
        else if(res == JFileChooser.CANCEL_OPTION)
        {
            //DO NOTHING
        }
        else if(res == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(this, "An error occured.");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "We don't know what happenned there boss.");
        }
    }
    /**
     * Creates a PhotoViewer Window
     */
    public static void main(String[] args)
    {
        PhotoViewer main = new PhotoViewer();
    }
}