set PATH_TO_FX=<path_to_javafx_lib_folder>

cd gameoflife
javac --module-path %PATH_TO_FX% --add-modules javafx.controls GameOfLife.java
javac --module-path %PATH_TO_FX% --add-modules javafx.controls Main.java
jar cmvf manifest.mf ../GameOfLife.jar ./*.java ./*.class
