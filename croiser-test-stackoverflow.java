

// #Try this one, I added another parameter into your methods called hierarchyTree to indicate if at a certain level, we should print | or empty space.

// # It is used as a stack to easily maintain the folder levels based on the recursion level.

public static void main(final String[] args) {
    final File folder = new File("example");
    final StringBuilder sb = renderFolder(folder);
    System.out.println(sb.toString());
}

private static StringBuilder renderFolder(File folder) {
    return renderFolder(folder, 0, new StringBuilder(), false, new ArrayList<>());
}

private static StringBuilder renderFolder(File folder, int level, StringBuilder sb, boolean isLast, List<Boolean> hierarchyTree) {
    indent(sb, level, isLast, hierarchyTree).append(folder.getName()).append("\n");

    File[] objects = folder.listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File current, String name) {
            return new File(current, name).isDirectory();
        }
    });

    for (int i = 0; i < objects.length; i++) {
        boolean last = ((i + 1) == objects.length);

        // this means if the current folder will still need to print subfolders at this level, if yes, then we need to continue print |
        hierarchyTree.add(i != objects.length - 1);
        renderFolder(objects[i], level + 1, sb, last, hierarchyTree);

        // pop the last value as we return from a lower level to a higher level
        hierarchyTree.remove(hierarchyTree.size() - 1);
    }
    return sb;
}


private static StringBuilder indent(StringBuilder sb, int level, boolean isLast, List<Boolean> hierarchyTree) {
    String indentContent = "\u2502   ";
    for (int i = 0; i < hierarchyTree.size() - 1; ++i) {
        // determines if we need to print | at this level to show the tree structure
        // i.e. if this folder has a sibling foler that is going to be printed later
        if (hierarchyTree.get(i)) {
            sb.append(indentContent);
        } else {
            sb.append("    "); // otherwise print empty space
        }
    }

    if (level > 0) {
        sb.append(isLast
                ? "\u2514\u2500\u2500"
                : "\u251c\u2500\u2500").append(" ");
    }

    return sb;
}
