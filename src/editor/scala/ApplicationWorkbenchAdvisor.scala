package editor.scala

import org.eclipse.ui.application.IWorkbenchWindowConfigurer
import org.eclipse.ui.application.WorkbenchAdvisor
import org.eclipse.ui.application.WorkbenchWindowAdvisor
import ApplicationWorkbenchAdvisor._

object ApplicationWorkbenchAdvisor {
  private val PERSPECTIVE_ID = "de.vogella.rcp.editor.example.perspective"
}

class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

  override def createWorkbenchWindowAdvisor(configurer: IWorkbenchWindowConfigurer): WorkbenchWindowAdvisor = {
    new ApplicationWorkbenchWindowAdvisor(configurer)
  }

  override def getInitialWindowPerspectiveId(): String = PERSPECTIVE_ID
}
