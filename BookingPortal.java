/**
 * @file BookingPortal.java
 * 
 * @author Malia Cherry
 *
 * @date Oct. 2022
 **/


/**
 * The BookingPortal class is the main class for the Booking Portal application.
 * It is responsible for creating the GUI and handling all events.
 * 
 */
public class BookingPortal extends BookingPortalUI {
    public static void main(String args[]) {

        BookingPortalUI reservationSystem = new BookingPortalUI();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingPortalUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                reservationSystem.setVisible(true);
            }
        });
    }
}