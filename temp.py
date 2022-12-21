class Node:
    def __init__(self, name):
        self.name = name
        self.children = []
    
    def display(self, level=0):
        # Affiche le noeud et tous ses enfants sous forme d'arbre
        print(' ' * 4 * level + '- ' + self.name)
        for child in self.children:
            child.display(level + 1)

class Tree:
    def __init__(self):
        self.root = Node('')
        self.current_path = self.root
    
    def build_tree(self, paths):
        for path in paths:
            parts = path.split('/')
            current_node = self.root
            for part in parts:
                # Recherchez le noeud enfant correspondant au nom de fichier ou de répertoire actuel
                child_node = next((child for child in current_node.children if child.name == part), None)
                if child_node is None:
                    # Si le noeud n'existe pas, créez-le et ajoutez-le en tant qu'enfant du noeud parent
                    child_node = Node(part)
                    current_node.children.append(child_node)
                current_node = child_node
    
    def display(self):
        self.root.display()

# Input
tree = Tree()
tree.build_tree(["/home/josh/project/app/src/index.js",
"/home/peter/.bashrc",
"/home/josh/project/app/images/logo1.png",
"/home/josh/project/app/images/logo2.png",
"/home/peter/.profile",
"/home/peter/test",
"/var/log",
"/usr/lib/node14",
"/home/josh/project/app/test.jpg",
"/home/josh/project/app/images/logo3.png",
"/opt/apache2",
"etc/hosts"])
tree.display()
