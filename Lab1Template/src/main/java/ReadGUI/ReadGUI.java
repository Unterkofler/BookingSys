package ReadGUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import readside.DTO.BookingDTO;
import readside.repository.RepositoryRead;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
@Service
public class ReadGUI implements ActionListener {


    private JLabel labelGetBookings, labelStartDate, labelEndDate;
    private JTextField textFieldStartDate, textFieldEndDate;
    private JButton buttonConfirm, cancelButton;
    private JPanel panel;
    private JFrame frame;

    @Autowired
    RepositoryRead repositoryRead;

    public void start(){
        panel = new JPanel();
        panel.setLayout(null);

        getBookings();


        frame = new JFrame("Achim's Hotel");
        //frame.setTitle("BookRoom");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void getBookings() {
        labelGetBookings = new JLabel("Get Bookings");
        labelGetBookings.setFont(labelGetBookings.getFont().deriveFont(24f));
        labelGetBookings.setBounds(100, 10, 200, 30);
        panel.add(labelGetBookings);

        labelStartDate = new JLabel("Start Date - Format: 2022-01-01");
        labelStartDate.setBounds(100, 60, 200, 20);
        panel.add(labelStartDate);

        labelEndDate = new JLabel("End Date - Format: 2022-01-01");
        labelEndDate.setBounds(100, 110, 200, 20);
        panel.add(labelEndDate);

        textFieldStartDate = new JTextField();
        textFieldEndDate = new JTextField();

        textFieldStartDate.setBounds(100, 80, 200, 28);
        textFieldEndDate.setBounds(100, 130, 200, 28);

        panel.add(textFieldEndDate);
        panel.add(textFieldStartDate);

        buttonConfirm = new JButton("Book Room");
        buttonConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
        buttonConfirm.setBounds(100, 160, 100, 28);
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setBackground(Color.BLACK);
        buttonConfirm.addActionListener(this);
        panel.add(buttonConfirm);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("BookingId");
        model.addColumn("FirstName");
        model.addColumn("LastName");
        model.addColumn("StartDate");
        model.addColumn("EndDate");
        model.addColumn("RoomId");
        JTable table = new JTable(model);

        buttonConfirm.addActionListener(e-> {

            int rows = model.getRowCount();
            for(int i = rows - 1; i >=0; i--)
            {
                model.removeRow(i);
            }

                    try {
                        List<BookingDTO> list = repositoryRead.getBookingsInPeriod(getStartDate(), getEndDate());
                        for (BookingDTO booking: list) {
                            model.addRow(new Object[]{booking.getBookingId().getBookingId(), booking.getCustomer().getFirstName(),
                                    booking.getCustomer().getLastName(), booking.getStartDate(),booking.getEndDate(),booking.getRoomId()});
                        }
                        table.setBounds(100, 250, 500, 200);
                        panel.add(table);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "No bookings found.");
                        textFieldStartDate.setText("");
                        textFieldEndDate.setText("");
                        ex.printStackTrace();
                    }
                }
        );


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public LocalDate getStartDate() {
        return LocalDate.parse(textFieldStartDate.getText());
    }

    public LocalDate getEndDate() {
        return LocalDate.parse(textFieldEndDate.getText());
    }
}
