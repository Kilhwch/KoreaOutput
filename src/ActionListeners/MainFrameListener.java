
package ActionListeners;

import Main.StudyFrame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainFrameListener extends AbstractAction {
    public JButton fOpen;
    public JButton quit;
    public JFrame frame;
    private final String PATH = "./Files/Items/";
    
    public MainFrameListener(JButton fOpen, JButton quit, JFrame frame) {
        this.fOpen = fOpen;
        this.quit = quit;
        this.frame = frame;
    }

    private enum Actions {
        Open,
        Exit
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Actions.Exit.name())) {
            System.exit(0);
        } else if (e.getActionCommand().equals(Actions.Open.name())) {
            JFileChooser chooser = new JFileChooser(PATH);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt only", "txt");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                StudyFrame study = new StudyFrame(chooser.getSelectedFile().getName());
                study.init();
                frame.dispose();
            }
        }
    }
}
