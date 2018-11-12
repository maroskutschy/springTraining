package sk.tuke.task_register;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@Component
/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** Register of persons. */
    private Register register;

    /**
     * In JDK 6 use Console class instead.
     *  readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };

    protected ConsoleUI() {
    }

    public ConsoleUI(Register register) {
        this.register = register;
    }

    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }

	private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();

        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");

        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);

        return Option.values()[selection - 1];
    }

    private void printRegister() {
        for(int index = 0; index < register.getCount(); index++) {
        	Person person = register.getPerson(index);
        	System.out.printf("%d. %s (%s)\n", index + 1,
        			person.getName(), person.getPhoneNumber());
        }
        System.out.println();
    }

    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        register.addPerson(new Person(name, phoneNumber));
    }

    private void updateRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine()) - 1;
        Person person = register.getPerson(index);

        System.out.printf("Enter new name [%s]: ", person.getName());
        String name = readLine();

        System.out.printf("Enter new phoneNumber [%s]: ", person.getPhoneNumber());
        String phoneNumber = readLine();

        person.setName(name);
        person.setPhoneNumber(phoneNumber);
    }

    private void findInRegister() {
    	System.out.println("Enter name or phone number: ");
    	String text = readLine();

    	Person person = register.findPersonByName(text);
    	if(person != null) {
    		System.out.println(person);
    	} else {
    		person = register.findPersonByPhoneNumber(text);
    		if(person != null) {
    			System.out.println(person);
    		} else {
    			System.out.println("No entry");
    		}
    	}
    }

    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }
}
