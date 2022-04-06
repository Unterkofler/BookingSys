package WriteGUI;

import writeside.domain.ValueObjects.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import writeside.application.interfaces.HotelService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.UUID;

@Component
@Service
public final class WriteGUI implements ActionListener {

    @Autowired
    private HotelService hotelService;

    private JLabel labelCreateBooking, labelCancelBooking, labelFirstName, labelLastName, labelStartDate, labelEndDate,labelRoomNumber, labelBookingId;
    private JTextField textFieldFirstName, textFieldLastName, textFieldStartDate, textFieldEndDate, textFieldCapacity, textFieldRoomNumber, textFieldBookingId;
    private JButton buttonConfirm, cancelButton;
    private JPanel panel;
    private JFrame frame;

    public void start() {
        createBooking();
        cancelBooking();
    }


    public void createBooking(){
        panel = new JPanel();
        panel.setLayout(null);

        labelCreateBooking = new JLabel("Create a Booking");
        labelCreateBooking.setFont(labelCreateBooking.getFont().deriveFont(24f));
        labelCreateBooking.setBounds(100, 10, 200, 30);
        panel.add(labelCreateBooking);


        labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(100, 60, 70, 20);
        panel.add(labelFirstName);

        labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(100, 110, 70, 20);
        panel.add(labelLastName);

        labelStartDate = new JLabel("Start Date - Format: 2022-01-01");
        labelStartDate.setBounds(100, 160, 200, 20);
        panel.add(labelStartDate);

        labelEndDate = new JLabel("End Date - Format: 2022-01-01");
        labelEndDate.setBounds(100, 210, 200, 20);
        panel.add(labelEndDate);

        labelEndDate = new JLabel("Capacity");
        labelEndDate.setBounds(100, 260, 70, 20);
        panel.add(labelEndDate);

        labelRoomNumber = new JLabel("RoomNumber");
        labelRoomNumber.setBounds(100,310,200,20);
        panel.add(labelRoomNumber);

        buttonConfirm = new JButton("Book Room");
        buttonConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
        buttonConfirm.setBounds(100, 380, 100, 28);
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setBackground(Color.BLACK);
        buttonConfirm.addActionListener(this);
        panel.add(buttonConfirm);

        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldEndDate = new JTextField();
        textFieldStartDate = new JTextField();
        textFieldCapacity = new JTextField();
        textFieldRoomNumber = new JTextField();

        textFieldFirstName.setBounds(100, 80, 200, 28);
        textFieldLastName.setBounds(100, 130, 200, 28);
        textFieldStartDate.setBounds(100, 180, 200, 28);
        textFieldEndDate.setBounds(100, 230, 200, 28);
        textFieldCapacity.setBounds(100, 280, 200, 28);
        textFieldRoomNumber.setBounds(100,330,200,28);

        panel.add(textFieldFirstName);
        panel.add(textFieldLastName);
        panel.add(textFieldEndDate);
        panel.add(textFieldStartDate);
        panel.add(textFieldCapacity);
        panel.add(textFieldRoomNumber);

        frame = new JFrame("Achim's Hotel");
        //frame.setTitle("BookRoom");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonConfirm.addActionListener(e-> {
                try {
                    hotelService.createBooking(getFirstName(), getLastName(), new BookingId(UUID.randomUUID()), getStartDate(), getEndDate(), getCapacity(), getRoomNumber());
                    JOptionPane.showMessageDialog(null, "Booking created.");
                    textFieldFirstName.setText("");
                    textFieldLastName.setText("");
                    textFieldStartDate.setText("");
                    textFieldEndDate.setText("");
                    textFieldCapacity.setText("");
                    textFieldRoomNumber.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Booking can't be created.");
                    textFieldFirstName.setText("");
                    textFieldLastName.setText("");
                    textFieldStartDate.setText("");
                    textFieldEndDate.setText("");
                    textFieldCapacity.setText("");
                    textFieldRoomNumber.setText("");

                    ex.printStackTrace();
                }
            }
        );
    }

    public void cancelBooking(){

        labelCancelBooking = new JLabel("Cancel a Booking");
        labelCancelBooking.setFont(labelCancelBooking.getFont().deriveFont(24f));
        labelCancelBooking.setBounds(500, 10, 200, 30);
        panel.add(labelCancelBooking);

        labelBookingId = new JLabel("BookingId");
        labelBookingId.setBounds(500, 60, 70, 20);
        panel.add(labelBookingId);

        textFieldBookingId = new JTextField();
        textFieldBookingId.setBounds(500, 80, 200, 28);
        panel.add(textFieldBookingId);

        cancelButton = new JButton("Cancel Booking");
        cancelButton.setFont(new Font("Dialog", Font.PLAIN, 12));
        cancelButton.setBounds(500, 130, 150, 28);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        cancelButton.addActionListener(e -> {
                try {
                    hotelService.cancelBooking(getBookingId());
                    JOptionPane.showMessageDialog(null, "Booking canceled.");
                    textFieldBookingId.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Booking can't be canceled.");
                    textFieldBookingId.setText("");
                    ex.printStackTrace();
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

    public int getRoomNumber() {
        return Integer.parseInt(textFieldRoomNumber.getText());
    }

    public BookingId getBookingId() {
        return new BookingId(UUID.fromString(textFieldBookingId.getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}