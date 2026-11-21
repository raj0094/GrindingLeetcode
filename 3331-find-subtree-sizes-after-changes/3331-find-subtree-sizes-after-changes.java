class Solution {
    private List<Integer>[] adjacencyList;  // Tree structure as adjacency list
    private List<Integer>[] charToNodeStack;  // Stack of nodes for each character (a-z)
    private char[] characters;  // Character array from input string
    private int[] subtreeSizes;  // Result array storing subtree sizes
  
    public int[] findSubtreeSizes(int[] parent, String s) {
        int nodeCount = s.length();
      
        // Initialize data structures
        adjacencyList = new List[nodeCount];
        charToNodeStack = new List[26];  // 26 letters in alphabet
        this.characters = s.toCharArray();
      
        // Create empty lists for each node and character
        Arrays.setAll(adjacencyList, index -> new ArrayList<>());
        Arrays.setAll(charToNodeStack, index -> new ArrayList<>());
      
        // Build adjacency list from parent array (skip root at index 0)
        for (int childNode = 1; childNode < nodeCount; ++childNode) {
            adjacencyList[parent[childNode]].add(childNode);
        }
      
        // Initialize result array and perform DFS
        subtreeSizes = new int[nodeCount];
        dfs(0, -1);  // Start DFS from root (node 0) with no parent (-1)
      
        return subtreeSizes;
    }
  
    private void dfs(int currentNode, int parentNode) {
        
        subtreeSizes[currentNode] = 1;
      
       
        int charIndex = characters[currentNode] - 'a';
      
    
        charToNodeStack[charIndex].add(currentNode);
    
        for (int childNode : adjacencyList[currentNode]) {
            dfs(childNode, currentNode);
        }
      
       
        int closestAncestorWithSameChar = charToNodeStack[charIndex].size() > 1 ? 
            charToNodeStack[charIndex].get(charToNodeStack[charIndex].size() - 2) : 
            parentNode;
      
       
        if (closestAncestorWithSameChar >= 0) {
            subtreeSizes[closestAncestorWithSameChar] += subtreeSizes[currentNode];
        }
      
      
        charToNodeStack[charIndex].remove(charToNodeStack[charIndex].size() - 1);
    }
}
