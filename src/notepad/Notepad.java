
package notepad;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.File.*;
import java.io.FileWriter;
import javax.swing.filechooser.*;

public class Notepad extends JFrame implements ActionListener{

    JTextArea area;
    JScrollPane pane;
    String text;
    public Notepad() {
        setBounds(0,0,800,600);
        JMenuBar obj=new JMenuBar();
        JMenu file=new JMenu("File");
        JMenuItem doc=new JMenuItem("New");
        doc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        doc.addActionListener(this);
        JMenuItem open=new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        JMenuItem save=new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        //JMenuItem saveas=new JMenuItem("Save as");
        //saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        //saveas.addActionListener(this);
        JMenuItem print=new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        JMenuItem esc=new JMenuItem("Exit");
        esc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        esc.addActionListener(this);
        obj.add(file);
        file.add(doc);
        file.add(open);
        file.add(save);
        //file.add(saveas);
        file.add(print);
        file.add(esc);
        
        
        JMenu edit=new JMenu("Edit");
        obj.add(edit);
        JMenuItem copy=new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        JMenuItem paste=new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        JMenuItem cut=new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        JMenuItem select=new JMenuItem("Select All");
        select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        select.addActionListener(this);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(select);
        JMenu help=new JMenu("help");
        JMenuItem about=new JMenuItem("About the NotePad");
        about.addActionListener(this);
        help.add(about);
        
        obj.add(help);
        area=new JTextArea();
        area.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        pane=new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane,BorderLayout.CENTER);
        // add(obj); // not designed for this specific task
        setJMenuBar(obj); // designed this method for this specific task
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("New")) {
            area.setText("");
        } else if(ae.getActionCommand().equals("Open")) {
            JFileChooser chooser=new JFileChooser(); 
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt Files","txt");
            chooser.addChoosableFileFilter(restrict);
            int action = chooser.showOpenDialog(this);
            if(action!=JFileChooser.APPROVE_OPTION) {
                return;
            }
            File file=chooser.getSelectedFile();
            try {
                BufferedReader reader=new BufferedReader(new FileReader(file));
                area.read(reader,null);
            }catch(Exception e) {
                
            } 
        } else if(ae.getActionCommand().equals("Save")) {
            JFileChooser saveas=new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action=saveas.showOpenDialog(this);
            if(action!=JFileChooser.APPROVE_OPTION) {
                return;
            } 
            File filename=new File(saveas.getSelectedFile()+".txt");
            BufferedWriter outfile= null;
            try {
              outfile=new BufferedWriter(new FileWriter(filename));
              area.write(outfile);
            }catch(Exception e) {
                
            }
        } else if(ae.getActionCommand().equals("Print")) {
            try {
                area.print(); 
            } catch(Exception e) {
                
            }
        } else if(ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else if(ae.getActionCommand().equals("Copy")) {
            text=area.getSelectedText();
        } else if(ae.getActionCommand().equals("Paste")) {
            area.insert(text,area.getCaretPosition());
        } else if(ae.getActionCommand().equals("Cut")) {
            text=area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
        } else if(ae.getActionCommand().equals("Select All")) {
            area.selectAll();
        } else if(ae.getActionCommand().equals("About the NotePad")) {
            new About().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Notepad().setVisible(true); // to show the Jframe  
    }
}
