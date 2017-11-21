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
public class AddItems extends JFrame{
    public JPanel panel1;
    public JButton insertButton;
    public JTextField textField1;
    public JTextField textField2;

    public AddItems(){
        setTitle("Add New Item");
        getContentPane().add(panel1);

        pack();
        setVisible(true);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://datastore.ro:3306/CIS3374", "cis3374", "cis3374");
                    Statement sqlStmt = myConn.createStatement();
                    String sqlInsert = "insert into Coffee (Description, Price) values ('" + textField1.getText() + "', '" + Double.parseDouble(textField2.getText()) + "')";
                    sqlStmt.executeUpdate(sqlInsert);
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
