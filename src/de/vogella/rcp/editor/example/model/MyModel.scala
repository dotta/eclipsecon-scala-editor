package de.vogella.rcp.editor.example.model

object MyModel {
  val persons = Array(Person("Fredrik", "Nase"), Person("Jerry", "Knopf"))

  def personById(id: Int): Person =
    persons.find(person => person.id == id).orNull
}