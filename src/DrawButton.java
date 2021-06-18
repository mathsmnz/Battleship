import javax.swing.*;
import java.awt.*;

public class DrawButton {
    Font  defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal =    new Color(32,44,57);
    Color Charcoal =    new Color(40,56,69);
    Color LCharcoal =   new Color(52,73,91);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB =      new Color(255,51,31);
    Color Platinum =    new Color(235,235,235);
    Color SpringGreen = new Color(50,232,117);


    public JButton[][] drawButton(int x, int y, int i,JButton[][] gridPos, Container scr, Color color, String buttonLabel){
        for(int a = 0; a < 10; a++){
            String text  = buttonLabel + Integer.toString(a);
            gridPos[i][a] = new JButton(text); gridPos[i][a].setBounds (x, y, 50, 50) ;scr.add(gridPos[i][a]);
            gridPos[i][a].setFont(defaultFont);
            

            if(color == Charcoal){
                gridPos[i][a].setForeground(Platinum);
            }else{
                gridPos[i][a].setForeground(Platinum);
            }
            if((i % 2) == 0){
                if((a % 2) == 0){
                    gridPos[i][a].setBackground(color);
                }else{
                    gridPos[i][a].setBackground(LCharcoal);
                }
            }else{
                if((a % 2) != 0){
                    gridPos[i][a].setBackground(color);
                }else{
                    gridPos[i][a].setBackground(LCharcoal);
                }
            }


            x = x + 55;
        }
        return gridPos;
    }
}
