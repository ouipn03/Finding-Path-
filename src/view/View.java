package view;

import FordFulkerson.FFTest;
import controller.FindWay;
import model.Model;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Maps map;
    private Model model;
    private JTextField jTextField_start;
    private JTextField jTextField_end;
    private JTextArea jTextArea_findFF;
    private JTextArea jTextArea_findDT;

    private JLabel jLabel_answer;

    public View () throws HeadlessException {
        super();
        this.model = new Model ();
        this.init();
    }
    private void init ( ) {
        this.setTitle("Map");
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1300,700);
        this.setLocationRelativeTo (null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Times New Roman",Font.BOLD,20);
        //West
        JLabel jLabel_start = new JLabel("Start point");
        jLabel_start.setFont ( font );
        jTextField_start = new JTextField (  );
        jTextField_start.setFont ( font );

        JLabel jLabel_end = new JLabel("End point");
        jLabel_end.setFont ( font );
        jTextField_end = new JTextField (  );
        jTextField_end.setFont ( font );

        JButton jButton_findFF = new JButton("Find ways using FF");
        jButton_findFF.setFont(font);
        jTextArea_findFF = new JTextArea (  );
        jTextArea_findFF.setFont ( font );
        jTextArea_findFF.setLineWrap ( true );
        jTextArea_findFF.setWrapStyleWord(true);
        JButton jButton_findDT = new JButton("Find ways using DT");
        jButton_findDT.setFont(font);
        jTextArea_findDT = new JTextArea (  );
        jTextArea_findDT.setFont ( font );
        jTextArea_findDT.setLineWrap ( true );
        jTextArea_findDT.setWrapStyleWord(true);

        jLabel_answer = new JLabel (  );

        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout ( new GridLayout(8,1,1,1));
        jPanel_menu.add( jLabel_start);
        jPanel_menu.add(jTextField_start);
        jPanel_menu.add( jLabel_end);
        jPanel_menu.add(jTextField_end);

        jPanel_menu.add(jButton_findFF);
        jPanel_menu.add(jTextArea_findFF);

        jPanel_menu.add(jButton_findDT);
        jPanel_menu.add(jTextArea_findDT);

        map = new Maps (this);
        this.setLayout(new BorderLayout());
        this.add ( jPanel_menu, BorderLayout.WEST );
        this.add( map,BorderLayout.CENTER);
        this.setVisible (true);

        FindWay findWayFF = new FindWay(this);
        jButton_findFF.addActionListener ( findWayFF );

        FindWay findWayDT = new FindWay(this);
      jButton_findDT.addActionListener ( findWayDT );
    }
    public int getStart(){
        return Integer.parseInt(jTextField_start.getText ()) ;
    }
    public int getEnd(){
        return Integer.parseInt(jTextField_end.getText ());
    }
    public void findDTs(){
        String finalString1 = this.model.findDT(this.getStart (),this.getEnd());
        String finalString2 = this.model.findDTMin(this.getStart (),this.getEnd());
        this.jTextArea_findDT.setText(finalString1+"\n"+finalString2);
        this.map.onFindDTClicked ();
        repaint();
    }
    public void findFFs(){
        //FFTest.run_test (this.getStart (),this.getEnd ());
        String finalString1 = this.model.findFFmed(this.getStart (),this.getEnd ());
        String finalString2 = this.model.findFFhig (this.getStart (),this.getEnd ());
        this.jTextArea_findFF.setText(finalString1+"\n"+finalString2);
        this.map.onFindFFClicked ();
        repaint();
    }

}
