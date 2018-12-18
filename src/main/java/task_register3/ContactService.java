package task_register3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ContactService {

  @PersistenceContext
  private EntityManager entityManager;

  public void addContact(Contact contact) {
    entityManager.persist( contact );

  }

  public List<Contact> getContact() {
    return entityManager.createQuery("select c from Contact c").getResultList();
  }
}
