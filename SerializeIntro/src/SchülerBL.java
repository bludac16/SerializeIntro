
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
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
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Schüler s : klasse) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
    }
    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream o = new ObjectInputStream( new FileInputStream(f) );
        String string = (String) o.readObject();
        Date date     = (Date) o.readObject();
        
        System.out.println(string);
        System.out.println(date);
    }
    public void print()
    {
        for (Schüler s: klasse) {
            System.out.format("%s %s\n", s.getName(), s.getBirthday());
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
