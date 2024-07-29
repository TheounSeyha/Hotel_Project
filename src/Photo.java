import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UnsupportedLookAndFeelException;

public class Photo extends JFrame implements ActionListener {
    JCheckBox jbx1 , jbx2 , jbx3 ;
    JLabel answer1 , answer2 , answer3;
    boolean select1 , select2 , select3;
    String selection;
    Photo(String title){
        super(title);
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });
        setSize(450,300);
        jbx1 = new JCheckBox("China");
        jbx2 = new JCheckBox("Japen");
        jbx3 = new JCheckBox();
        answer1 = new JLabel();
        answer2 = new JLabel();
        answer3 = new JLabel();
        jbx3.setText("Cambodia");
        jbx1.addActionListener(this);
        jbx2.addActionListener(this);
        jbx3.addActionListener(this);
        setLayout(new FlowLayout((FlowLayout.LEFT)));
        add(jbx1);
        add(jbx2);
        add(jbx3);
        add(answer1);
        add(answer2);
        add(answer3);
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
        select1 = jbx1.isSelected();
        select2 = jbx2.isSelected();
        select3 = jbx3.isSelected();
        selection = " ";
        if(select1){
            selection = "C:\\Users\\USER\\Desktop\\ASSINGMENT\\Hotelproject\\src\\images.jpg";
            answer1.setIcon(new ImageIcon(selection));

        }
        else {
            selection=" ";
            answer1.setIcon(new ImageIcon(selection));
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        new Photo("JCheck Box And Frame");
    }

}
