/**
 * @file BookingPortal.java
 * 
 * @author Malia Cherry
 *
 * @date Oct. 2022
 **/

/**
 * The BookingPortal class is the main class for the Booking Portal
 * application.
 * It contains the main method for the Booking Portal application.
 * 
 */
public class BookingPortal extends BookingPortalUI {

    /**
     * The main method creates a new BookingPortal object and calls the run method.
     * 
     * @param args the command line arguments
     */
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