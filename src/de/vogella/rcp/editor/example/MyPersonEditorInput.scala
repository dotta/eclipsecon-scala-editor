package de.vogella.rcp.editor.example

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IPersistableElement
import scala.reflect.{BeanProperty, BooleanBeanProperty}

case class MyPersonEditorInput(id: Int) extends IEditorInput {

  override def exists(): Boolean = true

  override def getImageDescriptor(): ImageDescriptor = null

  override def getName(): String = String.valueOf(id)

  override def getPersistable(): IPersistableElement = null

  override def getToolTipText(): String = "Displays a person"

  override def getAdapter(adapter: Class[_]): AnyRef = null
}
