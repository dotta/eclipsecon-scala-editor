package de.vogella.rcp.editor.example.model

case class Person(firstName: String, lastName: String) {
  val id: Int = Person.counter()
}

object Person {
  private var id = 0
  private def counter(): Int = {
    id += 1
    id
  }
} 