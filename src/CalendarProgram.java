/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arturo III
 */

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import sms.SMS;

public class CalendarProgram{
    
        ArrayList<SMS> events;
	View nv;
        
        /**** Day Components ****/
	public int yearBound, monthBound, dayBound, yearToday, monthToday;

        /**** Swing Components ****/
        public JLabel monthLabel, yearLabel;
	public JButton btnPrev, btnNext, btnEvent, btnDelete;   //added btnEvent& btnDelete
        public JComboBox cmbYear;
	public JFrame frmMain;
	public Container pane;
	public JScrollPane scrollCalendarTable;
	public JPanel calendarPanel;
        
        /**** Calendar Table Components ***/
	public JTable calendarTable;
        public DefaultTableModel modelCalendarTable;
        
        public void refreshCalendar(int month, int year)
        {        
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, i, j;
			
                btnEvent.setEnabled(true);
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);   //added btnEvent
                btnDelete.setEnabled(true); //add btnDelete
		if (month == 0 && year <= yearBound-10)
                    btnPrev.setEnabled(false);
		if (month == 11 && year >= yearBound+100)
                    btnNext.setEnabled(false);
                
		monthLabel.setText(months[month]);
		monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 360, 50);
                
		cmbYear.setSelectedItem(""+year);
		
		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);
		
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (i = 1; i <= nod; i++)
                {
			int row = new Integer((i+som-2)/7);
			int column  =  (i+som-2)%7;
			modelCalendarTable.setValueAt(i, row, column);
		}

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
	}
        
        public void addEvent(SMS e) {
            events.add(e);
        }
        
        public void removeEvent(SMS e) {
            events.remove(e);
        }
        
	public CalendarProgram(ArrayList<SMS> events, View view)
        {
		try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
		catch (Exception e) {}
                
                this.events = events;
                this.nv = view;
                
		frmMain = new JFrame ("Calendar Application");
                frmMain.setSize(660, 750);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		monthLabel = new JLabel ("January");
		yearLabel = new JLabel ("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
                btnEvent = new JButton ("Add Event");  //added btnEvent
                btnDelete = new JButton ("Delete Event"); //delete btnDelete
		modelCalendarTable = new DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return true;
                    }

                };
                
		calendarTable = new JTable(modelCalendarTable); //The ff. are added for mouse clicked function to get specific cell in calendar
                Vector selectedCells = new Vector<int[]>();//int[]because every entry will store {cellX,cellY}
                 
                MouseListener tableMouseListener = new MouseAdapter() {
                    @Override
                        public void mouseClicked(MouseEvent e) {
                            EventView ev = new EventView();
                            ev.setVisible(true);
                           int row = calendarTable.rowAtPoint(e.getPoint());//get mouse-selected row
                           int col = calendarTable.columnAtPoint(e.getPoint());//get mouse-selected col
                           int[] newEntry = new int[]{row,col};//{row,col}=selected cell 
                           System.out.println("Row: " + row + "Column: " + col); //kulang ng 1 row and column sa pagpoint
                           //label.setText( "Cell Value at : Row:"+ row+" | Column:"+col+" is " + getValueAt(row,col)); //add label at lower part of calendar what the day and month is
                            }
                         
                 };
                calendarTable.addMouseListener(tableMouseListener); //End of added for mouseclicked function
                
               
                
                
		scrollCalendarTable = new JScrollPane(calendarTable);
		calendarPanel = new JPanel(null);

		calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
		
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
                btnEvent.addActionListener(new btnEvent_Action());
                btnDelete.addActionListener(new btnDelete_Action());
               
		
		pane.add(calendarPanel);
		calendarPanel.add(monthLabel);
		calendarPanel.add(yearLabel);
		calendarPanel.add(cmbYear);
		calendarPanel.add(btnPrev);
		calendarPanel.add(btnNext);
		calendarPanel.add(scrollCalendarTable);
                calendarPanel.add(btnEvent);
                 calendarPanel.add(btnDelete);
		
                calendarPanel.setBounds(0, 0, 640, 670);
                monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 200, 50);
		yearLabel.setBounds(20, 610, 160, 40);
		cmbYear.setBounds(100, 610, 160, 40);
		btnPrev.setBounds(20, 50, 100, 50);
		btnNext.setBounds(520, 50, 100, 50);
		scrollCalendarTable.setBounds(20, 100, 600, 500);
                btnEvent.setBounds(460, 610, 150, 40);
                btnDelete.setBounds(300, 610, 150, 40);
                
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		GregorianCalendar cal = new GregorianCalendar();
		dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
		monthBound = cal.get(GregorianCalendar.MONTH);
		yearBound = cal.get(GregorianCalendar.YEAR);
		monthToday = monthBound; 
		yearToday = yearBound;
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			modelCalendarTable.addColumn(headers[i]);
		}
		
		calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);

		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(76);
		modelCalendarTable.setColumnCount(7);
		modelCalendarTable.setRowCount(6);
		
		for (int i = yearBound-100; i <= yearBound+100; i++)
                {
			cmbYear.addItem(String.valueOf(i));
		}
                
               
		
		refreshCalendar (monthBound, yearBound); //Refresh calendar
                
               
	}
	

	class btnPrev_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 0)
                        {
				monthToday = 11;
				yearToday -= 1;
			}
			else
                        {
				monthToday -= 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class btnNext_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 11)
                        {
				monthToday = 0;
				yearToday += 1;
			}
			else
                        {
				monthToday += 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class cmbYear_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (cmbYear.getSelectedItem() != null)
                        {
				String b = cmbYear.getSelectedItem().toString();
				yearToday = Integer.parseInt(b);
				refreshCalendar(monthToday, yearToday);
			}
		}
	}
        
        class btnEvent_Action extends JFrame implements ActionListener //added for event
        {
            private JLabel enterDate, enterMonth, enterYear, enterEvent, enterColor;
            private JTextField day,month,year,event,color;
            private JButton click;
            private int storeDate = 0;
            private String storeMonth = "";
            private int storeYear = 0;
            private String storeEvent = "";
            private String storeColor = "";
            
            public btnEvent_Action(){
                setLayout(null);
                setSize(350, 300);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                enterDate = new JLabel("Enter the date: ");
                enterMonth = new JLabel("Enter the month: ");
                enterYear = new JLabel("Enter the year: ");
                enterEvent = new JLabel("Name the event: ");
                enterColor = new JLabel("Specify the color: ");
                
                click= new JButton("Set Date");
                
                day = new JTextField();
                month = new JTextField();
                year = new JTextField();
                event = new JTextField();
                color = new JTextField();
                
                enterDate.setBounds(60, 30, 120, 30);
                enterMonth.setBounds(60, 60, 120, 30);
                enterYear.setBounds(60, 90, 120, 30);
                enterEvent.setBounds(60, 120, 120, 30);
                enterColor.setBounds(60, 150, 120, 30);
                
                day.setBounds(150, 30 , 120, 30);
                month.setBounds(150, 60 , 120, 30);
                year.setBounds(150, 90 , 120, 30);
                event.setBounds(150, 120 , 120, 30);
                color.setBounds(150, 150 , 120, 30);
                click.setBounds( 180, 180, 80, 50);
                click.addActionListener(this);
                
                add(click);
                add(enterDate);
                add(enterMonth);
                add(enterYear);
                add(enterEvent);
                add(enterColor);
                add(day);
                add(month);
                add(year);
                add(event);
                add(color);
                
               
                setVisible(true);
              
               
            }
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                if(e.getSource() == click){

                    storeMonth = month.getText();
                    storeEvent = event.getText();
                    storeColor = color.getText();
                    JOptionPane.showMessageDialog(null, "Added: " + storeDate+ storeMonth + storeYear + storeEvent + storeColor);
                }
                
            }
        }
        
        public class btnDelete_Action extends JFrame implements ActionListener{
            
            public void actionPerformed(ActionEvent e)
                {
                
                }
        }
        
        public void updateView(ArrayList<SMS> events, View view) {
            int i = 0;
                while(events.get(i) != null) {
                //if event date == date of today
                view.printEventDetails(events.get(i));
                i++;
                }
        }
}
