package task_register3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestService {

  @Autowired
  private ContactService contactService;

  @GetMapping("/rest/contact")
  public List<Contact> getContact() {
    return  contactService.getContact();
  }

  @PostMapping("/rest/contact")
  @PutMapping("/rest/contact")
  public void addContact(@RequestBody Contact contact) {
    contactService.addContact( contact );

  }

  @DeleteMapping("/rest/contact/{id}")
  public void deleteContact(@PathVariable("id") int id) {
    contactService.deleteContact( id );
    System.out.println("Delete " + id);
  }

}
