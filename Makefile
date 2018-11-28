all :
    mkdir build
    javac -d build $$(find src/ -type f -follow -print)

run : 
    java -classpath build hidenword.App.HidenWordServer
    
clean :
    rm -r build