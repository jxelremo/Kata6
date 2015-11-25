package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata6 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        
        String nameFile="emails.txt";
        ArrayList <Person> mailArray = MailListReader.reader(nameFile);
        ArrayList <Person1> lista = Person1Loader.read();
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailArray);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder(lista);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        //Histogram<String> histo = MailHistogramBuilder.build(mailArray);   
        //new HistogramDisplay(histo).execute();
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> peso = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters,"CARACTER").execute();
        new HistogramDisplay(domains1,"DOMINIOS").execute();
        new HistogramDisplay(domains1,"PESOS").execute();

        System.out.println("Fin");
    }   
}