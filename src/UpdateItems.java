import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by D on 4/30/2017.
 */
public class UpdateItems extends JFrame {
    private JPanel panel1;
    private JButton updateButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;


    public UpdateItems(){

        setTitle("Update Existing Item");
        getContentPane().add(panel1);

        pack();
        setVisible(true);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://datastore.ro:3306/CIS3374", "cis3374", "cis3374");
                    Statement sqlStmt = myConn.createStatement();
                    String sqlUpdate = "UPDATE Coffee set Description='"+textField2.getText()+"', Price='"+Double.parseDouble(textField3.getText()) + "' WHERE CoffeeID = " + Integer.parseInt(textField1.getText());
                    sqlStmt.executeUpdate(sqlUpdate);
                    myConn.close();


                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });




    }

}

