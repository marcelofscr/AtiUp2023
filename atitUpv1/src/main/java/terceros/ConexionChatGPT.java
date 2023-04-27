/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceros;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.edit.EditChoice;
import com.theokanning.openai.edit.EditRequest;
import java.util.List;
/**
 *
 * @author Agus
 */
public class ConexionChatGPT {
    public static String conexion(String pregunta, String instruccion) {
        OpenAiService  service = new OpenAiService("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");
        String respuesta = "";
        EditRequest request = EditRequest.builder()
                .model("text-davinci-edit-001")
                .input(pregunta)
                .instruction(instruccion)
                .build();
        try
        {
            
            service.createEdit(request).getChoices();
            List<EditChoice> choices = service.createEdit(request).getChoices();
            for (EditChoice choice : choices) {
            respuesta += choice.toString() + "\n.";
        }
        }
        catch(Exception e)
        {
            respuesta = e.toString();
            
        }
        return respuesta;
    }
    
    
}
