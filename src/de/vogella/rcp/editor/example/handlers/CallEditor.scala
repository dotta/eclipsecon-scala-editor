package de.vogella.rcp.editor.example.handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IWorkbenchPage
import org.eclipse.ui.IWorkbenchWindow
import org.eclipse.ui.PartInitException
import org.eclipse.ui.handlers.HandlerUtil
import de.vogella.rcp.editor.example.MyPersonEditor
import de.vogella.rcp.editor.example.MyPersonEditorInput
import de.vogella.rcp.editor.example.View
import de.vogella.rcp.editor.example.model.Person
import scala.collection.JavaConversions._

class CallEditor extends AbstractHandler {

  override def execute(event: ExecutionEvent): AnyRef = {
    println("called")
    // get the view
    val window = HandlerUtil.getActiveWorkbenchWindow(event)
    val page = window.getActivePage
    val view = (page.findView(View.ID)).asInstanceOf[View]
    // get the selection
    val selection = view.getSite.getSelectionProvider.getSelection
    if (selection != null && selection.isInstanceOf[IStructuredSelection]) {
      val obj = selection.asInstanceOf[IStructuredSelection].getFirstElement
      if (obj != null) {
        val person = obj.asInstanceOf[Person]
        val input = new MyPersonEditorInput(person.id)
        page.openEditor(input, MyPersonEditor.ID)
      }
    }
    null
  }
} 