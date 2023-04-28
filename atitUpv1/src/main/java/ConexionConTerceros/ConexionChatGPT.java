/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionConTerceros;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.edit.EditChoice;
import com.theokanning.openai.edit.EditRequest;
import java.util.List;

/**
 *
 * @author Usuario
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
