
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class LoadTester {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
    SchülerBL bl = new SchülerBL();
    bl.load(new File("./klasse.bin"));
}
}