import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by dch67 on 4/12/2017.
 */
public class Databases extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JButton selectButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;


    public Databases() throws SQLException {
        setTitle("My database management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel1);

        pack();
        setVisible(true);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://datastore.ro:3306/CIS3374","cis3374","cis3374");
                    Statement sqlStmt = myConn.createStatement();
                    String sqlSelect = "select * from Coffee";
                    ResultSet myRs = sqlStmt.executeQuery(sqlSelect);

                    DefaultListModel listModel = new DefaultListModel();

                    while(myRs.next()){
                        listModel.addElement(myRs.getInt("CoffeeID") + " " + myRs.getString("Description") + " " + myRs.getDouble("Price"));
                        list1.setModel(listModel);

                    }
                    myConn.close();


                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddItems();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateItems();

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteItems();

            }
        });


    }


    public static void main(String[] args){
        try {
            new Databases();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}