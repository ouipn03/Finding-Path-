package view;

import FordFulkerson.FFTest;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maps extends JPanel {

    private Image backgroundImage;
    public Model model;
    public View view;
    private boolean activeFindFF = false;
    public boolean getActiveFindFF(){
        return activeFindFF;
    }
    private boolean activeFindDT = false;
    public boolean getActiveFindDT(){
        return activeFindDT;
    }
    public Maps(View view){
        super();
        this.view = view;
        try {
            backgroundImage = new ImageIcon("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\map.jpg").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent( Graphics g){
            super.paintComponents ( g );
            Graphics2D g2d = ( Graphics2D ) g;
            if (backgroundImage != null) {
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
            Scanner scanner;
            try {
                Font font = new Font("Arial", Font.BOLD, 16);
                File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                scanner = new Scanner ( file1 );
                while ( scanner.hasNextLine ( ) ) {
                    String line = scanner.nextLine ( );
                    String[] values = line.split ( "," );
                    int lx1 =Integer.parseInt(values[0]) ;
                    int lx2 =Integer.parseInt(values[1]) ;
                    int x1 = Integer.parseInt ( values[ 4 ] );
                    int y1 = Integer.parseInt ( values[ 5 ] );
                    int x2 = Integer.parseInt ( values[ 6 ] );
                    int y2 = Integer.parseInt ( values[ 7 ] );
                    int weight = Integer.parseInt ( values[ 3 ] );
                    g2d.setStroke(new BasicStroke(weight));
                    g2d.setColor(Color.darkGray);
                    g2d.draw(new Line2D.Double(x1,y1,x2,y2));
//                    g2d.setColor(Color.WHITE);
//                    g2d.drawOval ( x1,y1,2,2 );
//                    g2d.drawOval ( x2,y2,2,2);
//                    g2d.setColor(Color.RED);
//                    g2d.setFont(font);
//                    g2d.drawString( String.valueOf ( lx1 ) , x1, y1);
//                    g2d.drawString( String.valueOf ( lx2 ) , x2, y2);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException ( ex );
            }


        try {
            Font font = new Font("Arial", Font.BOLD, 16);
            File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
            scanner = new Scanner ( file1 );
            while ( scanner.hasNextLine ( ) ) {
                String line = scanner.nextLine ( );
                String[] values = line.split ( "," );
                int lx1 =Integer.parseInt(values[0]) ;
                int lx2 =Integer.parseInt(values[1]) ;
                int x1 = Integer.parseInt ( values[ 4 ] );
                int y1 = Integer.parseInt ( values[ 5 ] );
                int x2 = Integer.parseInt ( values[ 6 ] );
                int y2 = Integer.parseInt ( values[ 7 ] );
                g2d.setColor(Color.WHITE);
                g2d.drawOval ( x1,y1,2,2 );
                g2d.drawOval ( x2,y2,2,2);
                g2d.setColor(Color.RED);
                g2d.setFont(font);
                g2d.drawString( String.valueOf ( lx1 ) , x1, y1);
                g2d.drawString( String.valueOf ( lx2 ) , x2, y2);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException ( ex );
        }
            model = new Model();

            if(activeFindDT){
                int start = this.view.getStart();
                int end = this.view.getEnd();
                ArrayList <Integer> paths = model.findDTs(start, end);
                for (int i = 0; i < paths.size() - 1; i++) {
                    int A = paths.get(i);
                    int B = paths.get(i+1);
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            int A1 =Integer.parseInt(values[ 0 ]) ;
                            int B1 =Integer.parseInt(values[ 1 ]) ;
                            if ( ( A== A1  && B== B1  ) ||  A1==A  && B1== B )  {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor (new Color(209, 232, 0));
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }



                ArrayList <Integer> paths1 = model.findDTsMin(start, end);
                for (int i = 0; i < paths1.size() - 1; i++) {
                    int A = paths1.get(i);
                    int B = paths1.get(i+1);
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            int A1 =Integer.parseInt(values[ 0 ]) ;
                            int B1 =Integer.parseInt(values[ 1 ]) ;
                            if ( ( A== A1  && B== B1  ) ||  A1==A  && B1== B )  {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor (new Color(50, 168, 105));
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            if(activeFindFF){
                int start = this.view.getStart();
                int end = this.view.getEnd();
                String paths1 = model.findFFsMed(start,end);
                ArrayList<Integer> resultList1 = extractNumbers(paths1);
                for (int i = 0; i < resultList1.size() - 1; i += 2) {
                    int A = resultList1.get ( i );
                    int B = resultList1.get ( i + 1 );
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            int A1 = Integer.parseInt(values[ 0 ]);
                            int B1 = Integer.parseInt(values[ 1 ]);
                            if ( ( A==A1  && B==B1  ) || ( A1==A  && B1 ==B  ) ) {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor ( new Color(225,113,0) );
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                String paths2 = model.findFFsHig(start,end);
                ArrayList<Integer> resultList2 = extractNumbers(paths2);
                for (int i = 0; i < resultList2.size() - 1; i += 2) {
                    int A = resultList2.get ( i );
                    int B = resultList2.get ( i + 1 );
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            int A1 = Integer.parseInt(values[ 0 ]);
                            int B1 = Integer.parseInt(values[ 1 ]);
                            if ( ( A==A1  && B==B1  ) || ( A1==A  && B1 ==B  ) ) {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor ( Color.RED );
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        }
            scanner.close ( );
    }
    public static ArrayList<Integer> extractNumbers(String input) {
        ArrayList<Integer> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result.add(Integer.parseInt(matcher.group()));
        }

        return result;
    }
    int countFF = 0;
    int countDT = 0;
    public void onFindFFClicked() {
        countFF++;
        if(countFF%2!=0)  this.activeFindFF = true;
        else this.activeFindFF = false;
    }
    public void onFindDTClicked() {
        countDT++;
        if(countDT%2!=0) this.activeFindDT = true;
        else this.activeFindDT = false;
    }
}
