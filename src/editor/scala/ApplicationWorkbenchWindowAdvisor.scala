package editor.scala

import org.eclipse.swt.graphics.Point
import org.eclipse.ui.application.ActionBarAdvisor
import org.eclipse.ui.application.IActionBarConfigurer
import org.eclipse.ui.application.IWorkbenchWindowConfigurer
import org.eclipse.ui.application.WorkbenchWindowAdvisor

class ApplicationWorkbenchWindowAdvisor(configurer: IWorkbenchWindowConfigurer)
    extends WorkbenchWindowAdvisor(configurer) {

  override def createActionBarAdvisor(configurer: IActionBarConfigurer): ActionBarAdvisor = {
    new ApplicationActionBarAdvisor(configurer)
  }

  override def preWindowOpen() {
    val configurer = getWindowConfigurer
    configurer.setInitialSize(new Point(400, 300))
    configurer.setShowCoolBar(false)
    configurer.setShowStatusLine(false)
    configurer.setTitle("RCP Application")
  }
}
