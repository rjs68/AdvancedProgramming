package Composite;

public class DirectoryTest {
    public static void main(String[] args){
        FileLeaf kindOfBlue = new FileLeaf("Kind of Blue", 201);
        FileLeaf giantSteps = new FileLeaf("Giant Steps", 134);
        FileLeaf beethoven = new FileLeaf("Beethoven, Symphony no 6", 421);

        FileLeaf portrait = new FileLeaf("Portrait", 120);

        FileLeaf settings = new FileLeaf("settings", 10);

        Directory classical = new Directory("classical");
        classical.addChild(beethoven);

        Directory jazz = new Directory("jazz");
        jazz.addChild(kindOfBlue);
        jazz.addChild(giantSteps);

        Directory music = new Directory("music");
        music.addChild(jazz);
        music.addChild(classical);

        Directory pictures = new Directory("pictures");
        pictures.addChild(portrait);

        Directory root = new Directory("root");
        root.addChild(settings);
        root.addChild(pictures);
        root.addChild(music);
        
        System.out.println(root.print(""));
    }
}