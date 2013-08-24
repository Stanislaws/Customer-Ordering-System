package groupproject;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


/**
 *
 * @author ayoubrahhali
 */
public class Validation {
public Validation(){}


public  boolean isEmail(String email){
boolean isValid = false; 
String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
CharSequence inputStr = email;  
//Make the comparison case-insensitive.  
Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
Matcher matcher = pattern.matcher(inputStr);  
    if(matcher.matches()){  
    isValid = true;  
    }  
return isValid; 
}
    
public  boolean isPhone(String s) {
boolean isValid = false; 
String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
CharSequence inputStr = s;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
    if(matcher.matches()){  
    isValid = true;  
    }  
return isValid;
}
    
    
    
    
public  boolean isAddress( String s )
{
  return s.matches( 
     "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
}

    // for quantity and price in the new order form
public static boolean isNumeric(String number){  
boolean isValid = false;  
String expression = "^[-+]?[0-9]*\\.?[0-9]+$";  
CharSequence inputStr = number;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
if(matcher.matches()){  
isValid = true;  
}  
return isValid;  
}  
  
/**
 * Validate username with regular expression
 * @param username username for validation
 * @return true valid username, false invalid username
 */
public boolean isUser( String username){
String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

Pattern  pattern = Pattern.compile(USERNAME_PATTERN);
Matcher matcher = pattern.matcher(username);
return matcher.matches();

}
}
