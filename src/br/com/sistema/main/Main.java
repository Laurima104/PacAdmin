package br.com.sistema.main;

import br.com.sistema.view.FrmLogin;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e){
            e.printStackTrace();
        }
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }
}
