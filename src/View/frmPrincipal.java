
package View;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;

/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class frmPrincipal extends JFrame
                               implements ActionListener 
{
    JDesktopPane desktop;
    private BufferedImage img;

    
    public frmPrincipal() {
        
        super("CAMPOS ARQUITECTURA - CAC");
        try
        {
            //Make the big window be indented 50 pixels from each edge
            //of the screen.
            int inset = 50;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds(inset, inset,
                      screenSize.width  - inset*2,
                      screenSize.height - inset*2);
                                
        ImageIcon icon = new ImageIcon("images/Watermark.JPG");
        Image image = icon.getImage();
        
        //Set up the GUI.
        desktop = new JDesktopPane()
                {
                @Override
                protected void paintComponent(Graphics grphcs) 
                {
                    super.paintComponent(grphcs);
                    grphcs.drawImage(image, 0, 0, getWidth(), getHeight(),this);
                }                    
        }; //a specialized layered pane

            setContentPane(desktop);
            setJMenuBar(createMenuBar());

            //Make dragging a little faster but perhaps uglier.
            desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);                    
        }
        
        catch (Exception e) 
                {
                    e.printStackTrace();
                }
    }

    protected JMenuBar createMenuBar() 
    {
        JMenuBar menuBar = new JMenuBar();

        //Set up the lone menu.
        JMenu menu = new JMenu("Gestion");
        menu.setMnemonic(KeyEvent.VK_G);
        menuBar.add(menu);
        
        JMenu menu1 = new JMenu("Registro");
        menu.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menu1);
        
        JMenu menu2 = new JMenu("Informes");
        menu.setMnemonic(KeyEvent.VK_I);
        menuBar.add(menu2);
        
        JMenu menu3 = new JMenu("About");
        //menu.setMnemonic(KeyEvent.VK_I);
        menuBar.add(menu3);
        
        //Set up the first menu item.
        JMenuItem menuItem = new JMenuItem("Gestion");
        menuItem.setMnemonic(KeyEvent.VK_G);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        
         //Set up the first menu item.
        JMenuItem menuItem1 = new JMenuItem("Impresiones");
        menuItem1.setMnemonic(KeyEvent.VK_I);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        menuItem1.setActionCommand("impresiones");
        menuItem1.addActionListener(this);
        menu1.add(menuItem1);
        
        
        
        return menuBar;
    }

    //React to menu selections.
    public void actionPerformed(ActionEvent e) 
    {
        if (null != e.getActionCommand()) 
        switch (e.getActionCommand()) 
        {
            case "new":
                //new
                createFrame();
                break;
            case "impresiones":
                createJImpresionFrame();
                break;
            default:
                //quit
                
                quit();
                break;
        }
        
    }

    //Create a new internal frame.
    protected void createFrame() 
    {
        JIntGestion frame = new JIntGestion();
        
        Dimension desktopSize = desktop.getSize();
        
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
        
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    //Create a new internal frame.
    protected void createJImpresionFrame() 
    {
         JIntImpresion frame = new JIntImpresion();
        
        Dimension desktopSize = desktop.getSize();
        
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
        
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
        
    }

    //Quit the application.
    protected void quit() 
    {
        System.exit(0);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() 
    {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frmPrincipal frame = new frmPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}