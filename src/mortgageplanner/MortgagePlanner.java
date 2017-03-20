/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgageplanner;

/**
 *
 * @author Stuart
 */
public class MortgagePlanner {

    MainDisplay MainDisplay_ = new MainDisplay();
    Database d = new Database();
    
    public static void main(String[] args) {
        MortgagePlanner m = new MortgagePlanner();
        m.start();
    }
    
    private void start(){
        MainDisplay_.run();
    }
    
}
