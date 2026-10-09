class PrefixTree {
    boolean endOfValidWord = false;
    PrefixTree[] children = new PrefixTree[26];

    // public PrefixTree() {
    //     boolean endOfValidWord = false;
    //     PrefixTree[] children = new PrefixTree[26];
    // }

    public void insert(String word) {
        PrefixTree current = this;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                PrefixTree child = new PrefixTree();
                current.children[word.charAt(i) - 'a'] = child;
                current = child;
            } else current = current.children[word.charAt(i) - 'a'];
        }
        current.endOfValidWord = true;
    }

        public boolean search(String word) {
            PrefixTree current = this;
            for(int i = 0; i < word.length(); i ++) {
                if (current.children[word.charAt(i) - 'a'] == null) return false;
                else current = current.children[word.charAt(i) - 'a'];
            }
            return current.endOfValidWord;
        }

        public boolean startsWith(String prefix) {
            PrefixTree current = this;
            for(int i = 0; i < prefix.length(); i ++) {
                if (current.children[prefix.charAt(i) - 'a'] == null) return false;
                else current = current.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }
