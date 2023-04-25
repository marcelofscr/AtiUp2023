/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package ConexionConTerceros;

import java.util.List;
import java.util.Properties;
import java.util.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.sentiment.*;
*/
/**
 *
 * @author Usuario
 */

public class AnalisisSentimientos {
  public static String main(String text_) {
    // crea una nueva instancia de StanfordCoreNLP con las propiedades requeridas
    /**
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
 */ 
    // crea un texto para analizar su sentimiento
    String text = text_ ;

    // crea un objeto CoreDocument para representar el texto
    //CoreDocument document = new CoreDocument(text);

    // anota el documento con Stanford CoreNLP
    //pipeline.annotate(document);

    // extrae la información de sentimiento del documento
    /**
    List<CoreSentence> sentences = document.sentences();
    for (CoreSentence sentence : sentences) {
      String sentiment = sentence.sentiment();
      return "Sentimiento de la oración: " + sentiment ;
    } */ 
      return null;
  }
}
    
