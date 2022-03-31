package GUI;

import eventside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import writeside.application.interfaces.HotelService;
import writeside.application.interfaces.RepositoryWrite;
import writeside.repository.RepositoryWriteImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.UUID;

@Component
@Service
public final class GUI implements ActionListener{
    @Autowired
    private RepositoryWrite storageWrite = new RepositoryWriteImpl();

    @Autowired
    private HotelService hotelService;

    private JLabel labelFirstName, labelLastName, labelStartDate, labelEndDate;
    private JTextField textFieldFirstName, textFieldLastName, textFieldStartDate, textFieldEndDate;
    private JButton buttonConfirm;
    private JPanel panel;
    private JFrame frame;
    private static String firstName, lastName, startDate, endDate;

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = textFieldFirstName.getText();
        String lastName = textFieldLastName.getText();
        String startDate = textFieldStartDate.getText();
        String endDate = textFieldEndDate.getText();

      //  storageWrite.add(new Customer(firstName, lastName));
        JOptionPane.showMessageDialog(null, "firstName: " + firstName + '\n' +
                                                                    "lastName: " + lastName + '\n' +
                                                                    "startDate: " + startDate + '\n' +
                                                                    "endDate: " + endDate);
    }

    public void start(){

        buttonConfirm = new JButton("Confirm");

        panel = new JPanel();

        panel.setLayout(null);

        labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(100, 10,70,20);
        panel.add(labelFirstName);

        labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(100,60,70,20);
        panel.add(labelLastName);

        labelStartDate = new JLabel("Start Date");
        labelStartDate.setBounds(100, 110, 70,20);
        panel.add(labelStartDate);

        labelEndDate = new JLabel("End Date");
        labelEndDate.setBounds(100, 160, 70,20);
        panel.add(labelEndDate);




        buttonConfirm = new JButton("Login");
        buttonConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
        buttonConfirm.setBounds(100, 230, 100, 28);
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setBackground(Color.BLACK);
        buttonConfirm.addActionListener(this);
        panel.add(buttonConfirm);

        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldEndDate = new JTextField();
        textFieldStartDate = new JTextField();

        textFieldFirstName.setBounds(100,30,200,28);
        textFieldLastName.setBounds(100,80,200,28);
        textFieldStartDate.setBounds(100,130,200,28);
        textFieldEndDate.setBounds(100,180,200,28);

        panel.add(textFieldFirstName);
        panel.add(textFieldLastName);
        panel.add(textFieldEndDate);
        panel.add(textFieldStartDate);

        //hier kommt die Exception Achim!!!
        frame = new JFrame("BookRoom");
        //frame.setTitle("BookRoom");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    hotelService.createBooking("Tobias","Kurz",new BookingId(UUID.randomUUID()), LocalDate.now(),LocalDate.now(),2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}