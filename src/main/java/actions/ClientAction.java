package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ClientView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import services.ClientService;

public class ClientAction extends ActionBase {

    private ClientService service;

    @Override
    public void process() throws ServletException, IOException {
        service = new ClientService();
        invoke();
        service.close();
    }

    public void index() throws ServletException, IOException {
        int page = getPage();
        List<ClientView> clients = service.getPerPage(page);
        long clientsCount = service.countAll();

        putRequestScope(AttributeConst.CLIENTS,clients);
        putRequestScope(AttributeConst.CLI_COUNT,clientsCount);
        putRequestScope(AttributeConst.PAGE,page);
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);

        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        forward(ForwardConst.FW_CLI_INDEX);
    }

    public void entryNew() throws ServletException,IOException{
        putRequestScope(AttributeConst.TOKEN, getTokenId());
        putRequestScope(AttributeConst.CLIENT, new ClientView());

        forward(ForwardConst.FW_CLI_NEW);

    }

}
