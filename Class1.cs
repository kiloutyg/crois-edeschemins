using System.Collections.Generic;

// Classe abstraite qui représente un noeud de l'arbre
abstract class Node
{
    public abstract void Display(int level);
}

// Classe concrète qui représente un noeud de l'arbre contenant des enfants
class CompositeNode : Node
{
    private string name;
    private List<Node> children;

    public CompositeNode(string name)
    {
        this.name = name;
        children = new List<Node>();
    }

    public void AddChild(Node child)
    {
        children.Add(child);
    }

    public override void Display(int level)
    {
        // Affiche le noeud et tous ses enfants sous forme d'arbre
        for (int i = 0; i < level; i++)
        {
            System.console.Write("    ");
        }
        System.console.WriteLine("- " + name);
        foreach (Node child in children)
        {
            child.Display(level + 1);
        }
    }
}

// Classe concrète qui représente un noeud de l'arbre qui n'a pas d'enfants
class LeafNode : Node
{
    private string name;

    public LeafNode(string name)
    {
        this.name = name;
    }

    public override void Display(int level)
    {
        // Affiche le noeud
        for (int i = 0; i < level; i++)
        {
            System.console.Write("    ");
        }
        System.console.WriteLine("- " + name);
    }
}

// Classe qui représente l'arbre complet
class Tree
{
    // ...

    public void BuildTree(string[] paths)
    {
        // ...

        if (childNode == null)
        {
            // Si le noeud n'existe pas, créez-le et ajoutez-le en tant qu'enfant du noeud parent
            if (part.Contains("."))
            {
                // Si le nom de fichier contient un point, c'est un fichier, donc créez un noeud feuille
                childNode = new LeafNode(part);
            }
            else
            {
                // Sinon, c'est un répertoire, donc créez un noeud composite
                childNode = new CompositeNode(part);
            }
            currentNode.Children.Add(childNode);
        }
        currentNode = childNode;
    }

    // ...
}

// Exemple d'utilisation de la solution
Tree tree = new Tree();
tree.BuildTree(new string[] { "/usr/local/bin", "/usr/local/lib", "/usr/local/include" });
tree.Display();
