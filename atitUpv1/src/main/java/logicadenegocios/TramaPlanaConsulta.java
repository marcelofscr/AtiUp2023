package logicadenegocios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Daniella
 */
public class TramaPlanaConsulta extends ConsultasObserver {

    @Override
    public String update(ArrayList<Bitacora> bitacoras) {
        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + File.separator + "Desktop";
        String filePath = desktopPath + File.separator + "output.txt";

        // Generate the content for the file
        String content = new String();
        for (Bitacora bitacora : bitacoras) {
            content += (bitacora.getIdBitacora());
            content += (" ");
            content += (bitacora.getFecha());
            content += (" ");
            content += (bitacora.getHora());
            content += (" ");
            content += (bitacora.getAccion());
            content += ("\n");
        }
        try {
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            //System.err.println("Error: " + e.getMessage());
        }
        return content;
    }

}
