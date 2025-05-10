import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Student_Records extends javax.swing.JFrame {
    
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private int activeDataStructure = 1; 
    private Connection connection;
    private static final String DB_URL = "jdbc:sqlite:.//database//studentInfo.db";

    /**
     * Creates new form Student_Records
     */
    
    /**
     * Student class to store student information
     */
    public class Student {
        private String studentId;
        private String firstName;
        private String middleName;
        private String lastName;
        private String yearLevel;
        private String status;
        private String prelimGrade;
        private String midtermGrade;
        private String finalGrade;
        
        // Default constructor
        public Student() {
        }
        
        // Constructor with parameters
        public Student(String studentId, String firstName, String middleName, String lastName, 
                      String yearLevel, String status) {
            this.studentId = studentId;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.yearLevel = yearLevel;
            this.status = status;
        }
        
        // Getters and Setters
        public String getStudentId() {
            return studentId;
        }
        
        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        
        public String getMiddleName() {
            return middleName;
        }
        
        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        
        public String getYearLevel() {
            return yearLevel;
        }
        
        public void setYearLevel(String yearLevel) {
            this.yearLevel = yearLevel;
        }
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        public String getPrelimGrade() {
            return prelimGrade;
        }
        
        public void setPrelimGrade(String prelimGrade) {
            this.prelimGrade = prelimGrade;
        }
        
        public String getMidtermGrade() {
            return midtermGrade;
        }
        
        public void setMidtermGrade(String midtermGrade) {
            this.midtermGrade = midtermGrade;
        }
        
        public String getFinalGrade() {
            return finalGrade;
        }
        
        public void setFinalGrade(String finalGrade) {
            this.finalGrade = finalGrade;
        }
        
        @Override
        public String toString() {
            return "Student{" + "studentId=" + studentId + ", firstName=" + firstName + 
                   ", middleName=" + middleName + ", lastName=" + lastName + 
                   ", yearLevel=" + yearLevel + ", status=" + status + '}';
        }
    }
    public Student_Records() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        // Load data when form opens
        loadStudentData();
    }
    
    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    
    // Method to load student data from database
 // Method to load student data from database
    private void loadStudentData() {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM studentGrades";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel) studentGradesTable.getModel();
                model.setRowCount(0); // Clear existing data
                
                studentArrayList.clear(); // Clear existing data in ArrayList
                
                while (resultSet.next()) {
                    String id = resultSet.getString("student_id");
                    String firstName = resultSet.getString("student_first_name");
                    String middleName = resultSet.getString("student_middle_name");
                    String lastName = resultSet.getString("student_last_name");
                    String yearLevel = resultSet.getString("year_level");
                    String status = resultSet.getString("status");
                    String prelimGrade = resultSet.getString("prelimGrade");
                    String midtermGrade = resultSet.getString("midtermGrade");
                    String finalGrade = resultSet.getString("finalGrade");
                    
                    model.addRow(new Object[]{id, firstName, middleName, lastName, yearLevel, 
                        status, prelimGrade, midtermGrade, finalGrade});
                    
                    // Also add to ArrayList for possible array-based operations
                    Student student = new Student();
                    student.setStudentId(id);
                    student.setFirstName(firstName);
                    student.setMiddleName(middleName);
                    student.setLastName(lastName);
                    student.setYearLevel(yearLevel);
                    student.setStatus(status);
                    student.setPrelimGrade(prelimGrade);
                    student.setMidtermGrade(midtermGrade);
                    student.setFinalGrade(finalGrade);
                    studentArrayList.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading student data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        studentMiddleNametxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentLastNametxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        yearLvl = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        yearLvl1 = new javax.swing.JComboBox<>();
        studentIDtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        studentFirstNametxt = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        prelimGrade = new javax.swing.JTextField();
        midtermGrade = new javax.swing.JTextField();
        finalsGrade = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentGradesTable = new javax.swing.JTable();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Student First Name:");

        jLabel4.setText("Student Last Name:");

        jLabel5.setText("Year Level:");

        yearLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st year", "2nd year", "3rd year", "4th year", " " }));

        jLabel6.setText(" Status:");

        jLabel1.setText("Student ID:");

        yearLvl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Irregular", " " }));

        jLabel2.setText("Student Middle Name:");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Midterm Grade:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Finals Grade:");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Prelim Grade:");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        studentGradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "student_id", "student_first_name", "student_middle_name", "student_last_name", "year_level", "status", "prelim_grade", "midterm_grade", "finals_grade"
            }
        ));
        studentGradesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentGradesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentGradesTable);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentLastNametxt)
                            .addComponent(yearLvl, 0, 135, Short.MAX_VALUE)
                            .addComponent(studentMiddleNametxt)
                            .addComponent(studentFirstNametxt)
                            .addComponent(studentIDtxt))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yearLvl1, 0, 135, Short.MAX_VALUE)
                            .addComponent(prelimGrade)
                            .addComponent(midtermGrade)
                            .addComponent(finalsGrade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLvl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(prelimGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(midtermGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(finalsGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(studentFirstNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentMiddleNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentLastNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        StudentGrades studentGrades = new StudentGrades();
        studentGrades.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String studentId = studentIDtxt.getText();
        String firstName = studentFirstNametxt.getText();
        String middleName = studentMiddleNametxt.getText();
        String lastName = studentLastNametxt.getText();
        String yearLevelText = (String) yearLvl.getSelectedItem();
        String statusText = (String) yearLvl1.getSelectedItem();
        String prelimText = prelimGrade.getText();
        String midtermText = midtermGrade.getText();
        String finalsText = finalsGrade.getText();
        
        // Validate input fields
        if (studentId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || 
            yearLevelText.isEmpty() || statusText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Check if grades are valid numbers if they're not empty
            if (!prelimText.isEmpty()) {
                try {
                    double grade = Double.parseDouble(prelimText);
                    if (grade < 0 || grade > 100) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Prelim grade must be a number between 0-100",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (!midtermText.isEmpty()) {
                try {
                    double grade = Double.parseDouble(midtermText);
                    if (grade < 0 || grade > 100) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Midterm grade must be a number between 0-100",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (!finalsText.isEmpty()) {
                try {
                    double grade = Double.parseDouble(finalsText);
                    if (grade < 0 || grade > 100) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Finals grade must be a number between 0-100",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            try (Connection conn = getConnection()) {
                String sql = "UPDATE studentGrades SET student_first_name=?, student_middle_name=?, "
                        + "student_last_name=?, year_level=?, status=?, prelimGrade=?, midtermGrade=?, "
                        + "finalGrade=? WHERE student_id=?";
                
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, middleName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setString(4, yearLevelText);
                    preparedStatement.setString(5, statusText);
                    preparedStatement.setString(6, prelimText);
                    preparedStatement.setString(7, midtermText);
                    preparedStatement.setString(8, finalsText);
                    preparedStatement.setString(9, studentId);
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Student updated successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        // Refresh the table with updated data
                        loadStudentData();
                        // Clear input fields
                        clearInputFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "No student found with ID: " + studentId,
                                "Update Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String studentId = studentIDtxt.getText();
        
        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this student?",
                "Delete Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            try (Connection conn = getConnection()) {
                String sql = "DELETE FROM studentGrades WHERE student_id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, studentId);
                
                    int rowsAffected = preparedStatement.executeUpdate();
                
                    if (rowsAffected > 0) {
                        // Also remove from ArrayList if still using it
                        deleteStudent(studentId);
                    
                        // Clear input fields
                        clearInputFields();
                    
                        JOptionPane.showMessageDialog(this, "Student deleted successfully!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                        // Refresh table
                        loadStudentData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Student not found in database.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void deleteStudent(String studentId) {
        studentArrayList.removeIf(student -> student.getStudentId().equals(studentId));
    }
    
    private void quickSort(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }
    
    private int partition(ArrayList<Student> list, int low, int high) {
        String pivot = list.get(high).getLastName(); 
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getLastName().compareTo(pivot) < 0) {
                i++;
                // Swap
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        // Swap the pivot element
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
    
    private void clearInputFields() {
        studentIDtxt.setText("");
        studentFirstNametxt.setText("");
        studentMiddleNametxt.setText("");
        studentLastNametxt.setText("");
        yearLvl.setSelectedIndex(0);
        yearLvl1.setSelectedIndex(0);
        prelimGrade.setText("");
        midtermGrade.setText("");
        finalsGrade.setText("");
    }
    
    private void studentGradesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentGradesTableMouseClicked
        // Get the selected row index
        int selectedRow = studentGradesTable.getSelectedRow();
        
        if (selectedRow >= 0) {
            // Get data from the selected row
            String id = studentGradesTable.getValueAt(selectedRow, 0).toString();
            String firstName = studentGradesTable.getValueAt(selectedRow, 1).toString();
            Object middleNameObj = studentGradesTable.getValueAt(selectedRow, 2);
            String middleName = (middleNameObj != null) ? middleNameObj.toString() : "";
            String lastName = studentGradesTable.getValueAt(selectedRow, 3).toString();
            String yearLevelValue = studentGradesTable.getValueAt(selectedRow, 4).toString();
            String statusValue = studentGradesTable.getValueAt(selectedRow, 5).toString();
            
            // Get grade values (handle null values)
            Object prelimObj = studentGradesTable.getValueAt(selectedRow, 6);
            String prelimValue = (prelimObj != null) ? prelimObj.toString() : "";
            
            Object midtermObj = studentGradesTable.getValueAt(selectedRow, 7);
            String midtermValue = (midtermObj != null) ? midtermObj.toString() : "";
            
            Object finalsObj = studentGradesTable.getValueAt(selectedRow, 8);
            String finalsValue = (finalsObj != null) ? finalsObj.toString() : "";
            
            // Set values to text fields
            studentIDtxt.setText(id);
            studentFirstNametxt.setText(firstName);
            studentMiddleNametxt.setText(middleName);
            studentLastNametxt.setText(lastName);
            
            // Set combo box selections
            for (int i = 0; i < yearLvl.getItemCount(); i++) {
                if (yearLvl.getItemAt(i).toString().equals(yearLevelValue)) {
                    yearLvl.setSelectedIndex(i);
                    break;
                }
            }
            
            for (int i = 0; i < yearLvl1.getItemCount(); i++) {
                if (yearLvl1.getItemAt(i).toString().equals(statusValue)) {
                    yearLvl1.setSelectedIndex(i);
                    break;
                }
            }
            
            // Set grade values
            prelimGrade.setText(prelimValue);
            midtermGrade.setText(midtermValue);
            finalsGrade.setText(finalsValue);
        }
    }//GEN-LAST:event_studentGradesTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField finalsGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField midtermGrade;
    private javax.swing.JTextField prelimGrade;
    private javax.swing.JTextField studentFirstNametxt;
    private javax.swing.JTable studentGradesTable;
    private javax.swing.JTextField studentIDtxt;
    private javax.swing.JTextField studentLastNametxt;
    private javax.swing.JTextField studentMiddleNametxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JComboBox<String> yearLvl;
    private javax.swing.JComboBox<String> yearLvl1;
    // End of variables declaration//GEN-END:variables
}
