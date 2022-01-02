package notepad;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class About extends JFrame implements ActionListener{
    JButton button;
    About() {
        setBounds(300,100,700,500);
        setLayout(null);
        ImageIcon ii=new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image i2=ii.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
        ImageIcon ii2=new ImageIcon(i2);
        JLabel label=new JLabel(ii2);
        label.setBounds(150,40,400,80);
        add(label);
        ImageIcon iin=new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image i3=iin.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(i3);
        JLabel label2=new JLabel(ii3);
        label2.setBounds(50,150,70,70);
        add(label2);
        JLabel label3=new JLabel("<html><center><font color=Brown face=verdana>Aman Pathak</font><br>Version 1.7.1 2021<br>All Rights Reserved!<br>"
                + "Windows Notepad is a simple text editor for Windows<br>It creates and edits plain text documents."
                + "<br>First released in 1983 to commercialize the computer mouse in MS-DOS<br>"
                + "Notepad has been part of every version of Windows ever since.<br></html>");
        label3.setBounds(150,100,500,300);
        label3.setFont(new Font("SAN_SERIF",Font.PLAIN, 18));
        add(label3);
        button=new JButton("OK");
        button.setBounds(350,400,80,25);
        button.addActionListener(this);
        add(button);
        
        }  
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
    public static void main(String args[]) {
         new About().setVisible(true);
    }
}
