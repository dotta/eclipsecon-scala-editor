package de.vogella.rcp.editor.example.handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import de.vogella.rcp.editor.example.MyPersonEditor
import de.vogella.rcp.editor.example.MyPersonEditorInput
import de.vogella.rcp.editor.example.View
import de.vogella.rcp.editor.example.model.Person
import util.view.ViewUtil

class CallEditor extends AbstractHandler {

  override def execute(event: ExecutionEvent): AnyRef = {
    for {
      window <- Option(HandlerUtil.getActiveWorkbenchWindow(event))
      page <- Option(window.getActivePage)
      view <- Option((page.findView(View.ID)).asInstanceOf[View])
      selection <- Option(view.getSite.getSelectionProvider.getSelection.asInstanceOf[IStructuredSelection])
      obj <- Option(selection.getFirstElement)
      person <- Option(obj.asInstanceOf[Person])
    } {
      val input = new MyPersonEditorInput(person.id)
      page.openEditor(input, MyPersonEditor.ID)
    }

    null
  }
} 