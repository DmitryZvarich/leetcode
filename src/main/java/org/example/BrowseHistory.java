package org.example;

class BrowserHistory {
    Node curPage;

    public BrowserHistory(String homepage) {
        curPage = new Node(homepage);
    }

    public void visit(String url) {
        Node nextNode = new Node(url, curPage);
        curPage.next = nextNode;
        curPage = nextNode;
    }

    public String back(int steps) {
        int i = 0;
        while (i < steps && curPage.prev != null) {
            curPage = curPage.prev;
            i++;
        }

        return curPage.url;
    }

    public String forward(int steps) {
        int i = 0;
        while (i < steps && curPage.next != null) {
            curPage = curPage.next;
            i++;
        }

        return curPage.url;
    }

    static class Node {
        String url;
        Node prev;
        Node next;

        public Node(String url) {
            this.url = url;
        }

        public Node(String url, Node prev) {
            this.url = url;
            this.prev = prev;
        }
    }
}

//class BrowserHistory {
//    LinkedList<String> history;
//    int curPage;
//    public BrowserHistory(String homepage) {
//        history = new LinkedList<>();
//        history.add(homepage);
//        curPage = 0;
//    }
//
//    public void visit(String url) {
//        while (history.size() > curPage + 1){
//            history.removeLast();
//        }
//
//        history.addLast(url);
//        curPage++;
//    }
//
//    public String back(int steps) {
//        curPage = steps >= curPage ? 0 : curPage - steps;
//        System.out.println(curPage);
//        return history.get(curPage);
//    }
//
//    public String forward(int steps) {
//        curPage = Math.min(curPage + steps, history.size() - 1);
//        System.out.println(curPage);
//        return history.get(curPage);
//    }
//}
