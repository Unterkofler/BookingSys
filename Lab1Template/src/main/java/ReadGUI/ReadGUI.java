package ReadGUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import readside.DTO.BookingDTO;
import readside.DTO.RoomDTO;
import readside.repository.RepositoryRead;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

@Component
@Service
public class ReadGUI implements ActionListener {


    private JLabel labelGetBookings,labelGetFreeRooms, labelStartDate, labelEndDate, labelRoomStartDate, labelRoomEndDate, labelCapacity;
    private JTextField textFieldStartDate, textFieldEndDate, textFieldRoomStartDate, textFieldRoomEndDate, textFieldCapacity;
    private JButton buttonConfirm, getRooms;
    private JPanel panel;
    private JFrame frame;

    @Autowired
    RepositoryRead repositoryRead;

    public void start(){
        panel = new JPanel();
        panel.setLayout(null);

        getBookings();
        getFreeRooms();

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

        buttonConfirm = new JButton("Get Bookings");
        buttonConfirm.setFont(new Font("Dialog", Font.PLAIN, 12));
        buttonConfirm.setBounds(100, 180, 100, 28);
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
        model.addColumn("Room Number");
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
                                    booking.getCustomer().getLastName(), booking.getStartDate(),booking.getEndDate(),booking.getRoomNumber()});
                        }

                        JScrollPane scrollPane = new JScrollPane(table);
                        scrollPane.setBounds(100, 300, 500, 200);
                        scrollPane.setVisible(true);
                        panel.add(scrollPane);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "No bookings found.");
                        textFieldStartDate.setText("");
                        textFieldEndDate.setText("");
                        ex.printStackTrace();
                    }
                }
        );


    }

    public void getFreeRooms() {
        labelGetFreeRooms = new JLabel("Get Rooms");
        labelGetFreeRooms.setFont(labelGetFreeRooms.getFont().deriveFont(24f));
        labelGetFreeRooms.setBounds(800, 10, 200, 30);
        panel.add(labelGetFreeRooms);

        labelRoomStartDate = new JLabel("Start Date - Format: 2022-01-01");
        labelRoomStartDate.setBounds(800, 60, 70, 20);
        panel.add(labelRoomStartDate);

        labelRoomEndDate = new JLabel("End Date - Format: 2022-01-01");
        labelRoomEndDate.setBounds(800, 110, 70, 20);
        panel.add(labelRoomEndDate);

        labelCapacity = new JLabel("Capacity");
        labelCapacity.setBounds(800, 160, 70, 20);
        panel.add(labelCapacity);

        textFieldRoomStartDate = new JTextField();
        textFieldRoomStartDate.setBounds(800, 80, 200, 28);
        panel.add(textFieldRoomStartDate);

        textFieldRoomEndDate = new JTextField();
        textFieldRoomEndDate.setBounds(800, 130, 200, 28);
        panel.add(textFieldRoomEndDate);

        textFieldCapacity = new JTextField();
        textFieldCapacity.setBounds(800, 180, 200, 28);
        panel.add(textFieldCapacity);


        getRooms = new JButton("Get Rooms");
        getRooms.setFont(new Font("Dialog", Font.PLAIN, 12));
        getRooms.setBounds(800, 230, 150, 28);
        getRooms.setForeground(Color.WHITE);
        getRooms.setBackground(Color.BLACK);
        getRooms.addActionListener(this);
        panel.add(getRooms);

        DefaultTableModel modelRooms = new DefaultTableModel();
        modelRooms.addColumn("Room Number");
        modelRooms.addColumn("Capacity");
        JTable table = new JTable(modelRooms);

        getRooms.addActionListener(e-> {

                    int rows = modelRooms.getRowCount();
                    for(int i = rows - 1; i >=0; i--)
                    {
                        modelRooms.removeRow(i);
                    }

                    try {
                        List<RoomDTO> list = repositoryRead.getFreeRooms(getRoomStartDate(),getRoomEndDate(),getCapacity());
                        for (RoomDTO room: list) {
                            modelRooms.addRow(new Object[]{room.getRoomNumber(), room.getCapacity()});
                        }


                        JScrollPane scrollPane = new JScrollPane(table);
                        scrollPane.setBounds(800, 300, 500, 200);
                        scrollPane.setVisible(true);
                        panel.add(scrollPane);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "No free Rooms found.");
                        textFieldRoomStartDate.setText("");
                        textFieldRoomEndDate.setText("");
                        textFieldCapacity.setText("");
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

    public LocalDate getRoomStartDate() {
        return LocalDate.parse(textFieldRoomStartDate.getText());
    }

    public LocalDate getRoomEndDate() {
        return LocalDate.parse(textFieldRoomEndDate.getText());
    }

    public int getCapacity() {
        return Integer.parseInt(textFieldCapacity.getText());
    }
}
