package GUI;

import eventside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public final class GUI implements ActionListener {
    @Autowired
    private RepositoryWrite storageWrite = new RepositoryWriteImpl();

    @Autowired
    private HotelService hotelService;

    private JLabel labelFirstName, labelLastName, labelStartDate, labelEndDate;
    private JTextField textFieldFirstName, textFieldLastName, textFieldStartDate, textFieldEndDate, textFieldCapacity;
    private JButton buttonConfirm;
    private JPanel panel;
    private JFrame frame;
   // private static String firstName, lastName, startDate, endDate, capacity;

   /* @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = textFieldFirstName.getText();
        String lastName = textFieldLastName.getText();
        String startDate = textFieldStartDate.getText();
        String endDate = textFieldEndDate.getText();
        String capacity = textFieldCapacity.getText();
    } */

    public void start() {

        buttonConfirm = new JButton("Confirm");

        panel = new JPanel();

        panel.setLayout(null);

        labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(100, 10, 70, 20);
        panel.add(labelFirstName);

        labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(100, 60, 70, 20);
        panel.add(labelLastName);

        labelStartDate = new JLabel("Start Date - Format: 2022-01-01");
        labelStartDate.setBounds(100, 110, 70, 20);
        panel.add(labelStartDate);

        labelEndDate = new JLabel("End Date - Format: 2022-01-01");
        labelEndDate.setBounds(100, 160, 70, 20);
        panel.add(labelEndDate);

        labelEndDate = new JLabel("Capacity");
        labelEndDate.setBounds(100, 210, 70, 20);
        panel.add(labelEndDate);


        buttonConfirm = new JButton("Book Room");
        buttonConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
        buttonConfirm.setBounds(100, 300, 100, 28);
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setBackground(Color.BLACK);
        buttonConfirm.addActionListener(this);
        panel.add(buttonConfirm);

        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldEndDate = new JTextField();
        textFieldStartDate = new JTextField();
        textFieldCapacity = new JTextField();

        textFieldFirstName.setBounds(100, 30, 200, 28);
        textFieldLastName.setBounds(100, 80, 200, 28);
        textFieldStartDate.setBounds(100, 130, 200, 28);
        textFieldEndDate.setBounds(100, 180, 200, 28);
        textFieldCapacity.setBounds(100, 230, 200, 28);

        panel.add(textFieldFirstName);
        panel.add(textFieldLastName);
        panel.add(textFieldEndDate);
        panel.add(textFieldStartDate);
        panel.add(textFieldCapacity);

        frame = new JFrame("BookRoom");
        //frame.setTitle("BookRoom");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    hotelService.createBooking(getFirstName(), getLastName(), new BookingId(UUID.randomUUID()), getStartDate(), getEndDate(), getCapacity());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public String getFirstName() {
        return textFieldFirstName.getText();
    }

    public String getLastName() {
        return textFieldLastName.getText();
    }

    public LocalDate getStartDate() {
        return LocalDate.parse(textFieldStartDate.getText());
    }

    public LocalDate getEndDate() {
        return LocalDate.parse(textFieldEndDate.getText());
    }

    public int getCapacity() {
        return Integer.parseInt(textFieldCapacity.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}