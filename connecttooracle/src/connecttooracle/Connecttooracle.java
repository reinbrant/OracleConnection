/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connecttooracle;

/**
 *
 * @author Albrecht Arcangel
 */
public class Connecttooracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectDB.connect();
//        MainScreen ms = new MainScreen();
//        
//        ms.setVisible(true);
//        ms.setLocationRelativeTo(null);
        
        MainScreenAct msa = new MainScreenAct();
        msa.setVisible(true);
        msa.setLocationRelativeTo(null);
        
    }
    
}
