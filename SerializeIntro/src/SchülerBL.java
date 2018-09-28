
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class SchülerBL extends AbstractListModel{

    private ArrayList<Schüler> klasse = new ArrayList<>();
    
    public void add(Schüler s)
    {
        klasse.add(s);
        fireIntervalAdded(this, klasse.size()-1, klasse.size()-1);
    }
    
    public void save(File f) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schüler s: klasse) {
            bw.write(s.getName());
            bw.write(";");
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public void load(File f) throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line = br.readLine())!= null)
        {
            String[] parts = line.split(";");
            klasse.add(new Schüler(parts[0], LocalDate.parse(parts[1])));
        }
    }
    public void print()
    {
        for (Schüler s: klasse) {
            System.out.format("%s %s\n",s.getName(), s.getBirthday());
        }
    }
    @Override
    public int getSize() {
        return klasse.size();
    }

    @Override
    public Object getElementAt(int i) {
        return klasse.get(i);
    }
    
}
