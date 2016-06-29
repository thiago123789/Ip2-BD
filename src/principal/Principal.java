package principal;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import poo.gui.JFLogin;

public class Principal {
    public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
                Calendar aux = Calendar.getInstance();
                int ano = aux.get(Calendar.YEAR);
                System.out.println(ano);
                
                

    int i = okcancel("Are your sure ?");
    System.out.println("ret : " + i);

  

  


    }
        
    public static int okcancel(String theMessage) {
            int result = JOptionPane.showConfirmDialog((Component) null, theMessage,
                 "alert", JOptionPane.OK_CANCEL_OPTION);
            System.out.println(result);
    return result;
  }
}
