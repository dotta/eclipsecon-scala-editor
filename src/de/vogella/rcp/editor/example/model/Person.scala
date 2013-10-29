package de.vogella.rcp.editor.example.model

// Use @BeanProperty annotation to add plain Java bean getters to the class.
case class Person(firstName: String, lastName: String)(val id: Int = Person.counter()) {
//  override def toString(): String = firstName + " " + lastName
}

object Person {
  private var id = 0
  private def counter(): Int = {
    id += 1
    id
  }
} 