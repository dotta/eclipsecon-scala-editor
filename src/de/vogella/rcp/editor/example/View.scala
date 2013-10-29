package de.vogella.rcp.editor.example

import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.ListViewer
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.handlers.IHandlerService
import org.eclipse.ui.part.ViewPart

import de.vogella.rcp.editor.example.model.MyModel
import de.vogella.rcp.editor.example.model.Person
import util.EclipseUtil.LabelProvider
import util.EclipseUtil.doubleClickEvent2listener

object View {
  val ID = "de.vogella.rcp.editor.example.view"
}

class View extends ViewPart {

  private var viewer: ListViewer = _

  override def createPartControl(parent: Composite) {
    viewer = new ListViewer(parent)
    viewer.setContentProvider(ArrayContentProvider.getInstance)
    viewer.setLabelProvider(LabelProvider { element: AnyRef =>
      val p = element.asInstanceOf[Person]
      p.firstName + " " + p.lastName
    })
    viewer.setInput(MyModel.persons)
    getSite.setSelectionProvider(viewer)
    hookDoubleClickCommand()
  }

  private def hookDoubleClickCommand() {
    viewer.addDoubleClickListener (doubleClickEvent2listener { event: DoubleClickEvent => 
      val handlerService = getSite.getService(classOf[IHandlerService]).asInstanceOf[IHandlerService]
      handlerService.executeCommand("de.vogella.rcp.editor.example.openEditor", null)
    })
  }

  override def setFocus() {
    viewer.getControl.setFocus()
  }
}
