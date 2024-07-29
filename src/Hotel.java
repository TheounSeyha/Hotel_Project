import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Hotel extends Frame implements ActionListener {

    //Create object of all components
    private Label id = new Label("Reservation ID:");
    private TextField txtId = new TextField();
    private Label clientId = new Label("Client ID:");
    private TextField txtClientId = new TextField();
    private Label roomNo = new Label("Room No:");
    private TextField txtRoomNo= new TextField();
    private Button add = new Button("Add New");
    private Button edit = new Button("Edit");
    private Button remove = new Button("Remove");
    private Button clearField = new Button("Clear Field");
    private Button refresh = new Button("Refresh");
    private Label hotelReservation = new Label("Hotel Reservation");
    private Label dateIn =  new Label("Date In");
    private Label dateOut = new Label("Date Out");
    private JComboBox<String> hourComboBoxIn;
    private  JComboBox<String> hourComboBoxOut;
    private JDatePickerImpl datePickerIn;
    private JDatePickerImpl datePickerOut;
    private JComboBox<String> minuteComboBoxIn;
    private JComboBox<String> minuteComboBoxOut;

    //Header of table
    String[] header = {"ReservationID","ClientID","RoomNumber","DateIn","DateOut\n"};
    DefaultTableModel tableModel = new DefaultTableModel(header,0);
    JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);

    public Hotel(){

        //set panel
        setSize(1000,500);
        setVisible(true);
        setBackground(Color.GREEN);
        setLayout(null);
        setLocationRelativeTo(null);
        //create windowListener for closing window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Date Picker
        UtilDateModel modelIn = new UtilDateModel();
        UtilDateModel modelOut = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanelIn = new JDatePanelImpl(modelIn, p);
        datePickerIn = new JDatePickerImpl(datePanelIn, new DateLabelFormatter());

        JDatePanelImpl datePanelOut = new JDatePanelImpl(modelOut, p);
        datePickerOut = new JDatePickerImpl(datePanelOut, new DateLabelFormatter());
        add(datePanelIn);
        add(datePanelOut);
        add(datePickerOut);
        add(datePickerIn);

        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        hourComboBoxIn = new JComboBox<>(hours);
        hourComboBoxOut = new JComboBox<>(hours);
        add(hourComboBoxIn);
        add(hourComboBoxOut);

        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        minuteComboBoxIn = new JComboBox<>(minutes);
        minuteComboBoxOut = new JComboBox<>(minutes);
        add(minuteComboBoxIn);
        add(minuteComboBoxOut);

        //add all component
        add(id);
        add(txtId);
        add(clientId);
        add(txtClientId);
        add(roomNo);
        add(txtRoomNo);
        add(dateIn);
        add(dateOut);
        add(add);
        add(edit);
        add(remove);
        add(clearField);
        add(refresh);
        add(hotelReservation);
        add(scrollPane);

        //set place of all component
        id.setBounds(100,100,100,30);
        txtId.setBounds(210,100,130,30);
        clientId.setBounds(100,150,100,30);
        txtClientId.setBounds(210,150,130,30);
        roomNo.setBounds(100,200,100,30);
        txtRoomNo.setBounds(210,200,130,30);

        datePickerIn.setBounds(180,250,120,20);
        hourComboBoxIn.setBounds(300,250,40,20);
        minuteComboBoxIn.setBounds(340,250,40,20);

        datePickerOut.setBounds(180,300,120,20);
        hourComboBoxOut.setBounds(300,300,40,20);
        minuteComboBoxOut.setBounds(340,300,40,20);

        dateIn.setBounds(100,250,80,30);
        dateOut.setBounds(100,300,80,30);

        add.setBounds(100,350,80,30);
        edit.setBounds(195,350,50,30);
        remove.setBounds(260,350,80,30);
        clearField.setBounds(100,400,240,30);
        scrollPane.setBounds(390,100,540,280);
        refresh.setBounds(390,400,540,30);
        hotelReservation.setBounds(400,50,200,30);

        //set color
        remove.setBackground(Color.pink);
        add.setBackground(Color.pink);
        refresh.setBackground(Color.pink);
        edit.setBackground(Color.pink);
        clearField.setBackground(Color.pink);

        //create font object
        Font font = new Font("Serif", Font.BOLD, 25);
        Font buttonFont = new Font("SansSerif", Font.ITALIC, 18);
        Font textFieldFont = new Font("Serif", Font.BOLD, 14);

        //add font to components
        edit.setFont(buttonFont);
        add.setFont(buttonFont);
        remove.setFont(buttonFont);
        refresh.setFont(buttonFont);
        clearField.setFont(buttonFont);
        hotelReservation.setFont(font);
        id.setFont(textFieldFont);
        clientId.setFont(textFieldFont);
        roomNo.setFont(textFieldFont);
        dateIn.setFont(textFieldFont);
        dateOut.setFont(textFieldFont);

        add.addActionListener(this);
        clearField.addActionListener(this);
        remove.addActionListener(this);
        edit.addActionListener(this);
        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtClientId.requestFocus();
                }
            }
        });
        txtClientId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtRoomNo.requestFocus();
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    txtId.setText(String.valueOf(tableModel.getValueAt(selectedRow, 0)));
                    txtClientId.setText(String.valueOf(tableModel.getValueAt(selectedRow, 1)));
                    txtRoomNo.setText(String.valueOf(tableModel.getValueAt(selectedRow, 2)));

                    String[] dateInParts = String.valueOf(tableModel.getValueAt(selectedRow, 3)).split("/");
                    String[] dateInTimeParts = dateInParts[1].split(":");
                    try {
                        java.util.Date dateIn = new SimpleDateFormat("yyyy-MM-dd").parse(dateInParts[0]);
                        datePickerIn.getModel().setDate(dateIn.getYear() + 1900, dateIn.getMonth(), dateIn.getDate());
                        datePickerIn.getModel().setSelected(true);
                        hourComboBoxIn.setSelectedItem(dateInTimeParts[0]);
                        minuteComboBoxIn.setSelectedItem(dateInTimeParts[1]);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    String[] dateOutParts = String.valueOf(tableModel.getValueAt(selectedRow, 4)).split("/");
                    String[] dateOutTimeParts = dateOutParts[1].split(":");
                    try {
                        java.util.Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse(dateOutParts[0]);
                        datePickerOut.getModel().setDate(dateOut.getYear() + 1900, dateOut.getMonth(), dateOut.getDate());
                        datePickerOut.getModel().setSelected(true);
                        hourComboBoxOut.setSelectedItem(dateOutTimeParts[0]);
                        minuteComboBoxOut.setSelectedItem(dateOutTimeParts[1]);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= txtId.getText();
                String clientId= txtClientId.getText();
                String roomNo = txtRoomNo.getText();

                java.util.Date selectedDateIn = (java.util.Date) datePickerIn.getModel().getValue();
                String hourIn = (String) hourComboBoxIn.getSelectedItem();
                String minuteIn = (String) minuteComboBoxIn.getSelectedItem();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDateIn = sdf.format(selectedDateIn);

                java.util.Date selectedDateOut = (java.util.Date) datePickerOut.getModel().getValue();
                String hourOut = (String) hourComboBoxOut.getSelectedItem();
                String minuteOut = (String) minuteComboBoxOut.getSelectedItem();
                String formattedDateOut = sdf.format(selectedDateOut);
                tableModel.addRow(new Object[]{id,clientId,roomNo,formattedDateIn+ "/" +hourIn+":"+minuteIn,formattedDateOut+ "/" +hourOut+":"+minuteOut});

                clear();
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDateIn = sdf.format(datePickerIn.getModel().getValue());
                    String formattedDateOut = sdf.format(datePickerOut.getModel().getValue());
                    tableModel.setValueAt(txtId.getText(), selectedRow, 0);
                    tableModel.setValueAt(txtClientId.getText(), selectedRow, 1);
                    tableModel.setValueAt(txtRoomNo.getText(), selectedRow, 2);
                    tableModel.setValueAt(formattedDateIn + "/" + hourComboBoxIn.getSelectedItem() +":"+minuteComboBoxIn.getSelectedItem(), selectedRow, 3);
                    tableModel.setValueAt(formattedDateOut + "/" + hourComboBoxOut.getSelectedItem() +":"+minuteComboBoxOut.getSelectedItem(), selectedRow, 4);
                    clear();
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==clearField){
            clear();
        }

        if (e.getSource() == edit) {

        }

        if (e.getSource() == remove) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                clear();
            }
        }
    }

    void clear() {
        txtId.setText("");
        txtRoomNo.setText("");
        txtClientId.setText("");
        hourComboBoxIn.setSelectedIndex(0);
        hourComboBoxOut.setSelectedIndex(0);
        minuteComboBoxIn.setSelectedIndex(0);
        minuteComboBoxOut.setSelectedIndex(0);
    }

    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
}
