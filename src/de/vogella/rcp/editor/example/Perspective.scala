package de.vogella.rcp.editor.example

import org.eclipse.ui.IPageLayout
import org.eclipse.ui.IPerspectiveFactory

class Perspective extends IPerspectiveFactory {
  override def createInitialLayout(layout: IPageLayout) {
    layout.setEditorAreaVisible(false)
    layout.setFixed(true)
  }
}
