package marosSpringTutorial;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

//  @Autowired
  private SpellChecker spellChecker;

  @Autowired
  public TextEditor(SpellChecker spellChecker) {
    System.out.println("Inside TextEditor constructor." );
    this.spellChecker = spellChecker;
  }

//  public TextEditor() {
//    spellChecker = new SpellChecker();
//  }
//
//  public TextEditor (SpellChecker spellChecker) {
//    this.spellChecker = spellChecker;
//  }

  // a setter method to inject the dependency.
//  @Autowired
//  public void setSpellChecker(SpellChecker spellChecker) {
//    System.out.println("Text Editor: Inside setSpellChecker method." );
//    this.spellChecker = spellChecker;
//  }

  // a getter method to return spellChecker
  public SpellChecker getSpellChecker() {
    return spellChecker;
  }

  public void spellCheck() {
    spellChecker.checkSpelling();
  }


}
