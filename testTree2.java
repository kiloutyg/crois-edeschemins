
    import java.util.ArrayList;
    import java.util.List;
    
    // Classe abstraite qui représente un noeud de l'arbre
    abstract class Node {
        public abstract void display(int level);
    }
    
    // Classe concrète qui représente un noeud de l'arbre contenant des enfants
    class CompositeNode extends Node {
        private String name;
        private List<Node> children;
        
        public CompositeNode(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
        
        public void addChild(Node child) {
            children.add(child);
        }
        
        public void display(int level) {
            // Affiche le noeud et tous ses enfants sous forme d'arbre
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("- " + name);
            for (Node child : children) {
                child.display(level + 1);
            }
        }
    }
    
    // Classe concrète qui représente un noeud de l'arbre qui n'a pas d'enfants (suite)
    class LeafNode extends Node {
        private String name;
        
        public LeafNode(String name) {
            this.name = name;
        }
        
        public void display(int level) {
            // Affiche le noeud
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("- " + name);
        }
    }
    
    // Classe qui représente l'arbre complet
    class Tree {
        private Node root;
        private Node currentPath;
        
        public Tree() {
            root = new CompositeNode("");
            currentPath = root;
        }
        
        public void buildTree(String[] paths) {
            for (String path : paths) {
                String[] parts = path.split("/");
                Node currentNode = root;
                for (String part : parts) {
                    // Recherchez le noeud enfant correspondant au nom de fichier ou de répertoire actuel
                    Node childNode = null;
                    for (Node child : currentNode.children) {
                        if (child.name.equals(part)) {
                            childNode = child;
                            break;
                        }
                    }
                    if (childNode == null) {
                        // Si le noeud n'existe pas, créez-le et ajoutez-le en tant qu'enfant du noeud parent
                        if (part.contains(".")) {
                            // Si le nom de fichier contient un point, c'est un fichier, donc créez un noeud feuille
                            childNode = new LeafNode(part);
                        }
                        else {
                            // Sinon, c'est un répertoire, donc créez un noeud composite
                            childNode = new CompositeNode(part);
                        }
                    }
                    currentNode = childNode;
                }
            }
        }
        public void display() {
            root.display(0);
        }
    }
    
    public static void main(String[] args) {
        String[] paths = {
            "/home/kilo/sam512/cesi/UML/tp/crois-edeschemins/testTree1.java",
            "/home/kilo/sam512/cesi/UML/tp/crois-edeschemins/testTree2.java",
            "/home/kcurrentNode.children.
       

