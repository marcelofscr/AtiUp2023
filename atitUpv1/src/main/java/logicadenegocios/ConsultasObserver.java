package logicadenegocios;

import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author Daniella
 */
public abstract class ConsultasObserver {
    protected File documento;
    public abstract String update(ArrayList<Bitacora> Bitacoras);
}
