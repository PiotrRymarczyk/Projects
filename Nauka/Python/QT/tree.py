import sys
from PyQt5.QtWidgets import QApplication, QFileSystemModel, QTreeView, QWidget, QVBoxLayout
from PyQt5.QtGui import QIcon
from PyQt5.QtCore import QDir
 
class App(QWidget):
 
    def __init__(self):
        super().__init__()
        self.title = 'PyQt5 file system view - pythonspot.com'
        self.left = 10
        self.top = 10
        self.width = 640
        self.height = 480
        self.initUI()
 
    def initUI(self):
        self.setWindowTitle(self.title)
        self.setGeometry(self.left, self.top, self.width, self.height)
 
        self.model = QFileSystemModel()
        print(self.model.nameFilters())
        self.model.setNameFilters(['*.jpg', '*.pdf', '*.py'])
        self.model.setNameFilterDisables(False)
        self.model.setRootPath(QDir.currentPath())
        self.tree = QTreeView()
        self.tree.setModel(self.model)
        self.tree.setRootIndex(self.model.index(QDir.currentPath()))
        #self.tree.setRootPath('c:\\')
        self.tree.setAlternatingRowColors(True)
 
        self.tree.setAnimated(False)
        self.tree.setColumnWidth(0, 200)
        self.tree.setColumnWidth(1, 60)
        self.tree.setColumnWidth(3, 40)
        self.tree.setColumnWidth(4, 40)
        self.tree.setSortingEnabled(True)
 
        self.tree.setWindowTitle("Dir View")
        self.tree.resize(800, 600)
 
        windowLayout = QVBoxLayout()
        windowLayout.addWidget(self.tree)
        self.setLayout(windowLayout)
 
        self.show()
 
if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = App()
    sys.exit(app.exec_())
    