package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Client;

public class ClientConverter {
    public static Client toModel(ClientView cv) {
        return new Client (
              cv.getId(),
              cv.getName(),
              cv.getAddress(),
              cv.getPhoneNumber(),
              cv.getCreatedAt(),
              cv.getUpdatedAt(),
              cv.getDeleteFlag() == null
              ? null
              : cv.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                      ? JpaConst.CLI_DEL_TRUE
                      : JpaConst.CLI_DEL_FALSE);
    }

    public static ClientView toView(Client c) {
        if(c ==null) {
            return null;
        }

        return new ClientView(
                c.getId(),
                c.getName(),
                c.getAddress(),
                c.getPhoneNumber(),
                c.getCreatedAt(),
                c.getUpdatedAt(),
                c.getDeleteFlag() == null
                        ? null
                        : c.getDeleteFlag() == JpaConst.CLI_DEL_TRUE
                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());

    }

    public static List<ClientView> toViewList(List<Client> list) {
        List<ClientView> evs = new ArrayList<>();

        for (Client c : list) {
            evs.add(toView(c));
        }

        return evs;
    }

    public static void copyViewToModel(Client c, ClientView cv) {
        c.setId(cv.getId());
        c.setName(cv.getName());
        c.setAddress(cv.getAddress());
        c.setPhoneNumber(cv.getPhoneNumber());
        c.setCreatedAt(cv.getCreatedAt());
        c.setUpdatedAt(cv.getUpdatedAt());
        c.setDeleteFlag(cv.getDeleteFlag());


}
}
