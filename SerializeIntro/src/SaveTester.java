
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class SaveTester {
    public static void main(String[] args) throws IOException {
        Schüler s1 = new Schüler("Hans", LocalDate.of(2000,3,1));
        Schüler s2 = new Schüler("Grete", LocalDate.of(1999,10,10));
        
        SchülerBL bl = new SchülerBL();
        try{
            bl.save(new File("./klasse.csv"));
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "This is a error message!");
        }
    }
}
