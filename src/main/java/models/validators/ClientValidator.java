package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ClientView;
import constants.MessageConst;
import services.ClientService;

public class ClientValidator {
    public static List<String> validate(ClientService service,ClientView cv){
        List<String> errors = new ArrayList<String>();


    String nameError = validateName(cv.getName());
    if(!nameError.equals("")) {
        errors.add(nameError);
    }

    String addressError = validateAddress(cv.getAddress());
    if(!addressError.equals("")) {
        errors.add(addressError);
    }

    String phoneNumberError = validatePhoneNumber(cv.getPhoneNumber());
    if(!phoneNumberError.equals("")) {
        errors.add(phoneNumberError);
    }

    return errors;
    }


    private static String validateName(String name) {
        if( name == null || name.equals("")) {
            return MessageConst.E_NOCLIENTNAME.getMessage();
        }
        return "";
    }

    private static String validateAddress(String address) {
        if( address == null || address.equals("")) {
            return MessageConst.E_NOADDRESS.getMessage();
        }
        return "";
}

    private static String validatePhoneNumber(String phoneNumber) {
        if( phoneNumber == null || phoneNumber.equals("")) {
            return MessageConst.E_NOPHONE_NUMBER.getMessage();
        }
        return "";
    }
}

