package sk.tuke.task_register_2;

import java.util.ArrayList;
import java.util.List;

import sk.tuke.task_register_2.annotation.Log;
import sk.tuke.task_register_2.authentication.Role;
import sk.tuke.task_register_2.authentication.annotations.Permissions;

/**
 * Person register.
 */
public class RegisterImpl implements Register {
	/** Persons list. */
	private final List<Person> persons = new ArrayList<Person>();

	public RegisterImpl(List<Person> persons2) {
		persons2.forEach(this::addPerson);
	}

	@Override
	public int getCount() {
		return persons.size();
	}

	@Override
	@Log
	@Permissions(role = Role.GUEST)
	public Person getPerson(int index) {
		return persons.get(index);
	}

	@Override
	@Log
	@Permissions(role = Role.ADMIN)
	public void addPerson(Person person) {
		persons.add(person);
	}

	
	@Override
	@Permissions(role = Role.USER)
	public Person findPersonByName(String name) {
		for (Person person : persons) {
			if(person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	@Override
	@Permissions(role = Role.USER)
	public Person findPersonByPhoneNumber(String phoneNumber) {
		for (Person person : persons) {
			if(person.getPhoneNumber().equals(phoneNumber)) {
				return person;
			}
		}
		return null;
	}

	@Override
	@Permissions(role = Role.ADMIN)
	public void removePerson(Person person) {
		persons.remove(person);
	}
}
