package Composite;

public class FileLeaf implements FileComponent {
    private int size;
    private String name;

    public FileLeaf(String name, int size){
        this.name = name;
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public String print(String prefix){
        return prefix + name + " (" + getSize() + ")\n";
    }
}