/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniella
 */
public class validarEmail {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private final Pattern pattern;
    private Matcher matcher;

    public validarEmail() {
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    /**
     * Validar email normal
     *
     * @param email email a ser validado
     * @return true correo valido, false email invalido
     */
    public boolean validate(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
