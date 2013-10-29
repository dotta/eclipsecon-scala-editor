package de.vogella.rcp.editor.example

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorSite
import org.eclipse.ui.PartInitException
import org.eclipse.ui.part.EditorPart
import de.vogella.rcp.editor.example.model.MyModel
import de.vogella.rcp.editor.example.model.Person
import MyPersonEditor._

class MyPersonEditor extends EditorPart {

  private var person: Person = _

  private var input: MyPersonEditorInput = _

  // Will be called before createPartControl
  override def init(site: IEditorSite, input: IEditorInput) {
    if (!(input.isInstanceOf[MyPersonEditorInput]))
      throw new RuntimeException("Wrong input")

    this.input = input.asInstanceOf[MyPersonEditorInput]
    setSite(site)
    setInput(input)
    person = MyModel.personById(this.input.id)
    setPartName("Person ID: " + person.id)
  }

  override def createPartControl(parent: Composite) {
    val layout = new GridLayout()
    layout.numColumns = 2
    parent.setLayout(layout)
    val label1 = new Label(parent, SWT.NONE)
    label1.setText("First Name")
    val text = new Text(parent, SWT.BORDER)
    text.setText(person.firstName)
    text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false))
    new Label(parent, SWT.NONE).setText("Last Name")
    val lastName = new Text(parent, SWT.BORDER)
    lastName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false))
    lastName.setText(person.lastName)
  }

  override def doSave(monitor: IProgressMonitor) {
    // person.getAddress().setCountry(text2.getText());
  }

  override def doSaveAs() {}

  override def isDirty(): Boolean = false

  override def isSaveAsAllowed(): Boolean = false

  override def setFocus() {}
}

object MyPersonEditor {
  val ID = "de.vogella.rcp.editor.example.editor.personeditor"
}