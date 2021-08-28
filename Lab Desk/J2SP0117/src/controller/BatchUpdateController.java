/**
 *Title:             Batch update
 * Files:            BatchUpdateController.java
 * Semester:         LAB Desk Summer- Block 5 2021
 * Author:           TuyenNH
 * Email:            tuyennhhe141159@fpt.edu.vn
 * CS Login:         User
 * Lecturer's Name:  DuongTB
 * Lab Section:      4
 */
package controller;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class BatchUpdateController {

    /**
     * Get title for table
     *
     * @No param
     * @return array contains the title of table
     */
    public Object[] getTile() {
        Object[] title = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
        return title;
    }

    /**
     * Get row for table
     *
     * @No param
     * @return array contains row data of table
     */
    public Object[][] dataRow() {
        Object[][] data = {
            {"1", "Stock one", "Ha Noi", "2021-01-01", "None"},
            {"2", "Stock two", "Hoa Lac", "2021-01-01", ""},
            {"3", "Stock three", "Lao Cai", "2021-01-01", "Dangerous"},
            {"4", "Stock four", "Hai Phong", "2021-01-01", ""},
            {"5", "Stock five", "Da Nang", "2021-01-01", ""}
        };
        return data;
    }

    /**
     * Insert data to database
     *
     * @param table type DefaultTableModel
     * @No return
     * @throws Exception
     */
    public void insertToDB(DefaultTableModel table) throws Exception {
        Connection conn = null;
        conn = new DBContext().getConnection();//open connection
        try {
            // Create SQL statement
            String sql = "INSERT INTO [Stocks]\n"
                    + "           ([StockID]\n"
                    + "           ,[StockName]\n"
                    + "           ,[Address]\n"
                    + "           ,[DateAvailable]\n"
                    + "           ,[Note])\n"
                    + "     VALUES"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";
            // Create statement object
            PreparedStatement pstm = conn.prepareStatement(sql);

            //Create SimpleDateFormat object
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            //set commit mode to no auto commit
            conn.setAutoCommit(false);
            
            for (int i = 0; i < dataRow().length; i++) {
                pstm.setInt(1, Integer.parseInt(table.getValueAt(i, 0).toString()));
                pstm.setString(2, table.getValueAt(i, 1).toString());
                pstm.setString(3, table.getValueAt(i, 2).toString());
                
                //format String type to date type
                Date date = df.parse(table.getValueAt(i, 3).toString());
                long ms = date.getTime();
                java.sql.Date sdate = new java.sql.Date(ms);
                pstm.setDate(4, sdate);
                pstm.setString(5, table.getValueAt(i, 4).toString());
                
                //add data to batch
                pstm.addBatch();
            }
            //run batch
            pstm.executeBatch();

            //clear batch
            pstm.clearBatch();

            //Explicitly commit statements to apply changes
            conn.commit();
        } catch (SQLException esql) {
            // If there is any error.
            conn.rollback();
        } finally {
            //close connection
            conn.close();
        }
    }

}
