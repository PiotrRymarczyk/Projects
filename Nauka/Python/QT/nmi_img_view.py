'''
Created on 2017/11/10
Modified on 2017/11/14

@author: Piotr Rymarczyk

'''
import sys
from PyQt5.QtWidgets import QApplication, QFileSystemModel, QTreeView, QWidget, QGridLayout
from PyQt5.QtWidgets import QLabel, QMessageBox
from PyQt5.QtGui import QPixmap
from PyQt5.QtCore import QFileInfo

class ImageViewer(QWidget):
    '''
    Class for image viewer - learning PyQt5
    '''

    def __init__(self):
        '''
        initialize image viewer
        '''
        super().__init__()
        self.title = 'No Magic Involved - image viewer'
        self.left = 50
        self.top = 50
        self.width = 600
        self.height = 600
        self.supported_image_types = ['JPG', 'JPEG', 'PNG']
        self.create_gui()

    def create_directory_view(self):
        '''
        create user interface - tab with directory tree view
        '''
        self.model = QFileSystemModel()
        self.model.setNameFilters(['*.jpg', '*.pdf', '*.py', '*.jpeg', '*.png'])
        self.model.setNameFilterDisables(False)
        self.model.setRootPath('')
        self.tree = QTreeView()
        self.tree.setModel(self.model)
        self.tree.doubleClicked.connect(self.load_image)
        self.tree.setRootIndex(self.model.index(''))
        self.tree.setAlternatingRowColors(True)

        self.tree.setAnimated(False)
        self.tree.setColumnWidth(0, 400)
        self.tree.setColumnWidth(1, 60)
        self.tree.setColumnWidth(3, 40)
        self.tree.setColumnWidth(4, 40)

        self.tree.setWindowTitle("Dir View")
        self.tree.resize(600, 800)

    def create_info_panel(self):
        '''
        create user interface - panel with info
        '''
        self.info_panel = QLabel("To jest test")
        self.info_panel.resize(600, 800)
        self.info_panel.setToolTip('Loaded image :)')

    def create_date_tree_view_tab (self):
        self.date_view_tab = QLabel("Tutaj bedzie TreeView rok/miesiac/dzien")

    def create_printed_tree_view_tab (self):
        self.printed_view_tab = QLabel("Tutaj bedzie TreeView rok/miesiac/dzien - wydrukowane zdjecia")

    def create_gui(self):
        '''
        create user interface
        '''
        self.setWindowTitle(self.title)
        self.setGeometry(self.left, self.top, self.width, self.height)

        self.create_directory_view()
        self.create_date_tree_view_tab()
        self.create_printed_tree_view_tab()
        self.create_info_panel()

        self.tabs = QTabWidget()
        self.tabs.addTab(self.tree,"Directories")
        self.tabs.addTab(self.date_view_tab,"Date")
        self.tabs.addTab(self.printed_view_tab,"Printed")

        windowLayout = QGridLayout()
        windowLayout.addWidget(self.tabs, 0, 0)
        windowLayout.addWidget(self.info_panel, 0, 1)
        windowLayout.setColumnMinimumWidth(0, 600)
        windowLayout.setColumnMinimumWidth(1, 600)
        self.setLayout(windowLayout)
        self.resize(800, 800)
        self.show()

    def load_image(self, signal):
        '''
        check if element clicked in tree view is image and load it
        '''
        file_path = self.tree.model().filePath(signal)
        file_info = QFileInfo(file_path)
        if file_info.isDir():
            self.info_panel.setText('Directory')
        elif file_info.isFile():
            if file_info.suffix().upper() in self.supported_image_types:
                self.info_panel.setText(file_info.fileName())
                pixmap = QPixmap(file_path)
                if pixmap.width() > 600:
                    pixmap = QPixmap(file_path).scaledToWidth(600)
                self.info_panel.setPixmap(pixmap)
            else:
                self.info_panel.setText('Unsupported file type')
        else:
            self.info_panel.setText('Unrecognized')
        self.info_panel.resize(600, 800)

    def closeEvent(self, event):
        '''
        message shown when user closes application
        '''
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
