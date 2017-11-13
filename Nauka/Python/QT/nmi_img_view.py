'''
Created on 10.11.2017
Modified on 10.11.2017

@author: Piotr Rymarczyk



'''
import sys
from PyQt5.QtWidgets import QApplication, QFileSystemModel, QTreeView, QWidget, QGridLayout
from PyQt5.QtWidgets import QLabel, QMessageBox
from PyQt5.QtGui import QPixmap
from PyQt5.QtCore import QFileInfo

class ImageViewer(QWidget):

    def __init__(self):
        super().__init__()
        self.title = 'No Magic Involved - image viewer'
        self.left = 50
        self.top = 50
        self.width = 600
        self.height = 600
        self.supported_image_types = ['JPG', 'JPEG', 'PNG']
        self.create_gui()

    def create_gui(self):
        self.setWindowTitle(self.title)
        self.setGeometry(self.left, self.top, self.width, self.height)

        self.model = QFileSystemModel()
        self.model.setNameFilters(['*.jpg', '*.pdf', '*.py', '*.jpeg', '*.png'])
        self.model.setNameFilterDisables(False)
        #self.model.setRootPath(QDir.currentPath())
        self.model.setRootPath('')
        self.tree = QTreeView()
        self.tree.setModel(self.model)
        self.tree.doubleClicked.connect(self.test)
        #self.tree.setRootIndex(self.model.index(QDir.currentPath()))
        self.tree.setRootIndex(self.model.index(''))
        self.tree.setAlternatingRowColors(True)

        self.tree.setAnimated(False)
        self.tree.setColumnWidth(0, 400)
        self.tree.setColumnWidth(1, 60)
        self.tree.setColumnWidth(3, 40)
        self.tree.setColumnWidth(4, 40)
        #self.tree.setSortingEnabled(True)

        self.tree.setWindowTitle("Dir View")
        self.tree.resize(600, 800)

        self.label = QLabel("To jest test")
        self.label.resize(600, 800)
        self.label.setToolTip('Loaded image :)')

        windowLayout = QGridLayout()
        windowLayout.addWidget(self.tree, 0, 0)
        windowLayout.addWidget(self.label, 0, 1)
        windowLayout.setColumnMinimumWidth(0, 600)
        windowLayout.setColumnMinimumWidth(1, 600)
        self.setLayout(windowLayout)
        self.resize(800, 800)
        self.show()

    def test(self, signal):
        file_path = self.tree.model().filePath(signal)
        file_info = QFileInfo(file_path)
        if file_info.isDir():
            self.label.setText('Directory')
        elif file_info.isFile():
            if file_info.suffix().upper() in self.supported_image_types:
                self.label.setText(file_info.fileName())
                pixmap = QPixmap(file_path)
                if pixmap.width() > 600:
                    pixmap = QPixmap(file_path).scaledToWidth(600)
                self.label.setPixmap(pixmap)
            else:
                self.label.setText('Unsupported file type')
        else:
            self.label.setText('Unrecognized')
        self.label.resize(600, 800)

    def closeEvent(self, event):

        odp = QMessageBox.question(
            self, 'Warning',
            "Do you want to quit application?",
            QMessageBox.Yes | QMessageBox.No, QMessageBox.No)

        if odp == QMessageBox.Yes:
            event.accept()
        else:
            event.ignore()

if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = ImageViewer()
    sys.exit(app.exec_())
