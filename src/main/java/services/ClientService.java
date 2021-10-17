package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.ClientConverter;
import actions.views.ClientView;
import constants.JpaConst;
import models.Client;
import models.validators.ClientValidator;

public class ClientService extends ServiceBase {

    public List<ClientView> getPerPage(int page) {
        List<Client> clients = em.createNamedQuery(JpaConst.Q_CLI_GET_ALL, Client.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();

        return ClientConverter.toViewList(clients);
    }

    public long countAll() {
        long cliCount = (long) em.createNamedQuery(JpaConst.Q_CLI_COUNT, Long.class )
                .getSingleResult();

        return cliCount;
    }

    public ClientView findOne(int id) {
        return ClientConverter.toView(findOneInternal(id));
    }

    public List<String> create(ClientView cv) {

        LocalDateTime now = LocalDateTime.now();
        cv.setCreatedAt(now);
        cv.setUpdatedAt(now);

        List<String> errors = ClientValidator.validate(this,cv);
                if ( errors.size() == 0) {
                    create(cv);
                }
                return errors;
    }

    public List<String> update(ClientView cv){
        ClientView savedCli = findOne(cv.getId());

        savedCli.setName(cv.getName());
        savedCli.setAddress(cv.getAddress());
        savedCli.setPhoneNumber(cv.getPhoneNumber());

        LocalDateTime Today = LocalDateTime.now();
        savedCli.setUpdatedAt(Today);

        List<String> errors = ClientValidator.validate(this,cv);

        if ( errors.size() == 0 ) {
            update(savedCli);
        }
        return errors;
    }


    private Client findOneInternal(int id) {
        Client c = em.find(Client.class, id);
        return c;
    }

    private void createInternal(ClientView cv) {
        em.getTransaction().begin();
        em.persist(ClientConverter.toModel(cv));
        em.getTransaction().commit();
    }

    private void updateInternal(ClientView cv) {
        em.getTransaction().begin();
        Client c = findOneInternal(cv.getId());
        ClientConverter.copyViewToModel(c,cv);
        em.getTransaction().commit();
    }

}
