package sk.tuke.task_register;

import org.springframework.stereotype.Component;
import sk.tuke.task_register.aspect.Log;
import sk.tuke.task_register.aspect.Role;
import sk.tuke.task_register.aspect.RoleType;

import java.util.ArrayList;
import java.util.List;

import static sk.tuke.task_register.aspect.RoleType.*;

//@Component
/**
 * Person register.
 */
public class RegisterImpl implements Register {
	/** Persons list. */
	private final List<Person> persons = new ArrayList<Person>();

	/**
	 * Returns the number of persons in this register.
	 *
	 * @return the number of persons in this register
	 */
	@Role( GUEST )
	@Override public int getCount() {
		return persons.size();
	}

	/**
	 * Returns the person at the specified position in this register.
	 *
	 * @param index
	 *            index of the person to return
	 * @return person the person at the specified position in this register
	 */
	@Override public Person getPerson(int index) {
		return persons.get(index);
	}

	/**
	 * Appends the specified person to the end of this register.
	 *
	 * @param person
	 *            person to append to this register
	 */
	@Role(RoleType.ADMIN )
	@Log
	@Override public void addPerson(Person person) {
		persons.add(person);
	}

	/**
	 * Returns the person with specified name in this register or
	 * <code>null</code>, if match can not be found.
	 *
	 * @param name
	 *            name of a person to search for
	 * @return person with specified phone number
	 */
	@Role( USER )
	@Override public Person findPersonByName(String name) {
		for (Person person : persons) {
			if(person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	/**
	 * Returns the person with specified phone number in this register or
	 * <code>null</code>, if match can not be found.
	 *
	 * @param phoneNumber
	 *            phone number of a person to search for
	 * @return person with specified phone number
	 */
	@Role( USER )
	@Override public Person findPersonByPhoneNumber(String phoneNumber) {
		for (Person person : persons) {
			if(person.getPhoneNumber().equals(phoneNumber)) {
				return person;
			}
		}
		return null;
	}

	/**
	 * Removes the specified person from the register.
	 *
	 * @param person
	 *            person to remove
	 */
	@Role( ADMIN )
	@Override public void removePerson(Person person) {
		persons.remove(person);
	}
}
