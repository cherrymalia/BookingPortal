
/**
 * @file BookingPortalUI.java
 * 
 * @author Malia Cherry
 *
 * @date Oct. 2022
 **/

 // Import statements
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.time.*;
import java.time.format.*;
import java.text.*;
import java.awt.event.*;
import java.awt.*;

/**
 * The BookingPortalUI class contains the GUI for the Booking Portal
 * application.
 * It is responsible for creating the GUI and handling all events.
 * 
 */
public class BookingPortalUI extends JFrame {

    DefaultTableModel table;

    /**
     * Constructor for the BookingPortalUI class.
     *
     * Creates a new BookingPortalUI object and calls the initComponents method.
     *
     * @param none
     */
    public BookingPortalUI() {
        String[] availableRooms = { "Standard", "Standard", "Standard", "Standard", "Standard",
                "Standard", "Standard", "Standard", "Standard", "Standard",
                "Junior", "Junior", "Junior", "Junior", "Junior", "Junior",
                "Luxury", "Luxury", "Luxury", "Luxury" };
        Integer[] roomNumbers = { 100, 101, 102, 103, 104,
                105, 106, 107, 108, 109,
                200, 201, 202, 203, 204,
                205, 300, 301, 302, 303 };
        initComponents();

        for (int i = 0; i < 20; i++) {
            switch (availableRooms[i]) {
                case "Standard": {
                    FillTable(roomNumbers[i], availableRooms[i], 150, false);
                    break;
                }
                case "Junior": {
                    FillTable(roomNumbers[i], availableRooms[i], 200, false);
                    break;
                }
                default: {
                    FillTable(roomNumbers[i], availableRooms[i], 240, false);
                }
            }
        }
    }

    /**
     * Fills the table with the room number, room type, and price.
     *
     * @param number The room number
     * @param type   The type of room
     * @param rate   The nightly rate for the room
     * @param booked Whether the room is booked or not
     */
    private void FillTable(Integer number, String type, Integer rate, Boolean booked) {
        table = (DefaultTableModel) roomList.getModel();
        Object[] rowData = { number, type, rate, booked };
        table.addRow(rowData);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     * @param none
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        datePanel = new JPanel();
        inLabel = new JLabel();
        OutLabel = new JLabel();
        inDate = new JFormattedTextField();
        outDate = new JFormattedTextField();
        updateButton = new JButton();
        infoPanel = new JPanel();
        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        selectorLabel = new JLabel();
        roomSelector = new JComboBox<>();
        firstName = new JTextField();
        lastName = new JTextField();
        outputPanel = new JPanel();
        nightsLabel = new JLabel();
        subtotalLabel = new JLabel();
        subtotal = new JTextField();
        numNights = new JTextField();
        infoLabel = new JLabel();
        totalLabel = new JLabel();
        grandTotal = new JTextField();
        bookButton = new JButton();
        scroll = new JScrollPane();
        roomList = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marriott Reservation System");
        setBounds(new Rectangle(0, 0, 0, 0));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setResizable(false);

        datePanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        inLabel.setLabelFor(inDate);
        inLabel.setText("Check-In Date:");
        inLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        OutLabel.setLabelFor(outDate);
        OutLabel.setText("Check-Out Date:");
        OutLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        inDate.setFormatterFactory(new DefaultFormatterFactory(
                new DateFormatter(new SimpleDateFormat("MM/dd/yyyy"))));
        inDate.setText("mm/dd/yyyy");
        inDate.setActionCommand("<Not Set>");
        inDate.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        inDate.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                inDateFocusLost(evt);
            }
        });

        outDate.setFormatterFactory(new DefaultFormatterFactory(
                new DateFormatter(new SimpleDateFormat("MM/dd/yyyy"))));
        outDate.setText("mm/dd/yyyy");
        outDate.setToolTipText("");
        outDate.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                outDateFocusLost(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        updateButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        GroupLayout datePanelLayout = new GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
                datePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(datePanelLayout.createSequentialGroup()
                                .addGroup(datePanelLayout
                                        .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(OutLabel, GroupLayout.PREFERRED_SIZE, 137,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(datePanelLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(datePanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(inDate, GroupLayout.PREFERRED_SIZE,
                                                                122, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(datePanelLayout
                                                                .createParallelGroup(
                                                                        GroupLayout.Alignment.LEADING)
                                                                .addGroup(datePanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(inLabel,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                108,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(datePanelLayout.createSequentialGroup()
                                                                        .addGap(21, 21, 21)
                                                                        .addComponent(outDate,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                122,
                                                                                GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(datePanelLayout.createSequentialGroup()
                                                        .addGap(46, 46, 46)
                                                        .addComponent(updateButton,
                                                                GroupLayout.PREFERRED_SIZE, 69,
                                                                GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(30, Short.MAX_VALUE)));
        datePanelLayout.setVerticalGroup(
                datePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(datePanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(inLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inDate, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(OutLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outDate, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(updateButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        infoPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        firstNameLabel.setLabelFor(firstName);
        firstNameLabel.setText("First Name: ");

        lastNameLabel.setLabelFor(lastName);
        lastNameLabel.setText("Last Name:");

        selectorLabel.setLabelFor(roomSelector);
        selectorLabel.setText("Room Type:");

        roomSelector.setModel(new DefaultComboBoxModel<>(
                new String[] { "", "Standard Room", "Junior Suite", "Luxury Suite" }));
        roomSelector.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                roomSelectorItemStateChanged(evt);
            }
        });

        firstName.setInheritsPopupMenu(true);

        GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addGap(0, 19, Short.MAX_VALUE)
                                                .addGroup(infoPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(firstName, GroupLayout.PREFERRED_SIZE,
                                                                200, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lastName, GroupLayout.PREFERRED_SIZE,
                                                                196, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(roomSelector,
                                                                GroupLayout.PREFERRED_SIZE, 194,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addGroup(infoPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(firstNameLabel,
                                                                GroupLayout.PREFERRED_SIZE, 107,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lastNameLabel,
                                                                GroupLayout.PREFERRED_SIZE, 100,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(selectorLabel,
                                                                GroupLayout.PREFERRED_SIZE, 106,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(firstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstName, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastName, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectorLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomSelector, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE)));

        outputPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        nightsLabel.setLabelFor(numNights);
        nightsLabel.setText("No. of Nights:");

        subtotalLabel.setLabelFor(subtotal);
        subtotalLabel.setText("Subtotal:");

        subtotal.setEditable(false);
        subtotal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        subtotal.setFocusable(false);

        numNights.setEditable(false);
        numNights.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        numNights.setFocusable(false);

        totalLabel.setText("Total:");

        grandTotal.setEditable(false);
        grandTotal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        grandTotal.setFocusable(false);

        GroupLayout outputPanelLayout = new GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
                outputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(outputPanelLayout.createSequentialGroup()
                                .addGroup(outputPanelLayout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(outputPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(nightsLabel)
                                                .addGap(6, 6, 6))
                                        .addGroup(GroupLayout.Alignment.TRAILING, outputPanelLayout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(outputPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(totalLabel)
                                                        .addComponent(subtotalLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(
                                        outputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(numNights, GroupLayout.PREFERRED_SIZE, 81,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(subtotal, GroupLayout.PREFERRED_SIZE, 81,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(grandTotal, GroupLayout.PREFERRED_SIZE, 81,
                                                        GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 121,
                                        GroupLayout.PREFERRED_SIZE)));
        outputPanelLayout.setVerticalGroup(
                outputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(outputPanelLayout.createSequentialGroup()
                                .addGroup(outputPanelLayout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(outputPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(outputPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numNights, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nightsLabel))
                                                .addGap(8, 8, 8)
                                                .addGroup(outputPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(subtotal, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(subtotalLabel))
                                                .addGap(8, 8, 8)
                                                .addGroup(outputPanelLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(grandTotal,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalLabel)))
                                        .addGroup(outputPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 91,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        bookButton.setText("Book");
        bookButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        bookButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                bookButtonMouseClicked(evt);
            }
        });

        roomList.setModel(new DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Room No.", "Room Type", "Cost/night", "Booked?"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        roomList.getTableHeader().setResizingAllowed(false);
        roomList.getTableHeader().setReorderingAllowed(false);
        roomList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                roomListMouseClicked(evt);
            }
        });
        scroll.setViewportView(roomList);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(bookButton, GroupLayout.PREFERRED_SIZE, 69,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(outputPanel, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(datePanel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(datePanel, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputPanel, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 172,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bookButton)
                                .addContainerGap(15, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    /**
     * Gets the number of days between two dates
     * 
     * @param startDate The check-in date
     * @param endDate   The check-out date
     */
    private int getDifference(LocalDate startDate, LocalDate endDate) {
        LocalDate today = LocalDate.now();

        if (startDate.isBefore(today) || endDate.isBefore(today)) {
            JOptionPane.showMessageDialog(null, "<html>Cannot be a date in the past</html>", "Invalid Dates",
                    JOptionPane.WARNING_MESSAGE);
            if (roomList.getSelectedRow() != -1) {
                roomList.clearSelection();
            }
            return 0;
        }
        Period nights = Period.between(startDate, endDate);
        if (nights.getMonths() != 0 || nights.getYears() != 0) {
            JOptionPane.showMessageDialog(null, "<html>Reservations cannot be longer than 30 days</html>", "Invalid Dates",
                    JOptionPane.WARNING_MESSAGE);
            if (roomList.getSelectedRow() != -1) {
                roomList.clearSelection();
            }
            return 0;
        } else if (nights.getDays() < 0) {
            JOptionPane.showMessageDialog(null, "<html>Select valid check-in and check-out dates</html>", "Invalid Dates",
                    JOptionPane.WARNING_MESSAGE);
            if (roomList.getSelectedRow() != -1) {
                roomList.clearSelection();
            }
            return 0;
        }
        return nights.getDays();
    }

    /**
     * Filters the rooms based on the user's selection
     * 
     * @param room The type of room selected
     */
    private void filter(String room) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(table);
        roomList.setRowSorter(sorter);

        switch (room) {
            case "Standard Room": {
                sorter.setRowFilter(RowFilter.regexFilter("Standard"));
                break;
            }
            case "Junior Suite": {
                sorter.setRowFilter(RowFilter.regexFilter("Junior"));
                break;
            }
            case "Luxury Suite": {
                sorter.setRowFilter(RowFilter.regexFilter("Luxury"));
                break;
            }
            default: {
                roomList.setRowSorter(sorter);
            }
        }
    }

    /**
     * Books the selected room and return the number of the room booked
     * 
     * @param none
     */
    private int makeReservation() {
        if (roomList.getSelectedRow() == -1) {
            return 0;
        } else {
            int modelRow = roomList.convertRowIndexToModel(roomList.getSelectedRow());
            String num = roomList.getModel().getValueAt(modelRow, 0).toString();
            String room = roomList.getModel().getValueAt(modelRow, 1).toString();
            boolean booked = (Boolean) roomList.getModel().getValueAt(modelRow, 3);
            String nameRegex = "^[a-zA-Z]+$", dateRegex = "^(1[0-2]|0[1-9])\\/(3[01]|[12][0-9]|0[1-9])\\/[0-9]{4}";

            if (!(firstName.getText().matches(nameRegex)) || !(lastName.getText().matches(nameRegex))) {
                return 1;
            } else if (!(inDate.getText().matches(dateRegex)) || !(outDate.getText().matches(dateRegex))) {
                return 2;
            } else if (numNights.getText().equals("") || subtotal.getText().equals("")) {
                return 3;
            } else {
                if (booked == true) {
                    return 4;
                } else {
                    roomList.getModel().setValueAt(true, modelRow, 3);
                    JOptionPane.showMessageDialog(null, "Booked by: " + firstName.getText() + " " + lastName.getText()
                            + "\nCheck-In Date: " + inDate.getText() + ", 3 p.m.\nCheck-Out Date: " + outDate.getText()
                            + ", 11 a.m.\nRoom: " + room + ", " + num + "\nTotal: " + grandTotal.getText(),
                            "Booking Confirmation", JOptionPane.PLAIN_MESSAGE);
                    firstName.setText("");
                    lastName.setText("");
                    inDate.setText("mm/dd/yyyy");
                    outDate.setText("mm/dd/yyyy");
                    numNights.setText("");
                    subtotal.setText("");
                    grandTotal.setText("");
                    roomSelector.setSelectedIndex(0);
                    infoLabel.setText("");
                    roomList.clearSelection();
                    return Integer.parseInt(num);
                }
            }
        }
    }

    /**
     * Books the selected room and displays a confirmation message if the room is
     * available and the user has entered valid information
     * 
     * @param evt The event that triggered the action
     */
    private void bookButtonMouseClicked(MouseEvent evt) {
        int result = makeReservation();
        switch (result) {
            case (0): {
                JOptionPane.showMessageDialog(null, "<html>Please select a room</html>", "Selection Required",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
            case (1): {
                JOptionPane.showMessageDialog(null, "<html>Enter first and last name</html>", "Invalid Name",
                        JOptionPane.WARNING_MESSAGE);
                break;
            }
            case (2): {
                JOptionPane.showMessageDialog(null, "<html>Enter check-in and check-out dates</html>", "Invalid Date",
                        JOptionPane.WARNING_MESSAGE);
                break;
            }
            case (3): {
                JOptionPane.showMessageDialog(null, "<html>Hit Update to confirm total</html>", "More Information",
                        JOptionPane.WARNING_MESSAGE);
                break;
            }
            case (4): {
                JOptionPane.showMessageDialog(null,
                        "<html>This room is already booked. Please select an available room.</html>", "Room Unavailable",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }

    /**
     * Updates the subtotal and grand total based on the number of nights
     * 
     * @param evt The event that triggered the action
     */
    private void updateButtonMouseClicked(MouseEvent evt) {
        double taxes = 0.08875, postTax;
        String checkIn = inDate.getText();
        String checkOut = outDate.getText();
        String regex = "^(1[0-2]|0[1-9])\\/(3[01]|[12][0-9]|0[1-9])\\/[0-9]{4}";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        NumberFormat money = NumberFormat.getCurrencyInstance();

        if (!checkIn.matches(regex)) {
            JOptionPane.showMessageDialog(null, "<html>Enter a valid check-in date<br/>Format: mm/dd/yyyy</html>",
                    "Invalid Check-In Date", JOptionPane.WARNING_MESSAGE);
        } else if (!checkOut.matches(regex)) {
            JOptionPane.showMessageDialog(null, "<html>Enter a valid check-out date<br/>Format: mm/dd/yyyy</html>",
                    "Invalid Check-Out Date", JOptionPane.WARNING_MESSAGE);
        } else {
            LocalDate start = LocalDate.parse(inDate.getText(), formatter);
            LocalDate finish = LocalDate.parse(outDate.getText(), formatter);
            int difference = getDifference(start, finish);

            if (difference == 0) {
                numNights.setText("");
            } else {
                numNights.setText("" + difference);
            }

            if (subtotal.getText().equals("")) {
                if (roomList.getSelectedRow() == -1) {
                    subtotal.setText("");
                } else {
                    int modelRow = roomList.convertRowIndexToModel(roomList.getSelectedRow());
                    Integer rate = (Integer) (roomList.getModel().getValueAt(modelRow, 2));
                    Integer preTax = rate * Integer.valueOf(numNights.getText());
                    subtotal.setText(money.format(preTax));
                    postTax = preTax.doubleValue() * taxes;
                    postTax += preTax.doubleValue();
                    grandTotal.setText(money.format(postTax));
                }
            }
        }

    }

    /**
     * Shows information about the selected room and calculates the subtotal and
     * total based on the number of nights
     * 
     * @param evt The event that triggered the action
     */
    private void roomListMouseClicked(MouseEvent evt) {
        Integer rate, preTax;
        double taxes = 0.08875, postTax;
        String selectedRoom;
        Boolean booked;
        int modelRow = roomList.convertRowIndexToModel(roomList.getSelectedRow());
        selectedRoom = roomList.getModel().getValueAt(modelRow, 1).toString();
        booked = (Boolean) roomList.getModel().getValueAt(modelRow, 3);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        if (booked) {
            infoLabel.setText("Unavailable");
        } else {
            switch (selectedRoom) {
                case "Standard": {
                    infoLabel.setText("<html>Standard Room:<br/>One Queen Bed</html>");
                    break;
                }
                case "Junior": {
                    infoLabel.setText("<html>Junior Room:<br/>One Queen Bed<br/>Two Sofas</html>");
                    break;
                }
                case "Luxury": {
                    infoLabel.setText(
                            "<html>Luxury Room:<br/>One Queen Bed<br/>Two Sofas<br/>Openable Glass Door</html>");
                    break;
                }
                default: {
                    infoLabel.setText("");
                }
            }
            if (!(numNights.getText().equals(""))) {
                rate = (Integer) (roomList.getModel().getValueAt(modelRow, 2));
                preTax = rate * Integer.valueOf(numNights.getText());
                subtotal.setText(money.format(preTax));
                postTax = preTax.doubleValue() * taxes;
                postTax += preTax.doubleValue();
                grandTotal.setText(money.format(postTax));
            } else {
                subtotal.setText("");
            }
        }
    }

    /**
     * Filters the table based on the selected room type
     * 
     * @param evt The event that triggered the action
     */
    private void roomSelectorItemStateChanged(ItemEvent evt) {
        String query = roomSelector.getSelectedItem().toString();

        filter(query);
    }

    /**
     * Ensures that the number of nights shown and the subtotal and total are
     * updated when the user changes the check-in date
     * 
     * @param evt The event that triggered the action
     */
    private void inDateFocusLost(FocusEvent evt) {
        String checkIn = inDate.getText();
        String checkOut = outDate.getText();
        String regex = "^(1[0-2]|0[1-9])\\/(3[01]|[12][0-9]|0[1-9])\\/[0-9]{4}";

        if (checkIn.matches(regex) && checkOut.matches(regex)) {
            if (!(subtotal.getText().equals(""))) {
                subtotal.setText("");
                grandTotal.setText("");
                numNights.setText("");
            }
        }
    }

    /**
     * Ensures that the number of nights shown and the subtotal and total are
     * updated when the user changes the check-out date
     * 
     * @param evt The event that triggered the action
     */
    private void outDateFocusLost(FocusEvent evt) {
        String checkIn = inDate.getText();
        String checkOut = outDate.getText();
        String regex = "^(1[0-2]|0[1-9])\\/(3[01]|[12][0-9]|0[1-9])\\/[0-9]{4}";

        if (checkIn.matches(regex) && checkOut.matches(regex)) {
            if (!(subtotal.getText().equals(""))) {
                subtotal.setText("");
                grandTotal.setText("");
                numNights.setText("");
            }
        }
    }

     // Variables declaration
    private JLabel OutLabel;
    private JButton bookButton;
    private JPanel datePanel;
    private JTextField firstName;
    private JLabel firstNameLabel;
    private JTextField grandTotal;
    private JFormattedTextField inDate;
    private JLabel inLabel;
    private JLabel infoLabel;
    private JPanel infoPanel;
    private JTextField lastName;
    private JLabel lastNameLabel;
    private JLabel nightsLabel;
    private JTextField numNights;
    private JFormattedTextField outDate;
    private JPanel outputPanel;
    private JTable roomList;
    private JComboBox<String> roomSelector;
    private JScrollPane scroll;
    private JLabel selectorLabel;
    private JTextField subtotal;
    private JLabel subtotalLabel;
    private JLabel totalLabel;
    private JButton updateButton;
}
