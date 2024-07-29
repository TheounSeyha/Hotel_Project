import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGroup extends Frame implements ActionListener{
    Random rand = new Random();

    private Label groupRandom = new Label("Random Group");
    private Label g1 = new Label("Group I");
    private Label g2 = new Label("Group II");
    private Label g3 = new Label("Group III");
    private Label g4 = new Label("Group IV");
    private Button inputBt= new Button("Add people");
    private TextField info = new TextField();
    private Button randomGroup = new Button("Random");
    private List<String> people = new ArrayList<>();
    private java.awt.List G1 = new java.awt.List();
    private java.awt.List G2 = new java.awt.List();
    private java.awt.List G3 = new java.awt.List();
    private java.awt.List G4 = new java.awt.List();

    public RandomGroup(){
        setSize(700,500);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(G1);
        add(g1);
        add(G2);
        add(G3);
        add(G4);
        add(g2);
        add(g3);
        add(g4);
        add(groupRandom);
        add(info);
        add(inputBt);
        add(randomGroup);

        inputBt.setBounds(230,50,70,20);
        info.setBounds(300,50,100,20);
        groupRandom.setBounds(300,80,100,50);
        randomGroup.setBounds(50,130,50,20);
        g1.setBounds(125,180,50,20);
        g2.setBounds(245,180,50,20);
        g3.setBounds(365,180,50,20);
        g4.setBounds(485,180,50,20);
        G1.setBounds(100,200,100,200);
        G2.setBounds(220,200,100,200);
        G3.setBounds(340,200,100,200);
        G4.setBounds(460,200,100,200);

        inputBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = info.getText();
                people.add(name);
                info.setText("");
            }
        });

        randomGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<people.size();i++){
                    int g1 = rand.nextInt(people.size());
                    G1.add(people.get(g1));
                    people.remove(g1);
                    int g2 = rand.nextInt(people.size());
                    G2.add(people.get(g2));
                    people.remove(g2);
                    int g3 = rand.nextInt(people.size());
                    G3.add(people.get(g3));
                    people.remove(g3);
                    int g4 = rand.nextInt(people.size());
                    G4.add(people.get(g4));
                    people.remove(g4);
                }
            }
        });
    }

    public static void main(String[] args) {
        new RandomGroup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
