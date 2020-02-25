package Composite;

import java.util.ArrayList;

public class Directory implements FileComponent {
    private ArrayList<FileComponent> children;
    private String name;

    public Directory (String name){
        this.name = name;
        children = new ArrayList<FileComponent>();
    }

    public void addChild(FileComponent child){
        children.add(child);
    }

    public void removeChild(FileComponent child){
        children.remove(child);
    }

    public int getSize(){
        int size = 0;
        for(FileComponent child: children){
            size += child.getSize();
        }
        return size;
    }

    public String print(String prefix){
        String wholeString = prefix + name + " (" + getSize() + ")\n";
        prefix += "\t";
        for(FileComponent child: children){
            wholeString += child.print(prefix);
        }
        return wholeString;
    }
}