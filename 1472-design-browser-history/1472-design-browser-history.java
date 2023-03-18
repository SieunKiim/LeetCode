class Page{
    public String now;
    public Page next;
    public Page before;
    
    public Page(String now){
        this.now = now;
    }
    public Page(String now, Page next, Page before){
        this.now = now;
        this.next = next;
        this.before = before;
    }
}

class BrowserHistory {

    Page page;
    
    public BrowserHistory(String homepage) {
        page = new Page(homepage);
    }
    
    public void visit(String url) {
        page.next = new Page(url, null, page);
        page = page.next;
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps; i++){
            if(page.before == null) break;
            page = page.before;
        }
        return page.now;
    }
    
    public String forward(int steps) {
        for(int i = 0 ;i< steps; i++){
            if(page.next == null) break;
            page = page.next;
        }
        return page.now;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */