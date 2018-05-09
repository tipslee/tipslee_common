package com.jd.innovation.common.algorithm;

import com.jd.innovation.common.algorithm.trTree.TrieTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdyuanlifei on 2016/7/29.
 */
public class TrieTreeTest {

    @Test
    public void testInsert() throws Exception {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abcdefg");
        trieTree.insert("abcdefg");
        trieTree.insert("bcdefg");

        trieTree.insert(" ");
        trieTree.insert("0000");
    }

    @Test
    public void testSearch() throws Exception {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abcdefg");
        trieTree.insert("abcdefg");
        trieTree.insert("abcdef");
        trieTree.insert("bcdefg");
        trieTree.insert("0000");

        assertFalse(trieTree.search("abcdefghijklmn"));
        assertTrue(trieTree.search("abcdefg"));
        assertTrue(trieTree.search("abcdef"));
        assertFalse(trieTree.search("abcd"));
        assertFalse(trieTree.search(" "));
    }

    @Test
    public void testSearchPrefix() throws Exception {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abcdefg");
        trieTree.insert("abcdefg");
        trieTree.insert("abcdef");
        trieTree.insert("bcdefg");
        trieTree.insert("0000");

        assertTrue(trieTree.searchPrefix("abcdefghijklmn"));
        assertTrue(trieTree.searchPrefix("abcdefg"));
        assertTrue(trieTree.searchPrefix("abcdef"));
        assertFalse(trieTree.searchPrefix("abcd"));
        assertFalse(trieTree.searchPrefix(" "));
    }

    @Test
    public void testDeleteWord() throws Exception {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abcdefg");
        trieTree.insert("abcdefg");
        trieTree.insert("abcdef");
        trieTree.insert("bcdefg");
        trieTree.insert(" ");
        trieTree.insert("0000");

        trieTree.deleteWord(" ");
        assertFalse(trieTree.search(" "));
        trieTree.deleteWord("abcdefg");
        assertFalse(trieTree.search("abcdefg"));
        assertTrue(trieTree.search("abcdef"));
        trieTree.deleteWord(null);
        trieTree.deleteWord("0000");
    }
}